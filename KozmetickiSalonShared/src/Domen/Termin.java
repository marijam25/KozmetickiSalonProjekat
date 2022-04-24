package Domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

public class Termin implements Serializable, OpstiDomenskiObjekat {

    private int terminId;
    private Date datumTermina;
    private Time vremeTermina;

    public Termin() {
    }

    public Termin(int terminId, Date datumTermina, Time vremeTermina) {
        this.terminId = terminId;
        this.datumTermina = datumTermina;
        this.vremeTermina = vremeTermina;
    }

    public int getTerminId() {
        return terminId;
    }

    public Date getDatumTermina() {
        return datumTermina;
    }

    public Time getVremeTermina() {
        return vremeTermina;
    }

    @Override
    public String toString() {
        return "Termin{" + "terminId=" + terminId + ", datumTermina=" + datumTermina + ", vremeTermina=" + vremeTermina + '}';
    }
    
    @Override
    public String nazivTabele() {
        return "termin";
    }

    @Override
    public ArrayList<String> naziviKolona() {
        ArrayList<String> naziviKol = new ArrayList<>();
        naziviKol.add("terminId");
        naziviKol.add("datumTermina");
        naziviKol.add("vremeTermina");
        return naziviKol;
    }

    @Override
    public HashMap<String, String> naziviIVrednostiKolona() {
        SimpleDateFormat formatZaDatum = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatZaVreme = new SimpleDateFormat("HH:mm");
        String datum = formatZaDatum.format(datumTermina);
        String vreme = formatZaVreme.format(vremeTermina);
        HashMap<String, String> nazivIVrednostiKol = new HashMap<String, String>();
        nazivIVrednostiKol.put("terminId", Integer.toString(terminId));
        nazivIVrednostiKol.put("datumTermina",datum);
        nazivIVrednostiKol.put("vremeTermina",vreme);
        return nazivIVrednostiKol;
    }

    @Override
    public String nazivPrimarnogKljuca() {
        return "terminId";
    }

    @Override
    public Pair<String, String> nazivIVrednostPrimarnogKljuca() {
        return new Pair<>("terminId", Integer.toString(terminId));
    }

    @Override
    public ArrayList<Termin> ucitajIzResultSeta(ResultSet rs) {
        ArrayList<Termin> lista = new ArrayList<Termin>();
        try {
            while (rs.next()) {
                int Id = rs.getInt("terminId");
                Date dat = rs.getDate("datumTermina");
                Time vreme = rs.getTime("vremeTermina");

                Termin t = new Termin(Id,dat,vreme);
                lista.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Termin.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return lista;
    }

}
