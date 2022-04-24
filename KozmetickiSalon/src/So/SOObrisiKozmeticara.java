package So;

import Domen.Kozmeticar;
import db.DBBroker;

public class SOObrisiKozmeticara extends OpstaSistemskaOperacija {

    private Kozmeticar k;

    public SOObrisiKozmeticara(Kozmeticar k) {
        this.k = k;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        operacijaUspesnoIzvrsena = DBBroker.getInstance().izbrisiIzBaze(k);
    }

}
