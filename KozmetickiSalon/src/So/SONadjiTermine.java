package So;

import Domen.Termin;
import db.DBBroker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

public class SONadjiTermine extends OpstaSistemskaOperacija {

    //private Date d;
    private Pair<String, String> uslov;
    private ArrayList<Termin> listaTermina;

    public SONadjiTermine(Pair<String, String> uslov) {
        this.uslov = uslov;
    }

    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        /*listaTermina = new ArrayList<>();
        try {
            String upit = "select * from Termin";
            if (d != null) {
                java.sql.Date sqlDate = new java.sql.Date(d.getTime());
                String datum1 = sqlDate.toString();
                upit += " where datumTermina = " + "'" + datum1 + "'";
            }
            Statement statement = DBBroker.getInstance().getKonekcija().createStatement();
            ResultSet rs = statement.executeQuery(upit);

            while (rs.next()) {
                int id = rs.getInt("TerminID");
                java.sql.Date sqlDate = rs.getDate("DatumTermina");
                java.sql.Time sqlTime = rs.getTime("VremeTermina");
                java.util.Date datum = new java.util.Date(sqlDate.getTime());
                Time vreme = new Time(sqlTime.getTime());
                Termin t = new Termin(id, datum, (Time) vreme);
                listaTermina.add(t);
            }
            rs.close();
            statement.close();
            operacijaUspesnoIzvrsena = true;
        } catch (SQLException ex) {
            operacijaUspesnoIzvrsena = false;
            Logger.getLogger(SOPretraziTermine.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        Termin odo = new Termin();
        String datumKorinsikUneoStrng = uslov.getValue();
        SimpleDateFormat formatKojiKorisnikUnosi = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat formatKojiBazaHoce = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date datum = formatKojiKorisnikUnosi.parse(datumKorinsikUneoStrng);
            String datumBazaHoceString = formatKojiBazaHoce.format(datum);
            uslov = new Pair<>(uslov.getKey(), datumBazaHoceString);
        } catch (ParseException ex) {
            Logger.getLogger(SONadjiTermine.class.getName()).log(Level.SEVERE, null, ex);
        }

        listaTermina = (ArrayList<Termin>) DBBroker.getInstance().pronadjiUBazi(odo, uslov);
    }

    public ArrayList<Termin> getListaTermina() {
        return listaTermina;
    }

}
