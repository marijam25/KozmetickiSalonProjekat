package ServerskiOdgovor.kozmeticar;

import java.io.Serializable;

public class ObrisiKozmeticaraOdgovor implements Serializable {

    private boolean uspeo;

    public ObrisiKozmeticaraOdgovor(boolean success) {
        this.uspeo = success;
    }

    public boolean isUspeo() {
        return uspeo;
    }

}
