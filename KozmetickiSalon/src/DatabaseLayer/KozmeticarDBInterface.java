/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import Beans.Klijent;
import Beans.Kozmeticar;
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
public class KozmeticarDBInterface implements DBInterface<Kozmeticar> {

    public DBBroker broker;

    public KozmeticarDBInterface(DBBroker broker) {
        this.broker = broker;
    }

    @Override
    public List<Kozmeticar> getAll() {
        return getAll("");
    }

    @Override
    public List<Kozmeticar> getAll(String condition) {
        List<Kozmeticar> listaKozmeticar = new ArrayList<>();
        try {
            String query = "select * from Kozmeticar where " + condition;
            Statement statement = broker.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("KozmeticarID");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                Kozmeticar k = new Kozmeticar(id, ime, prezime);
                listaKozmeticar.add(k);
            }
            rs.close();
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaKozmeticar;
    }

    @Override
    public boolean add(Kozmeticar k) {
        try {
            String upit = "insert into Kozmeticar(ime, prezime) values (?, ?)";
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
    public boolean edit(Kozmeticar t) {
        try {
            String upit = "update Kozmeticar set ime=?, prezime=? where KOzmeticarID=?";
            PreparedStatement ps = broker.getConnection().prepareStatement(upit);
            ps.setString(1, t.getIme());
            ps.setString(2, t.getPrezime());
            ps.setInt(3, t.getKozmeticarId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(KozmeticarDBInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean delete(Kozmeticar t) {
        try {
            String upit = "delete from Kozmeticar where KozmeticarID= "+t.getKozmeticarId();
            Statement statement = broker.getConnection().createStatement();
            statement.executeUpdate(upit);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KozmeticarDBInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Kozmeticar getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
