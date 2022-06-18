package ServerskiOdgovor.kozmeticar;

import java.io.Serializable;

public class DodajNovogKozmeticaraOdgovor implements Serializable {

    private boolean uspeo;

    public DodajNovogKozmeticaraOdgovor(boolean success) {
        this.uspeo = success;
    }

    public boolean isUspeo() {
        return uspeo;
    }
}
