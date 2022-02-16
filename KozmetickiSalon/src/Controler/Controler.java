/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Beans.KategorijaUsluga;
import Beans.Klijent;
import Beans.Kozmeticar;
import Beans.Termin;
import Beans.Usluga;
import DatabaseLayer.DBBroker;
import DatabaseLayer.KategorijaUslugaDBInterface;
import DatabaseLayer.KlijentDBInterface;
import DatabaseLayer.KozmeticarDBInterface;
import DatabaseLayer.TerminDBInterface;
import DatabaseLayer.UslugaDBInterface;
import Threads.ListenerThread;
import java.util.ArrayList;

/**
 *
 * @author milic
 */
public class Controler {

    private static Controler instance;
    private DBBroker broker;
    private KlijentDBInterface klijentDBinterfejs;
    private KozmeticarDBInterface kozmeticarDBInterface;
    private UslugaDBInterface uslugaDBInterface;
    private TerminDBInterface terminDBInterface;
    private KategorijaUslugaDBInterface kategorijaUslugaDBInterface;

    private Controler() {
        broker = new DBBroker();
        klijentDBinterfejs = new KlijentDBInterface(broker);
        kozmeticarDBInterface = new KozmeticarDBInterface(broker);
        uslugaDBInterface = new UslugaDBInterface(broker);
        terminDBInterface = new TerminDBInterface(broker);
        kategorijaUslugaDBInterface = new KategorijaUslugaDBInterface(broker);
    }

    public static Controler getInstance() {
        if (instance == null) {
            instance = new Controler();
        }
        return instance;
    }

    public boolean dodajNovogKlijenta(Klijent klijent) {
        boolean uspeo = klijentDBinterfejs.add(klijent);
        return uspeo;
    }

    public boolean dodajNovogKozmeticara(Kozmeticar kozmeticar) {
        boolean uspeo = kozmeticarDBInterface.add(kozmeticar);
        return uspeo;
    }

    public boolean obrisiKozmeticara(Kozmeticar kozmeticar) {
        boolean uspeo = kozmeticarDBInterface.delete(kozmeticar);
        return uspeo;
    }

    public boolean dodajNovuUslugu(Usluga usluga) {
        boolean uspeo = uslugaDBInterface.add(usluga);
        return uspeo;
    }

    public boolean obrisiUslugu(Usluga usluga) {
        boolean uspeo = uslugaDBInterface.delete(usluga);
        return uspeo;
    }

    public boolean dodajNoviTermin(Termin termin) {
        boolean uspeo = terminDBInterface.add(termin);
        return uspeo;
    }

    public boolean obrisiTermin(Termin termin) {
        boolean uspeo = terminDBInterface.delete(termin);
        return uspeo;
    }

    public boolean azurirajKozmeticara(Kozmeticar kozmeticar) {
        boolean uspeo = kozmeticarDBInterface.edit(kozmeticar);
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
        
        ArrayList<Usluga> nizUsluga = (ArrayList<Usluga>) uslugaDBInterface.getAll();
        return nizUsluga;
    }

    public boolean azurirajTermin(Termin termin) {
        boolean uspeo = terminDBInterface.edit(termin);
        return uspeo;
    }

    public ArrayList<Kozmeticar> vratiSveKozmeticare() {
        ArrayList<Kozmeticar> listaKozmeticara = (ArrayList<Kozmeticar>) kozmeticarDBInterface.getAll();
        return listaKozmeticara;
    }

    public ArrayList<KategorijaUsluga> vratiSveKategorijeUsluga() {
        ArrayList<KategorijaUsluga> listaKategorijaUsluga = (ArrayList<KategorijaUsluga>) kategorijaUslugaDBInterface.getAll();
        return listaKategorijaUsluga;
    }

    

}
