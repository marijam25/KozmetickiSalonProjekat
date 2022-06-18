package Forme;

import Domen.Klijent;
import Domen.Kozmeticar;
import Domen.StavkaZakazivanja;
import Domen.Termin;
import Domen.Usluga;
import Domen.ZakazivanjeTermina;
import KlijentskiZahtev.DodajNoviTerminZahtev;
import KlijentskiZahtev.usluga.PretraziUslugeZahtev;
import KlijentskiZahtev.TipoviZahteva;
import KlijentskiZahtev.kozmeticar.VratiKozmeticareZahtev;
import ServerskiOdgovor.zakazivanjeTermina.DodajNoviTerminOdgovor;
import ServerskiOdgovor.usluga.PretraziUslugeOdgovor;
import ServerskiOdgovor.klijent.VratiSveKlijenteOdgovor;
import ServerskiOdgovor.kozmeticar.VratiKozmeticareOdgovor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.KomunikacijaSaServerom;

public class KreiranjeTerminaForma extends javax.swing.JFrame {

    public KreiranjeTerminaForma() {
        initComponents();
        popuniCmbKozmeticar();
        popuniCmbKlijent();
        popuniCmbUsluge();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDatum = new javax.swing.JTextField();
        txtVreme = new javax.swing.JTextField();
        cmbKozmeticar = new javax.swing.JComboBox();
        cmbKlijent = new javax.swing.JComboBox();
        cmbUsluga = new javax.swing.JComboBox();
        btnSacuvaj = new javax.swing.JButton();
        btnNazad = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        cmbKozmeticar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbKlijent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbUsluga.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        jLabel1.setText("Kreiranje termina");

        jLabel2.setText("Datum u formatu \"dd.MM.yyyy\"");

        jLabel3.setText("Vreme u formatu \"hh:mm\"");

        jLabel4.setText("Kozmeticar");

        jLabel5.setText("Klijent");

        jLabel6.setText("Usluga");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnNazad)
                            .addGap(194, 194, 194)
                            .addComponent(btnSacuvaj))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGap(90, 90, 90)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDatum)
                                .addComponent(txtVreme)
                                .addComponent(cmbKozmeticar, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbKlijent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbUsluga, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtVreme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbKozmeticar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbKlijent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(37, 37, 37)
                        .addComponent(cmbUsluga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnNazad))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            // TODO add your handling code here:
            if (txtDatum.getText().isEmpty() || txtVreme.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti termin");
            } else {

                SimpleDateFormat datumFormat = new SimpleDateFormat("dd.MM.yyyy");
                SimpleDateFormat vremeFormat = new SimpleDateFormat("hh:mm");

                String dat = txtDatum.getText();
                String vr = txtVreme.getText();

                java.util.Date datumUtil = null;
                java.sql.Time vremeSql = null;

                datumUtil = datumFormat.parse(dat);
                vremeSql = new Time(vremeFormat.parse(vr).getTime());

                Termin termin = new Termin(0, datumUtil, (Time) vremeSql);
                Kozmeticar kozmeticar = (Kozmeticar) cmbKozmeticar.getSelectedItem();
                Klijent klijent = (Klijent) cmbKlijent.getSelectedItem();
                Usluga usluga = (Usluga) cmbUsluga.getSelectedItem();
                ZakazivanjeTermina zakazivanjeTermina = new ZakazivanjeTermina(0, kozmeticar.getKozmeticarId(), klijent.getKlijentId());
                StavkaZakazivanja stavkaZakazivanja = new StavkaZakazivanja(0, 0, 0, usluga.getUslugaId());

                DodajNoviTerminZahtev zahtev = new DodajNoviTerminZahtev(termin, stavkaZakazivanja, zakazivanjeTermina);

                KomunikacijaSaServerom.getInstanca().getOos().writeInt(TipoviZahteva.DODAJ_NOVI_TERMIN_ZAHTEV);
                KomunikacijaSaServerom.getInstanca().getOos().writeObject(zahtev);

                int tipOdgovora = KomunikacijaSaServerom.getInstanca().getOis().readInt();
                DodajNoviTerminOdgovor odgovor = (DodajNoviTerminOdgovor) KomunikacijaSaServerom.getInstanca().getOis().readObject();

                if (odgovor.isUspeo()) {
                    JOptionPane.showMessageDialog(this, "Sistem je zapamtio termin");
                } else {
                    JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti termin");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(KreiranjeTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KreiranjeTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            //Logger.getLogger(KreiranjeTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti termin");
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
            java.util.logging.Logger.getLogger(KreiranjeTerminaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KreiranjeTerminaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KreiranjeTerminaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KreiranjeTerminaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KreiranjeTerminaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNazad;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbKlijent;
    private javax.swing.JComboBox cmbKozmeticar;
    private javax.swing.JComboBox cmbUsluga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtDatum;
    private javax.swing.JTextField txtVreme;
    // End of variables declaration//GEN-END:variables

    private void popuniCmbKozmeticar() {
        try {
            ObjectOutputStream oos = KomunikacijaSaServerom.getInstanca().getOos();
            ObjectInputStream ois = KomunikacijaSaServerom.getInstanca().getOis();
            VratiKozmeticareZahtev zahtev = new VratiKozmeticareZahtev();
            oos.writeInt(TipoviZahteva.VRATI_KOZMETICARE_ZAHTEV);
            oos.writeObject(zahtev);
            oos.flush();

            int tipOdgovora = ois.readInt();
            VratiKozmeticareOdgovor odgovor = (VratiKozmeticareOdgovor) ois.readObject();
            cmbKozmeticar.removeAllItems();

            for (Kozmeticar kozmeticar : odgovor.getListaKozmeticara()) {
                cmbKozmeticar.addItem(kozmeticar);
            }
        } catch (IOException ex) {
            Logger.getLogger(KreiranjeTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KreiranjeTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void popuniCmbKlijent() {
        try {
            ObjectOutputStream oos = KomunikacijaSaServerom.getInstanca().getOos();
            ObjectInputStream ois = KomunikacijaSaServerom.getInstanca().getOis();
            oos.writeInt(TipoviZahteva.VRATI_SVE_KLIJENTE_ZAHTEV);
            oos.flush();

            int tipOdgovora = ois.readInt();
            VratiSveKlijenteOdgovor odgovor = (VratiSveKlijenteOdgovor) ois.readObject();
            cmbKlijent.removeAllItems();

            for (Klijent klijent : odgovor.getListaKlijenata()) {
                cmbKlijent.addItem(klijent);
            }
        } catch (IOException ex) {
            Logger.getLogger(KreiranjeTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KreiranjeTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void popuniCmbUsluge() {
        try {
            ObjectOutputStream oos = KomunikacijaSaServerom.getInstanca().getOos();
            ObjectInputStream ois = KomunikacijaSaServerom.getInstanca().getOis();

            PretraziUslugeZahtev zahtev = new PretraziUslugeZahtev();
            oos.writeInt(TipoviZahteva.PRETRAZI_USLUGE_ZAHTEV);
            oos.writeObject(zahtev);
            oos.flush();

            int tipOdgovora = ois.readInt();
            PretraziUslugeOdgovor odgovor = (PretraziUslugeOdgovor) ois.readObject();
            cmbUsluga.removeAllItems();

            for (Usluga usluga : odgovor.getNizUsluga()) {
                cmbUsluga.addItem(usluga);
            }
        } catch (IOException ex) {
            Logger.getLogger(KreiranjeTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KreiranjeTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
