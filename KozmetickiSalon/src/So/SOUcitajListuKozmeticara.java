/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package So;

import Domen.Kozmeticar;
import Domen.OpstiDomenskiObjekat;
import db.DBBroker;
import java.util.ArrayList;

/**
 *
 * @author milic
 */
public class SOUcitajListuKozmeticara extends OpstaSistemskaOperacija{

    private ArrayList<Kozmeticar> listaKozmeticara;
    
    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        
        listaKozmeticara = (ArrayList<Kozmeticar>)DBBroker.getInstance().pronadjiUBazi(odo,null);
        
        if(listaKozmeticara==null)
            return false;
        else
            return true;
    }

    public ArrayList<Kozmeticar> getListaKozmeticara() {
        return listaKozmeticara;
    }
    
}
