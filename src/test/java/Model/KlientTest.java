package Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

@Category({TestEntity.class})
public class KlientTest {
    Klient klient;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        Rezerwacja rezerwacja = new Rezerwacja(new Film(1,"Titanic", 2000,120,20,"zły","suahili"));
        List<Rezerwacja> lista = new ArrayList<>();
        lista.add(rezerwacja);
        klient = new Klient(1, "Jan", "Kowalski", 12, "Długa", 123456789);
        klient.setListaRezerwacje(lista);
    }

    @Test
    public void countWyp(){
        Assert.assertEquals(0,klient.countWyp());
    }

    @Test
    public void countRez(){
        Assert.assertEquals(1,klient.countRez());
    }
}
