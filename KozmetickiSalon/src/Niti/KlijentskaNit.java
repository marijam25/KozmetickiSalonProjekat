/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Niti;

import Domen.KategorijaUsluga;
import Domen.Kozmeticar;
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
import Kontroler.Kontroler;
import ServerskiOdgovor.DodajNoviTerminOdgovor;
import ServerskiOdgovor.DodajNovogKlijentaOdgovor;
import ServerskiOdgovor.DodajNovogKozmeticaraOdgovor;
import ServerskiOdgovor.DodajNovuUsluguOdgovor;
import ServerskiOdgovor.ObrisiTerminOdgovor;
import ServerskiOdgovor.ObrisiKozmeticaraOdgovor;
import ServerskiOdgovor.ObrisiUsluguOdgovor;
import ServerskiOdgovor.VratiSveKozmeticareOdgovor;
import ServerskiOdgovor.TipoviOdgovora;
import ServerskiOdgovor.PretraziUslugeOdgovor;
import ServerskiOdgovor.IzmeniTerminOdgovor;
import ServerskiOdgovor.IzmeniKozmeticaraOdgovor;
import ServerskiOdgovor.VratiSveKategorijeUslugaOdgovor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author milic
 */
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

                        boolean uspeo = c.dodajNovogKlijenta(zahtev.getKlijent());

                        DodajNovogKlijentaOdgovor odgovor = new DodajNovogKlijentaOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.DODAJ_NOVOG_KLIJENTA_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.DODAJ_NOVOG_KOZMETICARA_ZAHTEV: {
                        DodajNovogKozmeticaraZahtev zahtev = (DodajNovogKozmeticaraZahtev) ois.readObject();

                        boolean uspeo = c.dodajNovogKozmeticara(zahtev.getKozmeticar());

                        DodajNovogKozmeticaraOdgovor odgovor = new DodajNovogKozmeticaraOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.DODAJ_NOVOG_KOZMETICARA_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.OBRISI_KOZMETICARA_ZAHTEV: {
                        ObrisiKozmeticaraZahtev zahtev = (ObrisiKozmeticaraZahtev) ois.readObject();

                        boolean uspeo = c.obrisiKozmeticara(zahtev.getKozmeticar());

                        ObrisiKozmeticaraOdgovor odgovor = new ObrisiKozmeticaraOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.OBRISI_KOZMETICARA_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.DODAJ_NOVU_USLUGU_ZAHTEV: {
                        DodajNovuUsluguZahtev zahtev = (DodajNovuUsluguZahtev) ois.readObject();

                        boolean uspeo = c.dodajNovuUslugu(zahtev.getUsluga());

                        DodajNovuUsluguOdgovor odgovor = new DodajNovuUsluguOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.DODAJ_NOVU_USLUGU_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.OBRISI_USLUGU_ZAHTEV: {
                        ObrisiUsluguZahtev zahtev = (ObrisiUsluguZahtev) ois.readObject();

                        boolean uspeo = c.obrisiUslugu(zahtev.getUsluga());

                        ObrisiUsluguOdgovor odgovor = new ObrisiUsluguOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.OBRISI_USLUGU_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.DODAJ_NOVI_TERMIN_ZAHTEV: {
                        DodajNoviTerminZahtev zahtev = (DodajNoviTerminZahtev) ois.readObject();

                        boolean uspeo = c.dodajNoviTermin(zahtev.getTermin());

                        DodajNoviTerminOdgovor odgovor = new DodajNoviTerminOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.DODAJ_NOVI_TERMIN_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.OBRISI_TERMIN_ZAHTEV: {
                        ObrisiTerminZahtev zahtev = (ObrisiTerminZahtev) ois.readObject();

                        boolean uspeo = c.obrisiTermin(zahtev.getTermin());

                        ObrisiTerminOdgovor odgovor = new ObrisiTerminOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.OBRISI_TERMIN_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.IZMENI_KOZMETICARA_ZAHTEV: {
                        IzmeniKozmeticaraZahtev zahtev = (IzmeniKozmeticaraZahtev) ois.readObject();

                        boolean uspeo = c.azurirajKozmeticara(zahtev.getKozmeticar());

                        IzmeniKozmeticaraOdgovor odgovor = new IzmeniKozmeticaraOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.IZMENI_KOZMETICARA_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.PRETRAZI_USLUGE_ZAHTEV: {
                        //SearchServiceRequest request = (SearchServiceRequest) ois.readObject();

                        ArrayList<Usluga> nizUsluga = c.pretraziUsluge();

                        PretraziUslugeOdgovor odgovor = new PretraziUslugeOdgovor(nizUsluga);
                        oos.writeInt(TipoviOdgovora.PRETRAZI_USLUGE_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.IZMENI_TERMIN_ZAHTEV: {
                        IzmeniTerminZahtev zahtev = (IzmeniTerminZahtev) ois.readObject();

                        boolean uspeo = c.azurirajTermin(zahtev.getTermin());

                        IzmeniTerminOdgovor odgovor = new IzmeniTerminOdgovor(uspeo);
                        oos.writeInt(TipoviOdgovora.IZMENI_TERMIN_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.VRATI_SVE_KOZMETICARE_ZAHTEV: {
                        ArrayList<Kozmeticar> listaKozmeticara = c.vratiSveKozmeticare();

                        VratiSveKozmeticareOdgovor odgovor = new VratiSveKozmeticareOdgovor(listaKozmeticara);
                        oos.writeInt(TipoviOdgovora.VRATI_SVE_KOZMETICARE_ODGOVOR);
                        oos.writeObject(odgovor);
                        break;
                    }
                    
                    case TipoviZahteva.VRATI_SVE_KATEGORIJE_USLUGA_ZAHTEV:{
                        ArrayList<KategorijaUsluga> listaKategorijaUsluga = c.vratiSveKategorijeUsluga();
                        
                        VratiSveKategorijeUslugaOdgovor odgovor = new VratiSveKategorijeUslugaOdgovor(listaKategorijaUsluga);
                        oos.writeInt(TipoviOdgovora.VRATI_SVE_KATEGORIJE_USLUGA_ODGOVOR);
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
            } catch(Exception ex){
                //Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Klijent disconectovan");
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
