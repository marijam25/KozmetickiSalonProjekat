package KlijentskiZahtev;

import java.io.Serializable;
import javafx.util.Pair;

public class PretraziUslugeZahtev implements Serializable {

    private Pair<String, String> uslov;

    public PretraziUslugeZahtev() {
        uslov = null;
    }

    public PretraziUslugeZahtev(String kolona, String vrednost) {
        uslov = new Pair<>(kolona, vrednost);
    }

    public Pair<String, String> getUslov() {
        return uslov;
    }

}
