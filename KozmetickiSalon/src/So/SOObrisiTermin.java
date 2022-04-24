package So;

import Domen.Termin;
import db.DBBroker;

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
        operacijaUspesnoIzvrsena = DBBroker.getInstance().izbrisiIzBaze(t);

    }

}
