package KlijentskiZahtevi.ZahteviZaDodavanje;

import Domen.Usluga;
import java.io.Serializable;

public class DodajUsluguZahtev implements Serializable {
    private Usluga usluga;

    public DodajUsluguZahtev(Usluga usluga) {
        this.usluga = usluga;
    }

    public Usluga getUsluga() {
        return usluga;
    }
}
