package ServerskiOdgovori.OdgovoriDohvatanje;

import Domen.Usluga;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DohvatiUsluguPoNazivuOdgovor implements Serializable {
    private List<Usluga> nizUsluga;

    public DohvatiUsluguPoNazivuOdgovor(List<Usluga> nizUsluga) {
        this.nizUsluga = nizUsluga;
    }

    public List<Usluga> getNizUsluga() {
        return nizUsluga;
    }
}
