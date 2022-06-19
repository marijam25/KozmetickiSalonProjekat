package ServerskiOdgovori.OdgovoriPrijavljivanje;

import java.io.Serializable;

public class PrijavljivanjeOdgovor implements Serializable {
    private boolean uspeo;

    public PrijavljivanjeOdgovor(boolean uspeo) {
        this.uspeo = uspeo;
    }

    public boolean isUspeo() {
        return uspeo;
    }
}
