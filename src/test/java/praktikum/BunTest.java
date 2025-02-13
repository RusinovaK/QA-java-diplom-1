package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    @Test
    public void checkGetName() {
        Bun bun = new Bun("black bun", 100);
        String actual = bun.getName();
        String expected = "black bun";

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void checkGetPrice() {
        Bun bun = new Bun("white bun", 200);
        float actual = bun.getPrice();
        float expected = 200;

        Assert.assertEquals(expected, actual, 0);
    }
}