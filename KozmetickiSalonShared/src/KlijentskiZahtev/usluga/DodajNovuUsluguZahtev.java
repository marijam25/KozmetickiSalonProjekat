package KlijentskiZahtev.usluga;

import Domen.Usluga;
import java.io.Serializable;

public class DodajNovuUsluguZahtev implements Serializable {

    private Usluga usluga;

    public DodajNovuUsluguZahtev(Usluga usluga) {
        this.usluga = usluga;
    }

    public Usluga getUsluga() {
        return usluga;
    }

}
