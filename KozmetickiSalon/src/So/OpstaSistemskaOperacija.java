package So;

import Domen.OpstiDomenskiObjekat;
import db.DBBroker;

public abstract class OpstaSistemskaOperacija {

    protected boolean operacijaUspesnoIzvrsena;

    public OpstaSistemskaOperacija() {
        operacijaUspesnoIzvrsena = false;
    }

    protected abstract boolean proveriPreduslov(OpstiDomenskiObjekat odo);

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

    public boolean isOperacijaUspesnoIzvrsena() {
        return operacijaUspesnoIzvrsena;
    }

    protected abstract boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo);
}
