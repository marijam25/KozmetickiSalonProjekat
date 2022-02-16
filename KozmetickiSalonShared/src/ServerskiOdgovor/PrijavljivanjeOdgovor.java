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
public class PrijavljivanjeOdgovor implements Serializable{
    private boolean uspesno;

    public PrijavljivanjeOdgovor(boolean uspesno) {
        this.uspesno = uspesno;
    }

    public boolean isUspesno() {
        return uspesno;
    }
    
    
}
