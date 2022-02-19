package So;

import Domen.Klijent;
import db.DBBroker;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SOVratiSveKlijente extends OpstaSistemskaOperacija {

    private ArrayList<Klijent> listaKlijenata;

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        listaKlijenata = new ArrayList<>();
        try {
            String upit = "select * from Klijent";

            Statement statement = DBBroker.getInstance().getKonekcija().createStatement();
            ResultSet rs = statement.executeQuery(upit);

            while (rs.next()) {
                int id = rs.getInt("KlijentID");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                Klijent k = new Klijent(id, ime, prezime);
                listaKlijenata.add(k);
            }
            rs.close();
            statement.close();
            operacijaUspesnoIzvrsena = true;
        } catch (SQLException ex) {
            operacijaUspesnoIzvrsena = false;
            Logger.getLogger(SOVratiSveKlijente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Klijent> getListaKlijenata() {
        return listaKlijenata;
    }

}
