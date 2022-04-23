/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbearia.arisol.dao;

import barbearia.arisol.configs.Conexao;
import barbearia.arisol.interfaces.IDao;
import barbearia.arisol.models.Categoria;
import barbearia.arisol.models.Corte;
import barbearia.arisol.models.Utilizador;
import barbearia.arisol.util.GenericMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author António Apolo
 */
public class CorteDao implements IDao<Corte>{
    
    private Conexao conexao = null;

    public CorteDao() {
        this.conexao = new Conexao();
    }

    @Override
    public void create(Corte obj) {
        String sql = "INSERT INTO cortes (" +
                        "nome," +
                        "descricao," +
                        "preco," +
                        "categoria_id," +
                        "user_id," +
                        "created_at," +
                        "is_deleted)" +
                        "VALUES (?, ?, ?,  ?, ?, DATETIME('NOW', 'LOCALTIME'), ?);";
        
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
        ){
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getDescrcao());
            stm.setDouble(3, obj.getPreco());
            
            if(obj.getCategoria() != null)
                stm.setInt(4, obj.getCategoria().getId());
            
            if(obj.getUser() != null)
                stm.setInt(5, obj.getUser().getId());
            
            stm.setBoolean(6, false);
            stm.addBatch();
            stm.executeUpdate();
        } catch (SQLException ex) {
            GenericMessage.showErrorCreate();
        }
    }

    @Override
    public void update(Corte obj) {
        String sql = "UPDATE cortes SET" +
                        "nome = ?," +
                        "descricao = ?," +
                        "preco = ?," +
                        "categoria_id = ?," +
                        "user_id = ?," +
                        "is_deleted = ?" +
                        "WHERE id = ?";
        
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
        ){
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getDescrcao());
            stm.setDouble(3, obj.getPreco());
            stm.setInt(4, obj.getCategoria().getId());
            stm.setInt(5, obj.getUser().getId());
            stm.setBoolean(6, obj.isDeleted());
            stm.setInt(7, obj.getId());
            stm.addBatch();
            stm.executeUpdate();
        } catch (SQLException ex) {
            GenericMessage.showErrorUpdate();
        }
    }

    @Override
    public boolean delete(Corte obj) {
        if(obj.getId() > 0){
            obj.setDeleted(true);
            this.update(obj);
            return true;
        }
        return false;
    }

    @Override
    public List<Corte> findAll() {
        String sql = "SELECT * FROM cortes WHERE is_deleted=0";
        List<Corte> list = new ArrayList<>();
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
        ){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            while(rs.next()){
                Categoria categoria = new CategoriaDao().findById(rs.getInt("categoria_id"));
                Utilizador user = new UtiizadorDao().findById(rs.getInt("user_id"));
                
                Corte c = new Corte(rs.getString("nome"), rs.getString("descricao"), rs.getDouble("preco"), categoria);
                c.setId(rs.getInt("id"))
                    .setCreatedAt(formatter.parse(rs.getString("created_at")))
                    .setUser(user)
                    .setDeleted(rs.getBoolean("is_deleted"));
                list.add(c);
            }
            
        } catch (Exception ex) {
            GenericMessage.showErrorList();
        }
        return list;
    }

    @Override
    public Corte findById(int id) {
        if(id > 0){
            String sql = "SELECT * FROM cortes WHERE id = ?";
            try(
                Connection con = this.conexao.getConnection();
                PreparedStatement stm= con.prepareStatement(sql);
            ){
                stm.setInt(1, id);
                stm.addBatch();
                ResultSet rs = stm.executeQuery();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                
                Categoria categoria = new CategoriaDao().findById(rs.getInt("categoria_id"));
                Utilizador user = new UtiizadorDao().findById(rs.getInt("user_id"));
                
                Corte c = new Corte(rs.getString("nome"), rs.getString("descricao"), rs.getDouble("preco"), categoria);
                c.setId(rs.getInt("id"))
                    .setCreatedAt(formatter.parse(rs.getString("created_at")))
                    .setUser(user)
                    .setCategoria(categoria)
                    .setDeleted(rs.getBoolean("is_deleted"));
                
                return c;
            } catch (Exception ex) {
                GenericMessage.showErrorList();
            }
        }
        return null;
    }
}
