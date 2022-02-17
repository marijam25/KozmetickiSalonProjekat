/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forme;

import Domen.Kozmeticar;
import KlijentskiZahtev.TipoviZahteva;
import Modeli.ModelTabeleKozmeticara;
import ServerskiOdgovor.VratiSveKozmeticareOdgovor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.KomunikacijaSaServerom;

/**
 *
 * @author milic
 */
public class IzmenaKozmeticaraForma extends javax.swing.JFrame {

    private ArrayList<Kozmeticar> listaTabela;

    /**
     * Creates new form IzmenaKozmeticaraForma
     */
    public IzmenaKozmeticaraForma() {
        initComponents();
        listaTabela = new ArrayList<>();
        podesiModelTabele();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPrezime = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKozmeticar = new javax.swing.JTable();
        btnPretrazi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnNazad = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblKozmeticar.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblKozmeticar);

        btnPretrazi.setText("Pretrazi");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnNazad.setText("Nazad");
        btnNazad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNazadActionPerformed(evt);
            }
        });

        jLabel1.setText("Izmena kozmeticara");

        jLabel2.setText("Pretraga kozmeticara po prezimenu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNazad)
                        .addGap(635, 635, 635)
                        .addComponent(btnIzmeni))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(47, 47, 47)
                            .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(71, 71, 71)
                            .addComponent(btnPretrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnPretrazi))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzmeni)
                    .addComponent(btnNazad))
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        try {
            // TODO add your handling code here:
            String pretraga = txtPrezime.getText();

            ObjectOutputStream oos = KomunikacijaSaServerom.getInstanca().getOos();
            ObjectInputStream ois = KomunikacijaSaServerom.getInstanca().getOis();
            oos.writeInt(TipoviZahteva.VRATI_SVE_KOZMETICARE_ZAHTEV);
            oos.flush();

            int tipOdgovora = ois.readInt();
            VratiSveKozmeticareOdgovor odgovor = (VratiSveKozmeticareOdgovor) ois.readObject();

            listaTabela = new ArrayList<>();
            for (Kozmeticar kozmeticar : odgovor.getListaKozmeticara()) {
                if (kozmeticar.getPrezime().toLowerCase().contains(pretraga.toLowerCase())) {
                    listaTabela.add(kozmeticar);
                }
            }
            podesiModelTabele();

            if (!listaTabela.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sistem je nasao kozmeticare po zadatoj vrednosti");
            } else {

                JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje kozmeticare po zadatoj vrednosti");
            }

        } catch (IOException ex) {
            Logger.getLogger(IzmenaKozmeticaraForma.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje kozmeticare po zadatoj vrednosti");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IzmenaKozmeticaraForma.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje kozmeticare po zadatoj vrednosti");
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        // TODO add your handling code here:
        int izabraniRed = tblKozmeticar.getSelectedRow();
        if (izabraniRed == -1) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita kozmeticara");
        } else {
            Kozmeticar kozmeticar = listaTabela.get(izabraniRed);
            KozmeticarIzmenaForma kif = new KozmeticarIzmenaForma(kozmeticar);
            this.setVisible(false);
            kif.setVisible(true);
            podesiModelTabele();
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

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
            java.util.logging.Logger.getLogger(IzmenaKozmeticaraForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IzmenaKozmeticaraForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IzmenaKozmeticaraForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IzmenaKozmeticaraForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IzmenaKozmeticaraForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnNazad;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKozmeticar;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    private void podesiModelTabele() {
        ModelTabeleKozmeticara mtk = new ModelTabeleKozmeticara(listaTabela);
        tblKozmeticar.setModel(mtk);
        mtk.osveziTabelu();
    }
}
