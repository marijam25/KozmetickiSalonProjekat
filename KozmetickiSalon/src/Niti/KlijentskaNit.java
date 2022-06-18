package Niti;

import Domen.KategorijaUsluga;
import Domen.Klijent;
import Domen.KorisnikSistema;
import Domen.Kozmeticar;
import Domen.StavkaZakazivanja;
import Domen.Usluga;
import Domen.ZakazivanjeTermina;
import KlijentskiZahtev.kozmeticar.DodajNovogKozmeticaraZahtev;
import KlijentskiZahtev.usluga.DodajNovuUsluguZahtev;
import KlijentskiZahtev.kozmeticar.ObrisiKozmeticaraZahtev;
import KlijentskiZahtev.usluga.ObrisiUsluguZahtev;
import KlijentskiZahtev.TipoviZahteva;
import KlijentskiZahtev.kozmeticar.IzmeniKozmeticaraZahtev;
import KlijentskiZahtev.usluga.PretraziUslugeZahtev;
import KlijentskiZahtev.korisnikSistema.PrijavljivanjeZahtev;
import KlijentskiZahtev.kozmeticar.VratiKozmeticareZahtev;
import KlijentskiZahtev.zakazivanjeTermina.DodajNovoZakazivanjeZahtev;
import Kontroler.Kontroler;
import ServerskiOdgovor.kozmeticar.DodajNovogKozmeticaraOdgovor;
import ServerskiOdgovor.usluga.DodajNovuUsluguOdgovor;
import ServerskiOdgovor.kozmeticar.ObrisiKozmeticaraOdgovor;
import ServerskiOdgovor.usluga.ObrisiUsluguOdgovor;
import ServerskiOdgovor.kozmeticar.VratiKozmeticareOdgovor;
import ServerskiOdgovor.TipoviOdgovora;
import ServerskiOdgovor.usluga.PretraziUslugeOdgovor;
import ServerskiOdgovor.kozmeticar.IzmeniKozmeticaraOdgovor;
import ServerskiOdgovor.korisnik.PrijavljivanjeOdgovor;
import ServerskiOdgovor.kategorijaUsluga.VratiSveKategorijeUslugaOdgovor;
import ServerskiOdgovor.klijent.VratiSveKlijenteOdgovor;
import ServerskiOdgovor.zakazivanjeTermina.DodajNovoZakazivanjeTerminaOdgovor;
import So.SOAzurirajKozmeticara;
import So.SONadjiKorisnikaSistemaPoKorisnickomImenuISifri;
import So.SOZapamtiKozmeticara;
import So.SOZapamtiUslugu;
import So.SOObrisiKozmeticara;
import So.SOObrisiUslugu;
import So.SONadjiKozmeticarePoPrezimenu;
import So.SONadjiUslugePoNazivu;
import So.SOUcitajListuKategorijaUsluga;
import So.SOUcitajListuKlijenata;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KlijentskaNit extends Thread {
    
    private Socket s;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    
    public KlijentskaNit(Socket s) {
        try {
            this.s = s;
            oos = new ObjectOutputStream(s.getOutputStream());
            ois = new ObjectInputStream(s.getInputStream());
            this.run();
        } catch (IOException ex) {
            Logger.getLogger(KlijentskaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void run() {
        Kontroler kontroler = Kontroler.getInstance();
        while (true) {
            try {
                int tipZahteva = ois.readInt();
                
                switch (tipZahteva) {
                    
                    case TipoviZahteva.DODAJ_NOVOG_KOZMETICARA_ZAHTEV: {
                        DodajNovogKozmeticaraZahtev zahtev = (DodajNovogKozmeticaraZahtev) ois.readObject();
                        
                        boolean uspeo = kontroler.zapamtiKozmeticara(zahtev.getKozmeticar());
                        
                        DodajNovogKozmeticaraOdgovor odgovor = new DodajNovogKozmeticaraOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.DODAJ_NOVOG_KOZMETICARA_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                    
                    case TipoviZahteva.OBRISI_KOZMETICARA_ZAHTEV: {
                        ObrisiKozmeticaraZahtev zahtev = (ObrisiKozmeticaraZahtev) ois.readObject();
                        
                        boolean uspeo = kontroler.obrisiKozmeticara(zahtev.getKozmeticar());
                        
                        ObrisiKozmeticaraOdgovor odgovor = new ObrisiKozmeticaraOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.OBRISI_KOZMETICARA_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                    
                    case TipoviZahteva.DODAJ_NOVU_USLUGU_ZAHTEV: {
                        DodajNovuUsluguZahtev zahtev = (DodajNovuUsluguZahtev) ois.readObject();
                        
                        boolean uspeo = kontroler.zapamtiUslugu(zahtev.getUsluga());
                        
                        DodajNovuUsluguOdgovor odgovor = new DodajNovuUsluguOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.DODAJ_NOVU_USLUGU_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                    
                    case TipoviZahteva.OBRISI_USLUGU_ZAHTEV: {
                        ObrisiUsluguZahtev zahtev = (ObrisiUsluguZahtev) ois.readObject();
                        
                        boolean uspeo = kontroler.obrisiUslugu(zahtev.getUsluga());
                        
                        ObrisiUsluguOdgovor odgovor = new ObrisiUsluguOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.OBRISI_USLUGU_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                    
                    case TipoviZahteva.DODAJ_NOVO_ZAKAZIVANJE_TERMINA_ZAHTEV: {
                        DodajNovoZakazivanjeZahtev zahtev = (DodajNovoZakazivanjeZahtev) ois.readObject();
                        ZakazivanjeTermina zakazivanje = zahtev.getZakazivanje();
                        boolean uspeo = kontroler.zapamtiZakazivanjeTermina(zakazivanje);
                        if(uspeo){
                            int zakazivanjeId = zakazivanje.getZakazivanjeId();
                            List<Usluga> listaUsluga = zahtev.getListaUsluga();
                            
                            for (Usluga usluga : listaUsluga) {
                                StavkaZakazivanja stavka = new StavkaZakazivanja(0, zakazivanjeId, usluga.getUslugaId());
                                uspeo = kontroler.zapamtiStavkaZakazivanja(stavka);
                                if(uspeo==false)
                                    break;
                            }
                        }
                        
                        DodajNovoZakazivanjeTerminaOdgovor odgovor = new DodajNovoZakazivanjeTerminaOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.DODAJ_NOVI_TERMIN_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                    
                    case TipoviZahteva.OBRISI_TERMIN_ZAHTEV: {
                        ObrisiTerminZahtev zahtev = (ObrisiTerminZahtev) ois.readObject();
                        
                        boolean uspeo = c.izvrsiSistemskuOperaciju(new SOObrisiTermin(zahtev.getTermin()));
                        
                        ObrisiTerminOdgovor odgovor = new ObrisiTerminOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.OBRISI_TERMIN_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                    
                    case TipoviZahteva.IZMENI_KOZMETICARA_ZAHTEV: {
                        IzmeniKozmeticaraZahtev zahtev = (IzmeniKozmeticaraZahtev) ois.readObject();
                        
                        boolean uspeo = c.izvrsiSistemskuOperaciju(new SOAzurirajKozmeticara(zahtev.getKozmeticar()));
                        
                        IzmeniKozmeticaraOdgovor odgovor = new IzmeniKozmeticaraOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.IZMENI_KOZMETICARA_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                    
                    case TipoviZahteva.PRETRAZI_USLUGE_ZAHTEV: {
                        PretraziUslugeZahtev zahtev = (PretraziUslugeZahtev) ois.readObject();
                        SONadjiUslugePoNazivu so = new SONadjiUslugePoNazivu(zahtev.getUslov());
                        c.izvrsiSistemskuOperaciju(so);
                        ArrayList<Usluga> nizUsluga = so.getListaUsluga();
                        
                        PretraziUslugeOdgovor odgovor = new PretraziUslugeOdgovor(nizUsluga);
                        oos.writeInt(TipoviOdgovora.PRETRAZI_USLUGE_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                    
                    case TipoviZahteva.IZMENI_TERMIN_ZAHTEV: {
                        IzmeniTerminZahtev zahtev = (IzmeniTerminZahtev) ois.readObject();
                        
                        boolean uspeo = c.izvrsiSistemskuOperaciju(new SOAzurirajTermin(zahtev.getTermin()));
                        
                        IzmeniTerminOdgovor odgovor = new IzmeniTerminOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.IZMENI_TERMIN_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                    
                    case TipoviZahteva.VRATI_KOZMETICARE_ZAHTEV: {
                        VratiKozmeticareZahtev zahtev = (VratiKozmeticareZahtev) ois.readObject();
                        SONadjiKozmeticarePoPrezimenu so = new SONadjiKozmeticarePoPrezimenu(zahtev.getUslov());
                        c.izvrsiSistemskuOperaciju(so);
                        ArrayList<Kozmeticar> listaKozmeticara = so.getListaKozmeticara();
                        
                        VratiKozmeticareOdgovor odgovor = new VratiKozmeticareOdgovor(listaKozmeticara);
                        oos.writeInt(TipoviOdgovora.VRATI_KOZMETICARE_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                    
                    case TipoviZahteva.VRATI_SVE_KATEGORIJE_USLUGA_ZAHTEV: {
                        SOUcitajListuKategorijaUsluga so = new SOUcitajListuKategorijaUsluga();
                        
                        c.izvrsiSistemskuOperaciju(so);
                        
                        ArrayList<KategorijaUsluga> listaKategorijaUsluga = so.getListaKategorijaUsluga();
                        
                        VratiSveKategorijeUslugaOdgovor odgovor = new VratiSveKategorijeUslugaOdgovor(listaKategorijaUsluga);
                        oos.writeInt(TipoviOdgovora.VRATI_SVE_KATEGORIJE_USLUGA_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                    
                    case TipoviZahteva.PRIJAVLJIVANJE_ZAHTEV: {
                        /*PrijavljivanjeZahtev zahtev = (PrijavljivanjeZahtev) ois.readObject();
                        SONadjiKorisnikaSistema so = new SONadjiKorisnikaSistema(zahtev.getKorisnik());
                        c.izvrsiSistemskuOperaciju(so);
                        ArrayList<KorisnikSistema> listaKorisnika = so.getListaKorisnika();
                        //KorisnikSistema k = new KorisnikSistema(0, zahtev.getUslov()., sifra)
                        
                        PrijavljivanjeOdgovor odgovor = new PrijavljivanjeOdgovor(uspesno);
                        oos.writeInt(TipoviOdgovora.PRIJAVLJIVANJE_ODGOVOR);
                        oos.writeObject(odgovor);*/
                        
                        PrijavljivanjeZahtev zahtev = (PrijavljivanjeZahtev) ois.readObject();
                        boolean uspesno = Kontroler.getInstance().prijavljivanjeKorisnika(zahtev.getKorisnik());
                        PrijavljivanjeOdgovor odgovor = new PrijavljivanjeOdgovor(uspesno);
                        oos.writeObject(odgovor);
                        
                        break;
                    }
                    case TipoviZahteva.VRATI_SVE_KLIJENTE_ZAHTEV: {
                        SOUcitajListuKlijenata so = new SOUcitajListuKlijenata();
                        
                        c.izvrsiSistemskuOperaciju(so);
                        
                        ArrayList<Klijent> listaKlijenata = so.getListaKlijenata();
                        
                        VratiSveKlijenteOdgovor odgovor = new VratiSveKlijenteOdgovor(listaKlijenata);
                        oos.writeInt(TipoviOdgovora.VRATI_SVE_KLIJENTE_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                    
                    case TipoviZahteva.VRATI_SVE_TERMINE_ZAHTEV: {
                        VratiTermineZahtev zahtev = (VratiTermineZahtev) ois.readObject();
                        SONadjiTermine so = new SONadjiTermine(zahtev.getDatum());
                        
                        c.izvrsiSistemskuOperaciju(so);
                        ArrayList<Termin> listaTermina = so.getListaTermina();
                        
                        VratiTermineOdgovor odgovor = new VratiTermineOdgovor(listaTermina);
                        oos.writeInt(TipoviOdgovora.VRATI_SVE_TERMINE_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                }
                
            } catch (IOException ex) {
                //Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Klijent disconectovan");
                return;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(KlijentskaNit.class.getName()).log(Level.SEVERE, null, ex);
                return;
            } catch (Exception ex) {
                Logger.getLogger(KlijentskaNit.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }
    }
    
    void prekiniKonekciju() {
        try {
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(KlijentskaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
