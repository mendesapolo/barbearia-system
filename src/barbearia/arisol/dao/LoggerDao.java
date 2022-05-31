/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbearia.arisol.dao;

import barbearia.arisol.configs.Conexao;
import barbearia.arisol.models.Logger;
import barbearia.arisol.models.Utilizador;
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
public class LoggerDao {

    private Conexao conexao;
    
    public LoggerDao() {
        this.conexao = new Conexao();
    }
    
    public void create(Logger l){
        String sql = "INSERT INTO loggers(user_id, nome, created_at, is_active) VALUES(?, ?, DATETIME('NOW', 'LOCALTIME'), ?)";
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
        ){
            stm.setInt(1, l.getUserId());
            stm.setString(2, l.getNome());
            stm.setBoolean(3, true);
            stm.addBatch();
            stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteAll(){
        String sql = "UPDATE loggers SET is_active = ?";
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
        ){
            stm.setBoolean(1, false);
            stm.addBatch();
            stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean delete(Logger l){
        String sql = "UPDATE loggers SET is_active = ? WHERE id = ?";
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
        ){
            stm.setBoolean(1, false);
            stm.setInt(2, l.getId());
            stm.addBatch();
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public Utilizador getActiveUser(){
        Logger l = this.getLogged();
        if(l != null){
            Utilizador u = new UtilizadorDao().findById(l.getUserId());
            if(u != null){
                return u;
            }
        }
        return null;
    }
    
    public List<Logger> findAll(){
      String sql = "SELECT * FROM loggers ORDER BY id DESC";
        List<Logger> list = new ArrayList<>();
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
        ){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            while(rs.next()){
                Logger l = new Logger(rs.getInt("user_id"), rs.getString("nome"), formatter.parse(rs.getString("created_at")), rs.getBoolean("is_active"));
                l.setId(rs.getInt("id"));
                list.add(l);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public Logger getLogged(){
      String sql = "SELECT * FROM loggers WHERE is_active = 1 ORDER BY id DESC LIMIT 1";
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
        ){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if(rs != null && !rs.isClosed()){
                Logger l = new Logger(rs.getInt("user_id"), rs.getString("nome"), formatter.parse(rs.getString("created_at")), rs.getBoolean("is_active"));
                l.setId(rs.getInt("id"));
                return l;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
