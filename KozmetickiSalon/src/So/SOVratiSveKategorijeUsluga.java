package So;

import Domen.KategorijaUsluga;
import db.DBBroker;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
