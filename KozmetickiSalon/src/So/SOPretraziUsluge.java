package So;

import Domen.Usluga;
import db.DBBroker;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SOPretraziUsluge extends OpstaSistemskaOperacija {

    private String uslov;
    private ArrayList<Usluga> listaUsluga;

    public SOPretraziUsluge(String uslov) {
        this.uslov = uslov;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        listaUsluga = new ArrayList<>();
        try {
            String upit = "select * from Usluga";
            if (!uslov.isEmpty()) {
                upit += " where NazivUsluge like '" + uslov + "%'";
            }
            Statement statement = DBBroker.getInstance().getKonekcija().createStatement();
            ResultSet rs = statement.executeQuery(upit);

            while (rs.next()) {
                int id = rs.getInt("UslugaID");
                String ime = rs.getString("NazivUsluge");
                int idKategorije = rs.getInt("KategorijaID");
                Usluga u = new Usluga(id, ime, idKategorije);
                listaUsluga.add(u);
            }
            rs.close();
            statement.close();
            operacijaUspesnoIzvrsena = true;

        } catch (SQLException ex) {
            operacijaUspesnoIzvrsena = false;
            Logger.getLogger(SOPretraziUsluge.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Usluga> getListaUsluga() {
        return listaUsluga;
    }

}
