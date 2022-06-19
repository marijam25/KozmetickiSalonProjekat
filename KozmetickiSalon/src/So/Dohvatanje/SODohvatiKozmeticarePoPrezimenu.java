package So.Dohvatanje;

import Domen.Kozmeticar;
import Domen.OpstiDomenskiObjekat;
import So.OpstaSistemskaOperacija;
import db.DBBroker;
import java.util.ArrayList;
import java.util.List;

public class SODohvatiKozmeticarePoPrezimenu extends OpstaSistemskaOperacija {
    private ArrayList<Kozmeticar> listaKozmeticara;

    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        List<String> koloneZaUslov = new ArrayList<>();
        koloneZaUslov.add("prezime");

        listaKozmeticara = (ArrayList<Kozmeticar>)DBBroker.getInstance().dohvatiIzBaze(odo, koloneZaUslov);
        if(listaKozmeticara!=null)
            return true;
        else
            return false;
    }

    public List<Kozmeticar> getListaKozmeticara() {
        return listaKozmeticara;
    }
}
