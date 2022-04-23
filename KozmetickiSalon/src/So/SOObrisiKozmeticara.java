package So;

import Domen.Kozmeticar;
import db.DBBroker;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SOObrisiKozmeticara extends OpstaSistemskaOperacija {

    private Kozmeticar k;

    public SOObrisiKozmeticara(Kozmeticar k) {
        this.k = k;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        DBBroker.getInstance().izbrisiIzBaze(k);
    }

}
