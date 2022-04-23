package So;

import Domen.Usluga;
import db.DBBroker;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
