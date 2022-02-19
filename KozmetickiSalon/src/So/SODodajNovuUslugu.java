package So;

import Domen.Usluga;
import db.DBBroker;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SODodajNovuUslugu extends OpstaSistemskaOperacija {

    private Usluga u;

    public SODodajNovuUslugu(Usluga u) {
        this.u = u;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        try {
            String upit = "insert into Usluga(nazivUsluge, kategorijaId) values (?, ?)";
            PreparedStatement ps = DBBroker.getInstance().getKonekcija().prepareStatement(upit);
            ps.setString(1, u.getNazivUsluge());
            ps.setInt(2, u.getKategorijaId());
            ps.executeUpdate();
            operacijaUspesnoIzvrsena = true;
        } catch (SQLException ex) {
            operacijaUspesnoIzvrsena = false;
            Logger.getLogger(SODodajNovuUslugu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
