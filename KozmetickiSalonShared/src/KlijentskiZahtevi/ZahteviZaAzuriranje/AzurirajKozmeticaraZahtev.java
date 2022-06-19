package KlijentskiZahtevi.ZahteviZaAzuriranje;

import Domen.Kozmeticar;
import java.io.Serializable;

public class AzurirajKozmeticaraZahtev implements Serializable {
    private Kozmeticar kozmeticar;

    public AzurirajKozmeticaraZahtev(Kozmeticar kozmeticar) {
        this.kozmeticar = kozmeticar;
    }

    public Kozmeticar getKozmeticar() {
        return kozmeticar;
    }
}
