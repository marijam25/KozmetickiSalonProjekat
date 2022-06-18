/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package So;

import Domen.KorisnikSistema;
import Domen.OpstiDomenskiObjekat;
import db.DBBroker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javafx.util.Pair;

/**
 *
 * @author milic
 */
public class SONadjiKorisnikaSistemaPoKorisnickomImenuISifri extends OpstaSistemskaOperacija {

    private ArrayList<KorisnikSistema> listaKorisnika;

    public SONadjiKorisnikaSistemaPoKorisnickomImenuISifri() {
        
    }
    
    @Override
    public boolean proveriPreduslov(OpstiDomenskiObjekat odo) {
        return true;
    }

    @Override
    public boolean izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) {
        Set<String> koloneZaPretrazivanje = new HashSet<>();
        koloneZaPretrazivanje.add("korisnickoIme");
        koloneZaPretrazivanje.add("sifra");
        listaKorisnika = (ArrayList<KorisnikSistema>) DBBroker.getInstance().pronadjiUBazi(odo, koloneZaPretrazivanje);
        if(listaKorisnika==null)
            return false;
        else
            return true;
    }

    public ArrayList<KorisnikSistema> getListaKorisnika() {
        return listaKorisnika;
    }
    
}
