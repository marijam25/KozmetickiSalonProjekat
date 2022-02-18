package Modeli;

import Domen.Termin;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleTermina extends AbstractTableModel {

    ArrayList<Termin> listaTermina;

    public ModelTabeleTermina(ArrayList<Termin> listaTermina) {
        this.listaTermina = listaTermina;
    }

    @Override
    public int getRowCount() {
        return listaTermina.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Termin t = listaTermina.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return t.getDatumTermina();
            case 1:
                return t.getVremeTermina();

            default:
                return "Ne postoji";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Vreme termina";
            case 1:
                return "Datum termina";

            default:
                return "Ne postoji";
        }
    }

    public ArrayList<Termin> getListaTermina() {
        return listaTermina;
    }

    public void osveziTabelu() {
        fireTableDataChanged();
    }

}
