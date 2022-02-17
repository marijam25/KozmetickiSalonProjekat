/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerskiOdgovor;

import Domen.Klijent;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author milic
 */
public class VratiSveKlijenteOdgovor implements Serializable{
    private ArrayList<Klijent> listaKlijenata;

    public VratiSveKlijenteOdgovor(ArrayList<Klijent> listaKlijenata) {
        this.listaKlijenata = listaKlijenata;
    }

    public ArrayList<Klijent> getListaKlijenata() {
        return listaKlijenata;
    }
    
    
}
