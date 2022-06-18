package So;

import Domen.OpstiDomenskiObjekat;
import Domen.Usluga;
import db.DBBroker;

public class SOObrisiUslugu extends OpstaSistemskaOperacija {

    

    public SOObrisiUslugu() {
        
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
