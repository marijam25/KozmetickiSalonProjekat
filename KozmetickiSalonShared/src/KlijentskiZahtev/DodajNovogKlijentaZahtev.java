/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlijentskiZahtev;

import Domen.Klijent;
import java.io.Serializable;

/**
 *
 * @author milic
 */
public class DodajNovogKlijentaZahtev implements Serializable{
    private Klijent klijent;

    public DodajNovogKlijentaZahtev(Klijent klijent) {
        this.klijent = klijent;
    }

    public Klijent getKlijent() {
        return klijent;
    }
}
