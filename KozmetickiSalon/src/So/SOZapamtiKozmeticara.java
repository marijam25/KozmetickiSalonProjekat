package So;

import Domen.Kozmeticar;
import db.DBBroker;

public class SOZapamtiKozmeticara extends OpstaSistemskaOperacija {

    private Kozmeticar k;

    public SOZapamtiKozmeticara(Kozmeticar k) {
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
