package KlijentskiZahtevi.ZahteviZaPrijavljivanje;

import Domen.KorisnikSistema;
import java.io.Serializable;

public class PrijavljivanjeZahtev implements Serializable {
    private KorisnikSistema korisnik;

    public PrijavljivanjeZahtev(KorisnikSistema korisnik) {
        this.korisnik = korisnik;
    }

    public KorisnikSistema getKorisnik() {
        return korisnik;
    }
}
