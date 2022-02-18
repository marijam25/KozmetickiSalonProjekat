package KlijentskiZahtev;

import Domen.Termin;
import java.io.Serializable;

public class ObrisiTerminZahtev implements Serializable {

    private Termin termin;

    public ObrisiTerminZahtev(Termin termin) {
        this.termin = termin;
    }

    public Termin getTermin() {
        return termin;
    }

}
