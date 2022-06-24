package db;

import Domen.OpstiDomenskiObjekat;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBBroker {

    private static DBBroker instance;

    private Connection konekcija;

    private DBBroker() {
        uspostaviKonekciju();
    }

    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    public void uspostaviKonekciju() {
        try {
            if (konekcija == null || konekcija.isClosed()) {
                DBPropertiesLoader dbl = new DBPropertiesLoader();

                String url = dbl.vratiURL();
                String user = dbl.vratiUsername();
                String password = dbl.vratiPassword();
                konekcija = DriverManager.getConnection(url, user, password);
                konekcija.setAutoCommit(false);
            }
        } catch (SQLException ex) {
            System.out.println("Neuspesno uspostavljanje konekcije!\n" + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void zatvoriKonekciju() {
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void potvrdiTransakciju() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ponistiTransakciju() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean executeUpdateWrapper(String upit) {
        try {
            Statement st = konekcija.createStatement();
            st.executeUpdate(upit);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean upisiUBazu(OpstiDomenskiObjekat odo) {
        String upit = "insert into " + odo.nazivTabele();
        Map<String, String> naziviIVrednosti = odo.naziviIVrednostiKolona();
        String imenaKolona = " (";
        String vrednostiKolona = " (";

        int i = 0;

        for (Map.Entry<String, String> parNazivVrednost : naziviIVrednosti.entrySet()) {
            imenaKolona += parNazivVrednost.getKey();
            vrednostiKolona += "'" + parNazivVrednost.getValue() + "'";

            if (i < naziviIVrednosti.size() - 1) {
                imenaKolona += ", ";
                vrednostiKolona += ", ";
            }
            i++;
        }

        imenaKolona += ")";
        vrednostiKolona += ")";
        upit += imenaKolona + " values " + vrednostiKolona;
        return executeUpdateWrapper(upit);
    }

    public boolean azurirajUBazi(OpstiDomenskiObjekat odo, List<String> koloneZaUslov) {
        String upit = "update " + odo.nazivTabele() + " set ";
        Map<String, String> naziviIVrednosti = odo.naziviIVrednostiKolona();

        int i = 0;

        for (Map.Entry<String, String> parNazivVrednost : naziviIVrednosti.entrySet()) {
            upit += parNazivVrednost.getKey() + "=" + "'" + parNazivVrednost.getValue() + "'";

            if (i < naziviIVrednosti.size() - 1) {
                upit += ", ";
            }
            i++;
        }

        upit += " where";
        
        int j=0;
        for (Map.Entry<String, String> nazivIVrednostKolone : naziviIVrednosti.entrySet()) {
            if (koloneZaUslov != null && koloneZaUslov.contains(nazivIVrednostKolone.getKey())) {
                if(j>0) upit+= " AND";
                upit += " " + nazivIVrednostKolone.getKey() + "=" + "'" + nazivIVrednostKolone.getValue() + "'";
                j++;
            }
            
        }

        return executeUpdateWrapper(upit);
    }

    public boolean azurirajUBaziPoIdju(OpstiDomenskiObjekat odo) {
        return azurirajUBazi(odo, odo.naziviKolonaPrimarnogKljuca());
    }

    public boolean izbrisiIzBaze(OpstiDomenskiObjekat odo, List<String> koloneZaUslov) {
        String upit = "delete from " + odo.nazivTabele();

        upit += " where";
        Map<String, String> naziviIVrednostiKolona = odo.naziviIVrednostiKolona();
        int i=0;
        for (Map.Entry<String, String> nazivIVrednostKolone : naziviIVrednostiKolona.entrySet()) {
            if (koloneZaUslov != null && koloneZaUslov.contains(nazivIVrednostKolone.getKey())) {
                if(i>0) upit+= " AND";
                upit += " " + nazivIVrednostKolone.getKey() + "=" + "'" + nazivIVrednostKolone.getValue() + "'";
                i++;
            } 
        }
       return executeUpdateWrapper(upit);
    }

    public boolean izbrisiIzBazePoIdju(OpstiDomenskiObjekat odo) {
        return izbrisiIzBaze(odo, odo.naziviKolonaPrimarnogKljuca());
    }

    public List<OpstiDomenskiObjekat> dohvatiIzBaze(OpstiDomenskiObjekat odo, List<String> koloneZaUslov) {
        String upit = "select * from " + odo.nazivTabele();
        if (koloneZaUslov != null && !koloneZaUslov.isEmpty()) {
            upit += " where";
            Map<String, String> uslovi = odo.naziviIVrednostiKolona();
            int i=0;
            for (Map.Entry<String, String> uslov : uslovi.entrySet()) {
                if (uslov.getValue() != null && koloneZaUslov.contains(uslov.getKey())) {
                    if(i>0) upit+= " AND";
                    upit += " " + uslov.getKey() + "=" + "'" + uslov.getValue() + "'";
                    i++;
                }
            }
        }
        try {
            Statement st = konekcija.createStatement();
            ResultSet res = st.executeQuery(upit);

            return odo.ucitajIzResultSeta(res);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<OpstiDomenskiObjekat> dohvatiIzBazePoIdju(OpstiDomenskiObjekat odo, List<String> koloneZaUslov) {
        return dohvatiIzBaze(odo, odo.naziviKolonaPrimarnogKljuca());
    }

    public List<OpstiDomenskiObjekat> dohvatiSveIzBaze(OpstiDomenskiObjekat odo) {
        return dohvatiIzBaze(odo, null);
    }

    public int vratiMaxId(OpstiDomenskiObjekat odo) {
        try {
            String upit = "SELECT max(" + odo.naziviKolonaPrimarnogKljuca().get(0) + ") as maxid FROM " + odo.nazivTabele();
            Statement st = konekcija.createStatement();
            ResultSet rs = st.executeQuery(upit);
            rs.first();
            return rs.getInt("maxid");
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
