package So;

import Domen.Kozmeticar;
import db.DBBroker;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SOAzurirajKozmeticara extends OpstaSistemskaOperacija {

    private Kozmeticar k;

    public SOAzurirajKozmeticara(Kozmeticar k) {
        this.k = k;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        try {
            String upit = "update Kozmeticar set ime=?, prezime=?, godine=? where KOzmeticarID=?";
            PreparedStatement ps = DBBroker.getInstance().getKonekcija().prepareStatement(upit);
            ps.setString(1, k.getIme());
            ps.setString(2, k.getPrezime());
            ps.setInt(3, k.getGodine());
            ps.setInt(4, k.getKozmeticarId());
            ps.executeUpdate();
            operacijaUspesnoIzvrsena = true;
        } catch (SQLException ex) {
            operacijaUspesnoIzvrsena = false;
            Logger.getLogger(SOAzurirajKozmeticara.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
