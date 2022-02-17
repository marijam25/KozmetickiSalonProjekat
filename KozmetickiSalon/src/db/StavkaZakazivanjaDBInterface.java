/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import Domen.StavkaZakazivanja;
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
    public List<StavkaZakazivanja> vratiSve() {
        return vratiSve("");
    }

    @Override
    public List<StavkaZakazivanja> vratiSve(String uslov) {
        List<StavkaZakazivanja> listaStavkiZakazivanja = new ArrayList<>();
        try {
            String upit = "select * from StavkaZakazivanja";
            if(!uslov.isEmpty()){
                upit += " where " + uslov;
            }
            Statement statement = broker.getKonekcija().createStatement();
            ResultSet rs = statement.executeQuery(upit);

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
    public boolean dodaj(StavkaZakazivanja sz) {
        try {
            String upit = "insert into StavkaZakazivanja(ZakazivanjeID,TerminID,UslugaID) VALUES ((select max(ZakazivanjeID) from zakazivanjetermina), (SELECT max(TerminID) from termin), ?)";
            PreparedStatement ps = broker.getKonekcija().prepareStatement(upit);
            ps.setInt(1, sz.getUslugaId());
            return ps.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean izmeni(StavkaZakazivanja t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean obrisi(StavkaZakazivanja t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StavkaZakazivanja vratiPoIdu(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
