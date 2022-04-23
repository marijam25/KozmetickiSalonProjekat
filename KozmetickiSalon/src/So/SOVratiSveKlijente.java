package So;

import Domen.Klijent;
import db.DBBroker;
import java.util.ArrayList;

public class SOVratiSveKlijente extends OpstaSistemskaOperacija {

    private ArrayList<Klijent> listaKlijenata;

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        Klijent odo = new Klijent();
        listaKlijenata = (ArrayList<Klijent>) DBBroker.getInstance().pronadjiUBazi(odo);
    }

    public ArrayList<Klijent> getListaKlijenata() {
        return listaKlijenata;
    }

}
