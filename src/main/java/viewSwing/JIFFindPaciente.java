/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package viewSwing;

import controller.PacienteController;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.entities.AgendasEntity;
import model.entities.PacientesEntity;
import static org.trab.com.FeatureMain.jDesktop;

/**
 *
 * @author Queiro Ubeda
 */
public class JIFFindPaciente extends javax.swing.JInternalFrame {
    PacienteController pacienteController = new PacienteController();
    DefaultTableModel model = new DefaultTableModel();
    Long selectClienteId;
    Boolean telaDecitiom;
    /**
     * Creates new form JIFFindPaciente
     */
    public JIFFindPaciente(Boolean tela) {
    initComponents();
    popularTabela();
    this.telaDecitiom = tela;  // Corrigir a atribuição
    }
    public void setPosicao() {
        JDesktopPane desktopPane = getDesktopPane();
        if (desktopPane != null) {
            Dimension d = desktopPane.getSize();
            this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
        }
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jpButton = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jbFechar = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(5, 113, 189));

        jLabel1.setText("Selecinar Paciente:");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
        );

        jbFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FecharIcon.png"))); // NOI18N
        jbFechar.setText("Fechar");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SalvarIcon2.png"))); // NOI18N
        jbSalvar.setText("Selecinar Paciente");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpButtonLayout = new javax.swing.GroupLayout(jpButton);
        jpButton.setLayout(jpButtonLayout);
        jpButtonLayout.setHorizontalGroup(
            jpButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpButtonLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(jbFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpButtonLayout.setVerticalGroup(
            jpButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        dispose();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        int selectedRow = jTable3.getSelectedRow(); 
        if (selectedRow >= 0) {  
            Long idSelecionado = Long.valueOf(jTable3.getValueAt(selectedRow, 0).toString());

            PacientesEntity paciente = pacienteController.finById(idSelecionado);

            if (paciente != null) {
                try {
                    if (telaDecitiom) {
                        JIFAgendar telaAgendar = new JIFAgendar();
                        jDesktop.add(telaAgendar);
                        telaAgendar.setVisible(true);
                        telaAgendar.setPosicao();
                        telaAgendar.toFront();
                        telaAgendar.textNome.setText(paciente.getNome());   
                        telaAgendar.textId.setText(String.format("%d", paciente.getId()));
                    } else {
                        JIFMedicamentos telaMedicamentos = new JIFMedicamentos();
                        jDesktop.add(telaMedicamentos);
                        telaMedicamentos.setVisible(true);
                        telaMedicamentos.setPosicao();
                        telaMedicamentos.toFront();
                        telaMedicamentos.textNome.setText(paciente.getNome());   
                        telaMedicamentos.textId.setText(String.format("%d", paciente.getId()));
                    }
                    dispose();
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Erro ao selecionar paciente: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Paciente não encontrado");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma linha selecionada");
        }
        
        
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
      
    }//GEN-LAST:event_jTable3MouseClicked

    private void popularTabela(){
        
        java.util.List<PacientesEntity> dadosPacientes = pacienteController.findAll();

        java.util.List<Object[]> linhas= new ArrayList<>();
        for (PacientesEntity paciente : dadosPacientes) {
            linhas.add(new Object[]{
                paciente.getId(),
                paciente.getNome(),
                paciente.getDataNascimento(),
            });
        }
      
        Object[][] data = linhas.toArray(new Object[0][]);
        String[] columnNames = {"ID", "Nome Paciente", "Data Nascimentto"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        jTable3.setModel(model);
        this.model=model;
    }
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable3;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JPanel jpButton;
    // End of variables declaration//GEN-END:variables
}
