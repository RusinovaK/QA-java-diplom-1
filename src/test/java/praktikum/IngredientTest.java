package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    @Test
    public void checkGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        float actual = ingredient.getPrice();
        float expected = 100;

        Assert.assertEquals(expected, actual, 0);
    }
    @Test
    public void checkGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        String actual = ingredient.getName();
        String expected = "cutlet";

        Assert.assertEquals(expected, actual);
    }
}