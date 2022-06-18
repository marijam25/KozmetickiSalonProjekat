package Domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

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
    public ArrayList<String> naziviKolona() {
        ArrayList<String> naziviKol = new ArrayList<>();
        naziviKol.add("uslugaId");
        naziviKol.add("nazivUsluge");
        naziviKol.add("kategorijaId");
        return naziviKol;
    }

    @Override
    public HashMap<String, String> naziviIVrednostiKolona() {
        HashMap<String, String> nazivIVrednostiKol = new HashMap<String, String>();
        nazivIVrednostiKol.put("uslugaId", Integer.toString(uslugaId));
        nazivIVrednostiKol.put("nazivUsluge", nazivUsluge);
        nazivIVrednostiKol.put("kategorijaId", Integer.toString(kategorijaId));
        return nazivIVrednostiKol;
    }

    @Override
    public String nazivPrimarnogKljuca() {
        return "uslugaId";
    }

    @Override
    public HashMap<String, String> nazivIVrednostPrimarnogKljuca() {
        HashMap<String, String> mapa = new HashMap<>();
        mapa.put("uslugaId",Integer.toString(uslugaId));
        return mapa;
    }

    @Override
    public ArrayList<Usluga> ucitajIzResultSeta(ResultSet rs) {
        ArrayList<Usluga> lista = new ArrayList<Usluga>();
        try {
            while (rs.next()) {
                int id = rs.getInt("UslugaID");
                String nazivUsluge = rs.getString("NazivUsluge");
                int kategorijaId = rs.getInt("KategorijaId");

                Usluga u = new Usluga(id, nazivUsluge, kategorijaId);
                lista.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usluga.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return lista;
    }

}
