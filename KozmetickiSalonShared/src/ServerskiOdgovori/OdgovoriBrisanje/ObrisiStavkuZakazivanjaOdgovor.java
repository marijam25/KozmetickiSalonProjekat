/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerskiOdgovori.OdgovoriBrisanje;

import java.io.Serializable;

/**
 *
 * @author milic
 */
public class ObrisiStavkuZakazivanjaOdgovor implements Serializable{
    private boolean uspeo;

    public ObrisiStavkuZakazivanjaOdgovor(boolean uspeo) {
        this.uspeo = uspeo;
    }

    public boolean isUspeo() {
        return uspeo;
    }
}
