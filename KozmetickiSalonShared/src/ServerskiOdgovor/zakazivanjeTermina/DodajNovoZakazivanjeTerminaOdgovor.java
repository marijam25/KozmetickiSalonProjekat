package ServerskiOdgovor.zakazivanjeTermina;

import java.io.Serializable;

public class DodajNovoZakazivanjeTerminaOdgovor implements Serializable {

    private boolean uspeo;

    public DodajNovoZakazivanjeTerminaOdgovor(boolean uspeo) {
        this.uspeo = uspeo;
    }

    public boolean isUspeo() {
        return uspeo;
    }

}
