package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun stabBun;

    @Mock
    private Ingredient stabIngredient;

    @Mock
    private Ingredient stabIngredientSec;

    @Mock
    private Burger stabBurger;

    @Test
    public void checkSetBuns() {
        float expectedPrice = 200;
        String expectedName = "white bun";

        Burger burger = new Burger(stabBun);
        burger.setBuns(new Bun(expectedName, expectedPrice));

        when(stabBun.getPrice()).thenReturn(expectedPrice);
        when(stabBun.getName()).thenReturn(expectedName);

        float actualPrice = stabBun.getPrice();
        String actualName = stabBun.getName();

        Assert.assertEquals(expectedPrice, actualPrice, 0);
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void checkAddIngredient() {
        IngredientType expectedType = IngredientType.SAUCE;
        String expectedName = "hot sauce";
        float expectedPrice = 100;

        Burger burger = new Burger(stabIngredient);
        burger.addIngredient(new Ingredient(expectedType, expectedName, expectedPrice));

        when(stabIngredient.getType()).thenReturn(expectedType);
        when(stabIngredient.getName()).thenReturn(expectedName);
        when(stabIngredient.getPrice()).thenReturn(expectedPrice);

        IngredientType actualType = stabIngredient.getType();
        String actualName = stabIngredient.getName();
        float actualPrice = stabIngredient.getPrice();

        Assert.assertEquals(expectedType, actualType);
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void checkRemoveIngredient() {
        IngredientType expectedType = IngredientType.FILLING;
        String expectedName = "sausage";
        float expectedPrice = 300;

        Burger burger = new Burger(stabIngredient);
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(expectedType, expectedName, expectedPrice));
        burger.removeIngredient(0);

        when(stabIngredient.getType()).thenReturn(expectedType);
        when(stabIngredient.getName()).thenReturn(expectedName);
        when(stabIngredient.getPrice()).thenReturn(expectedPrice);

        IngredientType actualType = stabIngredient.getType();
        String actualName = stabIngredient.getName();
        float actualPrice = stabIngredient.getPrice();

        Assert.assertEquals(expectedType, actualType);
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void checkMoveIngredient() {
        IngredientType expectedType = IngredientType.SAUCE;
        String expectedName = "chili sauce";
        float expectedPrice = 300;

        Burger burger = new Burger(stabIngredient);
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        burger.addIngredient(new Ingredient(expectedType, expectedName, expectedPrice));
        burger.moveIngredient(2, 0);

        when(stabIngredient.getType()).thenReturn(expectedType);
        when(stabIngredient.getName()).thenReturn(expectedName);
        when(stabIngredient.getPrice()).thenReturn(expectedPrice);

        IngredientType actualType = stabIngredient.getType();
        String actualName = stabIngredient.getName();
        float actualPrice = stabIngredient.getPrice();

        Assert.assertEquals(expectedType, actualType);
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void checkGetPrice() {
        when(stabBun.getPrice()).thenReturn(100F);
        when(stabIngredient.getPrice()).thenReturn(100F);
        when(stabIngredientSec.getPrice()).thenReturn(200F);

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(stabIngredient);
        ingredients.add(stabIngredientSec);

        Burger burger = new Burger(stabBun, ingredients);

        float actual = burger.getPrice();
        float expected = (100 * 2) + 100 + 200;
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void checkGetReceipt() {

        when(stabBun.getName()).thenReturn("red bun");
        when(stabIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(stabIngredient.getName()).thenReturn("cutlet");
        when(stabIngredientSec.getType()).thenReturn(IngredientType.FILLING);
        when(stabIngredientSec.getName()).thenReturn("dinosaur");

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(stabIngredient);
        ingredients.add(stabIngredientSec);

        stabBurger = new Burger(stabBun, ingredients);

        when(stabBurger.getPrice()).thenReturn(900F);
        String actual = stabBurger.getReceipt();
        String expected = "(==== red bun ====)" + "\n" + "= filling cutlet =" + "\n" + "= filling dinosaur =" + "\n" + "(==== red bun ====)" + "\n" + "\n" + "Price: 900,000000" + "\n";

        Assert.assertEquals(expected, actual);
    }
}