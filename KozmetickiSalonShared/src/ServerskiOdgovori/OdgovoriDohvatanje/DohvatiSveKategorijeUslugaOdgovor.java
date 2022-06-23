package ServerskiOdgovori.OdgovoriDohvatanje;

import Domen.KategorijaUsluga;
import java.io.Serializable;
import java.util.List;

public class DohvatiSveKategorijeUslugaOdgovor implements Serializable {

    private List<KategorijaUsluga> listaKategorijaUsluga;

    public DohvatiSveKategorijeUslugaOdgovor(List<KategorijaUsluga> listaKategorijaUsluga) {
        this.listaKategorijaUsluga = listaKategorijaUsluga;
    }

    public List<KategorijaUsluga> getListaKategorijaUsluga() {
        return listaKategorijaUsluga;
    }

}
