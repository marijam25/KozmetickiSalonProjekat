package So;

import Domen.Kozmeticar;
import db.DBBroker;

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
