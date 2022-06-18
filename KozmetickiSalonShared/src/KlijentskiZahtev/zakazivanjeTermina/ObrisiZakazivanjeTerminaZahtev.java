package KlijentskiZahtev.zakazivanjeTermina;

import Domen.ZakazivanjeTermina;
import java.io.Serializable;

public class ObrisiZakazivanjeTerminaZahtev implements Serializable {
    private ZakazivanjeTermina zakazivanje;

    public ObrisiZakazivanjeTerminaZahtev(ZakazivanjeTermina zakazivanje) {
        this.zakazivanje = zakazivanje;
    }

    public ZakazivanjeTermina getZakazivanje() {
        return zakazivanje;
    }
    
    
    

}
