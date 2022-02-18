package db;

import Domen.Klijent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KlijentDBInterface implements DBInterface<Klijent> {

    public DBBroker broker;

    public KlijentDBInterface(DBBroker broker) {
        this.broker = broker;
    }

    @Override
    public List<Klijent> vratiSve() {
        return vratiSve("");
    }

    @Override
    public List<Klijent> vratiSve(String uslov) {
        List<Klijent> listaKlijenata = new ArrayList<>();
        try {
            String upit = "select * from Klijent";
            if (!uslov.isEmpty()) {
                upit += " where " + uslov;
            }
            Statement statement = broker.getKonekcija().createStatement();
            ResultSet rs = statement.executeQuery(upit);

            while (rs.next()) {
                int id = rs.getInt("KlijentID");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                Klijent k = new Klijent(id, ime, prezime);
                listaKlijenata.add(k);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaKlijenata;
    }

    @Override
    public boolean dodaj(Klijent k) {
        try {
            String upit = "insert into Klijent(ime, prezime) values (?, ?)";
            PreparedStatement ps = broker.getKonekcija().prepareStatement(upit);
            ps.setString(1, k.getIme());
            ps.setString(2, k.getPrezime());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean izmeni(Klijent t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean obrisi(Klijent t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Klijent vratiPoIdu(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
