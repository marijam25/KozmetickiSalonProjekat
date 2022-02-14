/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import Beans.Termin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author milic
 */
public class TerminDBInterface implements DBInterface<Termin> {

    public DBBroker broker;

    public TerminDBInterface(DBBroker broker) {
        this.broker = broker;
    }

    @Override
    public List<Termin> getAll() {
        return getAll("");
    }

    @Override
    public List<Termin> getAll(String condition) {
        List<Termin> listaTermina = new ArrayList<>();
        try {
            String query = "select * from Termin where " + condition;
            Statement statement = broker.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("TerminID");
                java.sql.Date sqlDate = rs.getDate("Datum");
                java.sql.Time sqlTime = rs.getTime("Vreme");
                java.util.Date datum = new java.util.Date(sqlDate.getTime());
                java.util.Date vreme = new java.util.Date(sqlTime.getTime());
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
    public boolean add(Termin t) {
        try {
            String upit = "insert into Termin(Datum, Vreme) values (?,?)";
            PreparedStatement ps = broker.getConnection().prepareStatement(upit);
            java.sql.Date sqlDate = new java.sql.Date(t.getDatumTermina().getTime());
            java.sql.Time sqlTime = new java.sql.Time(t.getVremeTermina().getTime());
            ps.setDate(1, sqlDate);
            ps.setTime(2, sqlTime);
            return ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public void edit(Termin t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Termin t) {
        try {
            String query = "delete from Termin where TerminID= " + t.getTerminId();
            Statement statement = broker.getConnection().createStatement();
            statement.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TerminDBInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Termin getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
