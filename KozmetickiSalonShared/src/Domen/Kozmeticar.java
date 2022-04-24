package Domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

public class Kozmeticar implements Serializable, OpstiDomenskiObjekat {

    private int kozmeticarId;
    private String ime;
    private String prezime;
    private int godine;
    
    public Kozmeticar(){}
    
    public Kozmeticar(int kozmeticarId, String ime, String prezime, int godine) {
        this.kozmeticarId = kozmeticarId;
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
    }

    public int getKozmeticarId() {
        return kozmeticarId;
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

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        this.godine = godine;
    }

    @Override
    public String nazivTabele() {
        return "Kozmeticar";
    }

    @Override
    public ArrayList<String> naziviKolona() {
        ArrayList<String> naziviKol = new ArrayList<>();
        naziviKol.add("kozmeticarId");
        naziviKol.add("ime");
        naziviKol.add("prezime");
        naziviKol.add("godine");
        return naziviKol;

    }

    @Override
    public HashMap<String, String> naziviIVrednostiKolona() {
        HashMap<String, String> nazivIVrednostiKol = new HashMap<String, String>();
        nazivIVrednostiKol.put("kozmeticarId", Integer.toString(kozmeticarId));
        nazivIVrednostiKol.put("ime", ime);
        nazivIVrednostiKol.put("prezime", prezime);
        nazivIVrednostiKol.put("godine", Integer.toString(godine));
        return nazivIVrednostiKol;
    }

    @Override
    public String nazivPrimarnogKljuca() {
        return "kozmeticarId";
    }

    @Override
    public Pair<String, String> nazivIVrednostPrimarnogKljuca() {
        return new Pair<>("kozmeticarId", Integer.toString(kozmeticarId));
    }

    @Override
    public ArrayList<Kozmeticar> ucitajIzResultSeta(ResultSet rs) {
        ArrayList<Kozmeticar> lista = new ArrayList<Kozmeticar>();
        try {
            while (rs.next()) {
                int kozmeticarid = rs.getInt("KozmeticarID");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                int godine = rs.getInt("Godine");

                Kozmeticar k = new Kozmeticar(kozmeticarid, ime, prezime, godine);
                lista.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Kozmeticar.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return lista;
    }

}
