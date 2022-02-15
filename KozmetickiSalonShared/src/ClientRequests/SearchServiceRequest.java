/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientRequests;

import java.io.Serializable;

/**
 *
 * @author milic
 */
public class SearchServiceRequest implements Serializable {
    private String nazivUsluge;
    private int kategorijaID;

    public SearchServiceRequest(String nazivUsluge, int kategorijaID) {
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
