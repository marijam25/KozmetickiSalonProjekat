package ServerskiOdgovor.kozmeticar;

import Domen.Kozmeticar;
import java.io.Serializable;
import java.util.ArrayList;

public class VratiKozmeticareOdgovor implements Serializable {

    private ArrayList<Kozmeticar> listaKozmeticara;

    public VratiKozmeticareOdgovor(ArrayList<Kozmeticar> listaKozmeticara) {
        this.listaKozmeticara = listaKozmeticara;
    }

    public ArrayList<Kozmeticar> getListaKozmeticara() {
        return listaKozmeticara;
    }

}
