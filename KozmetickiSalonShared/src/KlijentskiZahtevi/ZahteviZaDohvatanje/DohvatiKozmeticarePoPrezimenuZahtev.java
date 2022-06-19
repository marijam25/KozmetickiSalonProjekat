package KlijentskiZahtevi.ZahteviZaDohvatanje;

import Domen.Kozmeticar;
import java.io.Serializable;

public class DohvatiKozmeticarePoPrezimenuZahtev implements Serializable {
    private Kozmeticar kozmeticar;

    public DohvatiKozmeticarePoPrezimenuZahtev(Kozmeticar kozmeticar) {
        this.kozmeticar = kozmeticar;
    }

    public Kozmeticar getKozmeticar() {
        return kozmeticar;
    }
}
