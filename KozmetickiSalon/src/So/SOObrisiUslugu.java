package So;

import Domen.Usluga;
import db.DBBroker;

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
        operacijaUspesnoIzvrsena = DBBroker.getInstance().izbrisiIzBaze(u);
    }

}
