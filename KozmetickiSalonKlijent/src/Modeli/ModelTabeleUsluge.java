/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modeli;

import Beans.Usluga;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author milic
 */
public class ModelTabeleUsluge extends AbstractTableModel {

    ArrayList<Usluga> listaUsluga;

    public ModelTabeleUsluge(ArrayList<Usluga> listaUsluga) {
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
        
        switch(columnIndex){
            case 0: return u.getNazivUsluge(); 
            case 1: return u.getKategorijaId();
            
            default: return "Ne postoji";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Naziv usluge";
            case 1: return "Kategorija usluge";
            
            default: return "Ne postoji";
        }
    }

    public ArrayList<Usluga> getListaKozmeticara() {
        return listaUsluga;
    }
    
    public void osveziTabelu(){
        fireTableDataChanged();
    }
    
}
