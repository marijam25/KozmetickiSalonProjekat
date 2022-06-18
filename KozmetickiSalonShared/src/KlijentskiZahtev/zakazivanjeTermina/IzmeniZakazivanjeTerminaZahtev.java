package KlijentskiZahtev.zakazivanjeTermina;

import Domen.StavkaZakazivanja;
import Domen.ZakazivanjeTermina;
import java.io.Serializable;

public class IzmeniZakazivanjeTerminaZahtev implements Serializable {
    private ZakazivanjeTermina zakazivanje;

    public IzmeniZakazivanjeTerminaZahtev(ZakazivanjeTermina zakazivanje) {
        this.zakazivanje = zakazivanje;
    }

    public ZakazivanjeTermina getZakazivanje() {
        return zakazivanje;
    }
  

}
