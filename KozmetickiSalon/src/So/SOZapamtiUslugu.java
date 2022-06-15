package So;

import Domen.Usluga;
import db.DBBroker;

public class SOZapamtiUslugu extends OpstaSistemskaOperacija {

    private Usluga u;

    public SOZapamtiUslugu(Usluga u) {
        this.u = u;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        operacijaUspesnoIzvrsena = DBBroker.getInstance().upisiUBazu(u);
    }

}
