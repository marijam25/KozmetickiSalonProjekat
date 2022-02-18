package ServerskiOdgovor;

import java.io.Serializable;

public class ObrisiTerminOdgovor implements Serializable {

    private boolean uspeo;

    public ObrisiTerminOdgovor(boolean success) {
        this.uspeo = success;
    }

    public boolean isUspeo() {
        return uspeo;
    }

}
