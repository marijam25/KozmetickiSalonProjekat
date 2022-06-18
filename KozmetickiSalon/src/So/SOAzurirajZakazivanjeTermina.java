package So;

import Domen.OpstiDomenskiObjekat;

import db.DBBroker;

public class SOAzurirajZakazivanjeTermina extends OpstaSistemskaOperacija {

    

    public SOAzurirajZakazivanjeTermina() {
        
    }

    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        operacijaUspesnoIzvrsena = DBBroker.getInstance().azurirajUBazi(odo);
        return operacijaUspesnoIzvrsena;
    }

}
