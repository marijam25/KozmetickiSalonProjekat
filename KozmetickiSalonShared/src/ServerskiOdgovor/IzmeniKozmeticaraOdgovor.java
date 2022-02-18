package ServerskiOdgovor;

import java.io.Serializable;

public class IzmeniKozmeticaraOdgovor implements Serializable {

    private boolean uspeo;

    public IzmeniKozmeticaraOdgovor(boolean success) {
        this.uspeo = success;
    }

    public boolean isUspeo() {
        return uspeo;
    }
}
