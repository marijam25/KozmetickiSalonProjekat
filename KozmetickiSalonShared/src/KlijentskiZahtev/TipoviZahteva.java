package KlijentskiZahtev;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author milic
 */
public class TipoviZahteva implements Serializable{
    public static final int DODAJ_NOVOG_KLIJENTA_ZAHTEV = 1;
    public static final int DODAJ_NOVOG_KOZMETICARA_ZAHTEV = 2;
    public static final int OBRISI_KOZMETICARA_ZAHTEV = 3;
    public static final int DODAJ_NOVU_USLUGU_ZAHTEV = 4;
    public static final int OBRISI_USLUGU_ZAHTEV = 5;
    public static final int DODAJ_NOVI_TERMIN_ZAHTEV = 6;
    public static final int OBRISI_TERMIN_ZAHTEV = 7;
    public static final int IZMENI_KOZMETICARA_ZAHTEV = 8;
    public static final int PRETRAZI_USLUGE_ZAHTEV = 9;
    public static final int IZMENI_TERMIN_ZAHTEV = 10;
    public static final int VRATI_SVE_KOZMETICARE_ZAHTEV = 11;
    public static final int VRATI_SVE_KATEGORIJE_USLUGA_ZAHTEV = 12;
}
