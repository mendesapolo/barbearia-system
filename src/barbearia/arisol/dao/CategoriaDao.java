/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbearia.arisol.dao;

import barbearia.arisol.configs.Conexao;
import barbearia.arisol.interfaces.IDao;
import barbearia.arisol.models.Categoria;
import barbearia.arisol.util.GenericMessage;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author António Apolo
 */
public class CategoriaDao implements IDao<Categoria>{

    private Conexao conexao = null;
    
    public CategoriaDao() {
//        this.conexao = new Conexao("barbearia.db");
        this.conexao = new Conexao();
    }

    @Override
    public void create(Categoria obj) {
        String sql = "INSERT INTO categorias(nome, descricao, created_at, is_deleted) VALUES(?, ?, DATETIME('NOW', 'LOCALTIME'), ?)";
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
        ){
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getDescricao());
            stm.setBoolean(3, false);
            stm.addBatch();
            stm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, GenericMessage.ERROR_CREATE, "Erro ao Criar", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(Categoria obj) {
        if(obj.getId() > 0){
            String sql = "UPDATE categorias SET nome=?, descricao=?, is_deleted=? WHERE id=?";
            try(
                Connection con = this.conexao.getConnection();
                PreparedStatement stm= con.prepareStatement(sql);
            ){
                stm.setString(1, obj.getNome());
                stm.setString(2, obj.getDescricao());
                stm.setBoolean(3, obj.isDeleted());
                stm.setInt(4, obj.getId());
                stm.addBatch();
                stm.executeUpdate();
            } catch (SQLException ex) {
                GenericMessage.showErrorCreate();
            }
        }
    }

    @Override
    public boolean delete(Categoria obj) {
        if(obj.getId() > 0){
//            String sql = "DELETE FROM categorias WHERE id = ?";
//            try(
//                Connection con = this.conexao.getConnection();
//                PreparedStatement stm= con.prepareStatement(sql);
//            ){
//                stm.setInt(1, obj.getId());
//                if(stm.executeUpdate() > 0){
//                    return true;
//                }
//            } catch (SQLException ex) {
//                System.err.println("Erro ao deleta:: \nERRO: "+ ex.getMessage());
//            }
            obj.setDeleted(true);
            this.update(obj);
            return true;
        }
        return false;
    }

    @Override
    public List<Categoria> findAll() {
        String sql = "SELECT * FROM categorias WHERE is_deleted=0";
        List<Categoria> list = new ArrayList<>();
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
        ){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            while(rs.next()){
                Categoria c = new Categoria(rs.getString("nome"), rs.getString("descricao"), rs.getBoolean("is_deleted"));
                c.setId(rs.getInt("id"));
                c.setCreatedAt(formatter.parse(rs.getString("created_at")));
                list.add(c);
            }
            
        } catch (Exception ex) {
            GenericMessage.showErrorList();
        }
        return list;
    }

    @Override
    public Categoria findById(int id) {
        if(id > 0){
            String sql = "SELECT * FROM categorias WHERE id = ?";
            try(
                Connection con = this.conexao.getConnection();
                PreparedStatement stm= con.prepareStatement(sql);
            ){
                stm.setInt(1, id);
                stm.addBatch();
                Categoria c;
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                ResultSet rs = stm.executeQuery();
                c = new Categoria(rs.getString("nome"), rs.getString("descricao"), rs.getBoolean("is_deleted"));
                c.setId(rs.getInt("id"));
                c.setCreatedAt(formatter.parse(rs.getString("created_at")));
                rs.close();
                return c;
            } catch (Exception ex) {
                ex.printStackTrace();
                GenericMessage.showErrorList();
            }
        }
        return null;
    }
    
}
