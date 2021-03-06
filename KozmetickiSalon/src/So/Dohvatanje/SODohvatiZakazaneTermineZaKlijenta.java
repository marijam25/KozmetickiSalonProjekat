package So.Dohvatanje;

import Domen.OpstiDomenskiObjekat;
import Domen.ZakazaniTermin;
import So.OpstaSistemskaOperacija;
import db.DBBroker;

import java.util.ArrayList;
import java.util.List;

public class SODohvatiZakazaneTermineZaKlijenta extends OpstaSistemskaOperacija {

    private List<OpstiDomenskiObjekat>  listaZakazanihTermina;

    @Override
    protected boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    protected boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        List<String> koloneZaUslov = new ArrayList<>();
        koloneZaUslov.add("klijentId");
        listaZakazanihTermina = DBBroker.getInstance().dohvatiIzBaze(odo, koloneZaUslov);
        if(listaZakazanihTermina==null)
            return false;
        else
            return true;
    }

    public List<ZakazaniTermin> getListaZakazanihTermina() {
        List<ZakazaniTermin> listaZakazanihTerminaKastovana = new ArrayList<>();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaZakazanihTermina) {
            listaZakazanihTerminaKastovana.add((ZakazaniTermin)opstiDomenskiObjekat);
        }
        return listaZakazanihTerminaKastovana;
    }
}
