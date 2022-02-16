/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modeli;

import Beans.Kozmeticar;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author milic
 */
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
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kozmeticar k = listaKozmeticara.get(rowIndex);
        
        switch(columnIndex){
            case 0: return k.getIme(); 
            case 1: return k.getPrezime();
            
            default: return "Ne postoji";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Ime";
            case 1: return "Prezime";
            
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
