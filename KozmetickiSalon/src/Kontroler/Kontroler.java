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

    public boolean prijavljivanjeKorisnika(OpstiDomenskiObjekat odo) {
        OpstaSistemskaOperacija oso = new SOPrijavljivanje();
        return oso.izvrsi(odo);
    }


    //-------------------------------------------------------------------
    // Dodavanje
    //-------------------------------------------------------------------

    public boolean dodajKozmeticara(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SODodajKozmeticara();
        return oso.izvrsi(odo);
    }

    public boolean dodajStavkuZakazaogTermina(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SODodajStavkuZakazanogTermina();
        return oso.izvrsi(odo);
    }

    public boolean dodajUslugu(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SODodajUslugu();
        return oso.izvrsi(odo);
    }

    public boolean dodajZakazaniTermin(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SODodajZakazaniTermin();
        return oso.izvrsi(odo);
    }

    //-------------------------------------------------------------------
    // Azuriranje
    //-------------------------------------------------------------------

    public boolean azurirajKozmeticara(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SOAzurirajKozmeticara();
        return oso.izvrsi(odo);
    }

    public boolean azurirajZakazaniTermin(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SOAzurirajZakazaniTermin();
        return oso.izvrsi(odo);
    }

    //-------------------------------------------------------------------
    // Brisanje
    //-------------------------------------------------------------------

    public boolean obrisiKozmeticara(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SOObrisiKozmeticara();
        return oso.izvrsi(odo);
    }

    public boolean obrisiStavkeZakazanogTermina(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SOObrisiStavkeZakazanogTermina();
        return oso.izvrsi(odo);
    }

    public boolean obrisiUslugu(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SOObrisiUslugu();
        return oso.izvrsi(odo);
    }

    public boolean obrisiZakazaniTermin(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SOObrisiZakazaniTermin();
        return oso.izvrsi(odo);
    }

    //-------------------------------------------------------------------
    // Dohvatanje
    //-------------------------------------------------------------------

    public List<KategorijaUsluga> dohvatiKategorijeUsluga(OpstiDomenskiObjekat odo){
        SODohvatiKategorijeUsluga oso = new SODohvatiKategorijeUsluga();
        boolean uspeo = oso.izvrsi(odo);
        if(uspeo){
            return oso.getListaKategorijaUsluga();
        }
        else{
            return null;
        }
    }

    public List<Klijent> dohvatiKlijente(OpstiDomenskiObjekat odo){
        SODohvatiKlijente oso = new SODohvatiKlijente();
        boolean uspeo = oso.izvrsi(odo);
        if(uspeo){
            return oso.getListaKlijenata();
        }
        else{
            return null;
        }
    }

    public List<Kozmeticar> dohvatiSveKozmeticare(OpstiDomenskiObjekat odo){
        SODohvatiSveKozmeticare oso = new SODohvatiSveKozmeticare();
        boolean uspeo = oso.izvrsi(odo);
        if(uspeo){
            return oso.getListaKozmeticara();
        }
        else{
            return null;
        }
    }

    public List<Kozmeticar> dohvatiKozmeticarePoPrezimenu(OpstiDomenskiObjekat odo){
        SODohvatiKozmeticarePoPrezimenu oso = new SODohvatiKozmeticarePoPrezimenu();
        boolean uspeo = oso.izvrsi(odo);
        if(uspeo){
            return oso.getListaKozmeticara();
        }
        else{
            return null;
        }
    }

    public List<Usluga> dohvatiSveUsluge(OpstiDomenskiObjekat odo){
        SODohvatiSveUsluge oso = new SODohvatiSveUsluge();
        boolean uspeo = oso.izvrsi(odo);
        if(uspeo){
            return oso.getListaUsluga();
        }
        else{
            return null;
        }
    }

    public List<Usluga> dohvatiUsluguPoNazivu(OpstiDomenskiObjekat odo){
        SODohvatiUsluguPoNazivu oso = new SODohvatiUsluguPoNazivu();
        boolean uspeo = oso.izvrsi(odo);
        if(uspeo){
            return oso.getListaUsluga();
        }
        else{
            return null;
        }
    }

    public List<ZakazaniTermin> dohvatiZakazaneTermineZaKlijenta(OpstiDomenskiObjekat odo){
        SODohvatiZakazaneTermineZaKlijenta oso = new SODohvatiZakazaneTermineZaKlijenta();
        boolean uspeo = oso.izvrsi(odo);
        if(uspeo){
            return oso.getListaZakazanihTermina();
        }
        else{
            return null;
        }
    }

    public List<StavkaZakazanogTermina> dohvatiStavkeZaZakazaniTermin(OpstiDomenskiObjekat odo){
        SODohvatiStavkeZaZakazaniTermin oso = new SODohvatiStavkeZaZakazaniTermin();
        boolean uspeo = oso.izvrsi(odo);
        if(uspeo){
            return oso.getListaStavki();
        }
        else{
            return null;
        }
    }
}
