package ServerskiOdgovori.OdgovoriDodavanje;

import java.io.Serializable;

public class DodajKozmeticaraOdgovor implements Serializable {

    private boolean uspeo;

    public DodajKozmeticaraOdgovor(boolean uspeo) {
        this.uspeo = uspeo;
    }

    public boolean isUspeo() {
        return uspeo;
    }
}
