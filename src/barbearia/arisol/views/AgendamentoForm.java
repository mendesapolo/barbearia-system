/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package barbearia.arisol.views;

import barbearia.arisol.dao.AgendamentoDao;
import barbearia.arisol.dao.ClienteDao;
import barbearia.arisol.dao.CorteDao;
import barbearia.arisol.dao.LoggerDao;
import barbearia.arisol.dao.SistemaDao;
import barbearia.arisol.data_adapter.AgendamentoAdapter;
import barbearia.arisol.models.Agendamento;
import barbearia.arisol.models.Cliente;
import barbearia.arisol.models.Corte;
import barbearia.arisol.models.Sistema;
import barbearia.arisol.models.Utilizador;
import barbearia.arisol.util.GenericMessage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author António Apolo
 */
public class AgendamentoForm extends javax.swing.JDialog {
    
    private double valorAux = 0;
    private AgendamentoDao agendamentoDao;
    private Utilizador utilizadorLogado;
    
    /**
     * Creates new form AgendamentoForm
     * @param parent
     * @param modal
     */
    public AgendamentoForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.utilizadorLogado = new LoggerDao().getActiveUser();
        
        this.agendamentoDao = new AgendamentoDao();
        this.txtValor.setEnabled(false);
        this.chIsActivo.setEnabled(false);
        
        getCortes();
        getClientes();
        clear();
        dataTable();
    }
    
    private void getCortes(){
        ArrayList<Corte> listC = (ArrayList<Corte>) new CorteDao().findAll();
        Corte[] cortes = new Corte[listC.size()];
        cortes = listC.toArray(cortes);
        DefaultComboBoxModel<Corte> model = new DefaultComboBoxModel<>(cortes);
        this.cbCortes.setModel(model);
    }
    
    private void getClientes(){
        cbClientes.removeAllItems();
        for(Cliente c: new ClienteDao().findAll()){
            cbClientes.addItem(c);
        }
    }
    
    private void dataTable(){
        dataTable.setModel(new AgendamentoAdapter());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbCortes = new javax.swing.JComboBox<>();
        cbClientes = new javax.swing.JComboBox<>();
        txtValor = new javax.swing.JTextField();
        txtData = new javax.swing.JFormattedTextField();
        chIsActivo = new javax.swing.JCheckBox();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnFeito = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(56, 179, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        cbCortes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCortesItemStateChanged(evt);
            }
        });

        txtValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        chIsActivo.setText("Esta Cancelado");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Data");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Valor");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Corte");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Cliente");

        btnClear.setBackground(new java.awt.Color(51, 204, 255));
        btnClear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClear.setText("Novo");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(0, 0, 153));
        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Salvar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 0, 153));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Atualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel5.setText("Agendamentos");

        btnFeito.setBackground(new java.awt.Color(0, 204, 153));
        btnFeito.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnFeito.setForeground(new java.awt.Color(0, 102, 51));
        btnFeito.setText("Feito");
        btnFeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeitoActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barbearia/arisol/views/assets/icons8-calendar-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFeito))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCortes, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chIsActivo)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(chIsActivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbCortes, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                                    .addComponent(txtValor)
                                    .addComponent(cbClientes))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnFeito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(229, 246, 255));

        dataTable.setBackground(new java.awt.Color(229, 246, 255));
        dataTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dataTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbCortesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCortesItemStateChanged
        calcularValor();
    }//GEN-LAST:event_cbCortesItemStateChanged

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            String data = this.txtData.getText();
            Cliente cliente = (Cliente) this.cbClientes.getSelectedItem();
            Corte corte = (Corte) this.cbCortes.getSelectedItem();
            double valor = Double.parseDouble(this.txtValor.getText());
            
            Agendamento a = new Agendamento(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data), valor, cliente, corte);
            agendamentoDao.create(a);
            
            GenericMessage.showSuccess(this, "Agendado com sucesso");
            clear();
            dataTable();
        } catch (ParseException ex) {
            GenericMessage.showAlertMessage(this, "Erro no sistema");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void dataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTableMouseClicked
        int idx = dataTable.getSelectedRow();
        if(idx >= 0){
            Agendamento a = new AgendamentoAdapter().getRow(idx);
            if(!a.isCancelado()){
                this.txtData.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(a.getData()));
                this.txtValor.setText(""+a.getValor());
                this.chIsActivo.setSelected(a.isCancelado());
                
                this.btnFeito.setEnabled(!a.isAtendido() && !a.isCancelado());
                cbClientes.setEnabled(false);
                cbCortes.setEnabled(false);
                this.btnSave.setEnabled(false);
                
                if(this.utilizadorLogado.getType().toLowerCase().equals("barbeiro")){
                    this.btnCancelar.setEnabled(false);
                }else{
                    btnCancelar.setEnabled(!a.isCancelado() && !a.isAtendido());
                }
                
                if(a.isAtendido()){
                    this.txtValor.setEnabled(false);
                    this.txtData.setEnabled(false);
                    this.btnUpdate.setEnabled(false);            
                }else{
                    this.txtValor.setEnabled(true);
                    this.txtData.setEnabled(true);
                    this.btnUpdate.setEnabled(true);            
                }
            }
        }
    }//GEN-LAST:event_dataTableMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            int idx = dataTable.getSelectedRow();
            if(idx >= 0){
                Agendamento a = new AgendamentoAdapter().getRow(idx);
                String data = this.txtData.getText();
                double valor = Double.parseDouble(this.txtValor.getText());
                
                a.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data))
                        .setValor(valor);
                
                agendamentoDao.update(a);

                GenericMessage.showSuccessUpdate(this);
                clear();
                dataTable();
            }
        } catch (ParseException ex) {
            GenericMessage.showAlertMessage(this, "Erro no sistema");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int conf = JOptionPane.showConfirmDialog(this, "Pretendes cancelar este agendamento?", "Cancelamento", JOptionPane.OK_CANCEL_OPTION);
        if(conf == JOptionPane.OK_OPTION){
            Agendamento a = new AgendamentoAdapter().getRow(dataTable.getSelectedRow());
            a.setCancelado(true);
            this.agendamentoDao.update(a);
            GenericMessage.showSuccessUpdate(this);
            
            clear();
            dataTable();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
//        int idx = dataTable.getSelectedRow();
//        if(idx >= 0){
//            Agendamento a = new AgendamentoAdapter().getRow(idx);
//            if(!a.isCancelado()){
//                this.txtData.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(a.getData()));
//                this.valorAux = a.getValor();
//                this.txtValor.setText(this.valorAux+"");
//                this.chIsActivo.setSelected(a.isCancelado());
//                
//                this.cbClientes.setSelectedItem(a.getCliente());
//                this.cbCortes.setSelectedItem(a.getCorte());
//                
//                btnCancelar.setEnabled(!a.isCancelado());
//                this.btnSave.setEnabled(false);
//                this.btnUpdate.setEnabled(true);
//            }
//        }
    }//GEN-LAST:event_jPanel1MousePressed

    private void btnFeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeitoActionPerformed
        int conf = JOptionPane.showConfirmDialog(this, "Pretende terminar o agendamento?", "Agendamento", JOptionPane.OK_CANCEL_OPTION);
        if(conf == JOptionPane.OK_OPTION){
            Agendamento a = new AgendamentoAdapter().getRow(dataTable.getSelectedRow());
            a.setAtendido(true);
            this.agendamentoDao.update(a);
            GenericMessage.showSuccessUpdate(this);
            
            clear();
            dataTable();
        }
                
    }//GEN-LAST:event_btnFeitoActionPerformed

    private void calcularValor(){
        Sistema s = new SistemaDao().getAtual();
        Corte c = (Corte) cbCortes.getSelectedItem();
        if(s != null){
            this.valorAux = c.getPreco()+s.getTaxaAgendamento();
        }else{
            this.valorAux = c.getPreco();
        }
        this.txtValor.setText(this.valorAux+"");
    }
    
    private void clear(){
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy H:m");
        String maskDate = sdf.format(new Date());
        
        this.txtData.setText(maskDate);
        this.txtValor.setText("");
        this.cbCortes.setSelectedIndex(0);
        this.cbClientes.setSelectedIndex(0);
        
        this.calcularValor();
        this.btnCancelar.setEnabled(false);
        this.chIsActivo.setSelected(false);
        
        btnFeito.setEnabled(false);
        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
        cbClientes.setEnabled(true);
        cbCortes.setEnabled(true);
        this.txtValor.setEnabled(true);
        this.txtData.setEnabled(true);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgendamentoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendamentoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendamentoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendamentoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            AgendamentoForm dialog = new AgendamentoForm(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFeito;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<Cliente> cbClientes;
    private javax.swing.JComboBox<Corte> cbCortes;
    private javax.swing.JCheckBox chIsActivo;
    private javax.swing.JTable dataTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}