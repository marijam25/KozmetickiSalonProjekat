/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerReplies;

import Beans.Kozmeticar;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author milic
 */
public class GetAllCosmeticReply implements Serializable{
    private ArrayList<Kozmeticar> listaKozmeticara;

    public GetAllCosmeticReply(ArrayList<Kozmeticar> listaKozmeticara) {
        this.listaKozmeticara = listaKozmeticara;
    }

    public ArrayList<Kozmeticar> getListaKozmeticara() {
        return listaKozmeticara;
    }
    
    
}
