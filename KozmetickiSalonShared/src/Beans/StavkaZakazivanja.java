/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;

/**
 *
 * @author milic
 */
public class StavkaZakazivanja implements Serializable{
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
