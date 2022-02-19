package KlijentskiZahtev;

import Domen.StavkaZakazivanja;
import Domen.Termin;
import Domen.ZakazivanjeTermina;
import java.io.Serializable;

public class IzmeniTerminZahtev implements Serializable {

    private Termin termin;

    public IzmeniTerminZahtev(Termin termin) {
        this.termin = termin;
    }

    public Termin getTermin() {
        return termin;
    }
    
    

}
