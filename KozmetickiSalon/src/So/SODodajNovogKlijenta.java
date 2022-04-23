package So;

import Domen.Klijent;
import db.DBBroker;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SODodajNovogKlijenta extends OpstaSistemskaOperacija {

    private Klijent k;

    public SODodajNovogKlijenta(Klijent k) {
        this.k = k;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        DBBroker.getInstance().upisiUBazu(k);
    }

}
