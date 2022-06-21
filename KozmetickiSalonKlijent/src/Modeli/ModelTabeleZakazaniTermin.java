package Modeli;

import Domen.ZakazaniTermin;
import PomocneFunkcije.DatumPomocneFunkcije;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleZakazaniTermin extends AbstractTableModel {

    List<ZakazaniTermin> listaZakaznihTermina;
    

    public ModelTabeleZakazaniTermin(List<ZakazaniTermin> listaZakaznihTermina) {
        this.listaZakaznihTermina = listaZakaznihTermina;
    }

    @Override
    public int getRowCount() {
        return listaZakaznihTermina.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ZakazaniTermin zt = listaZakaznihTermina.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return DatumPomocneFunkcije.UtilDateUString(zt.getDatumIVreme());

            default:
                return "Ne postoji";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Datum i vreme termina";

            default:
                return "Ne postoji";
        }
    }

    public List<ZakazaniTermin> getListaTermina() {
        return listaZakaznihTermina;
    }

    public void osveziTabelu() {
        fireTableDataChanged();
    }

}
