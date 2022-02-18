package Domen;

import java.io.Serializable;

public class ZakazivanjeTermina implements Serializable {

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
