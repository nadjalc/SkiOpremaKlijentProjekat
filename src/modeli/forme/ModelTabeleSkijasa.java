/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli.forme;

import domen.AbstractObject;
import domen.Skijas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nadja
 */
public class ModelTabeleSkijasa extends AbstractTableModel {

    private List<AbstractObject> listaSkijasa;

    public ModelTabeleSkijasa(List<AbstractObject> listaSkijasa) {
        this.listaSkijasa = listaSkijasa;
    }

    String[] kolone = new String[]{"Ime", "Prezime", "Broj telefona"};

    @Override
    public int getRowCount() {
        if (listaSkijasa == null) {
            return 0;
        }
        return listaSkijasa.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Skijas s = (Skijas) listaSkijasa.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getIme();
            case 1:
                return s.getPrezime();
            case 2:
                return s.getBrojTelefona();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<AbstractObject> getListaSkijasa() {
        return listaSkijasa;
    }

    public void setListaSkijasa(List<AbstractObject> listaSkijasa) {
        this.listaSkijasa = listaSkijasa;
    }
    
    

}
