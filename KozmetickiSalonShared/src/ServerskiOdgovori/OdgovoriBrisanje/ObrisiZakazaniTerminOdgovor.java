package ServerskiOdgovori.OdgovoriBrisanje;

import java.io.Serializable;

public class ObrisiZakazaniTerminOdgovor implements Serializable {

    private boolean uspeo;

    public ObrisiZakazaniTerminOdgovor(boolean uspeo) {
        this.uspeo = uspeo;
    }

    public boolean isUspeo() {
        return uspeo;
    }

}
