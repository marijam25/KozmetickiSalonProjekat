package ServerskiOdgovor;

import java.io.Serializable;

public class DodajNoviTerminOdgovor implements Serializable {

    private boolean uspeo;

    public DodajNoviTerminOdgovor(boolean success) {
        this.uspeo = success;
    }

    public boolean isUspeo() {
        return uspeo;
    }

}
