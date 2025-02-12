package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseTest {

    @Test
    public void checkAvailableBuns(){

        Database database = new Database();
        List<Bun> actual = database.availableBuns();
        assertEquals(3, actual.size());
    }
}