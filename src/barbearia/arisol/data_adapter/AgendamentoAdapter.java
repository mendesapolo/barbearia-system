/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbearia.arisol.data_adapter;

import barbearia.arisol.dao.AgendamentoDao;
import barbearia.arisol.models.Agendamento;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author António Apolo
 */
public class AgendamentoAdapter extends AbstractTableModel{
    
    private List<Agendamento> list;
    private String[] columns;
    
    public AgendamentoAdapter(){
        this.list = new ArrayList<>();
        for(Agendamento a: new AgendamentoDao().findAll()){
            if(!a.isCancelado()){
                this.list.add(a);
            }
        }
        this.columns  = new String[]{"Ord.", "Data", "Valor", "Corte", "Cliente", "Atendido", "Cancelado"};
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
        Agendamento c = list.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> (rowIndex + 1);
            case 1 -> new SimpleDateFormat("dd/MM/yyyy HH:mm").format(c.getData());
            case 2 -> c.getValor();
            case 3 -> c.getCorte().getNome();
            case 4 -> c.getCliente().getNome();
            case 5 -> c.isAtendido()? "SIM": "NÃO";
            case 6 -> c.isCancelado()? "SIM": "NÃO";
            default -> "---";
        };
    }
    
    public Agendamento getRow(int index){
        return this.list.get(index);
    }
    
}
