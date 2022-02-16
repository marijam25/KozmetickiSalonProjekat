/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlijentskiZahtev;

import java.io.Serializable;

/**
 *
 * @author milic
 */
public class PretraziUslugeZahtev implements Serializable {
    private String nazivUsluge;
    private int kategorijaID;

    public PretraziUslugeZahtev(String nazivUsluge, int kategorijaID) {
        this.nazivUsluge = nazivUsluge;
        this.kategorijaID = kategorijaID;
    }

    public String getNazivUsluge() {
        return nazivUsluge;
    }

    public int getKategorijaID() {
        return kategorijaID;
    }
}
