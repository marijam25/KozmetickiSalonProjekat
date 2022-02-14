/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientRequests;

import Beans.Termin;
import java.io.Serializable;

/**
 *
 * @author milic
 */
public class AddNewAppointmentRequest implements Serializable{
    private Termin termin;

    public AddNewAppointmentRequest(Termin termin) {
        this.termin = termin;
    }

    public Termin getTermin() {
        return termin;
    }
    
    
}
