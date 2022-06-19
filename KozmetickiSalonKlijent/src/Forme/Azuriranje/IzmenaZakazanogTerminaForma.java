package Forme.Azuriranje;

import Domen.Klijent;
import Domen.ZakazaniTermin;
import Forme.Brisanje.BrisanjeZakazanogTerminaForma;
import Forme.GlavnaForma;
import KlijentskiZahtevi.TipoviZahteva;
import KlijentskiZahtevi.ZahteviZaDohvatanje.DohvatiZakazaneTermineZaKlijentaZahtev;
import Modeli.ModelTabeleZakazaniTermin;
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

public class IzmenaZakazanogTerminaForma extends javax.swing.JFrame {

    private List<ZakazaniTermin> listaZakazanihTermina;
    private List<Klijent> listaKlijenata;

    public IzmenaZakazanogTerminaForma() {
        initComponents();
        listaZakazanihTermina = new ArrayList<>();
        listaKlijenata = new ArrayList<>();
        popuniKlijente();
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTermin = new javax.swing.JTable();
        btnNazad = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnPretrazi = new javax.swing.JButton();
        klijentiKombo = new javax.swing.JComboBox<>();

        jLabel1.setText("Izaberi klijenta:");

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

        btnNazad.setText("Nazad");
        btnNazad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNazadActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnPretrazi.setText("Pretrazi");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(91, 91, 91)
                        .addComponent(klijentiKombo, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPretrazi)
                        .addGap(57, 57, 57))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btnNazad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIzmeni)
                .addGap(188, 188, 188))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnPretrazi)
                    .addComponent(klijentiKombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNazad)
                    .addComponent(btnIzmeni))
                .addGap(85, 85, 85))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNazadActionPerformed
        // TODO add your handling code here:
        GlavnaForma gf = new GlavnaForma();
        this.setVisible(false);
        gf.setVisible(true);
    }//GEN-LAST:event_btnNazadActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        // TODO add your handling code here:
        int izabraniRed = tblTermin.getSelectedRow();

        if (izabraniRed == -1) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita termin");
        } else {
            ZakazaniTermin termin = listaZakazanihTermina.get(izabraniRed);
            TerminIzmenaForma tif = new TerminIzmenaForma(termin);
            this.setVisible(false);
            tif.setVisible(true);
            JOptionPane.showMessageDialog(this, "Sistem je ucitao termin");
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        // TODO add your handling code here:        
        try {
            
            ObjectOutputStream oos = KomunikacijaSaServerom.getInstanca().getOos();
            ObjectInputStream ois = KomunikacijaSaServerom.getInstanca().getOis();
            Klijent k = (Klijent) klijentiKombo.getSelectedItem();
            ZakazaniTermin zt = new ZakazaniTermin(0, 0, k.getKlijentId(), null);
            DohvatiZakazaneTermineZaKlijentaZahtev zahtev = new DohvatiZakazaneTermineZaKlijentaZahtev(zt);
            oos.writeInt(TipoviZahteva.DOHVATI_ZAKAZANE_TERMINE_ZA_KLIJENTA_ZAHTEV);
            oos.writeObject(zahtev);
            oos.flush();

            int tipOdgovora = ois.readInt();
            DohvatiZakazaneTermineZaKlijentaOdgovor odgovor = (DohvatiZakazaneTermineZaKlijentaOdgovor) ois.readObject();

            listaZakazanihTermina = odgovor.getListaZakazanihTermina();

            if (listaZakazanihTermina == null || !listaZakazanihTermina.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sistem je nasao termine po zadatoj vrednosti");
                podesiModelTabele();
            } else {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje termine po zadatoj vrednosti");
            }
        } //catch (ParseException ex) {
            //Logger.getLogger(IzmenaTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje termine po zadatoj vrednosti");
         catch (IOException ex) {
            Logger.getLogger(IzmenaZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IzmenaZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

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
            Logger.getLogger(IzmenaZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(IzmenaZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(IzmenaZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(IzmenaZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IzmenaZakazanogTerminaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnNazad;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Klijent> klijentiKombo;
    private javax.swing.JTable tblTermin;
    // End of variables declaration//GEN-END:variables

    private void podesiModelTabele() {
        ModelTabeleZakazaniTermin mtt = new ModelTabeleZakazaniTermin(listaZakazanihTermina);
        tblTermin.setModel(mtt);
        mtt.osveziTabelu();
    }
    
    private void popuniKlijente(){
        klijentiKombo.removeAllItems();
        for(Klijent k : listaKlijenata){
            klijentiKombo.addItem(k);
        }
    }

    private void dohvatiSveKlijente() {        
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
}