/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerskiOdgovor;

import java.io.Serializable;

/**
 *
 * @author milic
 */
public class TipoviOdgovora implements Serializable {
    public static final int DODAJ_NOVOG_KLIJENTA_ODGOVOR = 1;
    public static final int DODAJ_NOVOG_KOZMETICARA_ODGOVOR = 2;
    public static final int OBRISI_KOZMETICARA_ODGOVOR = 3;
    public static final int DODAJ_NOVU_USLUGU_ODGOVOR = 4;
    public static final int OBRISI_USLUGU_ODGOVOR = 5;
    public static final int DODAJ_NOVI_TERMIN_ODGOVOR = 6;
    public static final int OBRISI_TERMIN_ODGOVOR = 7;
    public static final int IZMENI_KOZMETICARA_ODGOVOR = 8;
    public static final int PRETRAZI_USLUGE_ODGOVOR = 9;
    public static final int IZMENI_TERMIN_ODGOVOR = 10;
    public static final int VRATI_SVE_KOZMETICARE_ODGOVOR = 11;
    public static final int VRATI_SVE_KATEGORIJE_USLUGA_ODGOVOR = 12;
    public static final int PRIJAVLJIVANJE_ODGOVOR = 13;
}
