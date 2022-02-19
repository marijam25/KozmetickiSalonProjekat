package Kontroler;

import Domen.KategorijaUsluga;
import Domen.Klijent;
import Domen.KorisnikSistema;
import Domen.Kozmeticar;
import Domen.StavkaZakazivanja;
import Domen.Termin;
import Domen.Usluga;
import Domen.ZakazivanjeTermina;
import db.DBBroker;
import db.KategorijaUslugaDBInterface;
import db.KlijentDBInterface;
import db.KozmeticarDBInterface;
import db.TerminDBInterface;
import db.UslugaDBInterface;
import db.StavkaZakazivanjaDBInterface;
import db.ZakazivanjeTerminaDBInterface;
import java.util.ArrayList;
import java.util.Date;

public class Kontroler {

    private static Kontroler instance;
    private DBBroker broker;
    private KlijentDBInterface klijentDBinterfejs;
    private KozmeticarDBInterface kozmeticarDBInterface;
    private UslugaDBInterface uslugaDBInterface;
    private TerminDBInterface terminDBInterface;
    private KategorijaUslugaDBInterface kategorijaUslugaDBInterface;
    private ZakazivanjeTerminaDBInterface zakazivanjeTerminaDBInterface;
    private StavkaZakazivanjaDBInterface stavkaZakazivanjaDBInterface;
    private ArrayList<KorisnikSistema> listaKorisnikaSistema;
    private KlijentDBInterface klijentDBInterface;

    private Kontroler() {
        broker = new DBBroker();
        klijentDBinterfejs = new KlijentDBInterface(broker);
        kozmeticarDBInterface = new KozmeticarDBInterface(broker);
        uslugaDBInterface = new UslugaDBInterface(broker);
        terminDBInterface = new TerminDBInterface(broker);
        kategorijaUslugaDBInterface = new KategorijaUslugaDBInterface(broker);
        zakazivanjeTerminaDBInterface = new ZakazivanjeTerminaDBInterface(broker);
        stavkaZakazivanjaDBInterface = new StavkaZakazivanjaDBInterface(broker);
        klijentDBInterface = new KlijentDBInterface(broker);
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

    public boolean dodajNovogKlijenta(Klijent klijent) {
        boolean uspeo = klijentDBinterfejs.dodaj(klijent);
        return uspeo;
    }

    public boolean dodajNovogKozmeticara(Kozmeticar kozmeticar) {
        boolean uspeo = kozmeticarDBInterface.dodaj(kozmeticar);
        return uspeo;
    }

    public boolean obrisiKozmeticara(Kozmeticar kozmeticar) {
        boolean uspeo = kozmeticarDBInterface.obrisi(kozmeticar);
        return uspeo;
    }

    public boolean dodajNovuUslugu(Usluga usluga) {
        boolean uspeo = uslugaDBInterface.dodaj(usluga);
        return uspeo;
    }

    public boolean obrisiUslugu(Usluga usluga) {
        boolean uspeo = uslugaDBInterface.obrisi(usluga);
        return uspeo;
    }

    public boolean obrisiTermin(Termin termin) {
        boolean uspeo = terminDBInterface.obrisi(termin);
        return uspeo;
    }

    public boolean azurirajKozmeticara(Kozmeticar kozmeticar) {
        boolean uspeo = kozmeticarDBInterface.izmeni(kozmeticar);
        return uspeo;
    }

    public ArrayList<KategorijaUsluga> vratiSveKategorijeUsluga() {
        ArrayList<KategorijaUsluga> listaKategorijaUsluga = (ArrayList<KategorijaUsluga>) kategorijaUslugaDBInterface.vratiSve();
        return listaKategorijaUsluga;
    }

    public boolean prijavljivanje(String korisnickoIme, String sifra) {
        for (KorisnikSistema korisnikSistema : listaKorisnikaSistema) {
            if (korisnikSistema.getKorisnickoIme().equals(korisnickoIme) && korisnikSistema.getSifra().equals(sifra)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Usluga> pretraziUsluge(String uslov) {
        String whereUslov = "";
        if (!uslov.equals("")) {
            whereUslov += " NazivUsluge like '" + uslov + "%'";
        }

        ArrayList<Usluga> nizUsluga = (ArrayList<Usluga>) uslugaDBInterface.vratiSve(whereUslov);
        return nizUsluga;
    }

    public ArrayList<Klijent> vratiSveKlijente() {
        ArrayList<Klijent> listaKlijenata = (ArrayList<Klijent>) klijentDBInterface.vratiSve();
        return listaKlijenata;
    }

    public boolean dodajNoviTermin(Termin termin, StavkaZakazivanja stavkaZakazivanja, ZakazivanjeTermina zakazivanjeTermina) {
        boolean uspeoTermin = terminDBInterface.dodaj(termin);
        if (!uspeoTermin) {
            return false;
        }

        boolean uspeloZakazivanje = zakazivanjeTerminaDBInterface.dodaj(zakazivanjeTermina);
        if (!uspeloZakazivanje) {
            return false;
        }

        boolean uspelaStavka = stavkaZakazivanjaDBInterface.dodaj(stavkaZakazivanja);
        if (!uspelaStavka) {
            return false;
        }

        return true;
    }

    public ArrayList<Kozmeticar> vratiKozmeticare(String uslov) {
        String whereUslov = "";
        if (!uslov.equals("")) {
            whereUslov += " Prezime like '" + uslov + "%'";
        }

        ArrayList<Kozmeticar> listaKozmeticara = (ArrayList<Kozmeticar>) kozmeticarDBInterface.vratiSve(whereUslov);
        return listaKozmeticara;
    }

    public ArrayList<Termin> vratiTermine(Date datum) {
        String whereUslov = "";
        if (datum != null) {
            java.sql.Date sqlDate = new java.sql.Date(datum.getTime());
            String datum1 = sqlDate.toString();
            whereUslov += " datumTermina = " + "'" + datum1 + "'";
        }

        ArrayList<Termin> listaTermina = (ArrayList<Termin>) terminDBInterface.vratiSve(whereUslov);
        return listaTermina;
    }

    public boolean azurirajTermin(Termin termin) {
        boolean uspeoTermin = terminDBInterface.izmeni(termin);
        if (!uspeoTermin) {
            return false;
        }

        return true;
    }

}
