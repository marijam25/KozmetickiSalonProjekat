package KlijentskiZahtev;

import java.io.Serializable;
import java.util.Date;

public class VratiTermineZahtev implements Serializable {

    private Date datum;

    public VratiTermineZahtev(Date datum) {
        this.datum = datum;
    }

    public Date getDatum() {
        return datum;
    }

}
