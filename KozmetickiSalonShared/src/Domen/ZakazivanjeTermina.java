package Domen;

import PomocneFunkcije.DatumPomocneFunkcije;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ZakazivanjeTermina implements Serializable, OpstiDomenskiObjekat {

    private int zakazivanjeId;
    private int kozmeticarId;
    private int klijentId;
    private java.util.Date datumIVreme;

    public ZakazivanjeTermina() {
    }

    public ZakazivanjeTermina(int zakazivanjeId, int kozmeticarId, int klijentId, Date datumIVreme) {
        this.zakazivanjeId = zakazivanjeId;
        this.kozmeticarId = kozmeticarId;
        this.klijentId = klijentId;
        this.datumIVreme = datumIVreme;
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

    public Date getDatumIVreme() {
        return datumIVreme;
    }

    public void setZakazivanjeId(int zakazivanjeId) {
        this.zakazivanjeId = zakazivanjeId;
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
        naziviKol.add("datumIVreme");
        return naziviKol;
    }

    @Override
    public HashMap<String, String> naziviIVrednostiKolona() {
        HashMap<String, String> nazivIVrednostiKol = new HashMap<String, String>();
        nazivIVrednostiKol.put("zakazivanjeId", Integer.toString(zakazivanjeId));
        nazivIVrednostiKol.put("kozmeticarId", Integer.toString(kozmeticarId));
        nazivIVrednostiKol.put("klijentId", Integer.toString(klijentId));
        nazivIVrednostiKol.put("datumIVreme", DatumPomocneFunkcije.UtilDateUString(datumIVreme));
        return nazivIVrednostiKol;
    }

    @Override
    public String nazivPrimarnogKljuca() {
        return "zakazivanjeId";
    }

    @Override
    public HashMap<String, String> nazivIVrednostPrimarnogKljuca() {
        HashMap<String, String> mapa = new HashMap<>();
        mapa.put("zakazivanjeId",Integer.toString(zakazivanjeId));
        return mapa;
    }

    @Override
    public ArrayList<ZakazivanjeTermina> ucitajIzResultSeta(ResultSet rs) {
        ArrayList<ZakazivanjeTermina> lista = new ArrayList<ZakazivanjeTermina>();
        try {
            while (rs.next()) {
                int zakazId = rs.getInt("zakazivanjeId");
                int kozmId = rs.getInt("kozmeticarId");
                int klijId = rs.getInt("klijentId");
                java.sql.Date datSql = rs.getDate("datumIVreme");
                java.util.Date datUtil = new java.util.Date(datSql.getTime());
                ZakazivanjeTermina z = new ZakazivanjeTermina(zakazId,kozmId,klijId,datUtil);
                lista.add(z);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ZakazivanjeTermina.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return lista;
    }

}
