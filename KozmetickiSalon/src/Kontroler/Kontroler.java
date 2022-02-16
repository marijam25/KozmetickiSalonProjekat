/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import Domen.KategorijaUsluga;
import Domen.Klijent;
import Domen.Kozmeticar;
import Domen.Termin;
import Domen.Usluga;
import db.DBBroker;
import db.KategorijaUslugaDBInterface;
import db.KlijentDBInterface;
import db.KozmeticarDBInterface;
import db.TerminDBInterface;
import db.UslugaDBInterface;
import Niti.OsluskivacNit;
import java.util.ArrayList;

/**
 *
 * @author milic
 */
public class Kontroler {

    private static Kontroler instance;
    private DBBroker broker;
    private KlijentDBInterface klijentDBinterfejs;
    private KozmeticarDBInterface kozmeticarDBInterface;
    private UslugaDBInterface uslugaDBInterface;
    private TerminDBInterface terminDBInterface;
    private KategorijaUslugaDBInterface kategorijaUslugaDBInterface;

    private Kontroler() {
        broker = new DBBroker();
        klijentDBinterfejs = new KlijentDBInterface(broker);
        kozmeticarDBInterface = new KozmeticarDBInterface(broker);
        uslugaDBInterface = new UslugaDBInterface(broker);
        terminDBInterface = new TerminDBInterface(broker);
        kategorijaUslugaDBInterface = new KategorijaUslugaDBInterface(broker);
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

    public boolean dodajNoviTermin(Termin termin) {
        boolean uspeo = terminDBInterface.dodaj(termin);
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

    public ArrayList<Usluga> pretraziUsluge() {
        /*String condString = "";
        if(!nazivUsluge.equals("")){
            condString+="nazivUsluge=" + nazivUsluge;
        }
        if(kategorijaID != -1){
            if(!condString.equals("")){
                condString+=" and ";
            }
            condString+=" KategorijaId = " + Integer.toString(kategorijaID);
        }*/
        
        ArrayList<Usluga> nizUsluga = (ArrayList<Usluga>) uslugaDBInterface.vratiSve();
        return nizUsluga;
    }

    public boolean azurirajTermin(Termin termin) {
        boolean uspeo = terminDBInterface.izmeni(termin);
        return uspeo;
    }

    public ArrayList<Kozmeticar> vratiSveKozmeticare() {
        ArrayList<Kozmeticar> listaKozmeticara = (ArrayList<Kozmeticar>) kozmeticarDBInterface.vratiSve();
        return listaKozmeticara;
    }

    public ArrayList<KategorijaUsluga> vratiSveKategorijeUsluga() {
        ArrayList<KategorijaUsluga> listaKategorijaUsluga = (ArrayList<KategorijaUsluga>) kategorijaUslugaDBInterface.vratiSve();
        return listaKategorijaUsluga;
    }

    

}
