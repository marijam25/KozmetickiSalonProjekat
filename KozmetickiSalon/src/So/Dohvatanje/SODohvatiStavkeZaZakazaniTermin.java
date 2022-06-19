package So.Dohvatanje;

import Domen.OpstiDomenskiObjekat;
import Domen.StavkaZakazanogTermina;
import Domen.ZakazaniTermin;
import So.OpstaSistemskaOperacija;
import db.DBBroker;

import java.util.ArrayList;
import java.util.List;

public class SODohvatiStavkeZaZakazaniTermin extends OpstaSistemskaOperacija {

    private List<StavkaZakazanogTermina> listaStavki;

    @Override
    protected boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    protected boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        List<String> koloneZaUslov = new ArrayList<>();
        koloneZaUslov.add("zakazaniTerminId");
        listaStavki = (List<StavkaZakazanogTermina>) DBBroker.getInstance().dohvatiIzBaze(odo, koloneZaUslov);
        if(listaStavki==null)
            return false;
        else
            return true;
    }

    public List<StavkaZakazanogTermina> getListaStavki() {
        return listaStavki;
    }
}
