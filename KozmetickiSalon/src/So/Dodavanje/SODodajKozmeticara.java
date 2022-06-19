package So.Dodavanje;

import Domen.OpstiDomenskiObjekat;
import So.OpstaSistemskaOperacija;
import db.DBBroker;

public class SODodajKozmeticara extends OpstaSistemskaOperacija {

    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        return DBBroker.getInstance().upisiUBazu(odo);
    }

}
