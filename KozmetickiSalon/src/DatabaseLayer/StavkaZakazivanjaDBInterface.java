/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import Beans.StavkaZakazivanja;
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
public class StavkaZakazivanjaDBInterface implements DBInterface<StavkaZakazivanja>{

    public DBBroker broker;

    public StavkaZakazivanjaDBInterface(DBBroker broker) {
        this.broker = broker;
    }

    @Override
    public List<StavkaZakazivanja> getAll() {
        return getAll("");
    }

    @Override
    public List<StavkaZakazivanja> getAll(String condition) {
        List<StavkaZakazivanja> listaStavkiZakazivanja = new ArrayList<>();
        try {
            String query = "select * from StavkaZakazivanja where " + condition;
            Statement statement = broker.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int stavkaId = rs.getInt("StavkaID");
                int zakazivanjeId = rs.getInt("ZakazivanjeID");
                int terminId = rs.getInt("TerminID");
                int uslugaId = rs.getInt("UslugaID");
                StavkaZakazivanja sz = new StavkaZakazivanja(stavkaId, zakazivanjeId, terminId, uslugaId);
                listaStavkiZakazivanja.add(sz);
            }
            rs.close();
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaStavkiZakazivanja;
    }

    @Override
    public boolean add(StavkaZakazivanja sz) {
        try {
            String upit = "insert into StavkaZakazivanja(zakazivanjeId, terminId, uslugaId) values (?,?,?)";
            PreparedStatement ps = broker.getConnection().prepareStatement(upit);
            ps.setInt(1, sz.getZakazivanjeId());
            ps.setInt(2, sz.getTerminId());
            ps.setInt(3, sz.getUslugaId());
            return ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public void edit(StavkaZakazivanja t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(StavkaZakazivanja t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StavkaZakazivanja getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
