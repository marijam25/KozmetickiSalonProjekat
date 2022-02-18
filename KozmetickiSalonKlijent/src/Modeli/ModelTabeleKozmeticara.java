package Modeli;

import Domen.Kozmeticar;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModelTabeleKozmeticara extends AbstractTableModel {

    ArrayList<Kozmeticar> listaKozmeticara;

    public ModelTabeleKozmeticara(ArrayList<Kozmeticar> listaKozmeticara) {
        this.listaKozmeticara = listaKozmeticara;
    }
    
    @Override
    public int getRowCount() {
        return listaKozmeticara.size();      
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kozmeticar k = listaKozmeticara.get(rowIndex);
        
        switch(columnIndex){
            case 0: return k.getIme(); 
            case 1: return k.getPrezime();
            case 2: return k.getGodine();
            
            default: return "Ne postoji";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Ime";
            case 1: return "Prezime";
            case 2: return "Godine";
            
            default: return "Ne postoji";
        }
    }

    public ArrayList<Kozmeticar> getListaKozmeticara() {
        return listaKozmeticara;
    }
    
    public void osveziTabelu(){
        fireTableDataChanged();
    }
    
}
