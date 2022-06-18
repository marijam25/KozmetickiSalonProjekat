package Domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.util.Pair;

public interface OpstiDomenskiObjekat {
    public abstract String nazivTabele();
    public abstract ArrayList<String> naziviKolona();
    public abstract HashMap<String, String> naziviIVrednostiKolona();
    public abstract String nazivPrimarnogKljuca();
    public abstract HashMap<String, String> nazivIVrednostPrimarnogKljuca();
    public abstract ArrayList<? extends OpstiDomenskiObjekat> ucitajIzResultSeta(ResultSet rs);
}
