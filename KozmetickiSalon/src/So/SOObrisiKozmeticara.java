package So;

import Domen.Kozmeticar;
import Domen.OpstiDomenskiObjekat;
import db.DBBroker;

public class SOObrisiKozmeticara extends OpstaSistemskaOperacija {

    

    public SOObrisiKozmeticara() {
        
    }

    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        operacijaUspesnoIzvrsena = DBBroker.getInstance().izbrisiIzBaze(odo);
        return operacijaUspesnoIzvrsena;
    }

}
