package So;

import Domen.OpstiDomenskiObjekat;
import Domen.Usluga;
import Domen.ZakazivanjeTermina;
import db.DBBroker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class SONadjiZakazivanjeTerminaPoIdu extends OpstaSistemskaOperacija {

    
    private ArrayList<ZakazivanjeTermina> listaZakazivanja;

    public SONadjiZakazivanjeTerminaPoIdu() {
    }

    

    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
     public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        Set<String> koloneZaPretrazivanje = new HashSet<>();
        koloneZaPretrazivanje.add("zakazivanjeId");
        listaZakazivanja = (ArrayList<ZakazivanjeTermina>) DBBroker.getInstance().pronadjiUBazi(odo, koloneZaPretrazivanje);
        if(listaZakazivanja==null)
            return false;
        else
            return true;
    }

    public ArrayList<ZakazivanjeTermina> getListaZakazivanja() {
        return listaZakazivanja;
    }

}
