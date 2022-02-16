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
public class PrijavljivanjeZahtev implements Serializable{
    private String korisnickoIme;
    private String sifra;

    public PrijavljivanjeZahtev(String korisnickoIme, String sifra) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }
    
    
}
