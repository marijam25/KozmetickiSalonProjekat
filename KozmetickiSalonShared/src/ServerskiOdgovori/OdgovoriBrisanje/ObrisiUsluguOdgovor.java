package ServerskiOdgovori.OdgovoriBrisanje;

import java.io.Serializable;

public class ObrisiUsluguOdgovor implements Serializable {

    boolean uspeo;

    public ObrisiUsluguOdgovor(boolean uspeo) {
        this.uspeo = uspeo;
    }

    public boolean isUspeo() {
        return uspeo;
    }

}
