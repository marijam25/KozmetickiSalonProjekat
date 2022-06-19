package ServerskiOdgovori.OdgovoriDodavanje;

import java.io.Serializable;

public class DodajZakazaniTerminOdgovor implements Serializable {

    private boolean uspeo;

    public DodajZakazaniTerminOdgovor(boolean uspeo) {
        this.uspeo = uspeo;
    }

    public boolean isUspeo() {
        return uspeo;
    }

}
