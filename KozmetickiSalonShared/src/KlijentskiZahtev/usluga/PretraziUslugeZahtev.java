package KlijentskiZahtev.usluga;

import Domen.Usluga;
import java.io.Serializable;
import java.util.Map;


public class PretraziUslugeZahtev implements Serializable {

    private Usluga usluga;

    public PretraziUslugeZahtev(Usluga usluga) {
        this.usluga = usluga;
    }

    public Usluga getUsluga() {
        return usluga;
    }
    
    

    

}
