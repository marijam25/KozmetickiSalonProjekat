package Forme.Brisanje;

import Domen.KategorijaUsluga;
import Domen.Usluga;
import KlijentskiZahtevi.TipoviZahteva;
import KlijentskiZahtevi.ZahteviZaBrisanje.ObrisiUsluguZahtev;
import KlijentskiZahtevi.ZahteviZaDohvatanje.DohvatiUsluguPoNazivuZahtev;
import Modeli.ModelTabeleUsluge;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ServerskiOdgovori.OdgovoriBrisanje.ObrisiUsluguOdgovor;
import ServerskiOdgovori.OdgovoriDohvatanje.DohvatiSveKategorijeUslugaOdgovor;
import ServerskiOdgovori.OdgovoriDohvatanje.DohvatiUsluguPoNazivuOdgovor;
import komunikacija.KomunikacijaSaServerom;

public class BrisanjeUslugeForma extends javax.swing.JFrame {

    private List<Usluga> listaTabela;
    private List<KategorijaUsluga> listaKategorija;

    /**
     * Creates new form BrisanjeUslugeForma
     */
    public BrisanjeUslugeForma() {
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
        btnObrisi = new javax.swing.JButton();
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

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        jLabel1.setText("Brisanje usluge");

        jLabel2.setText("Pretraga usluga po nazivu:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(66, 66, 66)
                        .addComponent(txtNazivUsluge, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPretrazi)
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnObrisi)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 83, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNazivUsluge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPretrazi)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btnObrisi)
                .addGap(52, 52, 52))
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
            Logger.getLogger(BrisanjeUslugeForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BrisanjeUslugeForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        int izbor = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da obrisete uslugu?", "Brisanje usluge", JOptionPane.YES_NO_OPTION);

        if (izbor == JOptionPane.YES_OPTION) {
            try {
               
                int izabraniRed = tblUsluge.getSelectedRow();

                if (izabraniRed == -1) {
                    JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise uslugu");
                } else {

                    Usluga usluga = listaTabela.get(izabraniRed);

                    ObrisiUsluguZahtev zahtev = new ObrisiUsluguZahtev(usluga);

                    KomunikacijaSaServerom.getInstanca().getOos().writeInt(TipoviZahteva.OBRISI_USLUGU_ZAHTEV);
                    KomunikacijaSaServerom.getInstanca().getOos().writeObject(zahtev);

                    
                    ObrisiUsluguOdgovor odgovor = (ObrisiUsluguOdgovor) KomunikacijaSaServerom.getInstanca().getOis().readObject();

                    if (odgovor.isUspeo()) {
                        JOptionPane.showMessageDialog(this, "Sistem je obrisao uslugu");
                        listaTabela.remove(usluga);
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise uslugu");
                        this.setVisible(false);
                    }

                    podesiModelTabele();
                }
            } catch (IOException ex) {
                Logger.getLogger(BrisanjeUslugeForma.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BrisanjeUslugeForma.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            Logger.getLogger(BrisanjeUslugeForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BrisanjeUslugeForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrisanjeUslugeForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(BrisanjeUslugeForma.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsluge;
    private javax.swing.JTextField txtNazivUsluge;
    // End of variables declaration//GEN-END:variables

    private void podesiModelTabele() {
        ModelTabeleUsluge mtu = new ModelTabeleUsluge(listaTabela);
        tblUsluge.setModel(mtu);
        mtu.setListaKategorija(listaKategorija);
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
            Logger.getLogger(BrisanjeUslugeForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BrisanjeUslugeForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
