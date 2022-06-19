package ServerskiOdgovori.OdgovoriBrisanje;

import java.io.Serializable;

public class ObrisiKozmeticaraOdgovor implements Serializable {

    private boolean uspeo;

    public ObrisiKozmeticaraOdgovor(boolean uspeo) {
        this.uspeo = uspeo;
    }

    public boolean isUspeo() {
        return uspeo;
    }

}
