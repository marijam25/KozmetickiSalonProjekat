/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package So.Brisanje;

import Domen.OpstiDomenskiObjekat;
import So.OpstaSistemskaOperacija;
import db.DBBroker;

/**
 *
 * @author milic
 */
public class SOObrisiStavkuZakazanogTerminaPoIdu extends OpstaSistemskaOperacija {

    @Override
    protected boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    protected boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        return DBBroker.getInstance().izbrisiIzBazePoIdju(odo);
    }
    
}
