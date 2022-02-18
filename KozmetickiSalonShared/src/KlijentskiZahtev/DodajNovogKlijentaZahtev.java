package KlijentskiZahtev;

import Domen.Klijent;
import java.io.Serializable;

public class DodajNovogKlijentaZahtev implements Serializable {

    private Klijent klijent;

    public DodajNovogKlijentaZahtev(Klijent klijent) {
        this.klijent = klijent;
    }

    public Klijent getKlijent() {
        return klijent;
    }
}
