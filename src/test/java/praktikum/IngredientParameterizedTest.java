package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private IngredientType type;
    private String name;
    private float price;


    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParam() {
        return new Object[][]{
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "dinosaur", 200}
        };
    }

    @Test
    public void checkGetType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actual = ingredient.getType();
        IngredientType expected = type;

        Assert.assertEquals(expected, actual);
    }
}
