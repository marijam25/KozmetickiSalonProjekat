package So;

import Domen.KategorijaUsluga;
import Domen.OpstiDomenskiObjekat;
import db.DBBroker;
import java.util.ArrayList;


public class SOUcitajListuKategorijaUsluga extends OpstaSistemskaOperacija {

    private ArrayList<KategorijaUsluga> listaKategorijaUsluga;

    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo)  {
        
        listaKategorijaUsluga = (ArrayList<KategorijaUsluga>) DBBroker.getInstance().pronadjiUBazi(odo,null);
        
         if(listaKategorijaUsluga==null)
            return false;
        else
            return true;
    }

    public ArrayList<KategorijaUsluga> getListaKategorijaUsluga() {
        return listaKategorijaUsluga;
    }

}
