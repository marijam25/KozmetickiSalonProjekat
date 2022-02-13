/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientRequests;

import Beans.Klijent;
import java.io.Serializable;

/**
 *
 * @author milic
 */
public class AddNewClientRequest implements Serializable{
    private Klijent klijent;

    public AddNewClientRequest(Klijent klijent) {
        this.klijent = klijent;
    }

    public Klijent getKlijent() {
        return klijent;
    }
}
