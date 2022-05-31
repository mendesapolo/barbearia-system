/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbearia.arisol.dao;

import barbearia.arisol.configs.Conexao;
import barbearia.arisol.interfaces.IDao;
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
public class UtilizadorDao implements IDao<Utilizador>{
    
    private Conexao conexao = null;

    public UtilizadorDao() {
        this.conexao = new Conexao();
    }

    @Override
    public void create(Utilizador obj) {
        String sql = "INSERT INTO utilizadores (" +
                        "nome," +
                        "telefone," +
                        "data_nascimento," +
                        "identidade," +
                        "username," +
                        "password," +
                        "type," +
                        "is_activo," +
                        "created_at," +
                        "is_deleted)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, DATETIME('NOW', 'LOCALTIME'), ?);";
        
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
        ){
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
                    
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getTelefone());
            stm.setString(3, formatDate.format(obj.getDataNascimento()));
            stm.setString(4, obj.getIdentidade());
            stm.setString(5, obj.getUsername());
            stm.setString(6, obj.getPassword());
            stm.setString(7, obj.getType());
            stm.setBoolean(8, obj.isActivo());
            stm.setBoolean(9, false);
            stm.addBatch();
            stm.executeUpdate();
        } catch (SQLException ex) {
            GenericMessage.showErrorCreate();
        }
    }

    @Override
    public void update(Utilizador obj) {
        String sql = "UPDATE utilizadores SET " +
                        "nome = ?," +
                        "telefone = ?," +
                        "data_nascimento = ?," +
                        "identidade = ?," +
                        "username = ?," +
                        "password = ?," +
                        "type = ?," +
                        "is_activo = ?," +
                        "is_deleted = ?" +
                        "WHERE id = ?";
        
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
        ){
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
            
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getTelefone());
            stm.setString(3, formatDate.format(obj.getDataNascimento()));
            stm.setString(4, obj.getIdentidade());
            stm.setString(5, obj.getUsername());
            stm.setString(6, obj.getPassword());
            stm.setString(7, obj.getType());
            stm.setBoolean(8, obj.isActivo());
            stm.setBoolean(9, obj.isDeleted());
            stm.setInt(10, obj.getId());
            stm.addBatch();
            stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            GenericMessage.showErrorUpdate();
        }
    }

    public void updateNoPasswordNoUsername(Utilizador obj) {
        String sql = "UPDATE utilizadores SET " +
                        "nome = ?," +
                        "telefone = ?," +
                        "data_nascimento = ?," +
                        "identidade = ?," +
                        "type = ?," +
                        "is_activo = ?," +
                        "is_deleted = ?" +
                        "WHERE id = ?";
        
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
        ){
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
            
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getTelefone());
            stm.setString(3, formatDate.format(obj.getDataNascimento()));
            stm.setString(4, obj.getIdentidade());
            stm.setString(5, obj.getType());
            stm.setBoolean(6, obj.isActivo());
            stm.setBoolean(7, obj.isDeleted());
            stm.setInt(8, obj.getId());
            stm.addBatch();
            stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            GenericMessage.showErrorUpdate();
        }
    }

    public void updateWithPassword(Utilizador obj) {
        String sql = "UPDATE utilizadores SET " +
                        "nome = ?," +
                        "telefone = ?," +
                        "data_nascimento = ?," +
                        "identidade = ?," +
                        "type = ?," +
                        "is_activo = ?," +
                        "is_deleted = ?," +
                        "password = ?" +
                        "WHERE id = ?";
        
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
        ){
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
            
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getTelefone());
            stm.setString(3, formatDate.format(obj.getDataNascimento()));
            stm.setString(4, obj.getIdentidade());
            stm.setString(5, obj.getType());
            stm.setBoolean(6, obj.isActivo());
            stm.setBoolean(7, obj.isDeleted());
            stm.setString(8, obj.getPassword());
            stm.setInt(9, obj.getId());
            stm.addBatch();
            stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            GenericMessage.showErrorUpdate();
        }
    }

    public void updateWithUsername(Utilizador obj) {
        String sql = "UPDATE utilizadores SET " +
                        "nome = ?," +
                        "telefone = ?," +
                        "data_nascimento = ?," +
                        "identidade = ?," +
                        "type = ?," +
                        "is_activo = ?," +
                        "is_deleted = ?," +
                        "username = ?" +
                        "WHERE id = ?";
        
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
        ){
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
            
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getTelefone());
            stm.setString(3, formatDate.format(obj.getDataNascimento()));
            stm.setString(4, obj.getIdentidade());
            stm.setString(5, obj.getType());
            stm.setBoolean(6, obj.isActivo());
            stm.setBoolean(7, obj.isDeleted());
            stm.setString(8, obj.getUsername());
            stm.setInt(9, obj.getId());
            stm.addBatch();
            stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            GenericMessage.showErrorUpdate();
        }
    }

    @Override
    public boolean delete(Utilizador obj) {
        if(obj.getId() > 0){
            obj.setDeleted(true);
            this.update(obj);
            return true;
        }
        return false;
    }

    @Override
    public List<Utilizador> findAll() {
        String sql = "SELECT * FROM utilizadores WHERE is_deleted=0";
        List<Utilizador> list = new ArrayList<>();
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
        ){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
            while(rs.next()){
                Utilizador u = new Utilizador(rs.getString("nome"), rs.getString("telefone"), rs.getString("password"), rs.getString("username"), rs.getString("identidade"), formatDate.parse(rs.getString("data_nascimento")));
                u.setId(rs.getInt("id"))
                    .setCreatedAt(formatter.parse(rs.getString("created_at")))
                    .setActivo(rs.getBoolean("is_activo"))
                    .setType(rs.getString("type"))
                    .setDeleted(rs.getBoolean("is_deleted"));
                list.add(u);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            GenericMessage.showErrorList();
        }
        return list;
    }

    @Override
    public Utilizador findById(int id) {
        if(id > 0){
            String sql = "SELECT * FROM utilizadores WHERE id = ?";
            try(
                Connection con = this.conexao.getConnection();
                PreparedStatement stm= con.prepareStatement(sql);
            ){
                stm.setInt(1, id);
                stm.addBatch();
                ResultSet rs = stm.executeQuery();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
                
                Utilizador u = new Utilizador(rs.getString("nome"), rs.getString("telefone"), rs.getString("password"), rs.getString("username"), rs.getString("identidade"), formatDate.parse(rs.getString("data_nascimento")));
                u.setId(rs.getInt("id"))
                    .setCreatedAt(formatter.parse(rs.getString("created_at")))
                    .setActivo(rs.getBoolean("is_activo"))
                    .setType(rs.getString("type"))
                    .setDeleted(rs.getBoolean("is_deleted"));
                
                return u;
            } catch (Exception ex) {
                GenericMessage.showErrorList();
            }
        }
        return null;
    }

    public Utilizador findByUsername(String username) {
        if(username != null && !username.equals("")){
            String sql = "SELECT * FROM utilizadores WHERE username = ?";
            try(
                Connection con = this.conexao.getConnection();
                PreparedStatement stm= con.prepareStatement(sql);
            ){
                stm.setString(1, username);
                stm.addBatch();
                ResultSet rs = stm.executeQuery();
                
                if(rs != null && !rs.isClosed()){
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
                    
                    Utilizador u = new Utilizador(rs.getString("nome"), rs.getString("telefone"), rs.getString("password"), rs.getString("username"), rs.getString("identidade"), formatDate.parse(rs.getString("data_nascimento")));
                    u.setId(rs.getInt("id"))
                        .setCreatedAt(formatter.parse(rs.getString("created_at")))
                        .setActivo(rs.getBoolean("is_activo"))
                        .setType(rs.getString("type"))
                        .setDeleted(rs.getBoolean("is_deleted"));
                    return u;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                GenericMessage.showAlertMessage(null, ex.getMessage());
            }
        }
        return null;
    }
    

    public Utilizador findByLogin(String username, String password) {
        if((username != null && !username.equals("")) && (password != null && !password.equals(""))){
            String sql = "SELECT * FROM utilizadores WHERE username = ? AND password = ?";
            try(
                Connection con = this.conexao.getConnection();
                PreparedStatement stm= con.prepareStatement(sql);
            ){
                stm.setString(1, username);
                stm.setString(2, password);
                stm.addBatch();
                ResultSet rs = stm.executeQuery();
                
                if(rs != null && !rs.isClosed()){
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
                    
                    Utilizador u = new Utilizador(rs.getString("nome"), rs.getString("telefone"), rs.getString("password"), rs.getString("username"), rs.getString("identidade"), formatDate.parse(rs.getString("data_nascimento")));
                    u.setId(rs.getInt("id"))
                        .setCreatedAt(formatter.parse(rs.getString("created_at")))
                        .setActivo(rs.getBoolean("is_activo"))
                        .setType(rs.getString("type"))
                        .setDeleted(rs.getBoolean("is_deleted"));
                    GenericMessage.showAlertMessage(null, u.getNome());
                    return u;
                }else{
                    
                    GenericMessage.showAlertMessage(null, "SSSS"+rs.getString(2));
                    GenericMessage.showAlertMessage(null, "XXXX"+rs.toString());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                GenericMessage.showAlertMessage(null, ex.getMessage());
            }
        }
        return null;
    }
    
}
