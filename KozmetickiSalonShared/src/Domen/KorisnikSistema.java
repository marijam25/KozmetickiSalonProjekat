package Domen;

import java.io.Serializable;

public class KorisnikSistema implements Serializable {

    private String korisnickoIme;
    private String sifra;

    public KorisnikSistema(String korisnickoIme, String sifra) {
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
