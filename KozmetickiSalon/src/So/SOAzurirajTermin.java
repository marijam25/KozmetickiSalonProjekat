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
        DBBroker.getInstance().azurirajUBazi(t);
    }

}
