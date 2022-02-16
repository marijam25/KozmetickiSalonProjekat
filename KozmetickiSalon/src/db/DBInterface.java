/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.List;

/**
 *
 * @author milic
 */
public interface DBInterface<T> {
    public List<T> vratiSve();
    public List<T> vratiSve(String uslov);
    public boolean dodaj(T t);
    public boolean izmeni(T t);
    public boolean obrisi(T t);
    public T vratiPoIdu(int id);
}
