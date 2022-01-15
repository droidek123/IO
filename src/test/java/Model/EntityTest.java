package Model;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

@Categories.SuiteClasses({KlientTest.class, ListaFilmowTest.class})
@RunWith(Categories.class)
@Categories.IncludeCategory(TestEntity.class)
public class EntityTest {
}