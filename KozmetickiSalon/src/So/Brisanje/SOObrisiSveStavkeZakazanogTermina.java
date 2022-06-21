
package So.Brisanje;

import Domen.OpstiDomenskiObjekat;
import So.OpstaSistemskaOperacija;
import db.DBBroker;

import java.util.ArrayList;
import java.util.List;

public class SOObrisiSveStavkeZakazanogTermina extends OpstaSistemskaOperacija {

    @Override
    protected boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    protected boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        List<String> koloneZaUslov = new ArrayList<>();
        koloneZaUslov.add("zakazaniTerminId");
        return DBBroker.getInstance().izbrisiIzBaze(odo, koloneZaUslov);
    }
}
