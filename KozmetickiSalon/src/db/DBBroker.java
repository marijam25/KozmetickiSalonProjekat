package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBBroker {
    
    private static DBBroker instance;
    

    private Connection konekcija;

    private DBBroker() {
        uspostaviKonekciju();
    }

    public static DBBroker getInstance() {
        if(instance==null)
            instance = new DBBroker();
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

}
