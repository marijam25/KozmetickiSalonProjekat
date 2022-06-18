package ServerskiOdgovor.klijent;

import Domen.Klijent;
import java.io.Serializable;
import java.util.ArrayList;

public class VratiSveKlijenteOdgovor implements Serializable {

    private ArrayList<Klijent> listaKlijenata;

    public VratiSveKlijenteOdgovor(ArrayList<Klijent> listaKlijenata) {
        this.listaKlijenata = listaKlijenata;
    }

    public ArrayList<Klijent> getListaKlijenata() {
        return listaKlijenata;
    }

}
