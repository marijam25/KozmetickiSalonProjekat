package ServerskiOdgovor.usluga;

import Domen.Usluga;
import java.io.Serializable;
import java.util.ArrayList;

public class PretraziUslugeOdgovor implements Serializable {

    private ArrayList<Usluga> nizUsluga;

    public PretraziUslugeOdgovor(ArrayList<Usluga> nizUsluga) {
        this.nizUsluga = nizUsluga;
    }

    public ArrayList<Usluga> getNizUsluga() {
        return nizUsluga;
    }
}
