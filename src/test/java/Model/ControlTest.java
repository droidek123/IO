package Model;

import Kontroler.AplkacjaTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

@Categories.SuiteClasses({AplkacjaTest.class})
@RunWith(Categories.class)
@Categories.IncludeCategory(TestControl.class)
public class ControlTest {
}