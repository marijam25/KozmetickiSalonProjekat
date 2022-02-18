package db;

import Domen.ZakazivanjeTermina;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ZakazivanjeTerminaDBInterface implements DBInterface<ZakazivanjeTermina> {

    public DBBroker broker;

    public ZakazivanjeTerminaDBInterface(DBBroker broker) {
        this.broker = broker;
    }

    @Override
    public List<ZakazivanjeTermina> vratiSve() {
        return vratiSve("");
    }

    @Override
    public List<ZakazivanjeTermina> vratiSve(String uslov) {
        List<ZakazivanjeTermina> listaZakazivanja = new ArrayList<>();
        try {
            String upit = "select * from ZakazivanjeTermina";
            if (!uslov.isEmpty()) {
                upit += " where " + uslov;
            }
            Statement statement = broker.getKonekcija().createStatement();
            ResultSet rs = statement.executeQuery(upit);

            while (rs.next()) {
                int zakazivanjeId = rs.getInt("ZakazivanjeID");
                int kozmeticarId = rs.getInt("KozmeticarID");
                int klijentId = rs.getInt("KlijentID");
                ZakazivanjeTermina zt = new ZakazivanjeTermina(zakazivanjeId, kozmeticarId, klijentId);
                listaZakazivanja.add(zt);
            }
            rs.close();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaZakazivanja;
    }

    @Override
    public boolean dodaj(ZakazivanjeTermina zt) {
        try {
            //zakazivanjeid, kozmeticarid, klijentid
            String upit = "insert into ZakazivanjeTermina(KozmeticarId, KlijentId) values (?,?)";
            PreparedStatement ps = broker.getKonekcija().prepareStatement(upit);

            ps.setInt(1, zt.getKozmeticarId());
            ps.setInt(2, zt.getKlijentId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean izmeni(ZakazivanjeTermina t) {
        try {
            String upit = "update ZakazivanjeTermina set KozmeticarId=?, KlijentId=? where TerminId=?";
            PreparedStatement ps = broker.getKonekcija().prepareStatement(upit);
            ps.setInt(1, t.getKozmeticarId());
            ps.setInt(2, t.getKlijentId());
            ps.setInt(3, t.getZakazivanjeId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ZakazivanjeTerminaDBInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean obrisi(ZakazivanjeTermina t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ZakazivanjeTermina vratiPoIdu(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
