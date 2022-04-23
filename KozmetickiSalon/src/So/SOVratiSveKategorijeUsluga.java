package So;

import Domen.KategorijaUsluga;
import db.DBBroker;
import java.util.ArrayList;


public class SOVratiSveKategorijeUsluga extends OpstaSistemskaOperacija {

    private ArrayList<KategorijaUsluga> listaKategorijaUsluga;

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        KategorijaUsluga odo = new KategorijaUsluga();
        listaKategorijaUsluga = (ArrayList<KategorijaUsluga>) DBBroker.getInstance().pronadjiUBazi(odo);
    }

    public ArrayList<KategorijaUsluga> getListaKategorijaUsluga() {
        return listaKategorijaUsluga;
    }

}
