/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli.forme;

import domen.ParSkija;
import domen.StavkaRezervacijeSkija;
import domen.TipSkija;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nadja
 */
public class ModelRezervacijaTabelaStavki extends AbstractTableModel {

    private List<StavkaRezervacijeSkija> listaStavki;

    public ModelRezervacijaTabelaStavki(List<StavkaRezervacijeSkija> listaStavki) {
        this.listaStavki = listaStavki;
    }

    String[] kolone = new String[]{"Redni broj", "Par skija", "Duzina", "Radijus", "Vezovi", "Marka", "Tip skija"};

    @Override
    public int getRowCount() {
        if (listaStavki == null) {
            return 0;
        }
        return listaStavki.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRezervacijeSkija s = listaStavki.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getRedniBrojStavke();
            case 1:
                return s.getParSkija();
            case 2:
                return s.getParSkija().getDuzina();
            case 3:
                return s.getParSkija().getRadijus();
            case 4:
                return s.getParSkija().getVezovi();
            case 5:
                return s.getParSkija().getMarka();
            case 6:
                return s.getParSkija().getTipSkija();
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
        switch (columnIndex) {
            case 0:
                return false;
            case 1:
                return true;
            default:
                return false;
        }
    }

    public List<StavkaRezervacijeSkija> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaRezervacijeSkija> listaStavki) {
        this.listaStavki = listaStavki;
    }

    public void dodajNovuStavku() {
        StavkaRezervacijeSkija nova = new StavkaRezervacijeSkija();
        nova.setRedniBrojStavke(listaStavki.size() + 1);
        nova.setParSkija(new ParSkija("", 0, 0, "", "", new TipSkija("", "")));
        listaStavki.add(nova);
        fireTableDataChanged();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        StavkaRezervacijeSkija st = listaStavki.get(rowIndex);
        switch (columnIndex) {
            case 1:
                st.setParSkija((ParSkija) aValue);
                fireTableDataChanged();
                break;
            default:
                System.out.println("DEFAULT");
                break;
        }
    }

}
