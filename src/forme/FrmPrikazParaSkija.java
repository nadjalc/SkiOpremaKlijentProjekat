/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.AbstractObject;
import domen.ParSkija;
import domen.RezervacijaSkija;
import modeli.forme.Model;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import modeli.forme.ModelRezervacija;

/**
 *
 * @author Nadja
 */
public class FrmPrikazParaSkija extends javax.swing.JFrame {

    FrmGlavna parent;

    public FrmGlavna getParent() {
        return parent;
    }

    public void setParent(FrmGlavna parent) {
        this.parent = parent;
    }

    /**
     * Creates new form FrmPrikazParaSkija
     */
    public FrmPrikazParaSkija() {
        initComponents();
        srediFormu();
        popuniRezervacijaTabelu();
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblParoviSkija = new javax.swing.JTable();
        btnDetalji = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblrezervacija = new javax.swing.JTable();
        btnIZmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Prikaz svih parova skija");

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tblParoviSkija.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblParoviSkija.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblParoviSkijaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblParoviSkija);

        btnDetalji.setText("Detalji");
        btnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiActionPerformed(evt);
            }
        });

        tblrezervacija.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblrezervacija.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblrezervacijaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblrezervacija);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDetalji)
                .addGap(36, 36, 36))
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDetalji)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnIZmeni.setText("Izmeni rezervaciju");
        btnIZmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIZmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIZmeni)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIZmeni)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed
        // TODO add your handling code here
        if (tblParoviSkija.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Niste izabrali red za prikaz detalja!");
        }

        int selected = tblParoviSkija.getSelectedRow();
        Model model = (Model) tblParoviSkija.getModel();
        ParSkija ps = model.getParSkija(selected);
        FrmUnosParaSkija f = new FrmUnosParaSkija(this, true, ps, "izmene");
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }//GEN-LAST:event_btnDetaljiActionPerformed

    private void tblParoviSkijaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblParoviSkijaMouseClicked
        //  TODO add your handling code here:
        if (tblParoviSkija.getSelectedRow() != -1) {
            Model m = (Model) tblParoviSkija.getModel();
            ParSkija ps = m.getParSkija(tblParoviSkija.getSelectedRow());
            try {
                List<AbstractObject> listaRez = Kontroler.getInstance().pretraziRezervacije(ps.getParSkijaID());
                ModelRezervacija mod = new ModelRezervacija(listaRez);
                tblrezervacija.setModel(mod);
                tblrezervacija.setEnabled(true);
            } catch (Exception ex) {
                Logger.getLogger(FrmPrikazParaSkija.class.getName()).log(Level.SEVERE, null, ex);
            }
        } //        if (tblParoviSkija.getSelectedRow() != -1) {
        //            try {
        //                Model m = (Model) tblParoviSkija.getModel();
        //                ParSkija ps = (ParSkija) m.getParSkija(tblParoviSkija.getSelectedRow());
        //                List<AbstractObject> listaRezervacija = Kontroler.getInstance().pretraziRezervacije(ps.getParSkijaID());
        //                tblrezervacija.setEnabled(true);
        //                btnDetalji.setEnabled(true);
        //                btnIZmeni.setEnabled(false);
        //                ModelRezervacija mpr = (ModelRezervacija) tblrezervacija.getModel();
        //                mpr.setListaRezervacija(listaRezervacija);
        //                mpr.fireTableDataChanged();
        //            } catch (ClassNotFoundException ex) {
        //                Logger.getLogger(FrmPrikazParaSkija.class.getName()).log(Level.SEVERE, null, ex);
        //            } catch (Exception ex) {
        //                Logger.getLogger(FrmPrikazParaSkija.class.getName()).log(Level.SEVERE, null, ex);
        //            }
        else {
            System.out.println("Ipak nije dobro ovo***********");
            popuniRezervacijaTabelu();
        }


    }//GEN-LAST:event_tblParoviSkijaMouseClicked

    private void btnIZmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIZmeniActionPerformed
        // TODO add your handling code here:
        if (tblrezervacija.getSelectedRow() != -1) {
            ModelRezervacija mr = (ModelRezervacija) tblrezervacija.getModel();
            FrmRezervacijaParaSkija fmr = new FrmRezervacijaParaSkija((RezervacijaSkija) mr.getListaRezervacija().get(tblrezervacija.getSelectedRow()));
            fmr.setVisible(true);
            fmr.setParent(this);
        }
    }//GEN-LAST:event_btnIZmeniActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void tblrezervacijaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblrezervacijaMouseClicked
        // TODO add your handling code here:
        if (tblrezervacija.getSelectedRow() != -1) {
            btnIZmeni.setEnabled(true);
        } else {
            btnIZmeni.setEnabled(false);
        }
    }//GEN-LAST:event_tblrezervacijaMouseClicked

    /**
     * @param args the command line arguments
     */
    private void srediFormu() {

        try {
            Model m = new Model(Kontroler.getInstance().vratiListuParovaSkija());
            tblParoviSkija.setModel(m);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Greska kod dovodjenja liste parova skija: ", "GRESKA!", JOptionPane.ERROR_MESSAGE);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalji;
    private javax.swing.JButton btnIZmeni;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblParoviSkija;
    private javax.swing.JTable tblrezervacija;
    // End of variables declaration//GEN-END:variables

    void sacuvaj(ParSkija parS) throws SQLException {
        try {
            Kontroler.getInstance().sacuvajParSkija(parS);
            Model m = (Model) tblParoviSkija.getModel();
            m.fireTableDataChanged();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Greska kod cuvanja para skija: ", "GRESKA!", JOptionPane.ERROR_MESSAGE);
        }
    }

    void listaPosleBrisanja(List<AbstractObject> lista) {
        Model m = (Model) tblParoviSkija.getModel();
        m.setListaParova(lista);
        m.fireTableDataChanged();
    }

    private void popuniRezervacijaTabelu() {
        ModelRezervacija m = new ModelRezervacija(new ArrayList<AbstractObject>());
        tblrezervacija.setModel(m);
        tblrezervacija.setEnabled(false);
        btnDetalji.setEnabled(true);
        btnIZmeni.setEnabled(false);
    }

    void refresujTabelu() {
       Model m = (Model) tblParoviSkija.getModel();
       m.osveziTabelu();
    }

}
