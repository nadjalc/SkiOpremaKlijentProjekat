/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.AbstractObject;
import domen.ParSkija;
import domen.TipSkija;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import kontroler.Kontroler;

/**
 *
 * @author Nadja
 */
public class FrmUnosParaSkija extends javax.swing.JDialog {

    FrmPrikazParaSkija pf;
    String mode;
    ParSkija parSkija;
    JFrame parent;

    public FrmUnosParaSkija(Frame parent, boolean modal, String mode) {
        super(parent, modal);
        this.mode = "unos";
        initComponents();
        srediFormu(mode);
    }

    public FrmUnosParaSkija(JFrame parent, boolean modal, ParSkija ps, String mode) {
        super(parent, modal);
        this.mode = "izmene";
        initComponents();
        srediFormu(mode);
        popuniPolja(ps);
        parSkija = ps;
        pf = (FrmPrikazParaSkija) parent;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDuzna = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRadijus = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtVezovi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbTipSkija = new javax.swing.JComboBox();
        btnUnosenjePodataka = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        lblMarka = new javax.swing.JLabel();
        txtMarka = new javax.swing.JTextField();
        btnPonisti = new javax.swing.JButton();
        btnOtkazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Podešavanje podataka o parovima skija");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Par skija ID");

        txtID.setEditable(false);
        txtID.setBackground(new java.awt.Color(255, 255, 255));
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel2.setText("Dužina skija");

        jLabel3.setText("Radijus");

        jLabel4.setText("Vezovi");

        jLabel5.setText("Tip skija");

        cmbTipSkija.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipSkija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipSkijaActionPerformed(evt);
            }
        });

        btnUnosenjePodataka.setText("Unesi par skija");
        btnUnosenjePodataka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnosenjePodatakaActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši par skija");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        lblMarka.setText("Marka");

        btnPonisti.setText("Ponisti");
        btnPonisti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonistiActionPerformed(evt);
            }
        });

        btnOtkazi.setText("Otkazi");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(lblMarka))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRadijus)
                            .addComponent(txtDuzna)
                            .addComponent(txtID)
                            .addComponent(txtVezovi)
                            .addComponent(cmbTipSkija, 0, 378, Short.MAX_VALUE)
                            .addComponent(txtMarka)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(btnUnosenjePodataka)
                        .addGap(58, 58, 58)
                        .addComponent(btnObrisi)))
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnPonisti)
                .addGap(18, 18, 18)
                .addComponent(btnOtkazi)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDuzna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRadijus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtVezovi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMarka))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipSkija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUnosenjePodataka)
                    .addComponent(btnObrisi))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPonisti)
                    .addComponent(btnOtkazi))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipSkijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipSkijaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipSkijaActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        // TODO add your handling code here:

        int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da obrisete par skija?", "Potvrda", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            try {

                List<AbstractObject> lista = Kontroler.getInstance().obrisiParSkija(parSkija);
                JOptionPane.showMessageDialog(rootPane, "Par skija je uspesno obrisan");
                pf.listaPosleBrisanja(lista);
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Par skija nije obrisan doslo je do greske", "GRESKA!", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnUnosenjePodatakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnosenjePodatakaActionPerformed
        // TODO add your handling code here:
        // LinkedList<ParSkija> sveSkije = Kontroler.getInstance().vratiListuParovaSkija();
        int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da napravite izmene?", "Potvrda", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            parSkija = new ParSkija();
            try {
                String parSkijaID;

                if (mode.equals("izmene")) {
                    parSkijaID = txtID.getText().trim();
                    System.out.println(mode + " je mode");
                } else {
                    parSkijaID = "0";
                    System.out.println("Postavilo nulu");
                }
                String duzina = txtDuzna.getText().trim();
                String radijus = txtRadijus.getText().trim();
                String vezovi = txtVezovi.getText().trim();
                String marka = txtMarka.getText().trim();
                TipSkija tipSkija = (TipSkija) cmbTipSkija.getSelectedItem();

                System.out.println("Uslo da kreira --@@@@@");
                if (vezovi.isEmpty() || marka.isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Sva polja moraju biti popunjena");
                    return;
                }
                System.out.println("Proslo puna polja");
                try {
                    parSkija.setParSkijaID(parSkijaID);
                    parSkija.setDuzina(Integer.parseInt(duzina));
                    parSkija.setRadijus(Double.parseDouble(radijus));
                    parSkija.setVezovi(vezovi);
                    parSkija.setMarka(marka);
                    parSkija.setTipSkija(tipSkija);
                    System.out.println("setovalo vrednosti");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(rootPane, "Radijus i duzina moraju biti numericke vrednosti");
                    return;
                }
                ParSkija ps = (ParSkija) Kontroler.getInstance().sacuvajParSkija(parSkija);
                System.out.println("Stigli rezultati cuvanja");

                String idNovi = ps.getParSkijaID();


                if (mode.equals("izmene")) {
                    JOptionPane.showMessageDialog(rootPane, "Par skija je uspesno Izmenjen: " + idNovi);

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Par skija je uspesno sacuvan: " + idNovi);

                }
                txtID.setText(idNovi);
                this.dispose();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(rootPane, "Par skija nije sacuvan doslo je do greske", "GRESKA!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnUnosenjePodatakaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowClosing

    private void btnPonistiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonistiActionPerformed
        // TODO add your handling code here:
        txtDuzna.setText("");
        txtRadijus.setText("");
        txtMarka.setText("");
        txtVezovi.setText("");

    }//GEN-LAST:event_btnPonistiActionPerformed

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        // TODO add your handling code here:
        formClosing();
    }//GEN-LAST:event_btnOtkaziActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnPonisti;
    private javax.swing.JButton btnUnosenjePodataka;
    private javax.swing.JComboBox cmbTipSkija;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblMarka;
    private javax.swing.JTextField txtDuzna;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMarka;
    private javax.swing.JTextField txtRadijus;
    private javax.swing.JTextField txtVezovi;
    // End of variables declaration//GEN-END:variables

    private void srediFormu(String mode) {
        try {
            cmbTipSkija.removeAllItems();
            System.out.println("Ocitavanje liste skija");

            List<AbstractObject> listaTipovaSkija = Kontroler.getInstance().vratiListuTipovaSkija();
            for (AbstractObject tip : listaTipovaSkija) {
                cmbTipSkija.addItem(tip);
            }
            btnOtkazi.setVisible(true);
            btnPonisti.setVisible(true);
            String status = mode;
            if (status.equals("unos")) {
                btnUnosenjePodataka.setVisible(true);
                btnUnosenjePodataka.setText("Sacuvaj");
                btnObrisi.setVisible(false);
            } else if (status.equals("izmene")) {
                btnUnosenjePodataka.setText("Izmena para skija");
                btnUnosenjePodataka.setVisible(true);
                btnUnosenjePodataka.setText("Izmeni");
                btnObrisi.setVisible(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Lista tipova skija nije dovedena doslo je do greske", "GRESKA!", JOptionPane.ERROR_MESSAGE);

        }

    }

    private void popuniPolja(ParSkija ps) {
        txtID.setText(ps.getParSkijaID());
        txtDuzna.setText(Integer.toString(ps.getDuzina()));
        txtRadijus.setText(Double.toString(ps.getRadijus()));
        txtVezovi.setText(ps.getVezovi());
        txtMarka.setText(ps.getMarka());
        cmbTipSkija.setSelectedItem(ps.getTipSkija());

    }

//    private ParSkija kreirajParSkija(String parSkijaID, String duzina, String radijus, String vezovi, String marka, TipSkija tipSkija) throws Exception {
//        int status = 1;
//
//        return parSkija;
//    }
    private void formClosing() {
        setVisible(false);
        if (mode.equals("izmene")) {

            FrmPrikazParaSkija novi = new FrmPrikazParaSkija();
            novi.setParent(pf.getParent());
            pf.dispose();
            novi.setVisible(true);
        }
        dispose();
    }
}
