package Domen;

import java.io.Serializable;

public class Kozmeticar implements Serializable, OpstiDomenskiObjekat {

    private int kozmeticarId;
    private String ime;
    private String prezime;
    private int godine;

    public Kozmeticar(int kozmeticarId, String ime, String prezime, int godine) {
        this.kozmeticarId = kozmeticarId;
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
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
        return ime + " " + prezime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        this.godine = godine;
    }

}
