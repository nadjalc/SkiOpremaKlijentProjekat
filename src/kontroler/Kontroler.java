/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.AbstractObject;
import domen.Korisnik;
import domen.ParSkija;
import domen.RezervacijaSkija;
import domen.TipSkija;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import komunikacija.Komunikacija;
import konstante.Konstante;
import transfer.KlijentTransfer;
import transfer.ServerTransfer;

/**
 *
 * @author Nadja
 */
public class Kontroler {

    private static Kontroler instance;
    KlijentTransfer kt;
    ServerTransfer st;

    public Kontroler() {
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public AbstractObject sacuvajParSkija(ParSkija parS) throws Exception {
        System.out.println("doslo da salje");
        kt = new KlijentTransfer();
        kt.setOperacija(Konstante.SACUVAJ_PAR_SKIJA);
        kt.setParametar(parS);
        Komunikacija.getInstance().posaljiZahtev(kt);
        System.out.println("Poslalo");
        st = Komunikacija.getInstance().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (AbstractObject) st.getPodaci();

        } else {
            Exception exec = st.getException();
            throw exec;
        }
    }

    public List<AbstractObject> vratiListuTipovaSkija() throws Exception {
        kt = new KlijentTransfer();
        kt.setOperacija(Konstante.UCITAJ_LISTU_TIPOVA_SKIJA);
        Komunikacija.getInstance().posaljiZahtev(kt);
        st = Komunikacija.getInstance().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (List<AbstractObject>) st.getPodaci();
        } else {
            Exception exec = st.getException();
            throw exec;
        }
    }

    public AbstractObject ulogujKorisnika(String username, String password) throws Exception {
        System.out.println("Pocetak logovanja korisnika");
        kt = new KlijentTransfer();
        kt.setOperacija(Konstante.ULOGUJ_KORISNIKA);
        Korisnik korisnik = new Korisnik(null, username, password, null, null, true);
        kt.setParametar(korisnik);
        Komunikacija.getInstance().posaljiZahtev(kt);
        st = Komunikacija.getInstance().procitajOdgovor();  
        if (st.getUspesnost() == 1) {
            return (AbstractObject) st.getPodaci();
        } else {
            Exception e = st.getException();
            throw e;
        }
    }

    public List<AbstractObject> obrisiParSkija(ParSkija parSkija) throws Exception {
        kt = new KlijentTransfer();
        kt.setOperacija(Konstante.OBRISI_PAR_SKIJA);
        kt.setParametar(parSkija);
        Komunikacija.getInstance().posaljiZahtev(kt);
        st = Komunikacija.getInstance().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (List<AbstractObject>) st.getPodaci();
        } else {
            Exception exec = st.getException();
            throw exec;
        }
    }

    public List<AbstractObject> vratiListuParovaSkija() throws Exception {
        List<AbstractObject> lista;

        System.out.println("Ucitavanje liste parova");
        kt = new KlijentTransfer();
        kt.setOperacija(Konstante.UCITAJ_LISTU_PAROVA_SKIJA);
        Komunikacija.getInstance().posaljiZahtev(kt);
        st = Komunikacija.getInstance().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (List<AbstractObject>) st.getPodaci();
        } else {
            Exception exec = st.getException();
            throw exec;
        }
    }

    public List<AbstractObject> vratiListuSkijasa() throws Exception {
        System.out.println("Ucitavanje liste skijasa");
        kt = new KlijentTransfer();
        kt.setOperacija(Konstante.UCITAJ_LISTU_SKIJASA);
        Komunikacija.getInstance().posaljiZahtev(kt);
        st = Komunikacija.getInstance().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (List<AbstractObject>) st.getPodaci();
        } else {
            Exception exec = st.getException();
            throw exec;
        }
    }

    public List<AbstractObject> pretraziSkijase(String pretraga) throws Exception {
        kt = new KlijentTransfer();
        kt.setOperacija(Konstante.PRETRAZI_SKIJASA);
        kt.setParametar(pretraga);
        Komunikacija.getInstance().posaljiZahtev(kt);
        st = Komunikacija.getInstance().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (List<AbstractObject>) st.getPodaci();
        } else {
            Exception exec = st.getException();
            throw exec;
        }
    }

    public RezervacijaSkija sacuvajRezervaciju(RezervacijaSkija rs) throws Exception {
        kt = new KlijentTransfer();
        kt.setOperacija(Konstante.KREIRAJ_REZERVACIJU_SKIJA);
        kt.setParametar(rs);
        Komunikacija.getInstance().posaljiZahtev(kt);
        st = Komunikacija.getInstance().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (RezervacijaSkija) (AbstractObject) st.getPodaci();
        } else {
            Exception exec = st.getException();
            throw exec;
        }
    }

    public RezervacijaSkija izmeniRezervaciju(RezervacijaSkija izmenjena) throws Exception {
        kt = new KlijentTransfer();
        kt.setOperacija(Konstante.ZAPAMTI_REZERVACIJU_SKIJA);
        kt.setParametar(izmenjena);
        Komunikacija.getInstance().posaljiZahtev(kt);
        st = Komunikacija.getInstance().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (RezervacijaSkija) (AbstractObject) st.getPodaci();
        } else {
            Exception exec = st.getException();
            throw exec;
        }
    }

    public List<AbstractObject> pretraziRezervacije(String pretraga) throws Exception {
        kt = new KlijentTransfer();
        kt.setOperacija(Konstante.PRETRAZI_REZERVACIJE);
        kt.setParametar(pretraga);
        Komunikacija.getInstance().posaljiZahtev(kt);
        ServerTransfer st = Komunikacija.getInstance().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (List<AbstractObject>) st.getPodaci();
        } else {
            Exception exec = st.getException();
            throw exec;
        }
    }

}
