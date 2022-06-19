package So.Dohvatanje;

import Domen.OpstiDomenskiObjekat;
import Domen.Usluga;
import So.OpstaSistemskaOperacija;
import db.DBBroker;
import java.util.ArrayList;
import java.util.List;

public class SODohvatiSveUsluge extends OpstaSistemskaOperacija {

    private ArrayList<Usluga> listaUsluga;
    
    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
   public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        
        listaUsluga = (ArrayList<Usluga>) DBBroker.getInstance().dohvatiSveIzBaze(odo);
        
        if(listaUsluga==null)
            return false;
        else
            return true;
    }

    public List<Usluga> getListaUsluga() {
        return listaUsluga;
    }
}
