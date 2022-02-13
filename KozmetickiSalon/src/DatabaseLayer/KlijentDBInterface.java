/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import Beans.Klijent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author milic
 */
public class KlijentDBInterface implements DBInterface<Klijent>{
    
    public DBBroker broker;

    public KlijentDBInterface(DBBroker broker) {
        this.broker = broker;
    }
    
    @Override
    public List<Klijent> getAll() {
        return getAll("");
    }
    
    @Override
    public List<Klijent> getAll(String condition) {
        List<Klijent> listaKlijenata = new ArrayList<>();
        try {
            String query = "select * from Klijent where " + condition;
            Statement statement = broker.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("KlijentID");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                Klijent k = new Klijent(id, ime, prezime);
                listaKlijenata.add(k);
            }
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitana lista Manufacturer!");
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaKlijenata;
    }

    @Override
    public boolean add(Klijent k) {
        try {
            String upit = "insert into Klijent(ime, prezime) values (?, ?)";
            PreparedStatement ps = broker.getConnection().prepareStatement(upit);
            ps.setString(1, k.getIme());
            ps.setString(2, k.getPrezime());
            return ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public void edit(Klijent t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Klijent t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Klijent getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
