package So;

import Domen.Kozmeticar;
import db.DBBroker;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SOPretraziKozmeticare extends OpstaSistemskaOperacija {

    private String uslov;
    private ArrayList<Kozmeticar> listaKozmeticara;

    public SOPretraziKozmeticare(String uslov) {
        this.uslov = uslov;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        listaKozmeticara = new ArrayList<>();
        try {
            String upit = "select * from Kozmeticar";
            if (!uslov.isEmpty()) {
                upit += " where prezime like '" + uslov + "%'";
            }
            Statement statement = DBBroker.getInstance().getKonekcija().createStatement();
            ResultSet rs = statement.executeQuery(upit);

            while (rs.next()) {
                int id = rs.getInt("KozmeticarID");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                int godine = rs.getInt("Godine");
                Kozmeticar k = new Kozmeticar(id, ime, prezime, godine);
                listaKozmeticara.add(k);
            }
            rs.close();
            statement.close();
            operacijaUspesnoIzvrsena = true;

        } catch (SQLException ex) {
            operacijaUspesnoIzvrsena = false;
            Logger.getLogger(SOPretraziKozmeticare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Kozmeticar> getListaKozmeticara() {
        return listaKozmeticara;
    }

}
