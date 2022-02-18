package Forme;

import Domen.Kozmeticar;
import KlijentskiZahtev.ObrisiKozmeticaraZahtev;
import KlijentskiZahtev.TipoviZahteva;
import KlijentskiZahtev.VratiKozmeticareZahtev;
import Modeli.ModelTabeleKozmeticara;
import ServerskiOdgovor.ObrisiKozmeticaraOdgovor;
import ServerskiOdgovor.VratiKozmeticareOdgovor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.KomunikacijaSaServerom;

public class BrisanjeKozmeticaraForma extends javax.swing.JFrame {

    private ArrayList<Kozmeticar> listaTabela;

    public BrisanjeKozmeticaraForma() {
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
        btnPretrazi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKozmeticar = new javax.swing.JTable();
        btnObrisi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnNazad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPretrazi.setText("Pretrazi");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

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

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        jLabel1.setText("Pretraga kozmeticara po prezimenu:");

        jLabel2.setText("Brisanje kozmeticara");

        btnNazad.setText("Nazad");
        btnNazad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNazadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(53, 53, 53)
                                .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPretrazi))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnNazad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnObrisi)))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretrazi)
                    .addComponent(jLabel1))
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnObrisi)
                    .addComponent(btnNazad))
                .addGap(68, 68, 68))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        try {
            // TODO add your handling code here:
            String pretraga = txtPrezime.getText();

            ObjectOutputStream oos = KomunikacijaSaServerom.getInstanca().getOos();
            ObjectInputStream ois = KomunikacijaSaServerom.getInstanca().getOis();
            VratiKozmeticareZahtev zahtev = new VratiKozmeticareZahtev(pretraga);
            oos.writeInt(TipoviZahteva.VRATI_KOZMETICARE_ZAHTEV);
            oos.writeObject(zahtev);
            oos.flush();

            int tipOdgovora = ois.readInt();
            VratiKozmeticareOdgovor odgovor = (VratiKozmeticareOdgovor) ois.readObject();

            listaTabela = odgovor.getListaKozmeticara();

            if (!listaTabela.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sistem je nasao kozmeticare po zadatoj vrednosti");
                podesiModelTabele();
            } else {

                JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje kozmeticare po zadatoj vrednosti");
            }

        } catch (IOException ex) {
            Logger.getLogger(BrisanjeKozmeticaraForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BrisanjeKozmeticaraForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        try {
            // TODO add your handling code here:
            int izabraniRed = tblKozmeticar.getSelectedRow();
            if (izabraniRed == -1) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise kozmeticara");
            } else {
                Kozmeticar kozmeticar = listaTabela.get(izabraniRed);

                ObrisiKozmeticaraZahtev zahtev = new ObrisiKozmeticaraZahtev(kozmeticar);

                KomunikacijaSaServerom.getInstanca().getOos().writeInt(TipoviZahteva.OBRISI_KOZMETICARA_ZAHTEV);
                KomunikacijaSaServerom.getInstanca().getOos().writeObject(zahtev);

                int tipOdgovora = KomunikacijaSaServerom.getInstanca().getOis().readInt();
                ObrisiKozmeticaraOdgovor odgovor = (ObrisiKozmeticaraOdgovor) KomunikacijaSaServerom.getInstanca().getOis().readObject();

                if (odgovor.isUspeo()) {
                    JOptionPane.showMessageDialog(this, "Sistem je obrisao kozmeticara");
                    listaTabela.remove(kozmeticar);
                } else {
                    JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise kozmeticara");
                }
                podesiModelTabele();
            }

        } catch (IOException ex) {
            Logger.getLogger(BrisanjeKozmeticaraForma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BrisanjeKozmeticaraForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

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
            java.util.logging.Logger.getLogger(BrisanjeKozmeticaraForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BrisanjeKozmeticaraForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BrisanjeKozmeticaraForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BrisanjeKozmeticaraForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BrisanjeKozmeticaraForma().setVisible(true);
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
    private javax.swing.JTable tblKozmeticar;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    private void podesiModelTabele() {
        ModelTabeleKozmeticara mtk = new ModelTabeleKozmeticara(listaTabela);
        tblKozmeticar.setModel(mtk);
        mtk.osveziTabelu();
    }
}
