/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package So;

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
    public boolean proveriPreduslov() {
        return true;
    }

    @Override
    public void izvrsi() {
        Usluga odo = new Usluga();
        listaUsluga = (ArrayList<Usluga>) DBBroker.getInstance().pronadjiUBazi(odo);
    }

    public ArrayList<Usluga> getListaUsluga() {
        return listaUsluga;
    }
}
