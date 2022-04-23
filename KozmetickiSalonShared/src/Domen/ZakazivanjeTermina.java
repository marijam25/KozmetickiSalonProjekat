package Domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

public class ZakazivanjeTermina implements Serializable, OpstiDomenskiObjekat {

    private int zakazivanjeId;
    private int kozmeticarId;
    private int klijentId;

    public ZakazivanjeTermina() {
    }

    public ZakazivanjeTermina(int zakazivanjeId, int kozmeticarId, int klijentId) {
        this.zakazivanjeId = zakazivanjeId;
        this.kozmeticarId = kozmeticarId;
        this.klijentId = klijentId;
    }

    public int getZakazivanjeId() {
        return zakazivanjeId;
    }

    public int getKozmeticarId() {
        return kozmeticarId;
    }

    public int getKlijentId() {
        return klijentId;
    }

    @Override
    public String toString() {
        return "ZakazivanjeTermina{" + "zakazivanjeId=" + zakazivanjeId + ", kozmeticarId=" + kozmeticarId + ", klijentId=" + klijentId + '}';
    }
    
    @Override
    public String nazivTabele() {
        return "zakazivanjeTermina";
    }

    @Override
    public ArrayList<String> naziviKolona() {
        ArrayList<String> naziviKol = new ArrayList<>();
        naziviKol.add("zakazivanjeId");
        naziviKol.add("kozmeticarId");
        naziviKol.add("klijentId");
        return naziviKol;
    }

    @Override
    public HashMap<String, String> naziviIVrednostiKolona() {
        HashMap<String, String> nazivIVrednostiKol = new HashMap<String, String>();
        nazivIVrednostiKol.put("zakazivanjeId", Integer.toString(zakazivanjeId));
        nazivIVrednostiKol.put("kozmeticarId", Integer.toString(kozmeticarId));
        nazivIVrednostiKol.put("klijentId", Integer.toString(klijentId));
        return nazivIVrednostiKol;
    }

    @Override
    public String nazivPrimarnogKljuca() {
        return "zakazivanjeId";
    }

    @Override
    public Pair<String, String> nazivIVrednostPrimarnogKljuca() {
        return new Pair<>("zakazivanjeId", Integer.toString(zakazivanjeId));
    }

    @Override
    public ArrayList<ZakazivanjeTermina> ucitajIzResultSeta(ResultSet rs) {
        ArrayList<ZakazivanjeTermina> lista = new ArrayList<ZakazivanjeTermina>();
        try {
            while (rs.next()) {
                int zakazivanjeId = rs.getInt("zakazivanjeId");
                int kozmeticarId = rs.getInt("kozmeticarId");
                int klijentId = rs.getInt("klijentId");

                ZakazivanjeTermina z = new ZakazivanjeTermina(zakazivanjeId,kozmeticarId,klijentId);
                lista.add(z);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ZakazivanjeTermina.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return lista;
    }

}
