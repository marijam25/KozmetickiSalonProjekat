package Domen;

import java.io.Serializable;

public class Klijent implements Serializable {

    private int klijentId;
    private String ime;
    private String prezime;

    public Klijent(int klijentId, String ime, String prezime) {
        this.klijentId = klijentId;
        this.ime = ime;
        this.prezime = prezime;
    }

    public int getKlijentId() {
        return klijentId;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

}
