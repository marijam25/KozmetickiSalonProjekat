package So;

import Domen.Termin;
import db.DBBroker;

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
        operacijaUspesnoIzvrsena = DBBroker.getInstance().azurirajUBazi(t);
    }

}
