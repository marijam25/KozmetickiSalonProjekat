package KlijentskiZahtevi.ZahteviZaAzuriranje;

import Domen.ZakazaniTermin;
import java.io.Serializable;

public class AzurirajZakazaniTerminZahtev implements Serializable {
    private ZakazaniTermin zakazaniTermin;

    public AzurirajZakazaniTerminZahtev(ZakazaniTermin zakazaniTermin) {
        this.zakazaniTermin = zakazaniTermin;
    }

    public ZakazaniTermin getZakazaniTermin() {
        return zakazaniTermin;
    }
}
