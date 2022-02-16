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
public class DodajNovogKozmeticaraZahtev implements Serializable {
    private Kozmeticar kozmeticar;

    public DodajNovogKozmeticaraZahtev(Kozmeticar kozmeticar) {
        this.kozmeticar = kozmeticar;
    }

    public Kozmeticar getKozmeticar() {
        return kozmeticar;
    }
}
