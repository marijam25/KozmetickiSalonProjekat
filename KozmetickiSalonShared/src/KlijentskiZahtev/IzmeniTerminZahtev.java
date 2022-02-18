package KlijentskiZahtev;

import Domen.StavkaZakazivanja;
import Domen.Termin;
import Domen.ZakazivanjeTermina;
import java.io.Serializable;

public class IzmeniTerminZahtev implements Serializable {

    private Termin termin;
    private StavkaZakazivanja stavkaZakazivanja;
    private ZakazivanjeTermina zakazivanjeTermina;

    public IzmeniTerminZahtev(Termin termin, StavkaZakazivanja stavkaZakazivanja, ZakazivanjeTermina zakazivanjeTermina) {
        this.termin = termin;
        this.stavkaZakazivanja = stavkaZakazivanja;
        this.zakazivanjeTermina = zakazivanjeTermina;
    }

    public Termin getTermin() {
        return termin;
    }

    public StavkaZakazivanja getStavkaZakazivanja() {
        return stavkaZakazivanja;
    }

    public ZakazivanjeTermina getZakazivanjeTermina() {
        return zakazivanjeTermina;
    }

}
