package So;

import Domen.Kozmeticar;
import db.DBBroker;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SOObrisiKozmeticara extends OpstaSistemskaOperacija {

    private Kozmeticar k;

    public SOObrisiKozmeticara(Kozmeticar k) {
        this.k = k;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        try {
            String upit = "delete from Kozmeticar where KozmeticarID= " + k.getKozmeticarId();
            Statement statement = DBBroker.getInstance().getKonekcija().createStatement();
            statement.executeUpdate(upit);
            operacijaUspesnoIzvrsena = true;
        } catch (SQLException ex) {
            operacijaUspesnoIzvrsena = false;
            Logger.getLogger(SOObrisiKozmeticara.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
