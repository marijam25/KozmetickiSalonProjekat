package So.Dohvatanje;

import Domen.OpstiDomenskiObjekat;
import Domen.Usluga;
import So.OpstaSistemskaOperacija;
import db.DBBroker;
import java.util.ArrayList;
import java.util.List;

public class SODohvatiUsluguPoNazivu extends OpstaSistemskaOperacija {
    private List<OpstiDomenskiObjekat> listaUsluga;

    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
     public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        List<String> koloneZaUslov = new ArrayList<>();
        koloneZaUslov.add("nazivUsluge");
        listaUsluga = DBBroker.getInstance().dohvatiIzBaze(odo, koloneZaUslov);
        if(listaUsluga==null)
            return false;
        else
            return true;
    }

    public List<Usluga> getListaUsluga() {
        List<Usluga> listaUslugaKastovana = new ArrayList<>();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaUsluga) {
            listaUslugaKastovana.add((Usluga)opstiDomenskiObjekat);
        }
        return listaUslugaKastovana;
    }
}
