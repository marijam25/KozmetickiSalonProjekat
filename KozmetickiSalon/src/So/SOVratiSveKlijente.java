package So;

import Domen.Klijent;
import db.DBBroker;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SOVratiSveKlijente extends OpstaSistemskaOperacija {

    private ArrayList<Klijent> listaKlijenata;

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        Klijent odo = new Klijent();
        listaKlijenata = (ArrayList<Klijent>) DBBroker.getInstance().pronadjiUBazi(odo);
    }

    public ArrayList<Klijent> getListaKlijenata() {
        return listaKlijenata;
    }

}
