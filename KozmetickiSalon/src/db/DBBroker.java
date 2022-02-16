/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import Domen.KategorijaUsluga;
import Domen.Klijent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author milic
 */
public class DBBroker {

    private Connection konekcija;

    public DBBroker() {
        uspostaviKonekciju();
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
                //konekcija.setAutoCommit(true);
            }
        } catch (SQLException ex) {
            System.out.println("Neuspesno uspostavljanje konekcije!\n" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeConnection(){
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
