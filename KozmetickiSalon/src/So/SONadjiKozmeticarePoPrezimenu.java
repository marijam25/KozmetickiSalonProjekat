package So;

import Domen.Kozmeticar;
import Domen.OpstiDomenskiObjekat;
import db.DBBroker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javafx.util.Pair;

public class SONadjiKozmeticarePoPrezimenu extends OpstaSistemskaOperacija {

    private ArrayList<Kozmeticar> listaKozmeticara;

    public SONadjiKozmeticarePoPrezimenu() {
        
    }

    

    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        Set<String> koloneZaPretrazivanje = new HashSet<>();
        koloneZaPretrazivanje.add("prezime");
        listaKozmeticara = (ArrayList<Kozmeticar>)DBBroker.getInstance().pronadjiUBazi(odo, koloneZaPretrazivanje);
        if(listaKozmeticara!=null)
            return true;
        else
            return false;
    }

    public ArrayList<Kozmeticar> getListaKozmeticara() {
        return listaKozmeticara;
    }

}
