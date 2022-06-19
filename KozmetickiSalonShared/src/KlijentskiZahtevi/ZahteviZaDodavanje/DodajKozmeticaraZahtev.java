package KlijentskiZahtevi.ZahteviZaDodavanje;

import Domen.Kozmeticar;
import java.io.Serializable;

public class DodajKozmeticaraZahtev implements Serializable {

    private Kozmeticar kozmeticar;

    public DodajKozmeticaraZahtev(Kozmeticar kozmeticar) {
        this.kozmeticar = kozmeticar;
    }

    public Kozmeticar getKozmeticar() {
        return kozmeticar;
    }
}
