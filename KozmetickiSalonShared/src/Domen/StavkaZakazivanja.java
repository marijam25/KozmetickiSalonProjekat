package Domen;

import java.io.Serializable;

public class StavkaZakazivanja implements Serializable, OpstiDomenskiObjekat {

    private int stavkaId;
    private int zakazivanjeId;
    private int terminId;
    private int uslugaId;

    public StavkaZakazivanja(int stavkaId, int zakazivanjeId, int terminId, int uslugaId) {
        this.stavkaId = stavkaId;
        this.zakazivanjeId = zakazivanjeId;
        this.terminId = terminId;
        this.uslugaId = uslugaId;
    }

    public int getStavkaId() {
        return stavkaId;
    }

    public int getZakazivanjeId() {
        return zakazivanjeId;
    }

    public int getTerminId() {
        return terminId;
    }

    public int getUslugaId() {
        return uslugaId;
    }

    @Override
    public String toString() {
        return "StavkaZakazivanja{" + "stavkaId=" + stavkaId + ", zakazivanjeId=" + zakazivanjeId + ", terminId=" + terminId + ", uslugaId=" + uslugaId + '}';
    }

}
