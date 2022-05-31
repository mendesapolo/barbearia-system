/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbearia.arisol.data_adapter;

import barbearia.arisol.dao.ClienteDao;
import barbearia.arisol.dao.CorteDao;
import barbearia.arisol.models.Cliente;
import barbearia.arisol.models.Corte;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author António Apolo
 */
public class ClienteAdapter extends AbstractTableModel{
    
    private List<Cliente> list;
    private String[] columns;
    
    public ClienteAdapter(){
        this.list = new ClienteDao().findAll();
        this.columns  = new String[]{"Ord.", "Nome", "Identidade", "Telefone", "Esta Activo"};
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
        Cliente c = list.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> (rowIndex + 1);
            case 1 -> c.getNome();
            case 2 -> c.getIdentidade();
            case 3 -> c.getTelefone();
            case 4 -> c.isActivo()? "SIM": "NÃO";
            default -> "---";
        };
    }
    
    public Cliente getRow(int index){
        return this.list.get(index);
    }
    
}
