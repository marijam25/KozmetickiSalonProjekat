/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forme;

import komunikacija.KomunikacijaSaServerom;

/**
 *
 * @author milic
 */
public class GlavnaForma extends javax.swing.JFrame {

    
    /**
     * Creates new form GlavnaForma
     */
    public GlavnaForma() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnKreirajKozmeticara = new javax.swing.JButton();
        txtBrisanjeKozmeticara = new javax.swing.JButton();
        btnIzmenaKozmeticara = new javax.swing.JButton();
        btnKreiranjeUsluge = new javax.swing.JButton();
        btnPretragaUsluga = new javax.swing.JButton();
        btnObrisiUslugu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnKreirajKozmeticara.setText("Kreiraj kozmeticara");
        btnKreirajKozmeticara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajKozmeticaraActionPerformed(evt);
            }
        });

        txtBrisanjeKozmeticara.setText("Brisanje kozmeticara");
        txtBrisanjeKozmeticara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBrisanjeKozmeticaraActionPerformed(evt);
            }
        });

        btnIzmenaKozmeticara.setText("Izmena kozmeticara");
        btnIzmenaKozmeticara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmenaKozmeticaraActionPerformed(evt);
            }
        });

        btnKreiranjeUsluge.setText("Kreiranje usluge");
        btnKreiranjeUsluge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreiranjeUslugeActionPerformed(evt);
            }
        });

        btnPretragaUsluga.setText("Pretraga usluga");
        btnPretragaUsluga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretragaUslugaActionPerformed(evt);
            }
        });

        btnObrisiUslugu.setText("Obrisi uslugu");
        btnObrisiUslugu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiUsluguActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPretragaUsluga)
                    .addComponent(btnKreiranjeUsluge)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBrisanjeKozmeticara)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnIzmenaKozmeticara)
                                .addComponent(btnKreirajKozmeticara)))
                        .addGap(121, 121, 121)
                        .addComponent(btnObrisiUslugu)))
                .addContainerGap(429, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKreirajKozmeticara)
                    .addComponent(btnObrisiUslugu))
                .addGap(34, 34, 34)
                .addComponent(btnIzmenaKozmeticara)
                .addGap(37, 37, 37)
                .addComponent(txtBrisanjeKozmeticara)
                .addGap(41, 41, 41)
                .addComponent(btnKreiranjeUsluge)
                .addGap(50, 50, 50)
                .addComponent(btnPretragaUsluga)
                .addContainerGap(279, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKreirajKozmeticaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajKozmeticaraActionPerformed
        // TODO add your handling code here:
        KreirajKozmeticaraForma kkf = new KreirajKozmeticaraForma();
        this.setVisible(false);
        kkf.setVisible(true);
    }//GEN-LAST:event_btnKreirajKozmeticaraActionPerformed

    private void txtBrisanjeKozmeticaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBrisanjeKozmeticaraActionPerformed
        // TODO add your handling code here:
        BrisanjeKozmeticaraForma bkf = new BrisanjeKozmeticaraForma();
        this.setVisible(false);
        bkf.setVisible(true);
    }//GEN-LAST:event_txtBrisanjeKozmeticaraActionPerformed

    private void btnIzmenaKozmeticaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmenaKozmeticaraActionPerformed
        // TODO add your handling code here:
        IzmenaKozmeticaraForma ikf = new IzmenaKozmeticaraForma();
        this.setVisible(false);
        ikf.setVisible(true);
    }//GEN-LAST:event_btnIzmenaKozmeticaraActionPerformed

    private void btnKreiranjeUslugeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreiranjeUslugeActionPerformed
        // TODO add your handling code here:
        KreiranjeUslugeForma kuf = new KreiranjeUslugeForma();
        this.setVisible(false);
        kuf.setVisible(true);
    }//GEN-LAST:event_btnKreiranjeUslugeActionPerformed

    private void btnPretragaUslugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretragaUslugaActionPerformed
        // TODO add your handling code here:
        PretrazivanjeUsluge pu = new PretrazivanjeUsluge();
        this.setVisible(false);
        pu.setVisible(true);
    }//GEN-LAST:event_btnPretragaUslugaActionPerformed

    private void btnObrisiUsluguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiUsluguActionPerformed
        // TODO add your handling code here:
        BrisanjeUslugeForma buf = new BrisanjeUslugeForma();
        this.setVisible(false);
        buf.setVisible(true);
    }//GEN-LAST:event_btnObrisiUsluguActionPerformed

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
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GlavnaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmenaKozmeticara;
    private javax.swing.JButton btnKreirajKozmeticara;
    private javax.swing.JButton btnKreiranjeUsluge;
    private javax.swing.JButton btnObrisiUslugu;
    private javax.swing.JButton btnPretragaUsluga;
    private javax.swing.JButton txtBrisanjeKozmeticara;
    // End of variables declaration//GEN-END:variables

   
}
