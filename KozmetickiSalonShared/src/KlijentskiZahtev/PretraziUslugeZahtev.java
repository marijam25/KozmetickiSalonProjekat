/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlijentskiZahtev;

import java.io.Serializable;

/**
 *
 * @author milic
 */
public class PretraziUslugeZahtev implements Serializable {
    private String uslov;

    public PretraziUslugeZahtev(String uslov) {
        this.uslov = uslov;
    }

    public String getUslov() {
        return uslov;
    }
    
    
}
