package ServerskiOdgovor.usluga;

import java.io.Serializable;

public class DodajNovuUsluguOdgovor implements Serializable {

    private boolean uspeo;

    public DodajNovuUsluguOdgovor(boolean success) {
        this.uspeo = success;
    }

    public boolean isUspeo() {
        return uspeo;
    }

}
