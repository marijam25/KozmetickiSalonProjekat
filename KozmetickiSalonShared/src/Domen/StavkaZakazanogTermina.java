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

public class StavkaZakazanogTermina implements Serializable, OpstiDomenskiObjekat {
    private int stavkaId;
    private int zakazaniTerminId;
    private int uslugaId;

    public StavkaZakazanogTermina() {
    }

    public StavkaZakazanogTermina(int stavkaId, int zakazaniTerminId, int uslugaId) {
        this.stavkaId = stavkaId;
        this.zakazaniTerminId = zakazaniTerminId;
        this.uslugaId = uslugaId;
    }

    public int getStavkaId() {
        return stavkaId;
    }

    public int getZakazivanjeId() {
        return zakazaniTerminId;
    }

    public int getUslugaId() {
        return uslugaId;
    }

    public void setZakazivanjeId(int zakazivanjeId) {
        this.zakazaniTerminId = zakazivanjeId;
    }

    @Override
    public String nazivTabele() {
        return "StavkaZakazanogTermina";
    }

    @Override
    public List<String> naziviKolona() {
        ArrayList<String> naziviKol = new ArrayList<>();
        naziviKol.add("stavkaId");
        naziviKol.add("zakazaniTerminId");
        naziviKol.add("uslugaId");
        return naziviKol;
    }

    @Override
    public Map<String, String> naziviIVrednostiKolona() {
        HashMap<String, String> nazivIVrednostiKol = new HashMap<>();
        nazivIVrednostiKol.put("stavkaId", Integer.toString(stavkaId));
        nazivIVrednostiKol.put("zakazaniTerminId", Integer.toString(zakazaniTerminId));
        nazivIVrednostiKol.put("uslugaId", Integer.toString(uslugaId));
        return nazivIVrednostiKol;
    }

    @Override
    public List<String> naziviKolonaPrimarnogKljuca() {
        ArrayList<String> naziviKolPrimKljuca = new ArrayList<>();
        naziviKolPrimKljuca.add("stavkaId");
        naziviKolPrimKljuca.add("zakazaniTerminId");
        return naziviKolPrimKljuca;
    }

    @Override
    public Map<String, String> nazivIVrednostPrimarnogKljuca() {
        HashMap<String, String> mapa = new HashMap<>();
        mapa.put("stavkaId",Integer.toString(stavkaId));
        mapa.put("zakazaniTerminId", Integer.toString(zakazaniTerminId));
        return mapa;
    }

    @Override
    public List<StavkaZakazanogTermina> ucitajIzResultSeta(ResultSet rs) {
        ArrayList<StavkaZakazanogTermina> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                int stavkaId1 = rs.getInt("stavkaID");
                int zakazaniTerminId1 = rs.getInt("zakazaniTerminId");
                int uslugaId1 = rs.getInt("uslugaId");

                StavkaZakazanogTermina u = new StavkaZakazanogTermina(stavkaId1,zakazaniTerminId1,uslugaId1);
                lista.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StavkaZakazanogTermina.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return lista;
    }

}
