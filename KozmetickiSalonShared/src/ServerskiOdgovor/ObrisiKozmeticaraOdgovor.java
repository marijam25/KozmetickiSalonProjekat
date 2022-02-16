/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerskiOdgovor;

import java.io.Serializable;

/**
 *
 * @author milic
 */
public class ObrisiKozmeticaraOdgovor implements Serializable {
    private boolean uspeo;

    public ObrisiKozmeticaraOdgovor(boolean success) {
        this.uspeo = success;
    }

    public boolean isUspeo() {
        return uspeo;
    }
  
}
