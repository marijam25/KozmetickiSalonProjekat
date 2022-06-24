package Forme.Azuriranje;

import Domen.Kozmeticar;
import Domen.StavkaZakazanogTermina;
import Domen.Usluga;
import Domen.ZakazaniTermin;
import Forme.Brisanje.BrisanjeZakazanogTerminaForma;
import KlijentskiZahtevi.TipoviZahteva;
import KlijentskiZahtevi.ZahteviZaAzuriranje.AzurirajZakazaniTerminZahtev;
import KlijentskiZahtevi.ZahteviZaBrisanje.ObrisiStavkuZakazivanjaZahtev;
import KlijentskiZahtevi.ZahteviZaDodavanje.DodajStavkuZakazivanjaZahtev;
import KlijentskiZahtevi.ZahteviZaDohvatanje.DohvatiStavkeZaZakazaniTerminZahtev;
import ServerskiOdgovori.OdgovoriAzuriranje.AzurirajZakazaniTerminOdgovor;
import ServerskiOdgovori.OdgovoriBrisanje.ObrisiStavkuZakazivanjaOdgovor;
import ServerskiOdgovori.OdgovoriDodavanje.DodajStavkuZakazivanjaOdgovor;
import ServerskiOdgovori.OdgovoriDohvatanje.DohvatiStavkeZaZakazniTerminOdgovor;
import ServerskiOdgovori.OdgovoriDohvatanje.DohvatiSveKozmeticareOdgovor;
import ServerskiOdgovori.OdgovoriDohvatanje.DohvatiSveUslugeOdgovor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import komunikacija.KomunikacijaSaServerom;

public class TerminIzmenaForma extends javax.swing.JFrame {

    private ZakazaniTermin zakazaniTermin;
    private List<StavkaZakazanogTermina> listaStavkiZaTermin;
    private List<Usluga> listaUsluga;
    private List<Kozmeticar> listaKozmeticara;
    private List<Usluga> listaUslugaZaKojePostojeStavke; //za koje postoje stavke
    private List<Usluga> listaUslugaKojeZelimoDaDodamo = new ArrayList<>(); //koje korisnik hoce da doda u termin
    private List<Usluga> listaUslugaKojeZelimoDaObrisemo = new ArrayList<>(); //koje korisnik hoce da obrise iz termina

    SimpleDateFormat datumIVremeFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");

    public TerminIzmenaForma(ZakazaniTermin zt) {
        initComponents();
        this.zakazaniTermin = zt;

        txtDatum.setText(datumIVremeFormat.format(zt.getDatumIVreme()));
        
        dohvatiSveUsluge();
        dohvatiStavkeZaTermin();
        napraviListuUslugaZaKojePostojeStavke();
        popuniCmbSvihUsluga();
        dohvatiSveKozmeticare();
        popuniCmbSvihKozmeticara();
        popuniSwingIzabranihUsluga();

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
        jLabel2 = new javax.swing.JLabel();
        txtDatum = new javax.swing.JTextField();
        btnNazad = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        swingListaIzabranihUsluga = new javax.swing.JList<>();
        cmbSveUsluge = new javax.swing.JComboBox();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        cmbKozmeticari = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("Izmena termina");

        jLabel2.setText("Datum i vreme \"dd.MM.yyyy hh:mm\"");

        btnNazad.setText("Nazad");
        btnNazad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNazadActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(swingListaIzabranihUsluga);

        cmbSveUsluge.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDodaj.setText("Dodaj uslugu");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi uslugu");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        cmbKozmeticari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Kozmeticari");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNazad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSacuvaj))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnObrisi)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDodaj, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbSveUsluge, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbKozmeticari, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDatum, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbKozmeticari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(cmbSveUsluge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDodaj))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnObrisi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNazad)
                    .addComponent(btnSacuvaj))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNazadActionPerformed
        // TODO add your handling code here:
        IzmenaZakazanogTerminaForma itf = new IzmenaZakazanogTerminaForma();
        this.setVisible(false);
        itf.setVisible(true);
    }//GEN-LAST:event_btnNazadActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed

        try {
            if (txtDatum.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti termin");
                return;
            }

            String dat = txtDatum.getText();
            java.util.Date datumUtil = null;
            datumUtil = datumIVremeFormat.parse(dat);
            Kozmeticar kozm = (Kozmeticar) cmbKozmeticari.getSelectedItem();

            if (zakazaniTermin.getDatumIVreme().getTime() != datumUtil.getTime()) {
                zakazaniTermin.setDatumIVreme(datumUtil);
                zakazaniTermin.setKozmeticarId(kozm.getKozmeticarId());

                AzurirajZakazaniTerminZahtev zahtev = new AzurirajZakazaniTerminZahtev(zakazaniTermin);
                KomunikacijaSaServerom.getInstanca().getOos().writeInt(TipoviZahteva.AZURIRAJ_ZAKAZANI_TERMIN_ZAHTEV);
                KomunikacijaSaServerom.getInstanca().getOos().writeObject(zahtev);

                
                AzurirajZakazaniTerminOdgovor odgovor = (AzurirajZakazaniTerminOdgovor) KomunikacijaSaServerom.getInstanca().getOis().readObject();

                if (!odgovor.isUspeo()) {
                    JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti termin");
                    return;
                }
            }

            for (Usluga usluga : listaUslugaKojeZelimoDaDodamo) {

                for (Usluga usluga1 : listaUslugaZaKojePostojeStavke) {
                    if (usluga.getUslugaId() != usluga1.getUslugaId()) {
                        StavkaZakazanogTermina s = new StavkaZakazanogTermina(0, zakazaniTermin.getZakazaniTerminId(), usluga.getUslugaId());
                        DodajStavkuZakazivanjaZahtev zahtev = new DodajStavkuZakazivanjaZahtev(s);
                        KomunikacijaSaServerom.getInstanca().getOos().writeInt(TipoviZahteva.DODAJ_STAVKU_ZAKAZIVANJA_ZAHTEV);
                        KomunikacijaSaServerom.getInstanca().getOos().writeObject(zahtev);

                        
                        DodajStavkuZakazivanjaOdgovor odgovor = (DodajStavkuZakazivanjaOdgovor) KomunikacijaSaServerom.getInstanca().getOis().readObject();

                        if (!odgovor.isUspeo()) {
                            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti termin");
                            return;
                        }
                    }
                }

            }

            for (Usluga usluga : listaUslugaKojeZelimoDaObrisemo) {
                int idStavke = 0;
                for (StavkaZakazanogTermina stavkaZakazanogTermina : listaStavkiZaTermin) {
                    if (stavkaZakazanogTermina.getUslugaId() == usluga.getUslugaId()) {
                        idStavke = stavkaZakazanogTermina.getStavkaId();
                        break;
                    }
                }
                StavkaZakazanogTermina s = new StavkaZakazanogTermina(idStavke, zakazaniTermin.getZakazaniTerminId(), usluga.getUslugaId());

                ObrisiStavkuZakazivanjaZahtev zahtev = new ObrisiStavkuZakazivanjaZahtev(s);
                KomunikacijaSaServerom.getInstanca().getOos().writeInt(TipoviZahteva.OBRISI_STAVKU_ZAKAZIVANJA_ZAHTEV);
                KomunikacijaSaServerom.getInstanca().getOos().writeObject(zahtev);

                
                ObrisiStavkuZakazivanjaOdgovor odgovor = (ObrisiStavkuZakazivanjaOdgovor) KomunikacijaSaServerom.getInstanca().getOis().readObject();

                if (!odgovor.isUspeo()) {
                    JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti termin");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio termin");
            this.setVisible(false);

        } catch (ParseException ex) {
            Logger.getLogger(TerminIzmenaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TerminIzmenaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TerminIzmenaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        // TODO add your handling code here:
        Usluga u = (Usluga) cmbSveUsluge.getSelectedItem();
        boolean pronasao = false;

        for (Usluga usluga : listaUslugaKojeZelimoDaObrisemo) {
            if (usluga.getUslugaId() == u.getUslugaId()) {
                listaUslugaKojeZelimoDaObrisemo.remove(usluga);
                pronasao = true;
                break;
            }
        }

        if (!pronasao) {

            for (Usluga usluga : listaUslugaZaKojePostojeStavke) {
                if (usluga.getUslugaId() == u.getUslugaId()) {
                    pronasao = true;
                    break;
                }
            }

            if (pronasao) {
                JOptionPane.showMessageDialog(this, "Usluga je vec izabrana");
                return;
            }
        }

        pronasao = false;
        for (Usluga usluga : listaUslugaKojeZelimoDaDodamo) {
            if (usluga.getUslugaId() == u.getUslugaId()) {
                pronasao = true;
                break;
            }
        }

        if (pronasao) {
            JOptionPane.showMessageDialog(this, "Usluga je vec dodata");
            return;
        }

        //pronasao=false;
        listaUslugaKojeZelimoDaDodamo.add(u);
        popuniSwingIzabranihUsluga();


    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        // TODO add your handling code here:
        List<Usluga> izabraneUslugeZaBrisanje = swingListaIzabranihUsluga.getSelectedValuesList();
        for (Usluga usluga : izabraneUslugeZaBrisanje) {
            for (Usluga usluga1 : listaUslugaKojeZelimoDaDodamo) {
                if (usluga.getUslugaId() == usluga1.getUslugaId()) {
                    listaUslugaKojeZelimoDaDodamo.remove(usluga1);
                    break;
                }
            }
            for (Usluga usluga1 : listaUslugaZaKojePostojeStavke) {
                if (usluga.getUslugaId() == usluga1.getUslugaId()) {
                    listaUslugaKojeZelimoDaObrisemo.add(usluga);
                    listaUslugaZaKojePostojeStavke.remove(usluga1);
                    break;
                }
            }
        }
        popuniSwingIzabranihUsluga();
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
            Logger.getLogger(TerminIzmenaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TerminIzmenaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TerminIzmenaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TerminIzmenaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new TerminIzmenaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnNazad;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbKozmeticari;
    private javax.swing.JComboBox cmbSveUsluge;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Usluga> swingListaIzabranihUsluga;
    private javax.swing.JTextField txtDatum;
    // End of variables declaration//GEN-END:variables

    private void dohvatiStavkeZaTermin() {
        try {
            ObjectOutputStream oos = KomunikacijaSaServerom.getInstanca().getOos();
            ObjectInputStream ois = KomunikacijaSaServerom.getInstanca().getOis();
            DohvatiStavkeZaZakazaniTerminZahtev zahtev = new DohvatiStavkeZaZakazaniTerminZahtev(new StavkaZakazanogTermina(0, zakazaniTermin.getZakazaniTerminId(), 0));
            oos.writeInt(TipoviZahteva.DOHVATI_STAVKE_ZA_ZAKAZANI_TERMIN_ZAHTEV);
            oos.writeObject(zahtev);
            oos.flush();

            
            DohvatiStavkeZaZakazniTerminOdgovor odgovor = (DohvatiStavkeZaZakazniTerminOdgovor) ois.readObject();
            listaStavkiZaTermin = odgovor.getStavkeZakazanogTermina();
        } catch (Exception ex) {
            Logger.getLogger(BrisanjeZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void dohvatiSveUsluge() {
        try {
            ObjectOutputStream oos = KomunikacijaSaServerom.getInstanca().getOos();
            ObjectInputStream ois = KomunikacijaSaServerom.getInstanca().getOis();
            oos.writeInt(TipoviZahteva.DOHVATI_SVE_USLUGE_ZAHTEV);
            oos.flush();

            
            DohvatiSveUslugeOdgovor odgovor = (DohvatiSveUslugeOdgovor) ois.readObject();
            listaUsluga = odgovor.getNizUsluga();
        } catch (Exception ex) {
            Logger.getLogger(BrisanjeZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void napraviListuUslugaZaKojePostojeStavke() {
        listaUslugaZaKojePostojeStavke = new ArrayList<>();

        for (StavkaZakazanogTermina stavkaZakazanogTermina : listaStavkiZaTermin) {
            for (Usluga usluga : listaUsluga) {
                if (stavkaZakazanogTermina.getUslugaId() == usluga.getUslugaId()) {
                    listaUslugaZaKojePostojeStavke.add(usluga);
                }
            }
        }
    }

    private void popuniSwingIzabranihUsluga() {
        DefaultListModel<Usluga> modelUsluga = new DefaultListModel<>();
        for (Usluga usluga : listaUslugaZaKojePostojeStavke) {
            modelUsluga.addElement(usluga);
        }

        for (Usluga usluga : listaUslugaKojeZelimoDaDodamo) {
            modelUsluga.addElement(usluga);
        }

        for (Usluga usluga : listaUslugaKojeZelimoDaObrisemo) {
            modelUsluga.removeElement(usluga);
        }

        swingListaIzabranihUsluga.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        swingListaIzabranihUsluga.setModel(modelUsluga);

    }

    private void popuniCmbSvihUsluga() {
        cmbSveUsluge.removeAllItems();
        for (Usluga usluga : listaUsluga) {
            cmbSveUsluge.addItem(usluga);
        }
    }

    private void dohvatiSveKozmeticare() {
        try {
            ObjectOutputStream oos = KomunikacijaSaServerom.getInstanca().getOos();
            ObjectInputStream ois = KomunikacijaSaServerom.getInstanca().getOis();
            oos.writeInt(TipoviZahteva.DOHVATI_SVE_KOZMETICARE_ZAHTEV);
            oos.flush();

            
            DohvatiSveKozmeticareOdgovor odgovor = (DohvatiSveKozmeticareOdgovor) ois.readObject();
            listaKozmeticara = odgovor.getListaKozmeticara();
        } catch (Exception ex) {
            Logger.getLogger(BrisanjeZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void popuniCmbSvihKozmeticara() {
        cmbKozmeticari.removeAllItems();
        for (Kozmeticar k : listaKozmeticara) {
            cmbKozmeticari.addItem(k);
            if(k.getKozmeticarId()==zakazaniTermin.getKozmeticarId()){
                cmbKozmeticari.setSelectedItem(k);
            }
        }
        
    }
    
    
}
