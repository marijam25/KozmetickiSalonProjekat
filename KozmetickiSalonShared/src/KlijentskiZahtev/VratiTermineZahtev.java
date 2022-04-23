package KlijentskiZahtev;

import java.io.Serializable;
import javafx.util.Pair;

public class VratiTermineZahtev implements Serializable {

    private Pair<String, String> uslov;

    public VratiTermineZahtev() {
        uslov = null;
    }
    

    public VratiTermineZahtev(String kolona, String vrednost) {
        uslov = new Pair<>(kolona, vrednost);
    }

    public Pair<String, String> getDatum() {
        return uslov;
    }

}
