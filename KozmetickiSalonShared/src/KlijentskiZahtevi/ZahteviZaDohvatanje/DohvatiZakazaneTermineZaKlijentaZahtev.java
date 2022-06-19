package KlijentskiZahtevi.ZahteviZaDohvatanje;

import Domen.ZakazaniTermin;
import java.io.Serializable;

public class DohvatiZakazaneTermineZaKlijentaZahtev implements Serializable {
    private ZakazaniTermin zakazaniTermin;

    public DohvatiZakazaneTermineZaKlijentaZahtev(ZakazaniTermin zakazaniTermin) {
        this.zakazaniTermin = zakazaniTermin;
    }

    public ZakazaniTermin getZakazaniTermin() {
        return zakazaniTermin;
    }
}
