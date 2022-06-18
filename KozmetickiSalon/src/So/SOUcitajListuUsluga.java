/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package So;

import Domen.OpstiDomenskiObjekat;
import Domen.Usluga;
import db.DBBroker;
import java.util.ArrayList;

/**
 *
 * @author milic
 */
public class SOUcitajListuUsluga extends OpstaSistemskaOperacija {

    private ArrayList<Usluga> listaUsluga;
    
    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
   public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        
        listaUsluga = (ArrayList<Usluga>) DBBroker.getInstance().pronadjiUBazi(odo,null);
        
        if(listaUsluga==null)
            return false;
        else
            return true;
    }

    public ArrayList<Usluga> getListaUsluga() {
        return listaUsluga;
    }
}
