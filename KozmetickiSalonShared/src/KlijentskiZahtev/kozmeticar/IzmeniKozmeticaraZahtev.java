package KlijentskiZahtev.kozmeticar;

import Domen.Kozmeticar;
import java.io.Serializable;

public class IzmeniKozmeticaraZahtev implements Serializable {

    private Kozmeticar kozmeticar;

    public IzmeniKozmeticaraZahtev(Kozmeticar kozmeticar) {
        this.kozmeticar = kozmeticar;
    }

    public Kozmeticar getKozmeticar() {
        return kozmeticar;
    }
}
