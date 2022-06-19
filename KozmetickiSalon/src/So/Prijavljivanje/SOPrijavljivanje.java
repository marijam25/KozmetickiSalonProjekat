package So.Prijavljivanje;

import Domen.KorisnikSistema;
import Domen.OpstiDomenskiObjekat;
import So.OpstaSistemskaOperacija;
import db.DBBroker;
import java.util.ArrayList;
import java.util.List;

public class SOPrijavljivanje extends OpstaSistemskaOperacija {
    private ArrayList<KorisnikSistema> listaKorisnika;

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
        if(listaKorisnika==null)
            return false;
        else
            return true;
    }

    public ArrayList<KorisnikSistema> getListaKorisnika() {
        return listaKorisnika;
    }
    
}
