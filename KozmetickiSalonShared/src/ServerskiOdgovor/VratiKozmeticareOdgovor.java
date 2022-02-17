/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerskiOdgovor;

import Domen.Kozmeticar;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author milic
 */
public class VratiKozmeticareOdgovor implements Serializable{
    private ArrayList<Kozmeticar> listaKozmeticara;

    public VratiKozmeticareOdgovor(ArrayList<Kozmeticar> listaKozmeticara) {
        this.listaKozmeticara = listaKozmeticara;
    }

    public ArrayList<Kozmeticar> getListaKozmeticara() {
        return listaKozmeticara;
    }
    
    
}
