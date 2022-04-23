package Domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

public class KategorijaUsluga implements Serializable, OpstiDomenskiObjekat {

    private int kategorijaId;
    private String nazivKategorije;

    public KategorijaUsluga() {
    }

    public KategorijaUsluga(int kategorijaId, String nazivKategorije) {
        this.kategorijaId = kategorijaId;
        this.nazivKategorije = nazivKategorije;
    }

    public int getKategorijaId() {
        return kategorijaId;
    }

    public String getNazivKategorije() {
        return nazivKategorije;
    }

    @Override
    public String toString() {
        return nazivKategorije;
    }

    @Override
    public String nazivTabele() {
        return "usluga";
    }

    @Override
    public ArrayList<String> naziviKolona() {
        ArrayList<String> naziviKol = new ArrayList<>();
        naziviKol.add("kategorijaId");
        naziviKol.add("nazivKategorije");
        return naziviKol;
    }

    @Override
    public HashMap<String, String> naziviIVrednostiKolona() {
        HashMap<String, String> nazivIVrednostiKol = new HashMap<String, String>();
        nazivIVrednostiKol.put("kategorijaId", Integer.toString(kategorijaId));
        nazivIVrednostiKol.put("nazivKategorije", nazivKategorije);
        return nazivIVrednostiKol;
    }

    @Override
    public String nazivPrimarnogKljuca() {
        return "kategorijaId";
    }

    @Override
    public Pair<String, String> nazivIVrednostPrimarnogKljuca() {
        return new Pair<>("kategorijaId", Integer.toString(kategorijaId));
    }

    @Override
    public ArrayList<KategorijaUsluga> ucitajIzResultSeta(ResultSet rs) {
        ArrayList<KategorijaUsluga> lista = new ArrayList<KategorijaUsluga>();
        try {
            while (rs.next()) {
                int id = rs.getInt("KategorijaID");
                String ime = rs.getString("nazivKategorije");
                
                KategorijaUsluga k = new KategorijaUsluga(kategorijaId, nazivKategorije);
                lista.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KategorijaUsluga.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return lista;
    }

}
