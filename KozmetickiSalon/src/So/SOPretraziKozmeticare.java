package So;

import Domen.Kozmeticar;
import db.DBBroker;
import java.util.ArrayList;
import javafx.util.Pair;

public class SOPretraziKozmeticare extends OpstaSistemskaOperacija {

    private Pair<String, String> uslov;
    private ArrayList<Kozmeticar> listaKozmeticara;

    public SOPretraziKozmeticare(Pair<String, String> uslov) {
        this.uslov = uslov;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        Kozmeticar odo = new Kozmeticar();
        listaKozmeticara = (ArrayList<Kozmeticar>)DBBroker.getInstance().pronadjiUBazi(odo, uslov);
    }

    public ArrayList<Kozmeticar> getListaKozmeticara() {
        return listaKozmeticara;
    }

}
