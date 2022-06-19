package ServerskiOdgovori.OdgovoriAzuriranje;

import java.io.Serializable;

public class AzurirajKozmeticaraOdgovor implements Serializable {

    private boolean uspeo;

    public AzurirajKozmeticaraOdgovor(boolean uspeo) {
        this.uspeo = uspeo;
    }

    public boolean isUspeo() {
        return uspeo;
    }
}
