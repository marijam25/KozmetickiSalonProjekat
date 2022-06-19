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
    public List<String> naziviKolona() {
        ArrayList<String> naziviKol = new ArrayList<>();
        naziviKol.add("kozmeticarId");
        naziviKol.add("ime");
        naziviKol.add("prezime");
        naziviKol.add("godine");
        return naziviKol;

    }

    @Override
    public Map<String, String> naziviIVrednostiKolona() {
        HashMap<String, String> nazivIVrednostiKol = new HashMap<>();
        nazivIVrednostiKol.put("kozmeticarId", Integer.toString(kozmeticarId));
        nazivIVrednostiKol.put("ime", ime);
        nazivIVrednostiKol.put("prezime", prezime);
        nazivIVrednostiKol.put("godine", Integer.toString(godine));
        return nazivIVrednostiKol;
    }

    @Override
    public List<String> naziviKolonaPrimarnogKljuca() {
        ArrayList<String> naziviKolPrimKljuca = new ArrayList<>();
        naziviKolPrimKljuca.add("kozmeticarId");
        return naziviKolPrimKljuca;
    }

    @Override
    public Map<String, String> nazivIVrednostPrimarnogKljuca() {
        HashMap<String, String> mapa = new HashMap<>();
        mapa.put("kozmeticarId",Integer.toString(kozmeticarId));
        return mapa;
    }

    @Override
    public List<Kozmeticar> ucitajIzResultSeta(ResultSet rs) {
        ArrayList<Kozmeticar> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("KozmeticarID");
                String imeK = rs.getString("Ime");
                String prezimeK = rs.getString("Prezime");
                int godineK = rs.getInt("Godine");

                Kozmeticar k = new Kozmeticar(id, imeK, prezimeK, godineK);
                lista.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Kozmeticar.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return lista;
    }

}
