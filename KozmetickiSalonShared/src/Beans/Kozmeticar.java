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
public class Kozmeticar implements Serializable{
    private int kozmeticarId;
    private String ime;
    private String prezime;

    public Kozmeticar(int kozmeticarId, String ime, String prezime) {
        this.kozmeticarId = kozmeticarId;
        this.ime = ime;
        this.prezime = prezime;
    }

    public int getKozmeticarId() {
        return kozmeticarId;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    @Override
    public String toString() {
        return "Kozmeticar{" + "ime=" + ime + ", prezime=" + prezime + '}';
    }
    
    
}
