package ServerskiOdgovor.kategorijaUsluga;

import Domen.KategorijaUsluga;
import java.io.Serializable;
import java.util.ArrayList;

public class VratiSveKategorijeUslugaOdgovor implements Serializable {

    ArrayList<KategorijaUsluga> listaKategorijaUsluga;

    public VratiSveKategorijeUslugaOdgovor(ArrayList<KategorijaUsluga> listaKategorijaUsluga) {
        this.listaKategorijaUsluga = listaKategorijaUsluga;
    }

    public ArrayList<KategorijaUsluga> getListaKategorijaUsluga() {
        return listaKategorijaUsluga;
    }

}
