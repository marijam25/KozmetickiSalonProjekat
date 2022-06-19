package Modeli;

import Domen.KategorijaUsluga;
import Domen.Usluga;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleUsluge extends AbstractTableModel {

    List<Usluga> listaUsluga;
    List<KategorijaUsluga> listaKategorija;

    public ModelTabeleUsluge(List<Usluga> listaUsluga) {
        this.listaUsluga = listaUsluga;
    }

    @Override
    public int getRowCount() {
        return listaUsluga.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usluga u = listaUsluga.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return u.getNazivUsluge();
            case 1:
                for (KategorijaUsluga kategorijaUsluga : listaKategorija) {
                    if (kategorijaUsluga.getKategorijaId() == u.getKategorijaId()) {
                        return kategorijaUsluga.getNazivKategorije();
                    }
                }
                return "/";

            default:
                return "Ne postoji";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Naziv usluge";
            case 1:
                return "Kategorija usluge";

            default:
                return "Ne postoji";
        }
    }

    public List<Usluga> getListaKozmeticara() {
        return listaUsluga;
    }

    public void osveziTabelu() {
        fireTableDataChanged();
    }

    public void setListaKategorija(List<KategorijaUsluga> listaKategorija) {
        this.listaKategorija = listaKategorija;
    }

}
