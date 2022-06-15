/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package So;

import Domen.Kozmeticar;
import db.DBBroker;
import java.util.ArrayList;

/**
 *
 * @author milic
 */
public class SOUcitajListuKozmeticara extends OpstaSistemskaOperacija{

    private ArrayList<Kozmeticar> listaKozmeticara;
    
    @Override
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        Kozmeticar odo = new Kozmeticar();
        listaKozmeticara = (ArrayList<Kozmeticar>)DBBroker.getInstance().pronadjiUBazi(odo);
    }

    public ArrayList<Kozmeticar> getListaKozmeticara() {
        return listaKozmeticara;
    }
    
}
