/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbearia.arisol.data_adapter;

import barbearia.arisol.dao.AtendimentoDao;
import barbearia.arisol.models.Atendimento;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author António Apolo
 */
public class AtendimentoAdapter extends AbstractTableModel{
    
    private List<Atendimento> list;
    private String[] columns;
    
    public AtendimentoAdapter(){
        this.list = new AtendimentoDao().findAll();
        this.columns  = new String[]{"Ord.", "Valor", "Corte", "Cliente", "Data"};
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
        Atendimento a = list.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> (rowIndex + 1);
            case 1 -> a.getValor();
            case 2 -> a.getCorte().getNome();
            case 3 -> a.getCliente().getNome();
            case 4 -> new SimpleDateFormat("dd/MM/yyyy").format(a.getData());
            default -> "---";
        };
    }
    
    public Atendimento getRow(int index){
        return this.list.get(index);
    }
    
}
