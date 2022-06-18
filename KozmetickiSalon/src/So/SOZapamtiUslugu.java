package So;

import Domen.OpstiDomenskiObjekat;
import Domen.Usluga;
import db.DBBroker;

public class SOZapamtiUslugu extends OpstaSistemskaOperacija {

    

    public SOZapamtiUslugu() {
        
    }

    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        operacijaUspesnoIzvrsena = DBBroker.getInstance().upisiUBazu(odo);
        return operacijaUspesnoIzvrsena;
    }

}
