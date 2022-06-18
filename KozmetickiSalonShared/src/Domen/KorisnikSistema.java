package Domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

public class KorisnikSistema implements Serializable, OpstiDomenskiObjekat {

    private int korisnikId;
    private String korisnickoIme;
    private String sifra;

    public KorisnikSistema(int korisnikId, String korisnickoIme, String sifra) {
        this.korisnikId = korisnikId;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public KorisnikSistema() {
    }
    

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    @Override
    public String nazivTabele() {
        return "korisnikSistema";
    }

    @Override
    public ArrayList<String> naziviKolona() {
        ArrayList<String> naziviKol = new ArrayList<>();
        naziviKol.add("korisnikId");
        naziviKol.add("korisnickoIme");
        naziviKol.add("sifra");
        return naziviKol;
    }

    @Override
    public HashMap<String, String> naziviIVrednostiKolona() {
        HashMap<String, String> nazivIVrednostiKol = new HashMap();
        nazivIVrednostiKol.put("korisnikId", Integer.toString(korisnikId));
        nazivIVrednostiKol.put("korisnickoIme", korisnickoIme);
        nazivIVrednostiKol.put("sifra", sifra);
        return nazivIVrednostiKol;
    }

    @Override
    public String nazivPrimarnogKljuca() {
        return "korisnikId";
    }

    @Override
    public HashMap<String, String> nazivIVrednostPrimarnogKljuca() {
        HashMap<String, String> mapa = new HashMap<>();
        mapa.put("korisnikId",Integer.toString(korisnikId));
        return mapa;
    }

    @Override
    public ArrayList<? extends OpstiDomenskiObjekat> ucitajIzResultSeta(ResultSet rs) {
        ArrayList<KorisnikSistema> lista = new ArrayList<KorisnikSistema>();
        try {
            while (rs.next()) {
                int Id = rs.getInt("korisnikId");
                String username = rs.getString("korisnickoIme");
                String password = rs.getString("sifra");
                

                KorisnikSistema k = new KorisnikSistema(Id, username, password);
                lista.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KorisnikSistema.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return lista;
    }
}