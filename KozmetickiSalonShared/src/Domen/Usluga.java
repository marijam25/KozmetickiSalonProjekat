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

public class Usluga implements Serializable, OpstiDomenskiObjekat {

    private int uslugaId;
    private String nazivUsluge;
    private int kategorijaId;

    public Usluga() {
    }

    public Usluga(int uslugaId, String nazivUsluge, int kategorijaId) {
        this.uslugaId = uslugaId;
        this.nazivUsluge = nazivUsluge;
        this.kategorijaId = kategorijaId;
    }

    public int getUslugaId() {
        return uslugaId;
    }

    public String getNazivUsluge() {
        return nazivUsluge;
    }

    public int getKategorijaId() {
        return kategorijaId;
    }

    @Override
    public String toString() {
        return nazivUsluge;
    }

    @Override
    public String nazivTabele() {
        return "usluga";
    }

    @Override
    public List<String> naziviKolona() {
        ArrayList<String> naziviKol = new ArrayList<>();
        naziviKol.add("uslugaId");
        naziviKol.add("nazivUsluge");
        naziviKol.add("kategorijaId");
        return naziviKol;
    }

    @Override
    public Map<String, String> naziviIVrednostiKolona() {
        HashMap<String, String> nazivIVrednostiKol = new HashMap<>();
        nazivIVrednostiKol.put("uslugaId", Integer.toString(uslugaId));
        nazivIVrednostiKol.put("nazivUsluge", nazivUsluge);
        nazivIVrednostiKol.put("kategorijaId", Integer.toString(kategorijaId));
        return nazivIVrednostiKol;
    }

    @Override
    public List<String> naziviKolonaPrimarnogKljuca() {
        ArrayList<String> naziviKol = new ArrayList<>();
        naziviKol.add("uslugaId");
        return naziviKol;
    }

    @Override
    public Map<String, String> nazivIVrednostPrimarnogKljuca() {
        HashMap<String, String> mapa = new HashMap<>();
        mapa.put("uslugaId",Integer.toString(uslugaId));
        return mapa;
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajIzResultSeta(ResultSet rs) {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("UslugaID");
                String naziv = rs.getString("NazivUsluge");
                int katId = rs.getInt("KategorijaId");

                Usluga u = new Usluga(id, naziv, katId);
                lista.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usluga.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return lista;
    }

}
