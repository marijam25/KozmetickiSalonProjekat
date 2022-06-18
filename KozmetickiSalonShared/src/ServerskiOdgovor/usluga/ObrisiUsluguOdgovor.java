package ServerskiOdgovor.usluga;

import java.io.Serializable;

public class ObrisiUsluguOdgovor implements Serializable {

    boolean uspeo;

    public ObrisiUsluguOdgovor(boolean success) {
        this.uspeo = success;
    }

    public boolean isUspeo() {
        return uspeo;
    }

}
