package So;

import Domen.Klijent;
import db.DBBroker;

public class SODodajNovogKlijenta extends OpstaSistemskaOperacija {

    private Klijent k;

    public SODodajNovogKlijenta(Klijent k) {
        this.k = k;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        operacijaUspesnoIzvrsena = DBBroker.getInstance().upisiUBazu(k);
    }

}
