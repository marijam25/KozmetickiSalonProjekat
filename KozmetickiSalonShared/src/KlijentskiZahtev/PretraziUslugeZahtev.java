package KlijentskiZahtev;

import java.io.Serializable;

public class PretraziUslugeZahtev implements Serializable {

    private String uslov;

    public PretraziUslugeZahtev(String uslov) {
        this.uslov = uslov;
    }

    public String getUslov() {
        return uslov;
    }

}
