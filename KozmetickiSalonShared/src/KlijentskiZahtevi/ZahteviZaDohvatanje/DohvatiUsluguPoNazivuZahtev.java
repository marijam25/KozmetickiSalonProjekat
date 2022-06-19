package KlijentskiZahtevi.ZahteviZaDohvatanje;

import Domen.Usluga;
import java.io.Serializable;

public class DohvatiUsluguPoNazivuZahtev implements Serializable {
    private Usluga usluga;

    public DohvatiUsluguPoNazivuZahtev(Usluga usluga) {
        this.usluga = usluga;
    }

    public Usluga getUsluga() {
        return usluga;
    }
}
