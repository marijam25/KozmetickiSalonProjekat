package KlijentskiZahtev.kozmeticar;

import Domen.Kozmeticar;
import java.io.Serializable;

public class DodajNovogKozmeticaraZahtev implements Serializable {

    private Kozmeticar kozmeticar;

    public DodajNovogKozmeticaraZahtev(Kozmeticar kozmeticar) {
        this.kozmeticar = kozmeticar;
    }

    public Kozmeticar getKozmeticar() {
        return kozmeticar;
    }
}
