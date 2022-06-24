package So.Dohvatanje;

import Domen.Klijent;
import Domen.OpstiDomenskiObjekat;
import So.OpstaSistemskaOperacija;
import db.DBBroker;
import java.util.ArrayList;
import java.util.List;

public class SODohvatiKlijente extends OpstaSistemskaOperacija {

    private List<OpstiDomenskiObjekat> listaKlijenata;

    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        
        listaKlijenata = DBBroker.getInstance().dohvatiSveIzBaze(odo);
        
        if(listaKlijenata==null)
            return false;
        else
            return true;
    }

    public List<Klijent> getListaKlijenata() {
       List<Klijent> listaKlijenataKastovana = new ArrayList<>();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaKlijenata) {
            listaKlijenataKastovana.add((Klijent)opstiDomenskiObjekat);
        }
        return listaKlijenataKastovana;
    }

}
