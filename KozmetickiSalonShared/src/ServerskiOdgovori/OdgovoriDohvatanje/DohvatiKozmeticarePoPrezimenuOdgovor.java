package ServerskiOdgovori.OdgovoriDohvatanje;

import Domen.Kozmeticar;
import java.io.Serializable;
import java.util.List;

public class DohvatiKozmeticarePoPrezimenuOdgovor implements Serializable {

    private List<Kozmeticar> listaKozmeticara;

    public DohvatiKozmeticarePoPrezimenuOdgovor(List<Kozmeticar> listaKozmeticara) {
        this.listaKozmeticara = listaKozmeticara;
    }

    public List<Kozmeticar> getListaKozmeticara() {
        return listaKozmeticara;
    }

}
