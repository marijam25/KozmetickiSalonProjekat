/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Beans.Klijent;
import Beans.Kozmeticar;
import DatabaseLayer.DBBroker;
import DatabaseLayer.KlijentDBInterface;
import DatabaseLayer.KozmeticarDBInterface;
import Threads.ListenerThread;

/**
 *
 * @author milic
 */
public class Controler {

    private static Controler instance;
    private DBBroker broker;
    private KlijentDBInterface klijentDBinterfejs;
    private KozmeticarDBInterface kozmeticarDBInterface;

    private Controler() {
        broker = new DBBroker();
        klijentDBinterfejs = new KlijentDBInterface(broker);
        kozmeticarDBInterface = new KozmeticarDBInterface(broker);
    }

    public static Controler getInstance() {
        if (instance == null) {
            instance = new Controler();
        }
        return instance;
    }

    public boolean dodajNovogKlijenta(Klijent k) {
        boolean uspeo = klijentDBinterfejs.add(k);
        return uspeo;
    }

    public boolean dodajNovogKozmeticara(Kozmeticar k) {
        boolean uspeo = kozmeticarDBInterface.add(k);
        return uspeo;
    }

}
