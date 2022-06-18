/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlijentskiZahtev.zakazivanjeTermina;

import Domen.StavkaZakazivanja;
import Domen.Usluga;
import Domen.ZakazivanjeTermina;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author milic
 */
public class DodajNovoZakazivanjeZahtev implements Serializable{
    private ZakazivanjeTermina zakazivanje;
    private List<Usluga> listaUsluga;

    public DodajNovoZakazivanjeZahtev(ZakazivanjeTermina zakazivanje, List<Usluga> listaUsluga) {
        this.zakazivanje = zakazivanje;
        this.listaUsluga = listaUsluga;
    }

    public ZakazivanjeTermina getZakazivanje() {
        return zakazivanje;
    }

    public List<Usluga> getListaUsluga() {
        return listaUsluga;
    }
    
    
    
    
}
