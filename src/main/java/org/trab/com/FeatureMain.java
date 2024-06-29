/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.trab.com;

import controller.AgendasController;
import java.awt.BorderLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.entities.AgendasEntity;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultKeyedValuesDataset;
import org.jfree.data.general.DefaultPieDataset;
import viewSwing.JIFAgendar;
import viewSwing.JIFMedicamentoNew;
import viewSwing.JIFMedicamentos;
import viewSwing.JIFPacientes;
import viewSwing.JIFProdutividade;
import viewSwing.JIFProntuarios;

/**
 *
 * @author Queiro Ubeda
 */
public class FeatureMain extends javax.swing.JFrame {

    AgendasController agendasController= new AgendasController();
    /**
     * Creates new form FeatureMain
     */
    public FeatureMain() {
        
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jmPacientes = new javax.swing.JMenu();
        jmiAdmiPacientes = new javax.swing.JMenuItem();
        jmAgendamentos = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jmMedicamentos = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jmProntuario = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(200, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.-psicologia-Photoroom (3).png"))); // NOI18N

        jDesktop.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopLayout = new javax.swing.GroupLayout(jDesktop);
        jDesktop.setLayout(jDesktopLayout);
        jDesktopLayout.setHorizontalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopLayout.createSequentialGroup()
                .addGap(384, 384, 384)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(799, Short.MAX_VALUE))
        );
        jDesktopLayout.setVerticalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(265, Short.MAX_VALUE))
        );

        jmPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PacientesIcon.png"))); // NOI18N
        jmPacientes.setText("Pacientes");
        jmPacientes.setToolTipText("");

        jmiAdmiPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PacientesAdmiIcon.png"))); // NOI18N
        jmiAdmiPacientes.setText("Administrar");
        jmiAdmiPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAdmiPacientesActionPerformed(evt);
            }
        });
        jmPacientes.add(jmiAdmiPacientes);

        jMenuBar.add(jmPacientes);

        jmAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AgendaIcon.png"))); // NOI18N
        jmAgendamentos.setText("Agendamentos");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PacientesAdmiIcon.png"))); // NOI18N
        jMenuItem1.setText("Administrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmAgendamentos.add(jMenuItem1);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconmonstr-chart-2-16.png"))); // NOI18N
        jMenuItem5.setText("Produtividade");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jmAgendamentos.add(jMenuItem5);

        jMenuBar.add(jmAgendamentos);

        jmMedicamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MedicamentosIcon.png"))); // NOI18N
        jmMedicamentos.setText("Medicamentos");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PacientesAdmiIcon.png"))); // NOI18N
        jMenuItem2.setText("Administrar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jmMedicamentos.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MedicamentosPacientesIcon.png"))); // NOI18N
        jMenuItem3.setText("Cadastrar Medicamento Paciente");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jmMedicamentos.add(jMenuItem3);

        jMenuBar.add(jmMedicamentos);

        jmProntuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ProntuariosIcon.png"))); // NOI18N
        jmProntuario.setText("Prontuario");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PacientesAdmiIcon.png"))); // NOI18N
        jMenuItem4.setText("Administrar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jmProntuario.add(jMenuItem4);

        jMenuBar.add(jmProntuario);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktop, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiAdmiPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAdmiPacientesActionPerformed
          JIFPacientes telaPAciente= new JIFPacientes();
          jDesktop.add(telaPAciente);
          telaPAciente.setVisible(true);
          telaPAciente.setPosicao();
    }//GEN-LAST:event_jmiAdmiPacientesActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JIFAgendar telaAgendar = new JIFAgendar ();
          jDesktop.add(telaAgendar);
          telaAgendar.setVisible(true);
          telaAgendar.setPosicao();

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JIFMedicamentoNew telaAdministrarMedicamentos= new JIFMedicamentoNew();
        jDesktop.add(telaAdministrarMedicamentos);
        telaAdministrarMedicamentos.setVisible(true);
        telaAdministrarMedicamentos.setPosicao();

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JIFMedicamentos telaMedicamentosPacientes= new JIFMedicamentos();
        jDesktop.add(telaMedicamentosPacientes);
        telaMedicamentosPacientes.setVisible(true);
        telaMedicamentosPacientes.setPosicao();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        JIFProntuarios telaPriontuarios= new JIFProntuarios();
        jDesktop.add(telaPriontuarios);
        telaPriontuarios.setVisible(true);
        telaPriontuarios.setPosicao();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        JIFProdutividade telaProdutividade= new JIFProdutividade();
        jDesktop.add(telaProdutividade);
        telaProdutividade.setVisible(true);
        telaProdutividade.setPosicao();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    
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
            java.util.logging.Logger.getLogger(FeatureMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FeatureMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FeatureMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FeatureMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FeatureMain().setVisible(true);
            }
        });
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane jDesktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenu jmAgendamentos;
    private javax.swing.JMenu jmMedicamentos;
    private javax.swing.JMenu jmPacientes;
    private javax.swing.JMenu jmProntuario;
    private javax.swing.JMenuItem jmiAdmiPacientes;
    // End of variables declaration//GEN-END:variables
}
