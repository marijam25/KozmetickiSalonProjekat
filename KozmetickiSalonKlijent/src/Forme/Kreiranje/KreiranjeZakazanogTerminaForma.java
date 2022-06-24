package Forme.Kreiranje;

import Domen.Klijent;
import Domen.Kozmeticar;
import Domen.Usluga;
import Domen.ZakazaniTermin;
import Forme.Brisanje.BrisanjeZakazanogTerminaForma;
import KlijentskiZahtevi.TipoviZahteva;
import KlijentskiZahtevi.ZahteviZaDodavanje.DodajZakazaniTerminZahtev;
import ServerskiOdgovori.OdgovoriDodavanje.DodajZakazaniTerminOdgovor;
import ServerskiOdgovori.OdgovoriDohvatanje.DohvatiSveKlijenteOdgovor;
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

public class KreiranjeZakazanogTerminaForma extends javax.swing.JFrame {
    
    private List<Klijent> listaKlijenata;
    private List<Usluga> listaUsluga;
    private List<Kozmeticar> listaKozmeticara;
    
    public KreiranjeZakazanogTerminaForma() {
        initComponents();
        listaKlijenata = new ArrayList<>();
        listaUsluga = new ArrayList<>();
        listaKozmeticara = new ArrayList<>();
        dohvatiSveKozmeticare();
        dohvatiSveUsluge();
        dohvatiSveKlijente();
        popuniKozmeticare();
        popuniUsluge();
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

        txtDatum = new javax.swing.JTextField();
        kozmeticariCombo = new javax.swing.JComboBox();
        klijentiCombo = new javax.swing.JComboBox();
        btnSacuvaj = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        uslugeSwingList = new javax.swing.JList<>();

        kozmeticariCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        klijentiCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        jLabel1.setText("Kreiranje termina");

        jLabel2.setText("Datum i vreme u formatu \"dd.MM.yyyy mm:hh\"");

        jLabel4.setText("Kozmeticar");

        jLabel5.setText("Klijent");

        jLabel6.setText("Usluga");

        jScrollPane1.setViewportView(uslugeSwingList);

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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSacuvaj))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGap(90, 90, 90)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDatum)
                                .addComponent(kozmeticariCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(klijentiCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
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
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kozmeticariCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(klijentiCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(59, 59, 59))
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnSacuvaj))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        List<Usluga> izabraneUsluge = uslugeSwingList.getSelectedValuesList();
        try {
            // TODO add your handling code here:
            if (txtDatum.getText().isEmpty() || izabraneUsluge.isEmpty() ) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti termin");
            } else {

                SimpleDateFormat datumIVremeFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
                String datumIVreme = txtDatum.getText();

                java.util.Date datumUtil =  datumIVremeFormat.parse(datumIVreme);

                Kozmeticar kozmeticar = (Kozmeticar) kozmeticariCombo.getSelectedItem();
                Klijent klijent = (Klijent) klijentiCombo.getSelectedItem();
                //List<Usluga> izabraneUsluge = uslugeSwingList.getSelectedValuesList();
                
                ZakazaniTermin zt = new ZakazaniTermin(0, kozmeticar.getKozmeticarId(), klijent.getKlijentId(), datumUtil);
                DodajZakazaniTerminZahtev dztz = new DodajZakazaniTerminZahtev(zt, izabraneUsluge);
                
                KomunikacijaSaServerom.getInstanca().getOos().writeInt(TipoviZahteva.DODAJ_ZAKAZANI_TERMIN_ZAHTEV);
                KomunikacijaSaServerom.getInstanca().getOos().writeObject(dztz);

                
                DodajZakazaniTerminOdgovor odgovor = (DodajZakazaniTerminOdgovor) KomunikacijaSaServerom.getInstanca().getOis().readObject();

                if (odgovor.isUspeo()) {
                    JOptionPane.showMessageDialog(this, "Sistem je zapamtio termin");
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti termin");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(KreiranjeZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KreiranjeZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            //Logger.getLogger(KreiranjeTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti termin");
        }

    }//GEN-LAST:event_btnSacuvajActionPerformed

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
            Logger.getLogger(KreiranjeZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(KreiranjeZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(KreiranjeZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(KreiranjeZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KreiranjeZakazanogTerminaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox klijentiCombo;
    private javax.swing.JComboBox kozmeticariCombo;
    private javax.swing.JTextField txtDatum;
    private javax.swing.JList<Usluga> uslugeSwingList;
    // End of variables declaration//GEN-END:variables

    private void popuniKozmeticare(){
        kozmeticariCombo.removeAllItems();
        for(Kozmeticar k : listaKozmeticara){
            kozmeticariCombo.addItem(k);
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
        } catch (IOException ex) {
            Logger.getLogger(KreiranjeZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KreiranjeZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void popuniKlijente(){
        klijentiCombo.removeAllItems();
        for(Klijent k : listaKlijenata){
            klijentiCombo.addItem(k);
        }
    }

    private void dohvatiSveKlijente() {        
        try {
            ObjectOutputStream oos = KomunikacijaSaServerom.getInstanca().getOos();
            ObjectInputStream ois = KomunikacijaSaServerom.getInstanca().getOis();
            oos.writeInt(TipoviZahteva.DOHVATI_SVE_KLIJENTE_ZAHTEV);
            oos.flush();
            
            
            DohvatiSveKlijenteOdgovor odgovor = (DohvatiSveKlijenteOdgovor) ois.readObject();
            listaKlijenata = odgovor.getListaKlijenata();
        } catch (Exception ex) {
            Logger.getLogger(BrisanjeZakazanogTerminaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void popuniUsluge(){
       
        DefaultListModel<Usluga> modelUsluga = new DefaultListModel<>();
        for (Usluga usluga : listaUsluga) {
            modelUsluga.addElement(usluga);
        }
        uslugeSwingList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        uslugeSwingList.setModel(modelUsluga);
        
        
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
}
