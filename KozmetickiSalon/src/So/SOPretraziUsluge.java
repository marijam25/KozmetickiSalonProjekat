package So;

import Domen.Usluga;
import db.DBBroker;
import java.util.ArrayList;
import javafx.util.Pair;

public class SOPretraziUsluge extends OpstaSistemskaOperacija {

    private Pair<String, String> uslov;
    private ArrayList<Usluga> listaUsluga;

    public SOPretraziUsluge(Pair<String, String> uslov) {
        this.uslov = uslov;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        Usluga odo = new Usluga();
        listaUsluga = (ArrayList<Usluga>) DBBroker.getInstance().pronadjiUBazi(odo, uslov);
    }

    public ArrayList<Usluga> getListaUsluga() {
        return listaUsluga;
    }

}
