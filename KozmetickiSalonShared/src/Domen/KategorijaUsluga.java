/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domen;

import java.io.Serializable;

/**
 *
 * @author milic
 */
public class KategorijaUsluga implements Serializable {
    private int kategorijaId;
    private String nazivKategorije;

    public KategorijaUsluga(int kategorijaId, String nazivKategorije) {
        this.kategorijaId = kategorijaId;
        this.nazivKategorije = nazivKategorije;
    }

    public int getKategorijaId() {
        return kategorijaId;
    }

    public String getNazivKategorije() {
        return nazivKategorije;
    }

    @Override
    public String toString() {
        return "KategorijaUsluga{" + "kategorijaId=" + kategorijaId + ", nazivKategorije=" + nazivKategorije + '}';
    }
    
    
}
