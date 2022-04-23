package db;

import Domen.OpstiDomenskiObjekat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;
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

    public Connection getKonekcija() {
        return konekcija;
    }

    public void uspostaviKonekciju() {
        try {
            if (konekcija == null || konekcija.isClosed()) {
                DBPropertiesLoader dbl = DBPropertiesLoader.getInstance();
                Class.forName(dbl.getValue(DBPropertiesLoader.Constants.DRIVER));

                String url = dbl.getValue(DBPropertiesLoader.Constants.URL);
                String user = dbl.getValue(DBPropertiesLoader.Constants.USER);
                String password = dbl.getValue(DBPropertiesLoader.Constants.PASS);
                konekcija = DriverManager.getConnection(url, user, password);
                konekcija.setAutoCommit(false);
            }
        } catch (SQLException ex) {
            System.out.println("Neuspesno uspostavljanje konekcije!\n" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeConnection() {
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
        HashMap<String, String> naziviIVrednosti = odo.naziviIVrednostiKolona();
        String imenaKolona = " (";
        String vrednostiKolona = " (";

        int i = 0;

        for (Map.Entry<String, String> parNazivVrednost : naziviIVrednosti.entrySet()) {
            imenaKolona += parNazivVrednost.getKey();
            vrednostiKolona += parNazivVrednost.getValue();

            if (i < naziviIVrednosti.size()) {
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

    public boolean azurirajUBazi(OpstiDomenskiObjekat odo) {
        String upit = "update " + odo.nazivTabele() + " set ";
        HashMap<String, String> naziviIVrednosti = odo.naziviIVrednostiKolona();

        int i = 0;

        for (Map.Entry<String, String> parNazivVrednost : naziviIVrednosti.entrySet()) {
            upit += parNazivVrednost.getKey() + "=" + parNazivVrednost.getValue();

            if (i < naziviIVrednosti.size()) {
                upit += ", ";
            }
            i++;
        }

        Pair<String, String> nazivIVrednostPrimarnogKljuca = odo.nazivIVrednostPrimarnogKljuca();
        upit += " where " + nazivIVrednostPrimarnogKljuca.getKey() + "=" + nazivIVrednostPrimarnogKljuca.getValue();

        return executeUpdateWrapper(upit);
    }

    public boolean izbrisiIzBaze(OpstiDomenskiObjekat odo) {
        String upit = "delete from " + odo.nazivTabele() + " where ";
        Pair<String, String> nazivIVrednostPrimarnogKljuca = odo.nazivIVrednostPrimarnogKljuca();
        upit += nazivIVrednostPrimarnogKljuca.getKey() + "=" + nazivIVrednostPrimarnogKljuca.getValue();

        return executeUpdateWrapper(upit);
    }
    
    public ArrayList<? extends OpstiDomenskiObjekat> pronadjiUBazi(OpstiDomenskiObjekat odo, Pair<String, String> uslov){
        String upit = "select * from " + odo.nazivTabele();
        if(uslov != null){
            upit += " where " + uslov.getKey() + "=" + uslov.getValue();
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
    
    public ArrayList<? extends OpstiDomenskiObjekat> pronadjiUBazi(OpstiDomenskiObjekat odo){
        return pronadjiUBazi(odo, null);
    }
}
