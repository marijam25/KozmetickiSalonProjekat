package So;

import Domen.Termin;
import db.DBBroker;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SOObrisiTermin extends OpstaSistemskaOperacija {

    private Termin t;

    public SOObrisiTermin(Termin t) {
        this.t = t;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        try {
            String upit = "delete from Termin where TerminID= " + t.getTerminId();
            Statement statement = DBBroker.getInstance().getKonekcija().createStatement();
            statement.executeUpdate(upit);
            operacijaUspesnoIzvrsena = true;
        } catch (SQLException ex) {
            operacijaUspesnoIzvrsena = false;
            Logger.getLogger(SOObrisiTermin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
