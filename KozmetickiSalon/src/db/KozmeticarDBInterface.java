/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import Domen.Kozmeticar;
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
    public List<Kozmeticar> vratiSve() {
        return vratiSve("");
    }

    @Override
    public List<Kozmeticar> vratiSve(String uslov) {
        List<Kozmeticar> listaKozmeticar = new ArrayList<>();
        try {
            String upit = "select * from Kozmeticar";
            if(!uslov.isEmpty()){
                upit += " where " + uslov;
            }
            Statement statement = broker.getKonekcija().createStatement();
            ResultSet rs = statement.executeQuery(upit);

            while (rs.next()) {
                int id = rs.getInt("KozmeticarID");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                int godine = rs.getInt("Godine");
                Kozmeticar k = new Kozmeticar(id, ime, prezime, godine);
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
    public boolean dodaj(Kozmeticar k) {
        try {
            String upit = "insert into Kozmeticar(ime, prezime, godine) values (?, ?, ?)";
            PreparedStatement ps = broker.getKonekcija().prepareStatement(upit);
            ps.setString(1, k.getIme());
            ps.setString(2, k.getPrezime());
            ps.setInt(3, k.getGodine());
            return ps.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean izmeni(Kozmeticar t) {
        try {
            String upit = "update Kozmeticar set ime=?, prezime=?, godine=? where KOzmeticarID=?";
            PreparedStatement ps = broker.getKonekcija().prepareStatement(upit);
            ps.setString(1, t.getIme());
            ps.setString(2, t.getPrezime());
            ps.setInt(3, t.getGodine());
            ps.setInt(4, t.getKozmeticarId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(KozmeticarDBInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean obrisi(Kozmeticar t) {
        try {
            String upit = "delete from Kozmeticar where KozmeticarID= "+t.getKozmeticarId();
            Statement statement = broker.getKonekcija().createStatement();
            statement.executeUpdate(upit);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KozmeticarDBInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Kozmeticar vratiPoIdu(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
