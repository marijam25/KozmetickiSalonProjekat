package So.Dodavanje;

import Domen.OpstiDomenskiObjekat;
import So.OpstaSistemskaOperacija;
import Domen.ZakazaniTermin;
import db.DBBroker;

public class SODodajZakazaniTermin extends OpstaSistemskaOperacija {
    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        boolean operacijaUspesnoIzvrsena = DBBroker.getInstance().upisiUBazu(odo);
        if(operacijaUspesnoIzvrsena){
            int maxId = DBBroker.getInstance().vratiMaxId(odo);
            operacijaUspesnoIzvrsena = maxId != -1;
            ((ZakazaniTermin)odo).setZakazaniTerminId(maxId);
        }
        return operacijaUspesnoIzvrsena;
    }
}
