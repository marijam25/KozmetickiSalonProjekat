package So.Dohvatanje;

import Domen.KategorijaUsluga;
import Domen.OpstiDomenskiObjekat;
import So.OpstaSistemskaOperacija;
import db.DBBroker;
import java.util.ArrayList;
import java.util.List;


public class SODohvatiKategorijeUsluga extends OpstaSistemskaOperacija {

    private List<OpstiDomenskiObjekat> listaKategorijaUsluga;

    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo)  {
        
        listaKategorijaUsluga =  DBBroker.getInstance().dohvatiSveIzBaze(odo);
        
         if(listaKategorijaUsluga==null)
            return false;
         else
            return true;
    }

    public List<KategorijaUsluga> getListaKategorijaUsluga() {
        List<KategorijaUsluga> listaKategorijaUslugaKastovana = new ArrayList<>();
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaKategorijaUsluga) {
            listaKategorijaUslugaKastovana.add((KategorijaUsluga)opstiDomenskiObjekat);
        }
        return listaKategorijaUslugaKastovana;
    }

}
