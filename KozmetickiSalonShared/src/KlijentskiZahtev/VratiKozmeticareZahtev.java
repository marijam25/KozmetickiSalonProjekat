package KlijentskiZahtev;

import java.io.Serializable;
import javafx.util.Pair;

public class VratiKozmeticareZahtev implements Serializable {

    private Pair<String, String> uslov;

    public VratiKozmeticareZahtev(){
        uslov = null;
    }
    
    public VratiKozmeticareZahtev(String kolona, String vrednost) {
        uslov = new Pair<>(kolona, vrednost);
    }

    public Pair<String, String> getUslov() {
        return uslov;
    }

}
