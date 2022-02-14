/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientRequests;

import Beans.Usluga;
import java.io.Serializable;

/**
 *
 * @author milic
 */
public class DeleteServiceRequest implements Serializable{
    private Usluga usluga;

    public DeleteServiceRequest(Usluga usluga) {
        this.usluga = usluga;
    }

    public Usluga getUsluga() {
        return usluga;
    }
    
    
}
