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
public class ZakazivanjeTermina implements Serializable{
    private int zakazivanjeId;
    private int kozmeticarId;
    private int klijentId;

    public ZakazivanjeTermina(int zakazivanjeId, int kozmeticarId, int klijentId) {
        this.zakazivanjeId = zakazivanjeId;
        this.kozmeticarId = kozmeticarId;
        this.klijentId = klijentId;
    }

    public int getZakazivanjeId() {
        return zakazivanjeId;
    }

    public int getKozmeticarId() {
        return kozmeticarId;
    }

    public int getKlijentId() {
        return klijentId;
    }

    @Override
    public String toString() {
        return "ZakazivanjeTermina{" + "zakazivanjeId=" + zakazivanjeId + ", kozmeticarId=" + kozmeticarId + ", klijentId=" + klijentId + '}';
    }
    
    
}
