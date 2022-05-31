/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbearia.arisol.dao;

import barbearia.arisol.configs.Conexao;
import barbearia.arisol.interfaces.IDao;
import barbearia.arisol.models.Cliente;
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
public class ClienteDao implements IDao<Cliente>{
   
    private Conexao conexao = null;

    public ClienteDao() {
        this.conexao = new Conexao();
    }

    @Override
    public void create(Cliente obj) {
        String sql = "INSERT INTO clientes (" +
                        "nome," +
                        "telefone," +
                        "identidade," +
                        "user_id," +
                        "is_activo," +
                        "created_at," +
                        "is_deleted)" +
                        "VALUES (?, ?, ?, ?, ?, DATETIME('NOW', 'LOCALTIME'), ?);";
        
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
        ){
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getTelefone());
            stm.setString(3, obj.getIdentidade());
            stm.setInt(4, obj.getUser().getId());
            stm.setBoolean(5, obj.isActivo());
            stm.setBoolean(6, false);
            stm.addBatch();
            stm.executeUpdate();
        } catch (SQLException ex) {
            GenericMessage.showErrorCreate();
        }
    }

    @Override
    public void update(Cliente obj) {
        String sql = "UPDATE clientes SET " +
                        "nome = ?," +
                        "telefone = ?," +
                        "identidade = ?," +
                        "is_activo = ?," +
                        "is_deleted = ?" +
                        "WHERE id = ?";
        
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
        ){
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getTelefone());
            stm.setString(3, obj.getIdentidade());
            stm.setBoolean(4, obj.isActivo());
            stm.setBoolean(5, obj.isDeleted());
            stm.setInt(6, obj.getId());
            stm.addBatch();
            stm.executeUpdate();
        } catch (SQLException ex) {
            GenericMessage.showErrorUpdate();
        }
    }

    @Override
    public boolean delete(Cliente obj) {
        if(obj.getId() > 0){
            obj.setDeleted(true);
            this.update(obj);
            return true;
        }
        return false;
    }

    @Override
    public List<Cliente> findAll() {
        String sql = "SELECT * FROM clientes WHERE is_deleted=0 ORDER BY id DESC";
        List<Cliente> list = new ArrayList<>();
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
        ){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            while(rs.next()){
                Utilizador user = new UtilizadorDao().findById(rs.getInt("user_id"));
                
                Cliente c = new Cliente(rs.getString("nome"), rs.getString("telefone"), rs.getString("identidade"), true);
                c.setId(rs.getInt("id"))
                    .setCreatedAt(formatter.parse(rs.getString("created_at")))
                    .setActivo(rs.getBoolean("is_activo"))
                    .setDeleted(rs.getBoolean("is_deleted"));
                if(user != null){
                    c.setUser(user);
                }
                list.add(c);
            }
            
        } catch (Exception ex) {
            GenericMessage.showErrorList();
        }
        return list;
    }

    @Override
    public Cliente findById(int id) {
        if(id > 0){
            String sql = "SELECT * FROM clientes WHERE id = ?";
            try(
                Connection con = this.conexao.getConnection();
                PreparedStatement stm= con.prepareStatement(sql);
            ){
                stm.setInt(1, id);
                stm.addBatch();
                ResultSet rs = stm.executeQuery();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                
                Cliente c = new Cliente(rs.getString("nome"), rs.getString("telefone"), rs.getString("identidade"), true);
                c.setId(rs.getInt("id"))
                    .setCreatedAt(formatter.parse(rs.getString("created_at")))
                    .setActivo(rs.getBoolean("is_activo"))
                    .setDeleted(rs.getBoolean("is_deleted"));
                
                return c;
            } catch (Exception ex) {
                GenericMessage.showErrorList();
            }
        }
        return null;
    }
    
}
