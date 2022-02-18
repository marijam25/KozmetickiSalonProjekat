package ServerskiOdgovor;

import java.io.Serializable;

public class PrijavljivanjeOdgovor implements Serializable {

    private boolean uspesno;

    public PrijavljivanjeOdgovor(boolean uspesno) {
        this.uspesno = uspesno;
    }

    public boolean isUspesno() {
        return uspesno;
    }

}
