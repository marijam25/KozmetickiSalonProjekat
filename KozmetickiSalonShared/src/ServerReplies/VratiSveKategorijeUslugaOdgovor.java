/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerReplies;

import Beans.KategorijaUsluga;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author milic
 */
public class VratiSveKategorijeUslugaOdgovor implements Serializable{
    ArrayList<KategorijaUsluga> listaKategorijaUsluga;

    public VratiSveKategorijeUslugaOdgovor(ArrayList<KategorijaUsluga> listaKategorijaUsluga) {
        this.listaKategorijaUsluga = listaKategorijaUsluga;
    }

    public ArrayList<KategorijaUsluga> getListaKategorijaUsluga() {
        return listaKategorijaUsluga;
    }
    
    
}
