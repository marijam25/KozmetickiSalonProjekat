package So;

import Domen.OpstiDomenskiObjekat;
import db.DBBroker;

public abstract class OpstaSistemskaOperacija {

    public boolean izvrsi(OpstiDomenskiObjekat odo) {
        boolean preduslovZadovoljen = proveriPreduslov(odo);

        if (preduslovZadovoljen) {

            boolean operacijaIzvrsena = izvrsiKonkretnuOperaciju(odo);
            if (operacijaIzvrsena) {
                potvrdi();
                return true;
            } else {
                ponisti();
                return false;
            }
        } else {
            return false;
        }
    }

    public void potvrdi() {
        DBBroker.getInstance().potvrdiTransakciju();
    }

    public void ponisti() {
        DBBroker.getInstance().ponistiTransakciju();
    }

    protected abstract boolean proveriPreduslov(OpstiDomenskiObjekat odo);

    protected abstract boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo);
}
