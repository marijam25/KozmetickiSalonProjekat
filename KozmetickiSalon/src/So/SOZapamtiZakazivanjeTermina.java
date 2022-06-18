package So;

import Domen.OpstiDomenskiObjekat;
import Domen.StavkaZakazivanja;
import Domen.ZakazivanjeTermina;
import db.DBBroker;
import java.util.List;

public class SOZapamtiZakazivanjeTermina extends OpstaSistemskaOperacija {

    public SOZapamtiZakazivanjeTermina() {
    }

    
    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        operacijaUspesnoIzvrsena = DBBroker.getInstance().upisiUBazu(odo);
        if(operacijaUspesnoIzvrsena){
            int maxId = DBBroker.getInstance().vratiMaxId(odo);
            operacijaUspesnoIzvrsena = maxId != -1;
            ((ZakazivanjeTermina)odo).setZakazivanjeId(maxId);
        }
        return operacijaUspesnoIzvrsena;
    }

}
