/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlijentskiZahtevi.ZahteviZaDodavanje;

import Domen.StavkaZakazanogTermina;
import java.io.Serializable;

/**
 *
 * @author milic
 */
public class DodajStavkuZakazivanjaZahtev implements Serializable{
    private StavkaZakazanogTermina stavka;

    public DodajStavkuZakazivanjaZahtev(StavkaZakazanogTermina stavka) {
        this.stavka = stavka;
    }

    public StavkaZakazanogTermina getStavka() {
        return stavka;
    }
    
    
}
