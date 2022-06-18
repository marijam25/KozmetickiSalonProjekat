package ServerskiOdgovor.zakazivanjeTermina;

import java.io.Serializable;

public class IzmeniZakazivanjeTerminaOdgovor implements Serializable {

    private boolean uspeo;

    public IzmeniZakazivanjeTerminaOdgovor(boolean success) {
        this.uspeo = success;
    }

    public boolean isUspeo() {
        return uspeo;
    }
}
