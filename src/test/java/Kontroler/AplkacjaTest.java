package Kontroler;

import Model.Klient;
import Model.ListaFilmow;
import Model.TestControl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@Category({TestControl.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AplkacjaTest {

    Klient klient;
    Aplkacja aplkacja;

    @Before
    public void setUp() {
    aplkacja = new Aplkacja();
    klient = new Klient(1, "Jan", "Kowalski", 12, "Długa", 123456789);
    }

    @Test
    public void dodajKlientaTest(){
    aplkacja.dodajKlienta(1, "Jan", "Kowalski", 12, "Długa", 123456789);
        Assert.assertNotEquals(klient, aplkacja.getListaKlientow().get(0));
    }

    @Test
    public void usunKlientaTest(){
        aplkacja.usunKlienta(1);
        Assert.assertEquals(1, aplkacja.getListaKlientow().size());
    }

    @Test
    public void zaktualizujKlientaTest(){
        aplkacja.zaktualizujKlienta(2,"Jan", "Nowak", 50, "ul.Krótka", 87654321);
        Assert.assertEquals("Nowak", aplkacja.getListaKlientow().get(0).getNazwisko());
    }
}