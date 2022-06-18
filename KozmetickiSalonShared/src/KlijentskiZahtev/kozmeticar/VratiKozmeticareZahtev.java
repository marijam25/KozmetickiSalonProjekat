package KlijentskiZahtev.kozmeticar;

import Domen.Kozmeticar;
import java.io.Serializable;
import java.util.Map;
import javafx.util.Pair;

public class VratiKozmeticareZahtev implements Serializable {

    private Kozmeticar kozmeticar;

    public VratiKozmeticareZahtev(Kozmeticar kozmeticar) {
        this.kozmeticar = kozmeticar;
    }

    public Kozmeticar getKozmeticar() {
        return kozmeticar;
    }
    
    
    
    

}
