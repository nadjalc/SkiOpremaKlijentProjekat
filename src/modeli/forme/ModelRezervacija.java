/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli.forme;

import domen.AbstractObject;
import domen.RezervacijaSkija;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nadja
 */
public class ModelRezervacija extends AbstractTableModel {

    private List<AbstractObject> listaRezervacija;

    public ModelRezervacija(List<AbstractObject> listaStavki) {
        this.listaRezervacija = listaStavki;
    }

    String[] kolone = new String[]{"RezervacijaID", "Datum", "Uplata Unapred", "Skijas"};

    @Override
    public int getRowCount() {
        if (listaRezervacija == null) {
            return 0;
        }
        return listaRezervacija.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RezervacijaSkija s = (RezervacijaSkija) listaRezervacija.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getRezervacijaID();
            case 1:
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                return sdf.format(s.getDatumRezervacije());
            case 2:
                return s.isUplataUnapred() ? "Da" : "Ne";
            case 3:
                return s.getSkijas().getIme() + " "+s.getSkijas().getPrezime();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public List<AbstractObject> getListaRezervacija() {
        return listaRezervacija;
    }

    public void setListaRezervacija(List<AbstractObject> listaRezervacija) {
        this.listaRezervacija = listaRezervacija;
    }

   
    
    
    

}
