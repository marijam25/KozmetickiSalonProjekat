/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlijentskiZahtevi.ZahteviZaBrisanje;

import Domen.StavkaZakazanogTermina;
import java.io.Serializable;

/**
 *
 * @author milic
 */
public class ObrisiStavkuZakazivanjaZahtev implements Serializable{
    private StavkaZakazanogTermina stavka;

    public ObrisiStavkuZakazivanjaZahtev(StavkaZakazanogTermina stavka) {
        this.stavka = stavka;
    }

    public StavkaZakazanogTermina getStavka() {
        return stavka;
    }
}
