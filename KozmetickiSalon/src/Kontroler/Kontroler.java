package Kontroler;

import Domen.KorisnikSistema;
import Domen.OpstiDomenskiObjekat;
import So.OpstaSistemskaOperacija;
import So.SOAzurirajKozmeticara;
import So.SOAzurirajZakazivanjeTermina;
import So.SONadjiKorisnikaSistemaPoKorisnickomImenuISifri;
import So.SONadjiKozmeticarePoPrezimenu;
import So.SONadjiUslugePoNazivu;
import So.SONadjiZakazivanjeTerminaPoDatumu;
import So.SONadjiZakazivanjeTerminaPoIdu;
import So.SOObrisiKozmeticara;
import So.SOObrisiStavkuZakazivanja;
import So.SOObrisiUslugu;
import So.SOObrisiZakazivanjeTermina;
import So.SOUcitajListuKategorijaUsluga;
import So.SOUcitajListuKlijenata;
import So.SOUcitajListuKozmeticara;
import So.SOUcitajListuUsluga;
import So.SOZapamtiKozmeticara;
import So.SOZapamtiStavkuZakazivanja;
import So.SOZapamtiUslugu;
import So.SOZapamtiZakazivanjeTermina;
import java.util.ArrayList;

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

    public boolean prijavljivanjeKorisnika(OpstiDomenskiObjekat odo) {
        OpstaSistemskaOperacija oso = new SONadjiKorisnikaSistemaPoKorisnickomImenuISifri();
        return oso.izvrsi(odo);
    }
    
    public boolean zapamtiKozmeticara(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SOZapamtiKozmeticara();
        return oso.izvrsi(odo);
    }
    
    public boolean zapamtiUslugu(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SOZapamtiUslugu();
        return oso.izvrsi(odo);
    }
    
    public boolean zapamtiZakazivanjeTermina(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SOZapamtiZakazivanjeTermina();
        return oso.izvrsi(odo);
    }
    
    public boolean zapamtiStavkaZakazivanja(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SOZapamtiStavkuZakazivanja();
        return oso.izvrsi(odo);
    }
    
    public boolean ucitajListuKategorijaUsluga(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SOUcitajListuKategorijaUsluga();
        return oso.izvrsi(odo);
    }
    
    public boolean ucitajListuKlijenata(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SOUcitajListuKlijenata();
        return oso.izvrsi(odo);
    }
    
    public boolean ucitajListuKozmeticara(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SOUcitajListuKozmeticara();
        return oso.izvrsi(odo);
    }
    
    public boolean ucitajListuUsluga(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SOUcitajListuUsluga();
        return oso.izvrsi(odo);
    }
    
    public boolean nadjiKorisnikaSistemaPoKorisnickomImenuISifri(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SONadjiKorisnikaSistemaPoKorisnickomImenuISifri();
        return oso.izvrsi(odo);
    }
    
    public boolean nadjiKozmeticarePoPrezimenu(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SONadjiKozmeticarePoPrezimenu();
        return oso.izvrsi(odo);
    }
    
    public boolean nadjiUslugePoNazivu(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SONadjiUslugePoNazivu();
        return oso.izvrsi(odo);
    }
    
    public boolean nadjiZakazivanjeTerminaPoDatumu(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SONadjiZakazivanjeTerminaPoDatumu();
        return oso.izvrsi(odo);
    }
    
    public boolean nadjiZakazivanjeTerminaPoIdu(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SONadjiZakazivanjeTerminaPoIdu();
        return oso.izvrsi(odo);
    }

    public boolean azurirajKozmeticara(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SOAzurirajKozmeticara();
        return oso.izvrsi(odo);
    }
    
    public boolean azurirajZakazivanjeTermina(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SOAzurirajZakazivanjeTermina();
        return oso.izvrsi(odo);
    }
    
    public boolean obrisiKozmeticara(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SOObrisiKozmeticara();
        return oso.izvrsi(odo);
    }
    
    public boolean obrisiStavkuZakazivanja(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SOObrisiStavkuZakazivanja();
        return oso.izvrsi(odo);
    }
    
    public boolean obrisiUslugu(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SOObrisiUslugu();
        return oso.izvrsi(odo);
    }
    
    public boolean obrisiZakazivanjeTermina(OpstiDomenskiObjekat odo){
        OpstaSistemskaOperacija oso = new SOObrisiZakazivanjeTermina();
        return oso.izvrsi(odo);
    }
    
    
}
