package So.Dohvatanje;

import Domen.Kozmeticar;
import Domen.OpstiDomenskiObjekat;
import So.OpstaSistemskaOperacija;
import db.DBBroker;
import java.util.ArrayList;
import java.util.List;

public class SODohvatiSveKozmeticare extends OpstaSistemskaOperacija {

    private List<OpstiDomenskiObjekat> listaKozmeticara;
    
    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        
        listaKozmeticara = DBBroker.getInstance().dohvatiSveIzBaze(odo);
        
        if(listaKozmeticara==null)
            return false;
        else
            return true;
    }

    public List<Kozmeticar> getListaKozmeticara() {
        List<Kozmeticar> listaKozmeticaraKastovana = new ArrayList<>();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaKozmeticara) {
            listaKozmeticaraKastovana.add((Kozmeticar)opstiDomenskiObjekat);
        }
        return listaKozmeticaraKastovana;
    }
    
}
