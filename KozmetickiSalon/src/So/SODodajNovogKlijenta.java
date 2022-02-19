package So;

import Domen.Klijent;
import db.DBBroker;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SODodajNovogKlijenta extends OpstaSistemskaOperacija {

    private Klijent k;

    public SODodajNovogKlijenta(Klijent k) {
        this.k = k;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {

        try {
            String upit = "insert into Klijent(ime, prezime) values (?, ?)";
            PreparedStatement ps = DBBroker.getInstance().getKonekcija().prepareStatement(upit);
            ps.setString(1, k.getIme());
            ps.setString(2, k.getPrezime());
            ps.executeUpdate();
            operacijaUspesnoIzvrsena = true;
        } catch (SQLException ex) {
            operacijaUspesnoIzvrsena = false;
            Logger.getLogger(SODodajNovogKlijenta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
