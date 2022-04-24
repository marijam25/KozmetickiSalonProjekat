package So;

import Domen.Usluga;
import db.DBBroker;

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
        operacijaUspesnoIzvrsena = DBBroker.getInstance().upisiUBazu(u);
    }

}
