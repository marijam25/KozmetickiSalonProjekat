package So;

import Domen.Kozmeticar;
import db.DBBroker;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SOAzurirajKozmeticara extends OpstaSistemskaOperacija {

    private Kozmeticar k;

    public SOAzurirajKozmeticara(Kozmeticar k) {
        this.k = k;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        DBBroker.getInstance().azurirajUBazi(k);
    }
}
