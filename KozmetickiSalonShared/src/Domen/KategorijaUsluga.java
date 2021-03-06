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
        return "kategorijaUsluga";
    }

    @Override
    public List<String> naziviKolona() {
        ArrayList<String> naziviKol = new ArrayList<>();
        naziviKol.add("kategorijaId");
        naziviKol.add("nazivKategorije");
        return naziviKol;
    }

    @Override
    public Map<String, String> naziviIVrednostiKolona() {
        HashMap<String, String> nazivIVrednostiKol = new HashMap<>();
        nazivIVrednostiKol.put("kategorijaId", Integer.toString(kategorijaId));
        nazivIVrednostiKol.put("nazivKategorije", nazivKategorije);
        return nazivIVrednostiKol;
    }

    @Override
    public List<String> naziviKolonaPrimarnogKljuca() {
        ArrayList<String> naziviKolPrimKljuca = new ArrayList<>();
        naziviKolPrimKljuca.add("kategorijaId");
        return naziviKolPrimKljuca;
    }

    @Override
    public Map<String, String> nazivIVrednostPrimarnogKljuca() {
        HashMap<String, String> mapa = new HashMap<>();
        mapa.put("kategorijaId",Integer.toString(kategorijaId));
        return mapa;
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajIzResultSeta(ResultSet rs) {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("KategorijaID");
                String naziv = rs.getString("NazivKategorije");
                
                KategorijaUsluga k = new KategorijaUsluga(id, naziv);
                lista.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KategorijaUsluga.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return lista;
    }

}
