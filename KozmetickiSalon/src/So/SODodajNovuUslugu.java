package So;

import Domen.Usluga;
import db.DBBroker;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SODodajNovuUslugu extends OpstaSistemskaOperacija {

    private Usluga u;

    public SODodajNovuUslugu(Usluga u) {
        this.u = u;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        DBBroker.getInstance().upisiUBazu(u);
    }

}
