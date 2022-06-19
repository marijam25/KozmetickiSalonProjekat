package Forme.Brisanje;

import Domen.Klijent;
import Domen.ZakazaniTermin;
import Forme.GlavnaForma;
import KlijentskiZahtevi.TipoviZahteva;
import KlijentskiZahtevi.ZahteviZaBrisanje.ObrisiZakazaniTerminZahtev;
import KlijentskiZahtevi.ZahteviZaDohvatanje.DohvatiZakazaneTermineZaKlijentaZahtev;
import Modeli.ModelTabeleZakazaniTermin;
import ServerskiOdgovori.OdgovoriBrisanje.ObrisiZakazaniTerminOdgovor;
import ServerskiOdgovori.OdgovoriDohvatanje.DohvatiSveKlijenteOdgovor;
import ServerskiOdgovori.OdgovoriDohvatanje.DohvatiZakazaneTermineZaKlijentaOdgovor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.KomunikacijaSaServerom;

public class BrisanjeZakazanogTerminaForma extends javax.swing.JFrame {

    private List<ZakazaniTermin> listaZakaznihTermina;
    private List<Klijent> listaKlijenata;
    
    public BrisanjeZakazanogTerminaForma() {
        initComponents();
        listaZakaznihTermina = new ArrayList<>();
        DohvatiSveKlijente();
        podesiModelTabele();
        popuniKlijente();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTermin = new javax.swing.JTable();
        btnPretrazi = new javax.swing.JButton();
        btnNazad = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        klijentiCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("Izaberi klijenta");

        tblTermin.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTermin);

        btnPretrazi.setText("Pretrazi");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        btnNazad.setText("Nazad");
        btnNazad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNazadActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        jLabel2.setText("Zakazani termini izabranog klijenta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnNazad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnObrisi)
                .addGap(126, 126, 126))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(klijentiCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPretrazi))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel2)))
                .addContainerGap(303, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnPretrazi)
                    .addComponent(klijentiCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btnNazad))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btnObrisi)))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        // TODO add your handling code here:
        DohvatiZakazaneTermineZaIzabranogKlijenta();
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNazadActionPerformed
        // TODO add your handling code here:
        GlavnaForma gf = new GlavnaForma();
        this.setVisible(false);
        gf.setVisible(true);
    }//GEN-LAST:event_btnNazadActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        // TODO add your handling code here:
        int izbor = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da obrisete termin?", "Brisanje termina", JOptionPane.YES_NO_OPTION);
        if (izbor == JOptionPane.YES_OPTION) {
            try {
                int izabraniRed = tblTermin.getSelectedRow();

                if (izabraniRed == -1) {
                    JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise termin");
                } else {
                    ZakazaniTermin zt = listaZakaznihTermina.get(izabraniRed);

                    ObrisiZakazaniTerminZahtev zahtev = new ObrisiZakazaniTerminZahtev(zt);

                    KomunikacijaSaServerom.getInstanca().getOos().writeInt(TipoviZahteva.OBRISI_ZAKAZANI_TERMIN_ZAHTEV);
                    KomunikacijaSaServerom.getInstanca().getOos().writeObject(zahtev);

                    int tipOdgovora = KomunikacijaSaServerom.getInstanca().getOis().readInt();
                    ObrisiZakazaniTerminOdgovor odgovor = (ObrisiZakazaniTerminOdgovor) KomunikacijaSaServerom.getInstanca().getOis().readObject();

                    if (odgovor.isUspeo()) {
                        JOptionPane.showMessageDialog(this, "Sistem je obrisao termin");
                    } else {
                        JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise termin");
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(BrisanjeZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BrisanjeZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

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
            Logger.getLogger(BrisanjeZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BrisanjeZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BrisanjeZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(BrisanjeZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BrisanjeZakazanogTerminaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNazad;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Klijent> klijentiCombo;
    private javax.swing.JTable tblTermin;
    // End of variables declaration//GEN-END:variables

    private void podesiModelTabele() {
        ModelTabeleZakazaniTermin mtt = new ModelTabeleZakazaniTermin(listaZakaznihTermina);
        tblTermin.setModel(mtt);
        mtt.osveziTabelu();
    }
    
    private void popuniKlijente(){
        klijentiCombo.removeAllItems();
        for(Klijent k : listaKlijenata){
            klijentiCombo.addItem(k);
        }
    }

    private void DohvatiSveKlijente() {        
        try {
            ObjectOutputStream oos = KomunikacijaSaServerom.getInstanca().getOos();
            ObjectInputStream ois = KomunikacijaSaServerom.getInstanca().getOis();
            oos.writeInt(TipoviZahteva.DOHVATI_SVE_KLIJENTE_ZAHTEV);
            oos.flush();
            
            int tipOdgovora = ois.readInt();
            DohvatiSveKlijenteOdgovor odgovor = (DohvatiSveKlijenteOdgovor) ois.readObject();
            listaKlijenata = odgovor.getListaKlijenata();
        } catch (Exception ex) {
            Logger.getLogger(BrisanjeZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void DohvatiZakazaneTermineZaIzabranogKlijenta() {
        try {
            ObjectOutputStream oos = KomunikacijaSaServerom.getInstanca().getOos();
            ObjectInputStream ois = KomunikacijaSaServerom.getInstanca().getOis();
            
            int indeks = klijentiCombo.getSelectedIndex();
            int selektovaniKlijentId = listaKlijenata.get(indeks).getKlijentId();
            ZakazaniTermin zt = new ZakazaniTermin(0, 0, selektovaniKlijentId, null);
            
            oos.writeInt(TipoviZahteva.DOHVATI_ZAKAZANE_TERMINE_ZA_KLIJENTA_ZAHTEV);
            DohvatiZakazaneTermineZaKlijentaZahtev zahtev= new DohvatiZakazaneTermineZaKlijentaZahtev(zt);
            oos.writeObject(zahtev);
            oos.flush();
            
            int tipOdgovora = ois.readInt();
            DohvatiZakazaneTermineZaKlijentaOdgovor odgovor = (DohvatiZakazaneTermineZaKlijentaOdgovor) ois.readObject();
            if(odgovor.getListaZakazanihTermina() != null){
                listaZakaznihTermina = odgovor.getListaZakazanihTermina();
                podesiModelTabele();
            }
            else{
                JOptionPane.showMessageDialog(this, "Desila se greska na serveru");
            }
        } catch (Exception ex) {
            Logger.getLogger(BrisanjeZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}