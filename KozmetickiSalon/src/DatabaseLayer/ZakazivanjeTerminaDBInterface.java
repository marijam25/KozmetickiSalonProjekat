/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import Beans.ZakazivanjeTermina;
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
public class ZakazivanjeTerminaDBInterface implements DBInterface<ZakazivanjeTermina>{

    public DBBroker broker;

    public ZakazivanjeTerminaDBInterface(DBBroker broker) {
        this.broker = broker;
    }

    @Override
    public List<ZakazivanjeTermina> getAll() {
        return getAll("");
    }

    @Override
    public List<ZakazivanjeTermina> getAll(String condition) {
        List<ZakazivanjeTermina> listaZakazivanja = new ArrayList<>();
        try {
            String query = "select * from ZakazivanjeTermin where " + condition;
            Statement statement = broker.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            
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
    public boolean add(ZakazivanjeTermina zt) {
        try {
            //zakazivanjeid, kozmeticarid, klijentid
            String upit = "insert into ZakazivanjeTermin(KozmeticarId, KlijentId) values (?,?)";
            PreparedStatement ps = broker.getConnection().prepareStatement(upit);
            
            ps.setInt(1, zt.getKozmeticarId());
            ps.setInt(2, zt.getKlijentId());
            return ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean edit(ZakazivanjeTermina t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(ZakazivanjeTermina t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ZakazivanjeTermina getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
