/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import Beans.Usluga;
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
public class UslugaDBInterface implements DBInterface<Usluga> {

    public DBBroker broker;

    public UslugaDBInterface(DBBroker broker) {
        this.broker = broker;
    }

    @Override
    public List<Usluga> getAll() {
        return getAll("");
    }

    @Override
    public List<Usluga> getAll(String condition) {
        List<Usluga> listaUsluga = new ArrayList<>();
        try {
            String query = "select * from Usluga where " + condition;
            Statement statement = broker.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("UslugaID");
                String ime = rs.getString("NazivUsluge");
                int idKategorije = rs.getInt("KategorijaID");
                Usluga u = new Usluga(id, ime, idKategorije);
                listaUsluga.add(u);
            }
            rs.close();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaUsluga;
    }

    @Override
    public boolean add(Usluga u) {
        try {
            String upit = "insert into Usluga(nazivUsluge, kategorijaId) values (?, ?)";
            PreparedStatement ps = broker.getConnection().prepareStatement(upit);
            ps.setString(1, u.getNazivUsluge());
            ps.setInt(2, u.getKategorijaId());
            return ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public void edit(Usluga t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Usluga t) {
        try {
            String query = "delete from Usluga where UslugaID= " + t.getUslugaId();
            Statement statement = broker.getConnection().createStatement();
            statement.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UslugaDBInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Usluga getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
