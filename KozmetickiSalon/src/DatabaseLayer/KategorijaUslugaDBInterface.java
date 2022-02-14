/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import Beans.KategorijaUsluga;
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
public class KategorijaUslugaDBInterface implements DBInterface<KategorijaUsluga>{

    public DBBroker broker;

    public KategorijaUslugaDBInterface(DBBroker broker) {
        this.broker = broker;
    }

    @Override
    public List<KategorijaUsluga> getAll() {
        return getAll("");
    }

    @Override
    public List<KategorijaUsluga> getAll(String condition) {
        List<KategorijaUsluga> listaKategorijaUsluga = new ArrayList<>();
        try {
            String query = "select * from KategorijaUsluga where " + condition;
            Statement statement = broker.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);

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
    public boolean add(KategorijaUsluga ku) {
        try {
            String upit = "insert into KategorijaUsluga(nazivKategorije) values (?)";
            PreparedStatement ps = broker.getConnection().prepareStatement(upit);
            ps.setString(1, ku.getNazivKategorije());
            return ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public void edit(KategorijaUsluga t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(KategorijaUsluga t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KategorijaUsluga getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
