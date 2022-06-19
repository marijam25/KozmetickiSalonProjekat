package ServerskiOdgovori.OdgovoriDohvatanje;

import Domen.Kozmeticar;

import java.io.Serializable;
import java.util.List;

public class DohvatiSveKozmeticareOdgovor implements Serializable {
    private List<Kozmeticar> listaKozmeticara;

    public DohvatiSveKozmeticareOdgovor(List<Kozmeticar> listaKozmeticara) {
        this.listaKozmeticara = listaKozmeticara;
    }

    public List<Kozmeticar> getListaKozmeticara() {
        return listaKozmeticara;
    }
}
