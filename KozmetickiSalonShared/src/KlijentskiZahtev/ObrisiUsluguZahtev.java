package KlijentskiZahtev;

import Domen.Usluga;
import java.io.Serializable;

public class ObrisiUsluguZahtev implements Serializable {

    private Usluga usluga;

    public ObrisiUsluguZahtev(Usluga usluga) {
        this.usluga = usluga;
    }

    public Usluga getUsluga() {
        return usluga;
    }

}
