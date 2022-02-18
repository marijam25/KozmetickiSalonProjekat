package db;

import Domen.KategorijaUsluga;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KategorijaUslugaDBInterface implements DBInterface<KategorijaUsluga> {

    public DBBroker broker;

    public KategorijaUslugaDBInterface(DBBroker broker) {
        this.broker = broker;
    }

    @Override
    public List<KategorijaUsluga> vratiSve() {
        return vratiSve("");
    }

    @Override
    public List<KategorijaUsluga> vratiSve(String uslov) {
        List<KategorijaUsluga> listaKategorijaUsluga = new ArrayList<>();
        try {
            String upit = "select * from KategorijaUsluga";
            if (!uslov.isEmpty()) {
                upit += " where " + uslov;
            }
            Statement statement = broker.getKonekcija().createStatement();
            ResultSet rs = statement.executeQuery(upit);

            while (rs.next()) {
                int id = rs.getInt("KategorijaID");
                String naziv = rs.getString("NazivKategorije");

                KategorijaUsluga ku = new KategorijaUsluga(id, naziv);
                listaKategorijaUsluga.add(ku);
            }
            rs.close();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaKategorijaUsluga;
    }

    @Override
    public boolean dodaj(KategorijaUsluga ku) {
        try {
            String upit = "insert into KategorijaUsluga(nazivKategorije) values (?)";
            PreparedStatement ps = broker.getKonekcija().prepareStatement(upit);
            ps.setString(1, ku.getNazivKategorije());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean izmeni(KategorijaUsluga t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean obrisi(KategorijaUsluga t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KategorijaUsluga vratiPoIdu(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
