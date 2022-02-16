/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlijentskiZahtev;

import Domen.Kozmeticar;
import java.io.Serializable;

/**
 *
 * @author milic
 */
public class ObrisiKozmeticaraZahtev implements Serializable{
    private Kozmeticar kozmeticar;

    public ObrisiKozmeticaraZahtev(Kozmeticar kozmeticar) {
        this.kozmeticar = kozmeticar;
    }

    public Kozmeticar getKozmeticar() {
        return kozmeticar;
    }
    
}
