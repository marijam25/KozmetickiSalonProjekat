package So;

import Domen.Usluga;
import db.DBBroker;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SOObrisiUslugu extends OpstaSistemskaOperacija {

    private Usluga u;

    public SOObrisiUslugu(Usluga u) {
        this.u = u;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        try {
            String upit = "delete from Usluga where UslugaID= " + u.getUslugaId();
            Statement statement = DBBroker.getInstance().getKonekcija().createStatement();
            statement.executeUpdate(upit);
            operacijaUspesnoIzvrsena = true;
        } catch (SQLException ex) {
            operacijaUspesnoIzvrsena = false;
            Logger.getLogger(SOObrisiUslugu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
