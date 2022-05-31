/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbearia.arisol.data_adapter;

import barbearia.arisol.dao.CategoriaDao;
import barbearia.arisol.models.Categoria;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author António Apolo
 */
public class CategoriaAdapter extends AbstractTableModel{
    
    private List<Categoria> list;
    private String[] columns;
    
    public CategoriaAdapter(){
        this.list = new CategoriaDao().findAll();
        this.columns  = new String[]{"Ord.", "Nome", "Descrição"};
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
        Categoria c = list.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> (rowIndex + 1);
            case 1 -> c.getNome();
            case 2 -> c.getDescricao();
            default -> "---";
        };
    }
    
    public Categoria getRow(int index){
        return this.list.get(index);
    }
    
}
