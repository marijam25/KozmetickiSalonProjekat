package KlijentskiZahtev;

import java.io.Serializable;

public class VratiKozmeticareZahtev implements Serializable {

    private String uslov;

    public VratiKozmeticareZahtev(String uslov) {
        this.uslov = uslov;
    }

    public String getUslov() {
        return uslov;
    }

}
