/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package So;

import Domen.OpstiDomenskiObjekat;
import db.DBBroker;

/**
 *
 * @author milic
 */
public class SOObrisiStavkuZakazivanja extends OpstaSistemskaOperacija{

    @Override
    protected boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    protected boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        operacijaUspesnoIzvrsena = DBBroker.getInstance().izbrisiIzBaze(odo);
        return operacijaUspesnoIzvrsena;
    }
    
}
