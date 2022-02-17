/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlijentskiZahtev;

import Domen.StavkaZakazivanja;
import Domen.Termin;
import Domen.ZakazivanjeTermina;
import java.io.Serializable;

/**
 *
 * @author milic
 */
public class DodajNoviTerminZahtev implements Serializable{
    private Termin termin;
    private StavkaZakazivanja stavkaZakazivanja;
    private ZakazivanjeTermina zakazivanjeTermina;

    public DodajNoviTerminZahtev(Termin termin, StavkaZakazivanja stavkaZakazivanja, ZakazivanjeTermina zakazivanjeTermina) {
        this.termin = termin;
        this.stavkaZakazivanja = stavkaZakazivanja;
        this.zakazivanjeTermina = zakazivanjeTermina;
    }

    public StavkaZakazivanja getStavkaZakazivanja() {
        return stavkaZakazivanja;
    }

    public ZakazivanjeTermina getZakazivanjeTermina() {
        return zakazivanjeTermina;
    }

    public Termin getTermin() {
        return termin;
    }
    
    
    
    
}
