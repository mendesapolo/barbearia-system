/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbearia.arisol.dao;

import barbearia.arisol.configs.Conexao;
import barbearia.arisol.interfaces.IDao;
import barbearia.arisol.models.Sistema;
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
public class SistemaDao implements IDao<Sistema>{
    
    private Conexao conexao = null;
    
    public SistemaDao() {
        this.conexao = new Conexao();
    }

    @Override
    public void create(Sistema obj) {
        String sql = "INSERT INTO sistema(estabelecimento, taxa_agenda, is_active, created_at) VALUES(?, ?, ?, DATETIME('NOW', 'LOCALTIME'))";
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
        ){
            stm.setString(1, obj.getEstabelecimento());
            stm.setInt(2, obj.getTaxaAgendamento());
            stm.setBoolean(3, true);
            stm.addBatch();
            stm.executeUpdate();
        } catch (SQLException ex) {
            GenericMessage.showErrorCreate();
        }
    }

    @Override
    public void update(Sistema obj) {
        if(obj.getId() > 0){
            String sql = "UPDATE sistema SET estabelecimento=?, taxa_agenda=?, is_active=? WHERE id=?";
            try(
                Connection con = this.conexao.getConnection();
                PreparedStatement stm= con.prepareStatement(sql);
            ){
                stm.setString(1, obj.getEstabelecimento());
                stm.setInt(2, obj.getTaxaAgendamento());
                stm.setBoolean(3, obj.isActive());
                stm.setInt(4, obj.getId());
                stm.addBatch();
                stm.executeUpdate();
            } catch (SQLException ex) {
                GenericMessage.showErrorCreate();
            }
        }
    }

    @Override
    public boolean delete(Sistema obj) {
        if(obj.getId() > 0){
            obj.setActive(false);
            this.update(obj);
            return true;
        }
        return false;
    }

    @Override
    public List<Sistema> findAll() {
        String sql = "SELECT * FROM sistema";
        List<Sistema> list = new ArrayList<>();
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
        ){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            while(rs.next()){
                Sistema s = new Sistema(rs.getString("estabelecimento"), rs.getInt("taxa_agenda"));
                s.setId(rs.getInt("id"))
                .setActive(rs.getBoolean("is_active"))
                .setCreatedAt(formatter.parse(rs.getString("created_at")));
                
                list.add(s);
            }
            
        } catch (Exception ex) {
            GenericMessage.showErrorList();
        }
        return list;
    }

    @Override
    public Sistema findById(int id) {
        if(id > 0){
            String sql = "SELECT * FROM sistema WHERE id = ?";
            try(
                Connection con = this.conexao.getConnection();
                PreparedStatement stm= con.prepareStatement(sql);
            ){
                stm.setInt(1, id);
                stm.addBatch();
                ResultSet rs  = stm.executeQuery();
                 
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                
                Sistema s = new Sistema(rs.getString("estabelecimento"), rs.getInt("taxa_agenda"));
                s.setId(rs.getInt("id"))
                .setActive(rs.getBoolean("is_active"))
                .setCreatedAt(formatter.parse(rs.getString("created_at")));
                
                rs.close();
                return s;
            } catch (Exception ex) {
                ex.printStackTrace();
                GenericMessage.showErrorList();
            }
        }
        return null;
    }
    //ride gas pact second young unable dizzy clog spot toe unaware uniform

    public Sistema getAtual() {
            String sql = "SELECT * FROM sistema WHERE is_active = 1";
            try(
                Connection con = this.conexao.getConnection();
                PreparedStatement stm= con.prepareStatement(sql);
            ){
                ResultSet rs  = stm.executeQuery();
                if(!rs.isClosed()){
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                    Sistema s = new Sistema(rs.getString("estabelecimento"), rs.getInt("taxa_agenda"));
                    s.setId(rs.getInt("id"))
                    .setActive(rs.getBoolean("is_active"))
                    .setCreatedAt(formatter.parse(rs.getString("created_at")));

                    rs.close();
                    return s;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                GenericMessage.showErrorList();
            }
        return null;
    }
    
}
