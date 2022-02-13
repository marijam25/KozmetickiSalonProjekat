/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;

/**
 *
 * @author milic
 */
public class Usluga implements Serializable{
    private int uslugaId;
    private String nazivUsluge;
    private int kategorijaId;

    public Usluga(int uslugaId, String nazivUsluge, int kategorijaId) {
        this.uslugaId = uslugaId;
        this.nazivUsluge = nazivUsluge;
        this.kategorijaId = kategorijaId;
    }

    public int getUslugaId() {
        return uslugaId;
    }

    public String getNazivUsluge() {
        return nazivUsluge;
    }

    public int getKategorijaId() {
        return kategorijaId;
    }

    @Override
    public String toString() {
        return "Usluga{" + "uslugaId=" + uslugaId + ", nazivUsluge=" + nazivUsluge + ", kategorijaId=" + kategorijaId + '}';
    }
    
    
}
