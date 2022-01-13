package Model;

import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;


@Category({TestControl.class})
public class ListaFilmowTest {
    ListaFilmow listaFilmow;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        listaFilmow = new ListaFilmow();
    }

    @Test
    public void zaktualizujFilmTest() {
        listaFilmow.dodajFilm("Titanic", 2000,120,20,"zły","suahili");
        listaFilmow.zaktualizujFilm(1, "Shrek", 2001,121,21, "dobry", "angielski");
        Assert.assertEquals("Shrek",listaFilmow.getListaFilmow().get(0).getNazwaFilmu());
    }

    @Test
    public void przekazFilmDoWypTest(){
        listaFilmow.dodajFilm("Titanic", 2000,120,20,"zły","suahili");
        listaFilmow.przekazFilmDoWyp(1);
        Assert.assertTrue(listaFilmow.getListaFilmow().isEmpty());
    }
}