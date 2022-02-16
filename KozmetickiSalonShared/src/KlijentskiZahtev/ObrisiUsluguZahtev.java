/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlijentskiZahtev;

import Domen.Usluga;
import java.io.Serializable;

/**
 *
 * @author milic
 */
public class ObrisiUsluguZahtev implements Serializable{
    private Usluga usluga;

    public ObrisiUsluguZahtev(Usluga usluga) {
        this.usluga = usluga;
    }

    public Usluga getUsluga() {
        return usluga;
    }
    
    
}
