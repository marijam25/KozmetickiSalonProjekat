package Domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

public class Klijent implements Serializable, OpstiDomenskiObjekat {

    private int klijentId;
    private String ime;
    private String prezime;

    public Klijent() {
    }

    public Klijent(int klijentId, String ime, String prezime) {
        this.klijentId = klijentId;
        this.ime = ime;
        this.prezime = prezime;
    }

    public int getKlijentId() {
        return klijentId;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String nazivTabele() {
        return "Klijent";
    }

    @Override
    public ArrayList<String> naziviKolona() {
        ArrayList<String> naziviKol = new ArrayList<>();
        naziviKol.add("klijentId");
        naziviKol.add("ime");
        naziviKol.add("prezime");
        return naziviKol;
    }

    @Override
    public HashMap<String, String> naziviIVrednostiKolona() {
        HashMap<String, String> nazivIVrednostiKol = new HashMap<String, String>();
        nazivIVrednostiKol.put("klijentId", Integer.toString(klijentId));
        nazivIVrednostiKol.put("ime", ime);
        nazivIVrednostiKol.put("prezime", prezime);
        return nazivIVrednostiKol;
    }

    @Override
    public String nazivPrimarnogKljuca() {
        return "klijentId";
    }

    @Override
    public Pair<String, String> nazivIVrednostPrimarnogKljuca() {
        return new Pair<>("klijentId", Integer.toString(klijentId));
    }

    @Override
    public ArrayList<Klijent> ucitajIzResultSeta(ResultSet rs) {
        ArrayList<Klijent> lista = new ArrayList<Klijent>();
        try {
            while (rs.next()) {
                int id = rs.getInt("KlijentID");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");

                Klijent k = new Klijent(klijentId, ime, prezime);
                lista.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return lista;
    }

}
