/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlijentskiZahtev;

import Domen.Termin;
import java.io.Serializable;

/**
 *
 * @author milic
 */
public class ObrisiTerminZahtev implements Serializable{
    private Termin termin;

    public ObrisiTerminZahtev(Termin termin) {
        this.termin = termin;
    }

    public Termin getTermin() {
        return termin;
    }
    
    
}
