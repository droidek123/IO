package Model;

import mockit.Mocked;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.ErrorCollector;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

@Category({TestEntity.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KlientTest {
    Klient klient;
    @Rule
    public ErrorCollector error = new ErrorCollector();

    @Mocked
    Rezerwacja rezerwacja = new Rezerwacja(new Film(1,"Titanic", 2000,120,20,"zły","suahili"));

    @Before
    public void setUp() {
        List<Rezerwacja> lista = new ArrayList<>();
        lista.add(rezerwacja);
        klient = new Klient(1, "Jan", "Kowalski", 12, "Długa", 123456789);
        klient.setListaRezerwacje(lista);
    }

    @Test
    public void countWypTest(){
        Assert.assertEquals(0,klient.countWyp());
    }

    @Test
    public void countRezTest(){
        Assert.assertEquals(1,klient.countRez());
        error.addError(new Throwable("Błąd"));
    }
}
