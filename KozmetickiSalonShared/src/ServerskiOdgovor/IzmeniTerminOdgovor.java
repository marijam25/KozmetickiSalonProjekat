package ServerskiOdgovor;

import java.io.Serializable;

public class IzmeniTerminOdgovor implements Serializable {

    private boolean uspeo;

    public IzmeniTerminOdgovor(boolean success) {
        this.uspeo = success;
    }

    public boolean isUspeo() {
        return uspeo;
    }
}
