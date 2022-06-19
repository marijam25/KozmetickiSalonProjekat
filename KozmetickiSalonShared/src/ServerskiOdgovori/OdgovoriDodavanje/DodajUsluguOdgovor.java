package ServerskiOdgovori.OdgovoriDodavanje;

import java.io.Serializable;

public class DodajUsluguOdgovor implements Serializable {

    private boolean uspeo;

    public DodajUsluguOdgovor(boolean uspeo) {
        this.uspeo = uspeo;
    }

    public boolean isUspeo() {
        return uspeo;
    }

}
