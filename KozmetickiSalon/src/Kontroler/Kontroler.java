package Kontroler;

import Domen.*;
import So.Dohvatanje.*;
import So.Azuriranje.*;
import So.Brisanje.*;
import So.Dodavanje.*;
import So.OpstaSistemskaOperacija;
import So.Prijavljivanje.SOPrijavljivanje;



import java.util.List;

public class Kontroler {

    private static Kontroler instance;

    private Kontroler() {
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }
    
    

    //-------------------------------------------------------------------
    // Prijavljivanje
    //-------------------------------------------------------------------

    public boolean prijavljivanjeKorisnika(KorisnikSistema korisnik) {
        OpstaSistemskaOperacija oso = new SOPrijavljivanje();
        return oso.izvrsi(korisnik);
    }


    //-------------------------------------------------------------------
    // Dodavanje
    //-------------------------------------------------------------------

    public boolean dodajKozmeticara(Kozmeticar kozmeticar){
        OpstaSistemskaOperacija oso = new SODodajKozmeticara();
        return oso.izvrsi(kozmeticar);
    }

    public boolean dodajStavkuZakazanogTermina(StavkaZakazanogTermina stavka){
        OpstaSistemskaOperacija oso = new SODodajStavkuZakazanogTermina();
        return oso.izvrsi(stavka);
    }

    public boolean dodajUslugu(Usluga usluga){
        OpstaSistemskaOperacija oso = new SODodajUslugu();
        return oso.izvrsi(usluga);
    }

    public boolean dodajZakazaniTermin(ZakazaniTermin zakazaniTermin){
        OpstaSistemskaOperacija oso = new SODodajZakazaniTermin();
        return oso.izvrsi(zakazaniTermin);
    }

    //-------------------------------------------------------------------
    // Azuriranje
    //-------------------------------------------------------------------

    public boolean azurirajKozmeticara(Kozmeticar kozmeticar){
        OpstaSistemskaOperacija oso = new SOAzurirajKozmeticara();
        return oso.izvrsi(kozmeticar);
    }

    public boolean azurirajZakazaniTermin(ZakazaniTermin zakazaniTermin){
        OpstaSistemskaOperacija oso = new SOAzurirajZakazaniTermin();
        return oso.izvrsi(zakazaniTermin);
    }

    //-------------------------------------------------------------------
    // Brisanje
    //-------------------------------------------------------------------

    public boolean obrisiKozmeticara(Kozmeticar kozmeticar){
        OpstaSistemskaOperacija oso = new SOObrisiKozmeticara();
        return oso.izvrsi(kozmeticar);
    }

    public boolean obrisiSveStavkeZakazanogTermina(StavkaZakazanogTermina stavka){
        OpstaSistemskaOperacija oso = new SOObrisiSveStavkeZakazanogTermina();
        return oso.izvrsi(stavka);
    }

    public boolean obrisiUslugu(Usluga usluga){
        OpstaSistemskaOperacija oso = new SOObrisiUslugu();
        return oso.izvrsi(usluga);
    }

    public boolean obrisiZakazaniTermin(ZakazaniTermin zakazaniTermin){
        OpstaSistemskaOperacija oso = new SOObrisiZakazaniTermin();
        return oso.izvrsi(zakazaniTermin);
    }
    
    public boolean obrisiStavkuZakaznogTermina (StavkaZakazanogTermina stavka){
        OpstaSistemskaOperacija oso = new SOObrisiStavkuZakazanogTerminaPoIdu();
        return oso.izvrsi(stavka);
    }

    //-------------------------------------------------------------------
    // Dohvatanje
    //-------------------------------------------------------------------

    public List<KategorijaUsluga> dohvatiKategorijeUsluga(KategorijaUsluga kategorija){
        SODohvatiKategorijeUsluga oso = new SODohvatiKategorijeUsluga();
        boolean uspeo = oso.izvrsi(kategorija);
        if(uspeo){
            return oso.getListaKategorijaUsluga();
        }
        else{
            return null;
        }
    }

    public List<Klijent> dohvatiKlijente(Klijent klijent){
        SODohvatiKlijente oso = new SODohvatiKlijente();
        boolean uspeo = oso.izvrsi(klijent);
        if(uspeo){
            return oso.getListaKlijenata();
        }
        else{
            return null;
        }
    }

    public List<Kozmeticar> dohvatiSveKozmeticare(Kozmeticar kozmeticar){
        SODohvatiSveKozmeticare oso = new SODohvatiSveKozmeticare();
        boolean uspeo = oso.izvrsi(kozmeticar);
        if(uspeo){
            return oso.getListaKozmeticara();
        }
        else{
            return null;
        }
    }

    public List<Kozmeticar> dohvatiKozmeticarePoPrezimenu(Kozmeticar kozmeticar){
        SODohvatiKozmeticarePoPrezimenu oso = new SODohvatiKozmeticarePoPrezimenu();
        boolean uspeo = oso.izvrsi(kozmeticar);
        if(uspeo){
            return oso.getListaKozmeticara();
        }
        else{
            return null;
        }
    }

    public List<Usluga> dohvatiSveUsluge(Usluga usluga){
        SODohvatiSveUsluge oso = new SODohvatiSveUsluge();
        boolean uspeo = oso.izvrsi(usluga);
        if(uspeo){
            return oso.getListaUsluga();
        }
        else{
            return null;
        }
    }

    public List<Usluga> dohvatiUsluguPoNazivu(Usluga usluga){
        SODohvatiUsluguPoNazivu oso = new SODohvatiUsluguPoNazivu();
        boolean uspeo = oso.izvrsi(usluga);
        if(uspeo){
            return oso.getListaUsluga();
        }
        else{
            return null;
        }
    }

    public List<ZakazaniTermin> dohvatiZakazaneTermineZaKlijenta(ZakazaniTermin zakazaniTermin){
        SODohvatiZakazaneTermineZaKlijenta oso = new SODohvatiZakazaneTermineZaKlijenta();
        boolean uspeo = oso.izvrsi(zakazaniTermin);
        if(uspeo){
            return oso.getListaZakazanihTermina();
        }
        else{
            return null;
        }
    }

    public List<StavkaZakazanogTermina> dohvatiStavkeZaZakazaniTermin(StavkaZakazanogTermina stavka){
        SODohvatiStavkeZaZakazaniTermin oso = new SODohvatiStavkeZaZakazaniTermin();
        boolean uspeo = oso.izvrsi(stavka);
        if(uspeo){
            return oso.getListaStavki();
        }
        else{
            return null;
        }
    }
}
