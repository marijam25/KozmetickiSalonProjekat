package KlijentskiZahtevi.ZahteviZaBrisanje;

import Domen.ZakazaniTermin;
import java.io.Serializable;

public class ObrisiZakazaniTerminZahtev implements Serializable {
    private ZakazaniTermin zakazaniTermin;

    public ObrisiZakazaniTerminZahtev(ZakazaniTermin zakazaniTermin) {
        this.zakazaniTermin = zakazaniTermin;
    }

    public ZakazaniTermin getZakazaniTermin() {
        return zakazaniTermin;
    }
}
