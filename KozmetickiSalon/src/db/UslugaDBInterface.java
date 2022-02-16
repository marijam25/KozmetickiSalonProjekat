/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import Domen.Usluga;
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
    public List<Usluga> vratiSve() {
        return vratiSve("");
    }

    @Override
    public List<Usluga> vratiSve(String uslov) {
        List<Usluga> listaUsluga = new ArrayList<>();
        try {
            String upit = "select * from Usluga";
            if(!uslov.isEmpty()){
                upit += " where " + uslov;
            }
            Statement statement = broker.getKonekcija().createStatement();
            ResultSet rs = statement.executeQuery(upit);

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
    public boolean dodaj(Usluga u) {
        try {
            String upit = "insert into Usluga(nazivUsluge, kategorijaId) values (?, ?)";
            PreparedStatement ps = broker.getKonekcija().prepareStatement(upit);
            ps.setString(1, u.getNazivUsluge());
            ps.setInt(2, u.getKategorijaId());
            return ps.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean izmeni(Usluga t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean obrisi(Usluga t) {
        try {
            String upit = "delete from Usluga where UslugaID= " + t.getUslugaId();
            Statement statement = broker.getKonekcija().createStatement();
            statement.executeUpdate(upit);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UslugaDBInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Usluga vratiPoIdu(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
