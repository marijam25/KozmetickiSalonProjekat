package So;

import Domen.OpstiDomenskiObjekat;

import db.DBBroker;

public class SOObrisiZakazivanjeTermina extends OpstaSistemskaOperacija {

    

    public SOObrisiZakazivanjeTermina() {
        
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
