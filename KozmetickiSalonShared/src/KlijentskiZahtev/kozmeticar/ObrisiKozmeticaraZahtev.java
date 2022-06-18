package KlijentskiZahtev.kozmeticar;

import Domen.Kozmeticar;
import java.io.Serializable;

public class ObrisiKozmeticaraZahtev implements Serializable {

    private Kozmeticar kozmeticar;

    public ObrisiKozmeticaraZahtev(Kozmeticar kozmeticar) {
        this.kozmeticar = kozmeticar;
    }

    public Kozmeticar getKozmeticar() {
        return kozmeticar;
    }

}
