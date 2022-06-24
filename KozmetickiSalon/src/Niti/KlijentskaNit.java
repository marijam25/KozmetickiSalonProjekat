package Niti;

import Domen.*;
import KlijentskiZahtevi.TipoviZahteva;
import KlijentskiZahtevi.ZahteviZaAzuriranje.*;
import KlijentskiZahtevi.ZahteviZaBrisanje.*;
import KlijentskiZahtevi.ZahteviZaDodavanje.*;
import KlijentskiZahtevi.ZahteviZaDohvatanje.*;
import KlijentskiZahtevi.ZahteviZaPrijavljivanje.PrijavljivanjeZahtev;
import Kontroler.Kontroler;
import ServerskiOdgovori.OdgovoriAzuriranje.*;
import ServerskiOdgovori.OdgovoriBrisanje.*;
import ServerskiOdgovori.OdgovoriDodavanje.*;
import ServerskiOdgovori.OdgovoriDohvatanje.*;
import ServerskiOdgovori.OdgovoriPrijavljivanje.PrijavljivanjeOdgovor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
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

                    // ----------------------------------------------------------------------------------------
                    // Zahtevi za prijavljivanje
                    // ----------------------------------------------------------------------------------------
                    case TipoviZahteva.PRIJAVLJIVANJE_ZAHTEV: {
                        PrijavljivanjeZahtev zahtev = (PrijavljivanjeZahtev) ois.readObject();
                        boolean uspesno = kontroler.prijavljivanjeKorisnika(zahtev.getKorisnik());

                        PrijavljivanjeOdgovor odgovor = new PrijavljivanjeOdgovor(uspesno);
                        
                        oos.writeObject(odgovor);
                        break;
                    }

                    // ----------------------------------------------------------------------------------------
                    // Zahtevi za dodavanje
                    // ----------------------------------------------------------------------------------------
                    case TipoviZahteva.DODAJ_KOZMETICARA_ZAHTEV: {
                        DodajKozmeticaraZahtev zahtev = (DodajKozmeticaraZahtev) ois.readObject();
                        boolean uspeo = kontroler.dodajKozmeticara(zahtev.getKozmeticar());

                        DodajKozmeticaraOdgovor odgovor = new DodajKozmeticaraOdgovor(uspeo);
                        
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.DODAJ_USLUGU_ZAHTEV: {
                        DodajUsluguZahtev zahtev = (DodajUsluguZahtev) ois.readObject();
                        boolean uspeo = kontroler.dodajUslugu(zahtev.getUsluga());

                        DodajUsluguOdgovor odgovor = new DodajUsluguOdgovor(uspeo);
                        
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.DODAJ_ZAKAZANI_TERMIN_ZAHTEV: {
                        DodajZakazaniTerminZahtev zahtev = (DodajZakazaniTerminZahtev) ois.readObject();
                        ZakazaniTermin zakazaniTermin = zahtev.getZakazaniTermin();
                        boolean uspeo = kontroler.dodajZakazaniTermin(zakazaniTermin);
                        if (uspeo) {
                            int zakazaniTerminId = zakazaniTermin.getZakazaniTerminId();
                            List<Usluga> listaUsluga = zahtev.getListaUsluga();

                            for (Usluga usluga : listaUsluga) {
                                StavkaZakazanogTermina stavka = new StavkaZakazanogTermina(0, zakazaniTerminId, usluga.getUslugaId());
                                uspeo = kontroler.dodajStavkuZakazanogTermina(stavka);
                                if (uspeo == false) {
                                    break;
                                }
                            }
                        }

                        DodajZakazaniTerminOdgovor odgovor = new DodajZakazaniTerminOdgovor(uspeo);
                        
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.DODAJ_STAVKU_ZAKAZIVANJA_ZAHTEV: {
                        DodajStavkuZakazivanjaZahtev zahtev = (DodajStavkuZakazivanjaZahtev) ois.readObject();
                        boolean uspeo = kontroler.dodajStavkuZakazanogTermina(zahtev.getStavka());

                        DodajStavkuZakazivanjaOdgovor odgovor = new DodajStavkuZakazivanjaOdgovor(uspeo);
                       
                        oos.writeObject(odgovor);
                        break;
                    }

                    // ----------------------------------------------------------------------------------------
                    // Zahtevi za azuriranje
                    // ----------------------------------------------------------------------------------------
                    case TipoviZahteva.AZURIRAJ_KOZMETICARA_ZAHTEV: {
                        AzurirajKozmeticaraZahtev zahtev = (AzurirajKozmeticaraZahtev) ois.readObject();
                        boolean uspeo = kontroler.azurirajKozmeticara(zahtev.getKozmeticar());

                        AzurirajKozmeticaraOdgovor odgovor = new AzurirajKozmeticaraOdgovor(uspeo);
                        
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.AZURIRAJ_ZAKAZANI_TERMIN_ZAHTEV: {
                        AzurirajZakazaniTerminZahtev zahtev = (AzurirajZakazaniTerminZahtev) ois.readObject();
                        boolean uspeo = kontroler.azurirajZakazaniTermin(zahtev.getZakazaniTermin());

                        AzurirajZakazaniTerminOdgovor odgovor = new AzurirajZakazaniTerminOdgovor(uspeo);
                        
                        oos.writeObject(odgovor);
                        break;
                    }

                    // ----------------------------------------------------------------------------------------
                    // Zahtevi za brisanje
                    // ----------------------------------------------------------------------------------------
                    case TipoviZahteva.OBRISI_KOZMETICARA_ZAHTEV: {
                        ObrisiKozmeticaraZahtev zahtev = (ObrisiKozmeticaraZahtev) ois.readObject();
                        boolean uspeo = kontroler.obrisiKozmeticara(zahtev.getKozmeticar());

                        ObrisiKozmeticaraOdgovor odgovor = new ObrisiKozmeticaraOdgovor(uspeo);
                        
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.OBRISI_USLUGU_ZAHTEV: {
                        ObrisiUsluguZahtev zahtev = (ObrisiUsluguZahtev) ois.readObject();
                        boolean uspeo = kontroler.obrisiUslugu(zahtev.getUsluga());

                        ObrisiUsluguOdgovor odgovor = new ObrisiUsluguOdgovor(uspeo);
                        
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.OBRISI_ZAKAZANI_TERMIN_ZAHTEV: {
                        ObrisiZakazaniTerminZahtev zahtev = (ObrisiZakazaniTerminZahtev) ois.readObject();
                        ZakazaniTermin zt = zahtev.getZakazaniTermin();
                        StavkaZakazanogTermina szt = new StavkaZakazanogTermina(0, zt.getZakazaniTerminId(), 0);

                        boolean uspeo = kontroler.obrisiSveStavkeZakazanogTermina(szt);
                        if (uspeo) {
                            // ako je uspeo da obrise stavke onda moze da obrise i zakazni termin
                            uspeo = kontroler.obrisiZakazaniTermin(zt);
                        }

                        ObrisiZakazaniTerminOdgovor odgovor = new ObrisiZakazaniTerminOdgovor(uspeo);
                        
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.OBRISI_STAVKU_ZAKAZIVANJA_ZAHTEV: {
                        ObrisiStavkuZakazivanjaZahtev zahtev = (ObrisiStavkuZakazivanjaZahtev) ois.readObject();
                        boolean uspeo = kontroler.obrisiStavkuZakaznogTermina(zahtev.getStavka());

                        ObrisiStavkuZakazivanjaOdgovor odgovor = new ObrisiStavkuZakazivanjaOdgovor(uspeo);
                        
                        oos.writeObject(odgovor);
                        break;
                    }

                    // ----------------------------------------------------------------------------------------
                    // Zahtevi za dohvatanje
                    // ----------------------------------------------------------------------------------------
                    case TipoviZahteva.DOHVATI_KOZMETICARE_PO_PREZIMENU_ZAHTEV: {
                        DohvatiKozmeticarePoPrezimenuZahtev zahtev = (DohvatiKozmeticarePoPrezimenuZahtev) ois.readObject();
                        List<Kozmeticar> listaKozmeticara = kontroler.dohvatiKozmeticarePoPrezimenu(zahtev.getKozmeticar());

                        DohvatiKozmeticarePoPrezimenuOdgovor odgovor = new DohvatiKozmeticarePoPrezimenuOdgovor(listaKozmeticara);
                        
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.DOHVATI_SVE_KATEGORIJE_USLUGA_ZAHTEV: {
                        KategorijaUsluga k = new KategorijaUsluga();
                        List<KategorijaUsluga> listaKategorijaUsluga = kontroler.dohvatiKategorijeUsluga(k);

                        DohvatiSveKategorijeUslugaOdgovor odgovor = new DohvatiSveKategorijeUslugaOdgovor(listaKategorijaUsluga);
                        
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.DOHVATI_SVE_KLIJENTE_ZAHTEV: {
                        Klijent k = new Klijent();
                        List<Klijent> listaKlijenata = kontroler.dohvatiKlijente(k);

                        DohvatiSveKlijenteOdgovor odgovor = new DohvatiSveKlijenteOdgovor(listaKlijenata);
                        
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.DOHVATI_USLUGU_PO_NAZIVU_ZAHTEV: {
                        DohvatiUsluguPoNazivuZahtev zahtev = (DohvatiUsluguPoNazivuZahtev) ois.readObject();
                        List<Usluga> lsitaUsluga = kontroler.dohvatiUsluguPoNazivu(zahtev.getUsluga());

                        DohvatiUsluguPoNazivuOdgovor odgovor = new DohvatiUsluguPoNazivuOdgovor(lsitaUsluga);
                        
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.DOHVATI_ZAKAZANE_TERMINE_ZA_KLIJENTA_ZAHTEV: {
                        DohvatiZakazaneTermineZaKlijentaZahtev zahtev = (DohvatiZakazaneTermineZaKlijentaZahtev) ois.readObject();
                        List<ZakazaniTermin> listaZakazanihTermina = kontroler.dohvatiZakazaneTermineZaKlijenta(zahtev.getZakazaniTermin());

                        DohvatiZakazaneTermineZaKlijentaOdgovor odgovor = new DohvatiZakazaneTermineZaKlijentaOdgovor(listaZakazanihTermina);
                        
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.DOHVATI_SVE_USLUGE_ZAHTEV: {
                        Usluga u = new Usluga();
                        List<Usluga> listaUsluga = kontroler.dohvatiSveUsluge(u);

                        DohvatiSveUslugeOdgovor odgovor = new DohvatiSveUslugeOdgovor(listaUsluga);
                        
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.DOHVATI_SVE_KOZMETICARE_ZAHTEV: {
                        Kozmeticar k = new Kozmeticar();
                        List<Kozmeticar> listaKozmeticara = kontroler.dohvatiSveKozmeticare(k);

                        DohvatiSveKozmeticareOdgovor odgovor = new DohvatiSveKozmeticareOdgovor(listaKozmeticara);
                        
                        oos.writeObject(odgovor);
                        break;
                    }

                    case TipoviZahteva.DOHVATI_STAVKE_ZA_ZAKAZANI_TERMIN_ZAHTEV: {
                        DohvatiStavkeZaZakazaniTerminZahtev zahtev = (DohvatiStavkeZaZakazaniTerminZahtev) ois.readObject();
                        List<StavkaZakazanogTermina> listaStavki = kontroler.dohvatiStavkeZaZakazaniTermin(zahtev.getStavkaZakazanogTermina());

                        DohvatiStavkeZaZakazniTerminOdgovor odgovor = new DohvatiStavkeZaZakazniTerminOdgovor(listaStavki);
                        
                        oos.writeObject(odgovor);
                        break;

                    }
                }

            } catch (IOException ex) {
                
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
