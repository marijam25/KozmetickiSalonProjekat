/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forme;

import Domen.Usluga;
import KlijentskiZahtev.ObrisiUsluguZahtev;
import KlijentskiZahtev.TipoviZahteva;
import Modeli.ModelTabeleUsluge;
import ServerskiOdgovor.ObrisiUsluguOdgovor;
import ServerskiOdgovor.PretraziUslugeOdgovor;
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
public class BrisanjeUslugeForma extends javax.swing.JFrame {

    private ArrayList<Usluga> listaTabela;

    /**
     * Creates new form BrisanjeUslugeForma
     */
    public BrisanjeUslugeForma() {
        initComponents();
        tblUsluge.setVisible(false);
        listaTabela = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNazivUsluge = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsluge = new javax.swing.JTable();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPretrazi.setText("Pretrazi");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        tblUsluge.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblUsluge);

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(txtNazivUsluge, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPretrazi)
                .addGap(123, 123, 123))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnObrisi)
                .addGap(136, 136, 136))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNazivUsluge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretrazi))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnObrisi)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        try {
            // TODO add your handling code here:
            String pretraga = txtNazivUsluge.getText();
            
            ObjectOutputStream oos = KomunikacijaSaServerom.getInstanca().getOos();
            ObjectInputStream ois = KomunikacijaSaServerom.getInstanca().getOis();
            oos.writeInt(TipoviZahteva.PRETRAZI_USLUGE_ZAHTEV);
            oos.flush();
            
            int tipOdgovora = ois.readInt();
            PretraziUslugeOdgovor odgovor = (PretraziUslugeOdgovor) ois.readObject();
            
            for (Usluga usluga : odgovor.getNizUsluga()) {
                if (usluga.getNazivUsluge().toLowerCase().contains(pretraga.toLowerCase())) {
                    listaTabela.add(usluga);
                }
            }
            ModelTabeleUsluge mtu = new ModelTabeleUsluge(listaTabela);
            tblUsluge.setModel(mtu);
            tblUsluge.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(BrisanjeUslugeForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BrisanjeUslugeForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        try {
            // TODO add your handling code here:
            int izabraniRed = tblUsluge.getSelectedRow();
            Usluga usluga = listaTabela.get(izabraniRed);
            
            ObrisiUsluguZahtev zahtev = new ObrisiUsluguZahtev(usluga);
            
            KomunikacijaSaServerom.getInstanca().getOos().writeInt(TipoviZahteva.OBRISI_USLUGU_ZAHTEV);
            KomunikacijaSaServerom.getInstanca().getOos().writeObject(zahtev);
            
            int tipOdgovora = KomunikacijaSaServerom.getInstanca().getOis().readInt();
            ObrisiUsluguOdgovor odgovor = (ObrisiUsluguOdgovor) KomunikacijaSaServerom.getInstanca().getOis().readObject();
            
            if(odgovor.isUspeo()){
                JOptionPane.showMessageDialog(this, "Usluga uspesno obrisana!");
                listaTabela.remove(usluga);
            }
            else{
                JOptionPane.showMessageDialog(this, "Neuspesno brisanje usluge!");
            }
            
            ModelTabeleUsluge mtu = new ModelTabeleUsluge(listaTabela);
            tblUsluge.setModel(mtu);
            mtu.osveziTabelu();
        } catch (IOException ex) {
            Logger.getLogger(BrisanjeUslugeForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BrisanjeUslugeForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

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
            java.util.logging.Logger.getLogger(BrisanjeUslugeForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BrisanjeUslugeForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BrisanjeUslugeForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BrisanjeUslugeForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BrisanjeUslugeForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsluge;
    private javax.swing.JTextField txtNazivUsluge;
    // End of variables declaration//GEN-END:variables
}