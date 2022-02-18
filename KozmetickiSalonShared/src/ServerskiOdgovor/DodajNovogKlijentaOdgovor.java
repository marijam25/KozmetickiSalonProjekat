package ServerskiOdgovor;

import java.io.Serializable;

public class DodajNovogKlijentaOdgovor implements Serializable {

    private boolean uspeo;

    public DodajNovogKlijentaOdgovor(boolean success) {
        this.uspeo = success;
    }

    public boolean isUspeo() {
        return uspeo;
    }
}
