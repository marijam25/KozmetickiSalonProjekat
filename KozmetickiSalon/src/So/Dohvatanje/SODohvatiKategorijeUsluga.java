package So.Dohvatanje;

import Domen.KategorijaUsluga;
import Domen.OpstiDomenskiObjekat;
import So.OpstaSistemskaOperacija;
import db.DBBroker;
import java.util.ArrayList;
import java.util.List;


public class SODohvatiKategorijeUsluga extends OpstaSistemskaOperacija {

    private ArrayList<KategorijaUsluga> listaKategorijaUsluga;

    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo)  {
        
        listaKategorijaUsluga = (ArrayList<KategorijaUsluga>) DBBroker.getInstance().dohvatiSveIzBaze(odo);
        
         if(listaKategorijaUsluga==null)
            return false;
         else
            return true;
    }

    public List<KategorijaUsluga> getListaKategorijaUsluga() {
        return listaKategorijaUsluga;
    }

}
