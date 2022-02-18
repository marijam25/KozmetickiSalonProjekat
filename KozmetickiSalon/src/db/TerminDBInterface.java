package db;

import Domen.Termin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TerminDBInterface implements DBInterface<Termin> {

    public DBBroker broker;

    public TerminDBInterface(DBBroker broker) {
        this.broker = broker;
    }

    @Override
    public List<Termin> vratiSve() {
        return vratiSve("");
    }

    @Override
    public List<Termin> vratiSve(String uslov) {
        List<Termin> listaTermina = new ArrayList<>();
        try {
            String upit = "select * from Termin";
            if (!uslov.isEmpty()) {
                upit += " where " + uslov;
            }
            Statement statement = broker.getKonekcija().createStatement();
            ResultSet rs = statement.executeQuery(upit);

            while (rs.next()) {
                int id = rs.getInt("TerminID");
                java.sql.Date sqlDate = rs.getDate("DatumTermina");
                java.sql.Time sqlTime = rs.getTime("VremeTermina");
                java.util.Date datum = new java.util.Date(sqlDate.getTime());
                Time vreme = new Time(sqlTime.getTime());
                Termin t = new Termin(id, datum, (Time) vreme);
                listaTermina.add(t);
            }
            rs.close();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaTermina;
    }

    @Override
    public boolean dodaj(Termin t) {
        try {
            String upit = "insert into Termin(DatumTermina, VremeTermina) values (?,?)";
            PreparedStatement ps = broker.getKonekcija().prepareStatement(upit);
            java.sql.Date sqlDate = new java.sql.Date(t.getDatumTermina().getTime());
            java.sql.Time sqlTime = new java.sql.Time(t.getVremeTermina().getTime());
            ps.setDate(1, sqlDate);
            ps.setTime(2, sqlTime);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean izmeni(Termin t) {

        try {
            String upit = "update Termin set DatumTermina=?, VremeTermina=? where TerminId=?";
            PreparedStatement ps = broker.getKonekcija().prepareStatement(upit);
            ps.setDate(1, new java.sql.Date(t.getDatumTermina().getTime()));
            ps.setTime(2, new java.sql.Time(t.getVremeTermina().getTime()));
            ps.setInt(3, t.getTerminId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TerminDBInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean obrisi(Termin t) {
        try {
            String upit = "delete from Termin where TerminID= " + t.getTerminId();
            Statement statement = broker.getKonekcija().createStatement();
            statement.executeUpdate(upit);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TerminDBInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Termin vratiPoIdu(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
