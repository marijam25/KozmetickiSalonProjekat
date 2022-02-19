package So;

import Domen.Kozmeticar;
import db.DBBroker;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SODodajNovogKozmeticara extends OpstaSistemskaOperacija {

    private Kozmeticar k;

    public SODodajNovogKozmeticara(Kozmeticar k) {
        this.k = k;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        try {
            String upit = "insert into Kozmeticar(ime, prezime, godine) values (?, ?, ?)";
            PreparedStatement ps = DBBroker.getInstance().getKonekcija().prepareStatement(upit);
            ps.setString(1, k.getIme());
            ps.setString(2, k.getPrezime());
            ps.setInt(3, k.getGodine());
            ps.executeUpdate();
            operacijaUspesnoIzvrsena = true;
        } catch (SQLException ex) {
            operacijaUspesnoIzvrsena = false;
            Logger.getLogger(SODodajNovogKozmeticara.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
