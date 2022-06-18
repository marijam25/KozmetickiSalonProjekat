package Domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

public class StavkaZakazivanja implements Serializable, OpstiDomenskiObjekat {

    private int stavkaId;
    private int zakazivanjeId;
    private int uslugaId;

    public StavkaZakazivanja() {
    }

    public StavkaZakazivanja(int stavkaId, int zakazivanjeId, int uslugaId) {
        this.stavkaId = stavkaId;
        this.zakazivanjeId = zakazivanjeId;
        this.uslugaId = uslugaId;
    }

    public int getStavkaId() {
        return stavkaId;
    }

    public int getZakazivanjeId() {
        return zakazivanjeId;
    }

    

    public int getUslugaId() {
        return uslugaId;
    }

    

    public void setZakazivanjeId(int zakazivanjeId) {
        this.zakazivanjeId = zakazivanjeId;
    }


    @Override
    public String nazivTabele() {
        return "stavkaZakazivanja";
    }

    @Override
    public ArrayList<String> naziviKolona() {
        ArrayList<String> naziviKol = new ArrayList<>();
        naziviKol.add("stavkaId");
        naziviKol.add("zakazivanjeId");
        naziviKol.add("uslugaId");
        return naziviKol;
    }

    @Override
    public HashMap<String, String> naziviIVrednostiKolona() {
        HashMap<String, String> nazivIVrednostiKol = new HashMap<String, String>();
        nazivIVrednostiKol.put("stavkaId", Integer.toString(stavkaId));
        nazivIVrednostiKol.put("zakazivanjeId", Integer.toString(zakazivanjeId));
        nazivIVrednostiKol.put("uslugaId", Integer.toString(uslugaId));
        return nazivIVrednostiKol;
    }

    @Override
    public String nazivPrimarnogKljuca() {
        return "stavkaId";
    }

    @Override
    public HashMap<String, String> nazivIVrednostPrimarnogKljuca() {
        HashMap<String, String> mapa = new HashMap<>();
        mapa.put("stavkaId",Integer.toString(stavkaId));
        mapa.put("zakazivanjeId", Integer.toString(zakazivanjeId));
        return mapa;
    }

    @Override
    public ArrayList<StavkaZakazivanja> ucitajIzResultSeta(ResultSet rs) {
        ArrayList<StavkaZakazivanja> lista = new ArrayList<StavkaZakazivanja>();
        try {
            while (rs.next()) {
                int stavkaId = rs.getInt("stavkaID");
                int zakazivanjeId = rs.getInt("zakazivanjeId");
                int uslugaId = rs.getInt("uslugaId");

                StavkaZakazivanja u = new StavkaZakazivanja(stavkaId,zakazivanjeId,uslugaId);
                lista.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StavkaZakazivanja.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return lista;
    }

}
