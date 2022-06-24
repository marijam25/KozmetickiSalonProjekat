package Forme.Pretrazivanje;

import Domen.KategorijaUsluga;
import Domen.Usluga;
import Forme.GlavnaForma;
import KlijentskiZahtevi.TipoviZahteva;
import KlijentskiZahtevi.ZahteviZaDohvatanje.DohvatiUsluguPoNazivuZahtev;
import Modeli.ModelTabeleUsluge;
import ServerskiOdgovori.OdgovoriDohvatanje.DohvatiSveKategorijeUslugaOdgovor;
import ServerskiOdgovori.OdgovoriDohvatanje.DohvatiUsluguPoNazivuOdgovor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.KomunikacijaSaServerom;

public class PretrazivanjeUsluge extends javax.swing.JFrame {

    private List<Usluga> listaTabela;
    private List<KategorijaUsluga> listaKategorija;

    public PretrazivanjeUsluge() {
        initComponents();
        listaTabela = new ArrayList<>();
        listaKategorija = new ArrayList<>();
        vratiKategorijeUsluga();
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

        txtNazivUsluge = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsluge = new javax.swing.JTable();
        btnPrikazi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

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

        btnPrikazi.setText("Prikazi");
        btnPrikazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikaziActionPerformed(evt);
            }
        });

        jLabel1.setText("Pretraga usluga");

        jLabel2.setText("Pretraga usluga po nazivu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(33, 33, 33)
                                .addComponent(txtNazivUsluge, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPretrazi))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 13, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(610, 610, 610)
                                        .addComponent(btnPrikazi))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(129, 129, 129))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNazivUsluge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretrazi)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnPrikazi)
                .addGap(93, 93, 93))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        try {
            // TODO add your handling code here:
            Usluga u = new Usluga(0, txtNazivUsluge.getText(), 0);
            
            ObjectOutputStream oos = KomunikacijaSaServerom.getInstanca().getOos();
            ObjectInputStream ois = KomunikacijaSaServerom.getInstanca().getOis();
            DohvatiUsluguPoNazivuZahtev zahtev = new DohvatiUsluguPoNazivuZahtev(u);
            oos.writeInt(TipoviZahteva.DOHVATI_USLUGU_PO_NAZIVU_ZAHTEV);
            oos.writeObject(zahtev);
            oos.flush();

            
            DohvatiUsluguPoNazivuOdgovor odgovor = (DohvatiUsluguPoNazivuOdgovor) ois.readObject();

            listaTabela = odgovor.getNizUsluga();
            if (!listaTabela.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sistem je nasao usluge po zadatoj vrednosti");
                podesiModelTabele();
            } else {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje usluge po zadatoj vrednosti");
            }

        } catch (IOException ex) {
            Logger.getLogger(PretrazivanjeUsluge.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PretrazivanjeUsluge.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnPrikaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikaziActionPerformed
        // TODO add your handling code here:
        int izabraniRed = tblUsluge.getSelectedRow();

        if (izabraniRed == -1) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita uslugu");
        } else {
            Usluga usluga = listaTabela.get(izabraniRed);
            PrikazUslugeForma puf = new PrikazUslugeForma(usluga, listaKategorija);
            this.setVisible(false);
            puf.setVisible(true);
            JOptionPane.showMessageDialog(this, "Sistem je ucitao uslugu");
        }
    }//GEN-LAST:event_btnPrikaziActionPerformed

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
            Logger.getLogger(PretrazivanjeUsluge.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(PretrazivanjeUsluge.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PretrazivanjeUsluge.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PretrazivanjeUsluge.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PretrazivanjeUsluge().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JButton btnPrikazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsluge;
    private javax.swing.JTextField txtNazivUsluge;
    // End of variables declaration//GEN-END:variables

    private void podesiModelTabele() {
        ModelTabeleUsluge mtu = new ModelTabeleUsluge(listaTabela);
        mtu.setListaKategorija(listaKategorija);
        tblUsluge.setModel(mtu);
        mtu.osveziTabelu();
    }

    private void vratiKategorijeUsluga() {
        try {
            ObjectOutputStream oos = KomunikacijaSaServerom.getInstanca().getOos();
            ObjectInputStream ois = KomunikacijaSaServerom.getInstanca().getOis();

            oos.writeInt(TipoviZahteva.DOHVATI_SVE_KATEGORIJE_USLUGA_ZAHTEV);
            oos.flush();

            
            DohvatiSveKategorijeUslugaOdgovor odgovor = (DohvatiSveKategorijeUslugaOdgovor) ois.readObject();

            listaKategorija = odgovor.getListaKategorijaUsluga();

            podesiModelTabele();

        } catch (IOException ex) {
            Logger.getLogger(PretrazivanjeUsluge.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PretrazivanjeUsluge.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
