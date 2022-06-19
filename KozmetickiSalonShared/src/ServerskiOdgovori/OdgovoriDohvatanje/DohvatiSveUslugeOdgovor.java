package ServerskiOdgovori.OdgovoriDohvatanje;

import Domen.Usluga;

import java.io.Serializable;
import java.util.List;

public class DohvatiSveUslugeOdgovor implements Serializable {
    private List<Usluga> nizUsluga;

    public DohvatiSveUslugeOdgovor(List<Usluga> nizUsluga) {
        this.nizUsluga = nizUsluga;
    }

    public List<Usluga> getNizUsluga() {
        return nizUsluga;
    }
}
