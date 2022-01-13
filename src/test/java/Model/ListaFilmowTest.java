package Model;

import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import java.util.Arrays;
import java.util.Collection;


@Category({TestControl.class})
@RunWith(Parameterized.class)
public class ListaFilmowTest {
    ListaFilmow listaFilmow;

    @Parameter
    public int id;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data1 = new Object[][]{ {0}, {1}};
        return Arrays.asList(data1);
    }

    @Rule
    public final ErrorCollector errorCollector = new ErrorCollector();

    @Before
    public void setUp() {
        listaFilmow = new ListaFilmow();
    }

    @Test
    public void zaktualizujFilmTest() {
        listaFilmow.dodajFilm("Titanic", 2000,120,20,"zły","suahili");
        listaFilmow.zaktualizujFilm(1, "Shrek", 2001,121,21, "dobry", "angielski");
        Assert.assertEquals("Shrek",listaFilmow.getListaFilmow().get(0).getNazwaFilmu());
        errorCollector.addError(new Throwable("Error"));
    }

    @Test
    public void przekazFilmDoWypTest(){
        listaFilmow.dodajFilm("Titanic", 2000,120,20,"zły","suahili");
        listaFilmow.przekazFilmDoWyp(id);
        Assert.assertTrue(listaFilmow.getListaFilmow().isEmpty());
    }
}