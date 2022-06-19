package ServerskiOdgovori.OdgovoriAzuriranje;

import java.io.Serializable;

public class AzurirajZakazaniTerminOdgovor implements Serializable {
    private boolean uspeo;

    public AzurirajZakazaniTerminOdgovor(boolean uspeo) {
        this.uspeo = uspeo;
    }

    public boolean isUspeo() {
        return uspeo;
    }
}
