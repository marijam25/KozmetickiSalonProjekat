/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import Domen.KorisnikSistema;
import Domen.Kozmeticar;
import Domen.StavkaZakazanogTermina;
import Domen.Usluga;
import Domen.ZakazaniTermin;
import KlijentskiZahtevi.TipoviZahteva;
import KlijentskiZahtevi.ZahteviZaAzuriranje.AzurirajKozmeticaraZahtev;
import KlijentskiZahtevi.ZahteviZaAzuriranje.AzurirajZakazaniTerminZahtev;
import KlijentskiZahtevi.ZahteviZaBrisanje.ObrisiStavkuZakazivanjaZahtev;
import KlijentskiZahtevi.ZahteviZaBrisanje.ObrisiZakazaniTerminZahtev;
import KlijentskiZahtevi.ZahteviZaDodavanje.DodajStavkuZakazivanjaZahtev;
import KlijentskiZahtevi.ZahteviZaDodavanje.DodajZakazaniTerminZahtev;
import KlijentskiZahtevi.ZahteviZaDohvatanje.DohvatiKozmeticarePoPrezimenuZahtev;
import KlijentskiZahtevi.ZahteviZaDohvatanje.DohvatiZakazaneTermineZaKlijentaZahtev;
import KlijentskiZahtevi.ZahteviZaPrijavljivanje.PrijavljivanjeZahtev;
import ServerskiOdgovori.OdgovoriAzuriranje.AzurirajKozmeticaraOdgovor;
import ServerskiOdgovori.OdgovoriAzuriranje.AzurirajZakazaniTerminOdgovor;
import ServerskiOdgovori.OdgovoriBrisanje.ObrisiStavkuZakazivanjaOdgovor;
import ServerskiOdgovori.OdgovoriBrisanje.ObrisiZakazaniTerminOdgovor;
import ServerskiOdgovori.OdgovoriDodavanje.DodajStavkuZakazivanjaOdgovor;
import ServerskiOdgovori.OdgovoriDodavanje.DodajZakazaniTerminOdgovor;
import ServerskiOdgovori.OdgovoriDohvatanje.DohvatiKozmeticarePoPrezimenuOdgovor;
import ServerskiOdgovori.OdgovoriDohvatanje.DohvatiZakazaneTermineZaKlijentaOdgovor;
import ServerskiOdgovori.OdgovoriPrijavljivanje.PrijavljivanjeOdgovor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import komunikacija.KomunikacijaSaServerom;

/**
 *
 * @author milic
 */
public class KontrolerKI {

    private static KontrolerKI instance;
    ObjectOutputStream oos = KomunikacijaSaServerom.getInstanca().getOos();
    ObjectInputStream ois = KomunikacijaSaServerom.getInstanca().getOis();

    private KontrolerKI() {
    }

    public static KontrolerKI getInstance() {
        if (instance == null) {
            instance = new KontrolerKI();
        }
        return instance;
    }

    public void prijaviKorisnikaZahtev(KorisnikSistema korisnik) throws IOException {
        PrijavljivanjeZahtev zahtev = new PrijavljivanjeZahtev(korisnik);
        oos.writeInt(TipoviZahteva.PRIJAVLJIVANJE_ZAHTEV);
        oos.writeObject(zahtev);
        oos.flush();
    }

    public boolean prijaviKorisnikaOdgovor() throws IOException, ClassNotFoundException {
        PrijavljivanjeOdgovor odgovor = (PrijavljivanjeOdgovor) ois.readObject();
        return odgovor.isUspeo();
    }

    public void dohvatiKozmeticarePoPrezimenuZahtev(Kozmeticar k) throws IOException {
        DohvatiKozmeticarePoPrezimenuZahtev zahtev = new DohvatiKozmeticarePoPrezimenuZahtev(k);
        oos.writeInt(TipoviZahteva.DOHVATI_KOZMETICARE_PO_PREZIMENU_ZAHTEV);
        oos.writeObject(zahtev);
        oos.flush();
    }

    public List<Kozmeticar> dohvatiKozmeticarePoPrezimenuOdgovor() throws IOException, ClassNotFoundException {
        DohvatiKozmeticarePoPrezimenuOdgovor odgovor = (DohvatiKozmeticarePoPrezimenuOdgovor) ois.readObject();
        return odgovor.getListaKozmeticara();
    }

    public void dohvatiZakazaneTermineZaKlijentaZahtev(ZakazaniTermin zakazaniTermin) throws IOException {
        DohvatiZakazaneTermineZaKlijentaZahtev zahtev = new DohvatiZakazaneTermineZaKlijentaZahtev(zakazaniTermin);
        oos.writeInt(TipoviZahteva.DOHVATI_ZAKAZANE_TERMINE_ZA_KLIJENTA_ZAHTEV);
        oos.writeObject(zahtev);
        oos.flush();
    }

    public List<ZakazaniTermin> dohvatiZakazaneTermineZaKlijentaOdgovor() throws IOException, ClassNotFoundException {
        DohvatiZakazaneTermineZaKlijentaOdgovor odgovor = (DohvatiZakazaneTermineZaKlijentaOdgovor) ois.readObject();
        return odgovor.getListaZakazanihTermina();
    }

    public void azurirajKozmeticaraZahtev(Kozmeticar kozmeticar) throws IOException {
        AzurirajKozmeticaraZahtev zahtev = new AzurirajKozmeticaraZahtev(kozmeticar);
        oos.writeInt(TipoviZahteva.AZURIRAJ_KOZMETICARA_ZAHTEV);
        oos.writeObject(zahtev);
    }

    public boolean azurirajKozmeticaraOdgovor() throws IOException, ClassNotFoundException {
        AzurirajKozmeticaraOdgovor odgovor = (AzurirajKozmeticaraOdgovor) ois.readObject();
        return odgovor.isUspeo();
    }

    public void azurirajZakazaniTerminZahtev(ZakazaniTermin zakazaniTermin) throws IOException {
        AzurirajZakazaniTerminZahtev zahtev = new AzurirajZakazaniTerminZahtev(zakazaniTermin);
        oos.writeInt(TipoviZahteva.AZURIRAJ_ZAKAZANI_TERMIN_ZAHTEV);
        oos.writeObject(zahtev);
    }

    public boolean azurirajZakazaniTerminOdgovor() throws IOException, ClassNotFoundException {
        AzurirajZakazaniTerminOdgovor odgovor = (AzurirajZakazaniTerminOdgovor) ois.readObject();
        return odgovor.isUspeo();
    }

    public void dodajStavkuZahtev(StavkaZakazanogTermina s) throws IOException {
        DodajStavkuZakazivanjaZahtev zahtev = new DodajStavkuZakazivanjaZahtev(s);
        oos.writeInt(TipoviZahteva.DODAJ_STAVKU_ZAKAZIVANJA_ZAHTEV);
        oos.writeObject(zahtev);
    }

    public boolean dodajStavkuOdgovor() throws IOException, ClassNotFoundException {
        DodajStavkuZakazivanjaOdgovor odgovor = (DodajStavkuZakazivanjaOdgovor) ois.readObject();
        return odgovor.isUspeo();
    }

    public void obrisiStavkuZahtev(StavkaZakazanogTermina s) throws IOException {
        ObrisiStavkuZakazivanjaZahtev zahtev = new ObrisiStavkuZakazivanjaZahtev(s);
        oos.writeInt(TipoviZahteva.OBRISI_STAVKU_ZAKAZIVANJA_ZAHTEV);
        oos.writeObject(zahtev);
    }

    public boolean obrisiStavkuOdgovor() throws IOException, ClassNotFoundException {
        ObrisiStavkuZakazivanjaOdgovor odgovor = (ObrisiStavkuZakazivanjaOdgovor) ois.readObject();
        return odgovor.isUspeo();
    }

    public void brisanjeZakazanogTerminaZahtev(ZakazaniTermin zakazaniTermin) throws IOException {
        ObrisiZakazaniTerminZahtev zahtev = new ObrisiZakazaniTerminZahtev(zakazaniTermin);
        oos.writeInt(TipoviZahteva.OBRISI_ZAKAZANI_TERMIN_ZAHTEV);
        oos.writeObject(zahtev);
    }

    public boolean brisanjeZakazanogTerminaOdgovor() throws IOException, ClassNotFoundException {
        ObrisiZakazaniTerminOdgovor odgovor = (ObrisiZakazaniTerminOdgovor) ois.readObject();
        return odgovor.isUspeo();
    }

    public void dodajZakazaniTerminZahtev(ZakazaniTermin z, List<Usluga> listaUsluga) throws IOException {
        DodajZakazaniTerminZahtev dztz = new DodajZakazaniTerminZahtev(z, listaUsluga);

        oos.writeInt(TipoviZahteva.DODAJ_ZAKAZANI_TERMIN_ZAHTEV);
        oos.writeObject(dztz);
    }
    
    public boolean dodajZakazaniTerminOdgovor() throws IOException, ClassNotFoundException{
        DodajZakazaniTerminOdgovor odgovor = (DodajZakazaniTerminOdgovor) ois.readObject();
        return odgovor.isUspeo();
    }
}
