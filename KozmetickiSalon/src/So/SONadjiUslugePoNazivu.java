package So;

import Domen.OpstiDomenskiObjekat;
import Domen.Usluga;
import db.DBBroker;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SONadjiUslugePoNazivu extends OpstaSistemskaOperacija {

    
    private ArrayList<Usluga> listaUsluga;

    public SONadjiUslugePoNazivu() {
    }

    

    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
     public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        Set<String> koloneZaPretrazivanje = new HashSet<>();
        koloneZaPretrazivanje.add("nazivUsluge");
        listaUsluga = (ArrayList<Usluga>) DBBroker.getInstance().pronadjiUBazi(odo, koloneZaPretrazivanje);
        if(listaUsluga==null)
            return false;
        else
            return true;
    }

    public ArrayList<Usluga> getListaUsluga() {
        return listaUsluga;
    }

}
