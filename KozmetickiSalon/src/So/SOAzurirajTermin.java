package So;

import Domen.Termin;
import db.DBBroker;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SOAzurirajTermin extends OpstaSistemskaOperacija {

    private Termin t;

    public SOAzurirajTermin(Termin t) {
        this.t = t;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        try {
            String upit = "update Termin set DatumTermina=?, VremeTermina=? where TerminId=?";
            PreparedStatement ps = DBBroker.getInstance().getKonekcija().prepareStatement(upit);
            ps.setDate(1, new java.sql.Date(t.getDatumTermina().getTime()));
            ps.setTime(2, new java.sql.Time(t.getVremeTermina().getTime()));
            ps.setInt(3, t.getTerminId());
            ps.executeUpdate();
            operacijaUspesnoIzvrsena = true;
        } catch (SQLException ex) {
            operacijaUspesnoIzvrsena = false;
            Logger.getLogger(SOAzurirajTermin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
