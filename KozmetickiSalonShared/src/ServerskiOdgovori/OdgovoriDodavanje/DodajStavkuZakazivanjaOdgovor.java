/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerskiOdgovori.OdgovoriDodavanje;

import java.io.Serializable;

/**
 *
 * @author milic
 */
public class DodajStavkuZakazivanjaOdgovor implements Serializable{
    private boolean uspeo;

    public DodajStavkuZakazivanjaOdgovor(boolean uspeo) {
        this.uspeo = uspeo;
    }

    public boolean isUspeo() {
        return uspeo;
    }
}
