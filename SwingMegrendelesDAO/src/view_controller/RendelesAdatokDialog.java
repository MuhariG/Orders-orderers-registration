/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Rendeles;
import model.Szemely;

/**
 *
 * @author Gabika
 */
public class RendelesAdatokDialog extends javax.swing.JDialog {

    private boolean mentes;
    private Rendeles rendeles;
    private Szemely kivalasztott;

    public RendelesAdatokDialog(java.awt.Frame parent, boolean modal, /*List<Szemely> szemelyek*/ Szemely kivalasztott) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(parent);
        setTitle("Új megrendelés felvétele");

        mentes = false;
        this.kivalasztott = kivalasztott;
        tfMegrendelo.setText(kivalasztott.getNev());

        //cbMegrendelo.setModel(new DefaultComboBoxModel(new Vector<Szemely>(szemelyek)));
    }

    public boolean isMentes() {
        return mentes;
    }

    public Rendeles getRendeles() {
        return rendeles;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfOsszeg = new javax.swing.JTextField();
        tfDarabszam = new javax.swing.JTextField();
        chTeljesitve = new javax.swing.JCheckBox();
        btnMentes = new javax.swing.JButton();
        btnMegsem = new javax.swing.JButton();
        tfMegrendelo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Megrendelő:");

        jLabel2.setText("Összeg:");

        jLabel3.setText("Darabszám:");

        chTeljesitve.setText("Teljesítve:              ");
        chTeljesitve.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        chTeljesitve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chTeljesitveActionPerformed(evt);
            }
        });

        btnMentes.setText("Mentés");
        btnMentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMentesActionPerformed(evt);
            }
        });

        btnMegsem.setText("Mégsem");
        btnMegsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMegsemActionPerformed(evt);
            }
        });

        tfMegrendelo.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chTeljesitve)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnMentes)
                            .addGap(30, 30, 30)
                            .addComponent(btnMegsem))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3))
                            .addGap(50, 50, 50)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfDarabszam, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                .addComponent(tfMegrendelo)
                                .addComponent(tfOsszeg)))))
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfMegrendelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfOsszeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfDarabszam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chTeljesitve)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMentes)
                    .addComponent(btnMegsem))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chTeljesitveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chTeljesitveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chTeljesitveActionPerformed

    private void btnMentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMentesActionPerformed

        if (tfOsszeg.getText().isEmpty() || tfDarabszam.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Tölts ki minden mezőt!",
                    "Hiányzó adat(ok)", JOptionPane.ERROR_MESSAGE);
        } else {

            if (rendeles == null) {
                rendeles = new Rendeles();
            }

            try {
                //Szemely kivalasztott = (Szemely) cbMegrendelo.getSelectedItem();

                rendeles.setRendeloId(kivalasztott.getId());
                rendeles.setOsszeg(Integer.parseInt(tfOsszeg.getText()));
                rendeles.setDarabszam(Integer.parseInt(tfDarabszam.getText()));
                rendeles.setTeljesitve(chTeljesitve.isSelected());

                mentes = true;
                setVisible(false);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(rootPane, "Az összeg és a darabszám csak egész szám lehet!",
                        "Hibás adat(ok)", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnMentesActionPerformed

    private void btnMegsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMegsemActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnMegsemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMegsem;
    private javax.swing.JButton btnMentes;
    private javax.swing.JCheckBox chTeljesitve;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tfDarabszam;
    private javax.swing.JTextField tfMegrendelo;
    private javax.swing.JTextField tfOsszeg;
    // End of variables declaration//GEN-END:variables
}
