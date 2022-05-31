/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbearia.arisol.dao;

import barbearia.arisol.configs.Conexao;
import barbearia.arisol.interfaces.IDao;
import barbearia.arisol.models.Agendamento;
import barbearia.arisol.models.Cliente;
import barbearia.arisol.models.Corte;
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
public class AgendamentoDao implements IDao<Agendamento>{
    
    private Conexao conexao = null;

    public AgendamentoDao() {
        this.conexao = new Conexao();
    }

    @Override
    public void create(Agendamento obj) {
        String sql = "INSERT INTO agendamentos (" +
                        "data," +
                        "valor," +
                        "is_cancelado," +
                        "cliente_id," +
                        "corte_id," +
                        "created_at," +
                        "is_deleted," +
                        "is_atendido)" +
                        "VALUES (?, ?, ?,  ?, ?, DATETIME('NOW', 'LOCALTIME'), ?, ?);";
        
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
        ){
            stm.setString(1, new SimpleDateFormat("yyyy-MM-dd HH:mm").format(obj.getData()));
            stm.setDouble(2, obj.getValor());
            stm.setBoolean(3, false);
            
            if(obj.getCliente() != null)
                stm.setInt(4, obj.getCliente().getId());
            
            if(obj.getCorte() != null)
                stm.setInt(5, obj.getCorte().getId());
            
            stm.setBoolean(6, false);
            stm.setBoolean(7, false);
            stm.addBatch();
            stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Agendamento obj) {
        String sql = "UPDATE agendamentos SET " +
                        "data = ?, " +
                        "valor = ?, " +
                        "is_cancelado = ?, " +
                        "cliente_id = ?, " +
                        "corte_id = ?, " +
                        "is_deleted = ?, " +
                        "is_atendido = ? " +
                        "WHERE id = ?";
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
        ){
            stm.setString(1, new SimpleDateFormat("yyyy-MM-dd HH:mm").format(obj.getData()));
            stm.setDouble(2, obj.getValor());
            stm.setBoolean(3, obj.isCancelado());
            stm.setInt(4, obj.getCliente().getId());
            stm.setInt(5, obj.getCorte().getId());
            stm.setBoolean(6, obj.isDeleted());
            stm.setBoolean(7, obj.isAtendido());
            stm.setInt(8, obj.getId());
            stm.addBatch();
            stm.executeUpdate();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }

    @Override
    public boolean delete(Agendamento obj) {
        if(obj.getId() > 0){
            obj.setDeleted(true);
            this.update(obj);
            return true;
        }
        return false;
    }

    @Override
    public List<Agendamento> findAll() {
        String sql = "SELECT * FROM agendamentos WHERE is_deleted=0";
        List<Agendamento> list = new ArrayList<>();
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
        ){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            
            while(rs.next()){
                Cliente cliente = new ClienteDao().findById(rs.getInt("cliente_id"));
                Corte corte = new CorteDao().findById(rs.getInt("corte_id"));
                
                Agendamento a = new Agendamento(formatter.parse(rs.getString("data")), rs.getDouble("valor"), cliente, corte);
                a.setId(rs.getInt("id"))
                    .setCreatedAt(formatter.parse(rs.getString("created_at")))
                    .setCancelado(rs.getBoolean("is_cancelado"))
                    .setAtendido(rs.getBoolean("is_atendido"))
                    .setDeleted(rs.getBoolean("is_deleted"));
                list.add(a);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Agendamento findById(int id) {
        if(id > 0){
            String sql = "SELECT * FROM agendamentos WHERE id = ?";
            try(
                Connection con = this.conexao.getConnection();
                PreparedStatement stm= con.prepareStatement(sql);
            ){
                stm.setInt(1, id);
                stm.addBatch();
                ResultSet rs = stm.executeQuery();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                
                Cliente cliente = new ClienteDao().findById(rs.getInt("cliente_id"));
                Corte corte = new CorteDao().findById(rs.getInt("corte_id"));
                
                Agendamento a = new Agendamento(formatter.parse(rs.getString("data")), rs.getDouble("valor"), cliente, corte);
                a.setId(rs.getInt("id"))
                    .setCreatedAt(formatter.parse(rs.getString("created_at")))
                    .setCancelado(rs.getBoolean("is_cancelado"))
                    .setAtendido(rs.getBoolean("is_atendido"))
                    .setDeleted(rs.getBoolean("is_deleted"));
                
                return a;
            } catch (Exception ex) {
                GenericMessage.showErrorList();
            }
        }
        return null;
    }
    
}
