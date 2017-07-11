    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli.forme;

import domen.AbstractObject;
import domen.ParSkija;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import kolekcije.KolekcijaSkija;
import kontroler.Kontroler;

/**
 *
 * @author Nadja
 */
public class Model extends AbstractTableModel {
    private List<AbstractObject> listaParova;
    private String[] kolone = new String[]{"ParSkijaID", "DuzinaSkija", "Radijus", "Vezovi", "Marka", "TipSkija"};

    public Model(List<AbstractObject> listaParova) {
        this.listaParova = listaParova;
    }


    public void deleteParSkija(int br) {
        listaParova.remove(br);
    }

    @Override
    public int getRowCount() {
        if (listaParova == null) {
            return 0;
        }
        return listaParova.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ParSkija ps = (ParSkija) listaParova.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ps.getParSkijaID();
            case 1:
                return ps.getDuzina();
            case 2:
                return ps.getRadijus();
            case 3:
                return ps.getVezovi();
            case 4:
                return ps.getMarka();
            case 5:
                return ps.getTipSkija();
            default:
                return "n/a";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void setListaParova(List<AbstractObject> listaParova) {
        this.listaParova = listaParova;
    }

    public ParSkija getParSkija(int selected) {
        return (ParSkija) listaParova.get(selected);
    }

    public List<AbstractObject> getListaParova() {
        return listaParova;
    }

    public void osveziTabelu() {
        try {
            listaParova = Kontroler.getInstance().vratiListuParovaSkija();
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    


    
    
    
}
