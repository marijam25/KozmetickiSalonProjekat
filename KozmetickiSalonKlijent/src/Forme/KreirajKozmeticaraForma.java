/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forme;

import Domen.Kozmeticar;
import KlijentskiZahtev.DodajNovogKozmeticaraZahtev;
import KlijentskiZahtev.TipoviZahteva;
import ServerskiOdgovor.DodajNovogKozmeticaraOdgovor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.KomunikacijaSaServerom;

/**
 *
 * @author milic
 */
public class KreirajKozmeticaraForma extends javax.swing.JFrame {

    /**
     * Creates new form KreirajKozmeticaraForma
     */
    public KreirajKozmeticaraForma() {
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

        txtImeKozmeticara = new javax.swing.JTextField();
        txtPrezimeKozmeticara = new javax.swing.JTextField();
        btnSacuvaj = new javax.swing.JButton();
        btnNazad = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnNazad.setText("Nazad");
        btnNazad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNazadActionPerformed(evt);
            }
        });

        jLabel1.setText("Unos kozmeticara");

        jLabel2.setText("Ime");

        jLabel3.setText("Prezime");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(311, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNazad)
                    .addComponent(btnSacuvaj))
                .addGap(302, 302, 302))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(159, 159, 159)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtImeKozmeticara, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addComponent(txtPrezimeKozmeticara)))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtImeKozmeticara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrezimeKozmeticara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(67, 67, 67)
                .addComponent(btnSacuvaj)
                .addGap(40, 40, 40)
                .addComponent(btnNazad)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            // TODO add your handling code here:
            String ime = txtImeKozmeticara.getText();
            String prezime = txtPrezimeKozmeticara.getText();
            Kozmeticar kozmeticar = new Kozmeticar(0, ime, prezime);
            
            if(ime.isEmpty() || prezime.isEmpty()){
                JOptionPane.showMessageDialog(this, "Polja ne smeju biti prazna!");
            }
            
            DodajNovogKozmeticaraZahtev zahtev = new DodajNovogKozmeticaraZahtev(kozmeticar);
        
            KomunikacijaSaServerom.getInstanca().getOos().writeInt(TipoviZahteva.DODAJ_NOVOG_KOZMETICARA_ZAHTEV);
            KomunikacijaSaServerom.getInstanca().getOos().writeObject(zahtev);
            
            int tipOdgovora = KomunikacijaSaServerom.getInstanca().getOis().readInt();
            DodajNovogKozmeticaraOdgovor odgovor = (DodajNovogKozmeticaraOdgovor) KomunikacijaSaServerom.getInstanca().getOis().readObject();
            if(odgovor.isUspeo()){
                JOptionPane.showMessageDialog(this, "Kozmeticar uspesno unet!");
            }
            else{
                JOptionPane.showMessageDialog(this, "Neuspesno unosenje kozmeticara!");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(KreirajKozmeticaraForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KreirajKozmeticaraForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNazadActionPerformed
        // TODO add your handling code here:
        GlavnaForma gf = new GlavnaForma();
        this.setVisible(false);
        gf.setVisible(true);
    }//GEN-LAST:event_btnNazadActionPerformed

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
            java.util.logging.Logger.getLogger(KreirajKozmeticaraForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KreirajKozmeticaraForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KreirajKozmeticaraForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KreirajKozmeticaraForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KreirajKozmeticaraForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNazad;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtImeKozmeticara;
    private javax.swing.JTextField txtPrezimeKozmeticara;
    // End of variables declaration//GEN-END:variables
}
