/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbearia.arisol.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author António Apolo
 */
public class Conexao {

    private String url = null;
    private Connection connection;

    public Conexao(String url) {
        this.url = "jdbc:sqlite:" + url;
        this.connection = null;
    }

    public Conexao() {
        this.url = "jdbc:sqlite:barbearia.db";
        this.connection = null;
    }

    public String getUrl() {
        return url;
    }

    public Connection getConnection() {
        try {
            if (this.connection == null) {
                this.open();
            }
            if (this.connection.isClosed()) {
                this.open();
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Não foi possível abrir a conexão com o banco de dados!", "Erro de conexão", JOptionPane.ERROR_MESSAGE);
        }
        return this.connection;
    }

    private void open() {
        try {
            Class.forName("org.sqlite.JDBC");
//            this.connection = DriverManager.getConnection("jdbc:sqlite:" + this.url);
            this.connection = DriverManager.getConnection(this.url);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Não foi possível abrir a conexão com o banco de dados!", "Erro de conexão", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException err) {
            JOptionPane.showMessageDialog(null, "Falha ao encontrar o driver de conexão de bases de dados", "Erro de conexão", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void close(){
        if (this.connection == null) {
            return;
        }
        try {
            if (!this.connection.isClosed()) {
                this.connection.close();
            }
        } catch (SQLException err) {
            System.err.println("Erro de conexão: Falha ao encontrar o driver de conexão de bases de dados");
        }
    }

    public void executeUpdate(String query) {
        try (
            Connection conn = this.getConnection();
            Statement stm = conn.createStatement();
        ) {
            if(conn == null) return;
            
            stm.executeUpdate(query);
        }catch(SQLException err){
            System.err.println("Erro ao executar a query inserida: "+query);
        }
    }
}
