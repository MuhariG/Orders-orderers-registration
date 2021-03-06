/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.DBModel;
import model.IModel;

/**
 *
 * @author Gabika
 */
public class Foablak extends javax.swing.JFrame {

    private IModel model;

    public Foablak() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Megrendelések nyilvántartása v0.1");

        String ConnURL = "jdbc:mysql://localhost:3306/megrendelesek";
        String dbUser = "root";
        String dbPass = "1234";

        Connection conn;
        try {
            conn = DriverManager.getConnection(ConnURL, dbUser, dbPass);
            model = new DBModel(conn);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex, "Adatbázis hiba", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
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

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnNevjegy = new javax.swing.JMenuItem();
        btnKilepes = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miMegrendelok = new javax.swing.JMenuItem();
        miRendelesek = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_controller/DBHatter.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        jMenu1.setText("File");

        btnNevjegy.setText("Névjegy");
        btnNevjegy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNevjegyActionPerformed(evt);
            }
        });
        jMenu1.add(btnNevjegy);

        btnKilepes.setText("Kilépés");
        btnKilepes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKilepesActionPerformed(evt);
            }
        });
        jMenu1.add(btnKilepes);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Adatok");

        miMegrendelok.setText("Megrendelők");
        miMegrendelok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMegrendelokActionPerformed(evt);
            }
        });
        jMenu2.add(miMegrendelok);

        miRendelesek.setText("Rendelések");
        miRendelesek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRendelesekActionPerformed(evt);
            }
        });
        jMenu2.add(miRendelesek);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miMegrendelokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMegrendelokActionPerformed
        MegrendelokDialog md = new MegrendelokDialog(this, true, model);
        md.setVisible(true);
    }//GEN-LAST:event_miMegrendelokActionPerformed

    private void miRendelesekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRendelesekActionPerformed
        RendelesekDialog rd = new RendelesekDialog(this, true, model);
        rd.setVisible(true);
    }//GEN-LAST:event_miRendelesekActionPerformed

    private void btnKilepesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKilepesActionPerformed
        int valasz = JOptionPane.showConfirmDialog(rootPane, "Biztosan kilépsz?", "Kilépés", JOptionPane.YES_NO_OPTION);

        if (valasz == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnKilepesActionPerformed

    private void btnNevjegyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNevjegyActionPerformed
        NevjegyDialog nd = new NevjegyDialog(this, true);
        nd.setVisible(true);
    }//GEN-LAST:event_btnNevjegyActionPerformed

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
            java.util.logging.Logger.getLogger(Foablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Foablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Foablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Foablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Foablak().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnKilepes;
    private javax.swing.JMenuItem btnNevjegy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem miMegrendelok;
    private javax.swing.JMenuItem miRendelesek;
    // End of variables declaration//GEN-END:variables
}
