package KlijentskiZahtevi;

import java.io.Serializable;

public class TipoviZahteva implements Serializable {

    /* Zahtevi za prijavljivanje */
    public static final int PRIJAVLJIVANJE_ZAHTEV = 1;


    /* Zahtevi za dodavanje */
    public static final int DODAJ_KOZMETICARA_ZAHTEV = 10;
    public static final int DODAJ_USLUGU_ZAHTEV = 11;
    public static final int DODAJ_ZAKAZANI_TERMIN_ZAHTEV = 12;
    public static final int DODAJ_STAVKU_ZAKAZIVANJA_ZAHTEV = 13;


    /* Zahtevi za azuriranje */
    public static final int AZURIRAJ_KOZMETICARA_ZAHTEV = 20;
    public static final int AZURIRAJ_ZAKAZANI_TERMIN_ZAHTEV = 21;


    /* Zahtevi za brisanje */
    public static final int OBRISI_KOZMETICARA_ZAHTEV = 30;
    public static final int OBRISI_USLUGU_ZAHTEV = 31;
    public static final int OBRISI_ZAKAZANI_TERMIN_ZAHTEV = 32;
    public static final int OBRISI_STAVKU_ZAKAZIVANJA_ZAHTEV = 33;
    


    /* Zahtevi za dohvatanje */
    public static final int DOHVATI_SVE_KATEGORIJE_USLUGA_ZAHTEV = 40;
    public static final int DOHVATI_SVE_KLIJENTE_ZAHTEV = 41;
    public static final int DOHVATI_SVE_USLUGE_ZAHTEV = 42;
    public static final int DOHVATI_SVE_KOZMETICARE_ZAHTEV = 43;
    public static final int DOHVATI_ZAKAZANE_TERMINE_ZA_KLIJENTA_ZAHTEV = 44;
    public static final int DOHVATI_USLUGU_PO_NAZIVU_ZAHTEV = 45;
    public static final int DOHVATI_KOZMETICARE_PO_PREZIMENU_ZAHTEV = 46;
    public static final int DOHVATI_STAVKE_ZA_ZAKAZANI_TERMIN_ZAHTEV = 47;

}
