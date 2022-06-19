package Domen;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface OpstiDomenskiObjekat {
    public abstract String nazivTabele();
    public abstract List<String> naziviKolona();
    public abstract Map<String, String> naziviIVrednostiKolona();
    public abstract List<String> naziviKolonaPrimarnogKljuca();
    public abstract Map<String, String> nazivIVrednostPrimarnogKljuca();
    public abstract List<? extends OpstiDomenskiObjekat> ucitajIzResultSeta(ResultSet rs);
}
