package ServerskiOdgovor.zakazivanjeTermina;

import Domen.ZakazivanjeTermina;
import java.io.Serializable;
import java.util.ArrayList;

public class VratiZakazivanjeTerminaOdgovor implements Serializable {

    private ArrayList<ZakazivanjeTermina> listaZakazivanja;

    public VratiZakazivanjeTerminaOdgovor(ArrayList<ZakazivanjeTermina> listaZakazivanja) {
        this.listaZakazivanja = listaZakazivanja;
    }

    public ArrayList<ZakazivanjeTermina> getListaTermina() {
        return listaZakazivanja;
    }

}
