package ServerskiOdgovor.zakazivanjeTermina;

import java.io.Serializable;

public class ObrisiZakazivanjeTerminaOdgovor implements Serializable {

    private boolean uspeo;

    public ObrisiZakazivanjeTerminaOdgovor(boolean success) {
        this.uspeo = success;
    }

    public boolean isUspeo() {
        return uspeo;
    }

}
