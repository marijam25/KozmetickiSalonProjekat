package So;

import Domen.Kozmeticar;
import db.DBBroker;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
