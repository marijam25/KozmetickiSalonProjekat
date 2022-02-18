package db;

import java.util.List;

public interface DBInterface<T> {

    public List<T> vratiSve();

    public List<T> vratiSve(String uslov);

    public boolean dodaj(T t);

    public boolean izmeni(T t);

    public boolean obrisi(T t);

    public T vratiPoIdu(int id);
}
