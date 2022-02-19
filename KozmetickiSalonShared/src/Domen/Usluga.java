package Domen;

import java.io.Serializable;

public class Usluga implements Serializable, OpstiDomenskiObjekat {

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
        return nazivUsluge;
    }

}
