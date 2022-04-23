package So;

import Domen.Usluga;
import db.DBBroker;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SOObrisiUslugu extends OpstaSistemskaOperacija {

    private Usluga u;

    public SOObrisiUslugu(Usluga u) {
        this.u = u;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        DBBroker.getInstance().izbrisiIzBaze(u);
    }

}
