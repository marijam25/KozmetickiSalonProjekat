package ServerskiOdgovori;

import java.io.Serializable;

public class TipoviOdgovora implements Serializable {

    /* Odgovori na zahteve za prijavljivanje */
    public static final int PRIJAVLJIVANJE_ODGOVOR = 1;


    /* Odgovori na zahteve za dodavanje */
    public static final int DODAJ_KOZMETICARA_ODGOVOR = 10;
    public static final int DODAJ_USLUGU_ODGOVOR = 11;
    public static final int DODAJ_ZAKAZANI_TERMIN_ODGOVOR = 12;
    public static final int DODAJ_STAVKU_ZAKAZIVANJA_ODGOVOR = 13;


    /* Odgovori na zahteve za azuriranje */
    public static final int AZURIRAJ_KOZMETICARA_ODGOVOR = 20;
    public static final int AZURIRAJ_ZAKAZANI_TERMIN_ODGOVOR = 21;


    /* Odgovori na zahteve za brisanje */
    public static final int OBRISI_KOZMETICARA_ODGOVOR = 30;
    public static final int OBRISI_USLUGU_ODGOVOR = 31;
    public static final int OBRISI_ZAKAZANI_TERMIN_ODGOVOR = 32;
    public static final int OBRISI_STAVKU_ZAKAZIVANJA_ZAHTEV = 33;


    /* Odgovori na zahteve za dohvatanje */
    public static final int DOHVATI_SVE_USLUGE_ODGOVOR = 40;
    public static final int DOHVATI_SVE_KATEGORIJE_USLUGA_ODGOVOR = 41;
    public static final int DOHVATI_SVE_KLIJENTE_ODGOVOR = 42;
    public static final int DOHVATI_SVE_KOZMETICARE_ODGOVOR = 43;
    public static final int DOKVATI_ZAKAZANE_TERMINE_ZA_KLIJENTA_ODGOVOR = 44;
    public static final int DOHVATI_USLUGU_PO_NAZIVU_ODGOVOR = 45;
    public static final int DOHVATI_KOZMETICARE_PO_PREZIMENU_ODGOVOR = 46;
    public static final int DOHVATI_STAVKE_ZA_ZAKAZANI_TERMIN_ODGOVOR = 47;

}
