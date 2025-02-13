package praktikum;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    @Test
    public void checkAvailableBuns(){

        Database database = new Database();
        List<Bun> actual = database.availableBuns();
        assertEquals(3, actual.size());
    }
}