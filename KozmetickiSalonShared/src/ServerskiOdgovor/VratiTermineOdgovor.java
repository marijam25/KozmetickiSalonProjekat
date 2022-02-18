package ServerskiOdgovor;

import Domen.Termin;
import java.io.Serializable;
import java.util.ArrayList;

public class VratiTermineOdgovor implements Serializable {

    private ArrayList<Termin> listaTermina;

    public VratiTermineOdgovor(ArrayList<Termin> listaTermina) {
        this.listaTermina = listaTermina;
    }

    public ArrayList<Termin> getListaTermina() {
        return listaTermina;
    }

}
