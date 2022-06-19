package ServerskiOdgovori.OdgovoriDohvatanje;

import Domen.StavkaZakazanogTermina;

import java.io.Serializable;
import java.util.List;

public class DohvatiStavkeZaZakazniTerminOdgovor implements Serializable {
    private List<StavkaZakazanogTermina> stavkeZakazanogTermina;

    public DohvatiStavkeZaZakazniTerminOdgovor(List<StavkaZakazanogTermina> stavkeZakazanogTermina) {
        this.stavkeZakazanogTermina = stavkeZakazanogTermina;
    }

    public List<StavkaZakazanogTermina> getStavkeZakazanogTermina() {
        return stavkeZakazanogTermina;
    }
}
