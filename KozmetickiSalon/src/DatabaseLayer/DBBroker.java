/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import Beans.KategorijaUsluga;
import Beans.Klijent;
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

    private Connection connection;

    public DBBroker() {
        establishConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    public void establishConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                DBPropertiesLoader dbl = DBPropertiesLoader.getInstance();
                Class.forName(dbl.getValue(DBPropertiesLoader.Constants.DRIVER));

                String url = dbl.getValue(DBPropertiesLoader.Constants.URL);
                String user = dbl.getValue(DBPropertiesLoader.Constants.USER);
                String password = dbl.getValue(DBPropertiesLoader.Constants.PASS);
                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false);
            }
        } catch (SQLException ex) {
            System.out.println("Neuspesno uspostavljanje konekcije!\n" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
