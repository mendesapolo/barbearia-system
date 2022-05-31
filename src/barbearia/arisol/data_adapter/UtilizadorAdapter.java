/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbearia.arisol.data_adapter;

import barbearia.arisol.dao.UtilizadorDao;
import barbearia.arisol.models.Utilizador;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author António Apolo
 */
public class UtilizadorAdapter extends AbstractTableModel{
    
    private List<Utilizador> list;
    private String[] columns;
    
    public UtilizadorAdapter(){
        this.list = new UtilizadorDao().findAll();
        this.columns  = new String[]{"Ord.", "Nome", "Data Nascimento", "Identidade", "Telefone", "Username", "Senha", "Tipo", "Activo", "Data Reg."};
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Utilizador u = list.get(rowIndex);
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        return switch (columnIndex) {
            case 0 -> (rowIndex + 1);
            case 1 -> u.getNome();
            case 2 -> formatDate.format(u.getDataNascimento());
            case 3 -> u.getIdentidade();
            case 4 -> u.getTelefone();
            case 5 -> u.getUsername();
            case 6 -> "******";
            case 7 -> u.getType().toUpperCase();
            case 8 -> u.isActivo()? "SIM": "NÃO";
            case 9 -> formatDate.format(u.getCreatedAt());
            default -> "---";
        };
    }
    
    public Utilizador getRow(int index){
        return this.list.get(index);
    }
    
}
