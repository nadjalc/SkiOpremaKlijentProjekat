/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domen.Korisnik;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Komunikacija;
import konstante.Konstante;
import transfer.KlijentTransfer;
import transfer.ServerTransfer;

/**
 *
 * @author Nadja
 */
public class Test {
    public void testLogin(Korisnik k){
        try {
            KlijentTransfer kt = new KlijentTransfer();
            kt.setOperacija(Konstante.ULOGUJ_KORISNIKA);
            kt.setParametar(k);
            Socket socket = new Socket("127.0.0.1", 9000);
            Komunikacija.getInstance().setSocket(socket);
            Komunikacija.getInstance().posaljiZahtev(kt);
            ServerTransfer st = Komunikacija.getInstance().procitajOdgovor();
            System.out.println(st);
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        Test t1 = new Test();
        
        Korisnik k = new Korisnik("nadja", "123");
        t1.testLogin(k);
    }
}
