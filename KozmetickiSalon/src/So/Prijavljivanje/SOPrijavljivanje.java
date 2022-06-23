package So.Prijavljivanje;

import Domen.KorisnikSistema;
import Domen.OpstiDomenskiObjekat;
import So.OpstaSistemskaOperacija;
import db.DBBroker;
import java.util.ArrayList;
import java.util.List;

public class SOPrijavljivanje extends OpstaSistemskaOperacija {
    private List<KorisnikSistema> listaKorisnika;

    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        List<String> koloneZaUslov = new ArrayList<>();
        koloneZaUslov.add("korisnickoIme");
        koloneZaUslov.add("sifra");

        listaKorisnika = (ArrayList<KorisnikSistema>) DBBroker.getInstance().dohvatiIzBaze(odo, koloneZaUslov);
        if(listaKorisnika.isEmpty())
            return false;
        else
            return true;
    }

    public List<KorisnikSistema> getListaKorisnika() {
        return listaKorisnika;
    }
    
}
