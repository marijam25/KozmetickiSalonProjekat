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
        listaKategorijaUsluga = new ArrayList<>();
        try {
            String upit = "select * from KategorijaUsluga";

            Statement statement = DBBroker.getInstance().getKonekcija().createStatement();
            ResultSet rs = statement.executeQuery(upit);

            while (rs.next()) {
                int id = rs.getInt("KategorijaID");
                String naziv = rs.getString("NazivKategorije");

                KategorijaUsluga ku = new KategorijaUsluga(id, naziv);
                listaKategorijaUsluga.add(ku);
            }
            rs.close();
            statement.close();
            operacijaUspesnoIzvrsena = true;

        } catch (SQLException ex) {
            operacijaUspesnoIzvrsena = false;
            Logger.getLogger(SOVratiSveKategorijeUsluga.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<KategorijaUsluga> getListaKategorijaUsluga() {
        return listaKategorijaUsluga;
    }

}
