package ServerskiOdgovori.OdgovoriDohvatanje;

import Domen.Klijent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DohvatiSveKlijenteOdgovor implements Serializable {

    private List<Klijent> listaKlijenata;

    public DohvatiSveKlijenteOdgovor(List<Klijent> listaKlijenata) {
        this.listaKlijenata = listaKlijenata;
    }

    public List<Klijent> getListaKlijenata() {
        return listaKlijenata;
    }
}
