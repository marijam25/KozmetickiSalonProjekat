package So;

import Domen.Klijent;
import Domen.OpstiDomenskiObjekat;
import db.DBBroker;
import java.util.ArrayList;

public class SOUcitajListuKlijenata extends OpstaSistemskaOperacija {

    private ArrayList<Klijent> listaKlijenata;

    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        
        listaKlijenata = (ArrayList<Klijent>) DBBroker.getInstance().pronadjiUBazi(odo,null);
        
        if(listaKlijenata==null)
            return false;
        else
            return true;
    }

    public ArrayList<Klijent> getListaKlijenata() {
        return listaKlijenata;
    }

}
