package Domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public List<String> naziviKolona() {
        ArrayList<String> naziviKol = new ArrayList<>();
        naziviKol.add("klijentId");
        naziviKol.add("ime");
        naziviKol.add("prezime");
        return naziviKol;
    }

    @Override
    public Map<String, String> naziviIVrednostiKolona() {
        HashMap<String, String> nazivIVrednostiKol = new HashMap<>();
        nazivIVrednostiKol.put("klijentId", Integer.toString(klijentId));
        nazivIVrednostiKol.put("ime", ime);
        nazivIVrednostiKol.put("prezime", prezime);
        return nazivIVrednostiKol;
    }

    @Override
    public List<String> naziviKolonaPrimarnogKljuca() {
        ArrayList<String> naziviKolPrimKljuca = new ArrayList<>();
        naziviKolPrimKljuca.add("klijentID");
        return naziviKolPrimKljuca;
    }

    @Override
    public Map<String, String> nazivIVrednostPrimarnogKljuca() {
        HashMap<String, String> mapa = new HashMap<>();
        mapa.put("klijentId",Integer.toString(klijentId));
        return mapa;
    }

    @Override
    public List<Klijent> ucitajIzResultSeta(ResultSet rs) {
        ArrayList<Klijent> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                int Id = rs.getInt("KlijentID");
                String imeK = rs.getString("Ime");
                String prezimeK = rs.getString("Prezime");

                Klijent k = new Klijent(Id, imeK, prezimeK);
                lista.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return lista;
    }

}
