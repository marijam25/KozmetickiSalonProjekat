package ServerskiOdgovori.OdgovoriDohvatanje;

import Domen.ZakazaniTermin;
import java.io.Serializable;
import java.util.List;

public class DohvatiZakazaneTermineZaKlijentaOdgovor implements Serializable {

    private List<ZakazaniTermin> listaZakazanihTermina;

    public DohvatiZakazaneTermineZaKlijentaOdgovor(List<ZakazaniTermin> listaZakazanihTermina) {
        this.listaZakazanihTermina = listaZakazanihTermina;
    }

    public List<ZakazaniTermin> getListaZakazanihTermina() {
        return listaZakazanihTermina;
    }

}
