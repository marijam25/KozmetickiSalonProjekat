package Kontroler;

import Domen.KorisnikSistema;
import So.OpstaSistemskaOperacija;
import java.util.ArrayList;

public class Kontroler {

    private static Kontroler instance;
    private ArrayList<KorisnikSistema> listaKorisnikaSistema;

    private Kontroler() {
        listaKorisnikaSistema = new ArrayList<>();
        listaKorisnikaSistema.add(new KorisnikSistema("korisnik1", "sifra1"));
        listaKorisnikaSistema.add(new KorisnikSistema("korisnik2", "sifra2"));
        listaKorisnikaSistema.add(new KorisnikSistema("korisnik3", "sifra3"));
        listaKorisnikaSistema.add(new KorisnikSistema("korisnik4", "sifra4"));
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public boolean izvrsiSistemskuOperaciju(OpstaSistemskaOperacija oso) {
        boolean preduslovZadovoljen = oso.proveriPreduslov();

        if (preduslovZadovoljen) {
            oso.izvrsi();
            boolean operacijaIzvrsena = oso.isOperacijaUspesnoIzvrsena();
            if (operacijaIzvrsena) {
                oso.potvrdi();
                return true;
            } else {
                oso.ponisti();
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean prijavljivanje(String korisnickoIme, String sifra) {
        for (KorisnikSistema korisnikSistema : listaKorisnikaSistema) {
            if (korisnikSistema.getKorisnickoIme().equals(korisnickoIme) && korisnikSistema.getSifra().equals(sifra)) {
                return true;
            }
        }
        return false;
    }

}
