package Domen;

import PomocneFunkcije.DatumPomocneFunkcije;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ZakazaniTermin implements Serializable, OpstiDomenskiObjekat {
    private int zakazaniTerminId;
    private int kozmeticarId;
    private int klijentId;
    private java.util.Date datumIVreme;

    public ZakazaniTermin() {
    }

    public ZakazaniTermin(int zakazaniTerminId, int kozmeticarId, int klijentId, Date datumIVreme) {
        this.zakazaniTerminId = zakazaniTerminId;
        this.kozmeticarId = kozmeticarId;
        this.klijentId = klijentId;
        this.datumIVreme = datumIVreme;
    }

    public int getZakazaniTerminId() {
        return zakazaniTerminId;
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

    public void setZakazaniTerminId(int zakazaniTerminId) {
        this.zakazaniTerminId = zakazaniTerminId;
    }

    public void setDatumIVreme(Date datumIVreme) {
        this.datumIVreme = datumIVreme;
    }
    
    

    
    @Override
    public String nazivTabele() {
        return "zakazaniTermin";
    }

    @Override
    public List<String> naziviKolona() {
        ArrayList<String> naziviKol = new ArrayList<>();
        naziviKol.add("zakazaniTerminId");
        naziviKol.add("kozmeticarId");
        naziviKol.add("klijentId");
        naziviKol.add("datumIVreme");
        return naziviKol;
    }

    @Override
    public Map<String, String> naziviIVrednostiKolona() {
        HashMap<String, String> nazivIVrednostiKol = new HashMap<>();
        nazivIVrednostiKol.put("zakazaniTerminId", Integer.toString(zakazaniTerminId));
        nazivIVrednostiKol.put("kozmeticarId", Integer.toString(kozmeticarId));
        nazivIVrednostiKol.put("klijentId", Integer.toString(klijentId));
        if(datumIVreme!=null){
           nazivIVrednostiKol.put("datumIVreme", DatumPomocneFunkcije.UtilDateUSQLString(datumIVreme)); 
        }
        
        return nazivIVrednostiKol;
    }

    @Override
    public List<String> naziviKolonaPrimarnogKljuca() {
        ArrayList<String> naziviKol = new ArrayList<>();
        naziviKol.add("zakazaniTerminId");
        return naziviKol;
    }

    @Override
    public Map<String, String> nazivIVrednostPrimarnogKljuca() {
        HashMap<String, String> mapa = new HashMap<>();
        mapa.put("zakazaniTerminId",Integer.toString(zakazaniTerminId));
        return mapa;
    }

    @Override
    public List<ZakazaniTermin> ucitajIzResultSeta(ResultSet rs) {
        ArrayList<ZakazaniTermin> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                int zakazId = rs.getInt("zakazaniTerminId");
                int kozmId = rs.getInt("kozmeticarId");
                int klijId = rs.getInt("klijentId");
                java.util.Date datUtil = rs.getTimestamp("datumIVreme");
                ZakazaniTermin z = new ZakazaniTermin(zakazId,kozmId,klijId,datUtil);
                lista.add(z);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ZakazaniTermin.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return lista;
    }

}
