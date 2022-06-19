package KlijentskiZahtevi.ZahteviZaDohvatanje;

import Domen.StavkaZakazanogTermina;

import java.io.Serializable;

public class DohvatiStavkeZaZakazaniTerminZahtev implements Serializable {
    private StavkaZakazanogTermina stavkaZakazanogTermina;

    public DohvatiStavkeZaZakazaniTerminZahtev(StavkaZakazanogTermina stavkaZakazanogTermina) {
        this.stavkaZakazanogTermina = stavkaZakazanogTermina;
    }

    public StavkaZakazanogTermina getStavkaZakazanogTermina() {
        return stavkaZakazanogTermina;
    }
}
