package So.Dodavanje;

import Domen.OpstiDomenskiObjekat;
import So.OpstaSistemskaOperacija;
import db.DBBroker;

public class SODodajStavkuZakazanogTermina extends OpstaSistemskaOperacija{

    @Override
    protected boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    protected boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        return DBBroker.getInstance().upisiUBazu(odo);
    }
}
