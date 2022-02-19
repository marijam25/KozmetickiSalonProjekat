package Niti;

import Domen.KategorijaUsluga;
import Domen.Klijent;
import Domen.Kozmeticar;
import Domen.OpstiDomenskiObjekat;
import Domen.Termin;
import Domen.Usluga;
import KlijentskiZahtev.DodajNoviTerminZahtev;
import KlijentskiZahtev.DodajNovogKlijentaZahtev;
import KlijentskiZahtev.DodajNovogKozmeticaraZahtev;
import KlijentskiZahtev.DodajNovuUsluguZahtev;
import KlijentskiZahtev.ObrisiTerminZahtev;
import KlijentskiZahtev.ObrisiKozmeticaraZahtev;
import KlijentskiZahtev.ObrisiUsluguZahtev;
import KlijentskiZahtev.TipoviZahteva;
import KlijentskiZahtev.IzmeniTerminZahtev;
import KlijentskiZahtev.IzmeniKozmeticaraZahtev;
import KlijentskiZahtev.PretraziUslugeZahtev;
import KlijentskiZahtev.PrijavljivanjeZahtev;
import KlijentskiZahtev.VratiKozmeticareZahtev;
import KlijentskiZahtev.VratiTermineZahtev;
import Kontroler.Kontroler;
import ServerskiOdgovor.DodajNoviTerminOdgovor;
import ServerskiOdgovor.DodajNovogKlijentaOdgovor;
import ServerskiOdgovor.DodajNovogKozmeticaraOdgovor;
import ServerskiOdgovor.DodajNovuUsluguOdgovor;
import ServerskiOdgovor.ObrisiTerminOdgovor;
import ServerskiOdgovor.ObrisiKozmeticaraOdgovor;
import ServerskiOdgovor.ObrisiUsluguOdgovor;
import ServerskiOdgovor.VratiKozmeticareOdgovor;
import ServerskiOdgovor.TipoviOdgovora;
import ServerskiOdgovor.PretraziUslugeOdgovor;
import ServerskiOdgovor.IzmeniTerminOdgovor;
import ServerskiOdgovor.IzmeniKozmeticaraOdgovor;
import ServerskiOdgovor.PrijavljivanjeOdgovor;
import ServerskiOdgovor.VratiSveKategorijeUslugaOdgovor;
import ServerskiOdgovor.VratiSveKlijenteOdgovor;
import ServerskiOdgovor.VratiTermineOdgovor;
import So.SOAzurirajKozmeticara;
import So.SOAzurirajTermin;
import So.SODodajNoviTermin;
import So.SODodajNovogKlijenta;
import So.SODodajNovogKozmeticara;
import So.SODodajNovuUslugu;
import So.SOObrisiKozmeticara;
import So.SOObrisiTermin;
import So.SOObrisiUslugu;
import So.SOPretraziKozmeticare;
import So.SOPretraziTermine;
import So.SOPretraziUsluge;
import So.SOVratiSveKategorijeUsluga;
import So.SOVratiSveKlijente;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
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
        Kontroler c = Kontroler.getInstance();
        while (true) {
            try {
                int tipZahteva = ois.readInt();
                
                switch (tipZahteva) {
                    case TipoviZahteva.DODAJ_NOVOG_KLIJENTA_ZAHTEV: {
                        DodajNovogKlijentaZahtev zahtev = (DodajNovogKlijentaZahtev) ois.readObject();
                        
                        boolean uspeo = c.izvrsiSistemskuOperaciju(new SODodajNovogKlijenta(zahtev.getKlijent()));
                        
                        DodajNovogKlijentaOdgovor odgovor = new DodajNovogKlijentaOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.DODAJ_NOVOG_KLIJENTA_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                    
                    case TipoviZahteva.DODAJ_NOVOG_KOZMETICARA_ZAHTEV: {
                        DodajNovogKozmeticaraZahtev zahtev = (DodajNovogKozmeticaraZahtev) ois.readObject();
                        
                        boolean uspeo = c.izvrsiSistemskuOperaciju(new SODodajNovogKozmeticara(zahtev.getKozmeticar()));
                        
                        DodajNovogKozmeticaraOdgovor odgovor = new DodajNovogKozmeticaraOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.DODAJ_NOVOG_KOZMETICARA_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                    
                    case TipoviZahteva.OBRISI_KOZMETICARA_ZAHTEV: {
                        ObrisiKozmeticaraZahtev zahtev = (ObrisiKozmeticaraZahtev) ois.readObject();
                        
                        boolean uspeo = c.izvrsiSistemskuOperaciju(new SOObrisiKozmeticara(zahtev.getKozmeticar()));
                        
                        ObrisiKozmeticaraOdgovor odgovor = new ObrisiKozmeticaraOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.OBRISI_KOZMETICARA_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                    
                    case TipoviZahteva.DODAJ_NOVU_USLUGU_ZAHTEV: {
                        DodajNovuUsluguZahtev zahtev = (DodajNovuUsluguZahtev) ois.readObject();
                        
                        boolean uspeo = c.izvrsiSistemskuOperaciju(new SODodajNovuUslugu(zahtev.getUsluga()));
                        
                        DodajNovuUsluguOdgovor odgovor = new DodajNovuUsluguOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.DODAJ_NOVU_USLUGU_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                    
                    case TipoviZahteva.OBRISI_USLUGU_ZAHTEV: {
                        ObrisiUsluguZahtev zahtev = (ObrisiUsluguZahtev) ois.readObject();
                        
                        boolean uspeo = c.izvrsiSistemskuOperaciju(new SOObrisiUslugu(zahtev.getUsluga()));
                        
                        ObrisiUsluguOdgovor odgovor = new ObrisiUsluguOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.OBRISI_USLUGU_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                    
                    case TipoviZahteva.DODAJ_NOVI_TERMIN_ZAHTEV: {
                        DodajNoviTerminZahtev zahtev = (DodajNoviTerminZahtev) ois.readObject();
                        SODodajNoviTermin so = new SODodajNoviTermin(zahtev.getStavkaZakazivanja(), zahtev.getZakazivanjeTermina(), zahtev.getTermin());
                        c.izvrsiSistemskuOperaciju(so);
                        boolean uspeo = so.isOperacijaUspesnoIzvrsena();
                        DodajNoviTerminOdgovor odgovor = new DodajNoviTerminOdgovor(uspeo);
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
                        SOPretraziUsluge so = new SOPretraziUsluge(zahtev.getUslov());
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
                        SOPretraziKozmeticare so = new SOPretraziKozmeticare(zahtev.getUslov());
                        c.izvrsiSistemskuOperaciju(so);
                        ArrayList<Kozmeticar> listaKozmeticara = so.getListaKozmeticara();
                        
                        VratiKozmeticareOdgovor odgovor = new VratiKozmeticareOdgovor(listaKozmeticara);
                        oos.writeInt(TipoviOdgovora.VRATI_KOZMETICARE_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                    
                    case TipoviZahteva.VRATI_SVE_KATEGORIJE_USLUGA_ZAHTEV: {
                        SOVratiSveKategorijeUsluga so = new SOVratiSveKategorijeUsluga();
                        
                        c.izvrsiSistemskuOperaciju(so);
                        
                        ArrayList<KategorijaUsluga> listaKategorijaUsluga = so.getListaKategorijaUsluga();
                        
                        VratiSveKategorijeUslugaOdgovor odgovor = new VratiSveKategorijeUslugaOdgovor(listaKategorijaUsluga);
                        oos.writeInt(TipoviOdgovora.VRATI_SVE_KATEGORIJE_USLUGA_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                    
                    case TipoviZahteva.PRIJAVLJIVANJE_ZAHTEV: {
                        PrijavljivanjeZahtev zahtev = (PrijavljivanjeZahtev) ois.readObject();
                        
                        boolean uspesno = c.prijavljivanje(zahtev.getKorisnickoIme(), zahtev.getSifra());
                        
                        PrijavljivanjeOdgovor odgovor = new PrijavljivanjeOdgovor(uspesno);
                        oos.writeInt(TipoviOdgovora.PRIJAVLJIVANJE_ODGOVOR);
                        oos.writeObject(odgovor);
                        
                        break;
                    }
                    case TipoviZahteva.VRATI_SVE_KLIJENTE_ZAHTEV: {
                        SOVratiSveKlijente so = new SOVratiSveKlijente();
                        
                        c.izvrsiSistemskuOperaciju(so);
                        
                        ArrayList<Klijent> listaKlijenata = so.getListaKlijenata();
                        
                        VratiSveKlijenteOdgovor odgovor = new VratiSveKlijenteOdgovor(listaKlijenata);
                        oos.writeInt(TipoviOdgovora.VRATI_SVE_KLIJENTE_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                    
                    case TipoviZahteva.VRATI_SVE_TERMINE_ZAHTEV: {
                        VratiTermineZahtev zahtev = (VratiTermineZahtev) ois.readObject();
                        SOPretraziTermine so = new SOPretraziTermine(zahtev.getDatum());
                        
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
