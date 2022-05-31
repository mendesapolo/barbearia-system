/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbearia.arisol.dao;

import barbearia.arisol.configs.Conexao;
import barbearia.arisol.interfaces.IDao;
import barbearia.arisol.models.Agendamento;
import barbearia.arisol.models.Atendimento;
import barbearia.arisol.models.Cliente;
import barbearia.arisol.models.Corte;
import barbearia.arisol.models.Utilizador;
import barbearia.arisol.util.GenericMessage;
import java.sql.Connection;
import java.sql.Date;
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
public class AtendimentoDao implements IDao<Atendimento>{
    
    private Conexao conexao = null;

    public AtendimentoDao() {
        this.conexao = new Conexao();
    }

    @Override
    public void create(Atendimento obj) {
        String sql = "INSERT INTO atendimentos(" +
                        "data," +
                        "valor," +
                        "is_agenda," +
                        "corte_id," +
                        "cliente_id," +
                        "agenda_id," +
                        "user_id," +
                        "created_at," +
                        "is_deleted)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, DATETIME('NOW', 'LOCALTIME'), ?);";
        
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
        ){
            stm.setString(1, new SimpleDateFormat("yyyy-MM-dd HH:mm").format(obj.getData()));
            stm.setDouble(2, obj.getValor());
            stm.setBoolean(3, obj.isAgenda());
            stm.setInt(4, obj.getCorte().getId());
            stm.setInt(5, obj.getCliente().getId());
            stm.setInt(6, 0);
            stm.setInt(7, obj.getUser().getId());
            stm.setBoolean(8, false);
            stm.addBatch();
            stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Atendimento obj) {
        String sql = "UPDATE agendamentos SET " +
                        "data = ?," +
                        "valor = ?," +
                        "is_agenda = ?," +
                        "corte_id = ?," +
                        "cliente_id = ?," +
                        "agenda_id = ?," +
                        "user_id = ?," +
                        "is_deleted = ?" +
                        "WHERE id = ?";
        
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
        ){
            stm.setString(1,  new SimpleDateFormat("yyyy-MM-dd HH:mm").format(obj.getData()));
            stm.setDouble(2, obj.getValor());
            stm.setBoolean(3, obj.isAgenda());
            
            stm.setInt(4, obj.getCorte().getId());
            stm.setInt(5, obj.getCliente().getId());
            stm.setInt(6, obj.getAgendamento().getId());
            
            stm.setInt(7, obj.getUser().getId());
            stm.setBoolean(8, obj.isDeleted());
            stm.setInt(9, obj.getId());
            stm.addBatch();
            stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean delete(Atendimento obj) {
        if(obj.getId() > 0){
            obj.setDeleted(true);
            this.update(obj);
            return true;
        }
        return false;
    }

    @Override
    public List<Atendimento> findAll() {
        String sql = "SELECT * FROM atendimentos WHERE is_deleted=0";
        List<Atendimento> list = new ArrayList<>();
        try(
            Connection con = this.conexao.getConnection();
            PreparedStatement stm= con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
        ){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            
            while(rs.next()){
                Corte corte = new CorteDao().findById(rs.getInt("corte_id"));
                Cliente cliente = new ClienteDao().findById(rs.getInt("cliente_id"));
                Agendamento agendamento = new AgendamentoDao().findById(rs.getInt("agenda_id"));
                Utilizador user = new UtilizadorDao().findById(rs.getInt("user_id"));
                
                Atendimento a = new Atendimento(formatter.parse(rs.getString("data")), rs.getDouble("valor"), user, corte, cliente);
                a.setId(rs.getInt("id"))
                    .setCreatedAt(formatter.parse(rs.getString("created_at")))
                    .setAgenda(rs.getBoolean("is_agenda"))
                    .setAgendamento(agendamento)
                    .setDeleted(rs.getBoolean("is_deleted"));
                list.add(a);
            }
            
        } catch (Exception ex) {
            GenericMessage.showErrorList();
        }
        return list;
    }

    @Override
    public Atendimento findById(int id) {
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
                
                Corte corte = new CorteDao().findById(rs.getInt("corte_id"));
                Cliente cliente = new ClienteDao().findById(rs.getInt("cliente_id"));
                Agendamento agendamento = new AgendamentoDao().findById(rs.getInt("agenda_id"));
                Utilizador user = new UtilizadorDao().findById(rs.getInt("user_id"));
                
                Atendimento a = new Atendimento(formatter.parse(rs.getString("data")), rs.getDouble("valor"), user, corte, cliente);
                a.setId(rs.getInt("id"))
                    .setCreatedAt(formatter.parse(rs.getString("created_at")))
                    .setAgenda(rs.getBoolean("is_agenda"))
                    .setAgendamento(agendamento)
                    .setDeleted(rs.getBoolean("is_deleted"));
                
                return a;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
