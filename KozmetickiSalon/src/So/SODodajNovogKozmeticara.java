package So;

import Domen.Kozmeticar;
import db.DBBroker;

public class SODodajNovogKozmeticara extends OpstaSistemskaOperacija {

    private Kozmeticar k;

    public SODodajNovogKozmeticara(Kozmeticar k) {
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
