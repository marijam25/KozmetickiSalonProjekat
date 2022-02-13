/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author milic
 */
public class Termin implements Serializable{
    private int terminId;
    private Date datumTermina;
    private Time vremeTermina;

    public Termin(int terminId, Date datumTermina, Time vremeTermina) {
        this.terminId = terminId;
        this.datumTermina = datumTermina;
        this.vremeTermina = vremeTermina;
    }

    public int getTerminId() {
        return terminId;
    }

    public Date getDatumTermina() {
        return datumTermina;
    }

    public Time getVremeTermina() {
        return vremeTermina;
    }

    @Override
    public String toString() {
        return "Termin{" + "terminId=" + terminId + ", datumTermina=" + datumTermina + ", vremeTermina=" + vremeTermina + '}';
    }
    
    
}
