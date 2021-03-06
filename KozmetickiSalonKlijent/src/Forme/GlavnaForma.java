package Forme;

import Forme.Azuriranje.IzmenaKozmeticaraForma;
import Forme.Azuriranje.IzmenaZakazanogTerminaForma;
import Forme.Brisanje.BrisanjeKozmeticaraForma;
import Forme.Brisanje.BrisanjeZakazanogTerminaForma;
import Forme.Brisanje.BrisanjeUslugeForma;
import Forme.Kreiranje.KreirajeKozmeticaraForma;
import Forme.Kreiranje.KreiranjeZakazanogTerminaForma;
import Forme.Kreiranje.KreiranjeUslugeForma;
import Forme.Pretrazivanje.PretrazivanjeUsluge;

import javax.swing.JFrame;

public class GlavnaForma extends JFrame {

    public GlavnaForma() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        jPanel1 = new javax.swing.JPanel();
        btnKreirajKozmeticara = new javax.swing.JButton();
        btnKreiranjeUsluge = new javax.swing.JButton();
        btnKreiranjeTermina = new javax.swing.JButton();
        btnIzmenaKozmeticara = new javax.swing.JButton();
        btnPretragaUsluga = new javax.swing.JButton();
        btnIzmenaTermina = new javax.swing.JButton();
        txtBrisanjeKozmeticara = new javax.swing.JButton();
        btnObrisiUslugu = new javax.swing.JButton();
        btnBrisanjeTermina = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikacija kozmetickog salona");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Dobrodosli!");

        btnKreirajKozmeticara.setText("Kreiraj kozmeticara");
        btnKreirajKozmeticara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajKozmeticaraActionPerformed(evt);
            }
        });

        btnKreiranjeUsluge.setText("Kreiranje usluge");
        btnKreiranjeUsluge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreiranjeUslugeActionPerformed(evt);
            }
        });

        btnKreiranjeTermina.setText("Kreiranje termina");
        btnKreiranjeTermina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreiranjeTerminaActionPerformed(evt);
            }
        });

        btnIzmenaKozmeticara.setText("Izmena kozmeticara");
        btnIzmenaKozmeticara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmenaKozmeticaraActionPerformed(evt);
            }
        });

        btnPretragaUsluga.setText("Pretraga usluga");
        btnPretragaUsluga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretragaUslugaActionPerformed(evt);
            }
        });

        btnIzmenaTermina.setText("Izmena termina");
        btnIzmenaTermina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmenaTerminaActionPerformed(evt);
            }
        });

        txtBrisanjeKozmeticara.setText("Brisanje kozmeticara");
        txtBrisanjeKozmeticara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBrisanjeKozmeticaraActionPerformed(evt);
            }
        });

        btnObrisiUslugu.setText("Brisanje usluge");
        btnObrisiUslugu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiUsluguActionPerformed(evt);
            }
        });

        btnBrisanjeTermina.setText("Brisanje termina");
        btnBrisanjeTermina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrisanjeTerminaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnKreirajKozmeticara, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKreiranjeUsluge, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(121, 121, 121)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPretragaUsluga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIzmenaKozmeticara, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnKreiranjeTermina, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIzmenaTermina, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnObrisiUslugu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBrisanjeKozmeticara, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrisanjeTermina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBrisanjeKozmeticara, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIzmenaKozmeticara, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnKreirajKozmeticara, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKreiranjeUsluge, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPretragaUsluga, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnObrisiUslugu, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(97, 97, 97)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKreiranjeTermina, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrisanjeTermina, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIzmenaTermina, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKreirajKozmeticaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajKozmeticaraActionPerformed
        // TODO add your handling code here:
        KreirajeKozmeticaraForma kkf = new KreirajeKozmeticaraForma();
        kkf.setVisible(true);
    }//GEN-LAST:event_btnKreirajKozmeticaraActionPerformed

    private void txtBrisanjeKozmeticaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBrisanjeKozmeticaraActionPerformed
        // TODO add your handling code here:
        BrisanjeKozmeticaraForma bkf = new BrisanjeKozmeticaraForma();
        
        bkf.setVisible(true);
        
    }//GEN-LAST:event_txtBrisanjeKozmeticaraActionPerformed

    private void btnIzmenaKozmeticaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmenaKozmeticaraActionPerformed
        // TODO add your handling code here:
        IzmenaKozmeticaraForma ikf = new IzmenaKozmeticaraForma();
        //this.setVisible(false);
        ikf.setVisible(true);
    }//GEN-LAST:event_btnIzmenaKozmeticaraActionPerformed

    private void btnKreiranjeUslugeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreiranjeUslugeActionPerformed
        // TODO add your handling code here:
        KreiranjeUslugeForma kuf = new KreiranjeUslugeForma();
        
        kuf.setVisible(true);
        
    }//GEN-LAST:event_btnKreiranjeUslugeActionPerformed

    private void btnPretragaUslugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretragaUslugaActionPerformed
        // TODO add your handling code here:
        PretrazivanjeUsluge pu = new PretrazivanjeUsluge();
        
        pu.setVisible(true);
    }//GEN-LAST:event_btnPretragaUslugaActionPerformed

    private void btnObrisiUsluguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiUsluguActionPerformed
        // TODO add your handling code here:
        BrisanjeUslugeForma buf = new BrisanjeUslugeForma();
        
        buf.setVisible(true);
    }//GEN-LAST:event_btnObrisiUsluguActionPerformed

    private void btnKreiranjeTerminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreiranjeTerminaActionPerformed
        // TODO add your handling code here:
        KreiranjeZakazanogTerminaForma ktf = new KreiranjeZakazanogTerminaForma();
        
        ktf.setVisible(true);
        
    }//GEN-LAST:event_btnKreiranjeTerminaActionPerformed

    private void btnIzmenaTerminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmenaTerminaActionPerformed
        // TODO add your handling code here:
        IzmenaZakazanogTerminaForma itf = new IzmenaZakazanogTerminaForma();
        
        itf.setVisible(true);
    }//GEN-LAST:event_btnIzmenaTerminaActionPerformed

    private void btnBrisanjeTerminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrisanjeTerminaActionPerformed
        // TODO add your handling code here:
        BrisanjeZakazanogTerminaForma btf = new BrisanjeZakazanogTerminaForma();
        
        btf.setVisible(true);
    }//GEN-LAST:event_btnBrisanjeTerminaActionPerformed

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
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GlavnaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrisanjeTermina;
    private javax.swing.JButton btnIzmenaKozmeticara;
    private javax.swing.JButton btnIzmenaTermina;
    private javax.swing.JButton btnKreirajKozmeticara;
    private javax.swing.JButton btnKreiranjeTermina;
    private javax.swing.JButton btnKreiranjeUsluge;
    private javax.swing.JButton btnObrisiUslugu;
    private javax.swing.JButton btnPretragaUsluga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton txtBrisanjeKozmeticara;
    // End of variables declaration//GEN-END:variables

}
