package KlijentskiZahtev.zakazivanjeTermina;

import Domen.ZakazivanjeTermina;
import java.io.Serializable;



public class VratiZakazivanjeTerminaZahtev implements Serializable {

    private ZakazivanjeTermina zakazivanje;

    public VratiZakazivanjeTerminaZahtev(ZakazivanjeTermina zakazivanje) {
        this.zakazivanje = zakazivanje;
    }

    public ZakazivanjeTermina getZakazivanje() {
        return zakazivanje;
    }
    
    
    

}
