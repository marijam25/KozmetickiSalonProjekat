package Domen;

import java.io.Serializable;

public class KategorijaUsluga implements Serializable {

    private int kategorijaId;
    private String nazivKategorije;

    public KategorijaUsluga(int kategorijaId, String nazivKategorije) {
        this.kategorijaId = kategorijaId;
        this.nazivKategorije = nazivKategorije;
    }

    public int getKategorijaId() {
        return kategorijaId;
    }

    public String getNazivKategorije() {
        return nazivKategorije;
    }

    @Override
    public String toString() {
        return nazivKategorije;
    }

}
