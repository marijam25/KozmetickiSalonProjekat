/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlijentskiZahtevi.ZahteviZaDodavanje;

import Domen.Usluga;
import Domen.ZakazaniTermin;
import java.io.Serializable;
import java.util.List;

public class DodajZakazaniTerminZahtev implements Serializable{
    private ZakazaniTermin zakazaniTermin;
    private List<Usluga> listaUsluga;

    public DodajZakazaniTerminZahtev(ZakazaniTermin zakazaniTermin, List<Usluga> listaUsluga) {
        this.zakazaniTermin = zakazaniTermin;
        this.listaUsluga = listaUsluga;
    }

    public ZakazaniTermin getZakazaniTermin() {
        return zakazaniTermin;
    }

    public List<Usluga> getListaUsluga() {
        return listaUsluga;
    }
}
