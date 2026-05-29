import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class TestCreaArrayInRange {

    @Test
    public void testArray() {
        int min = 2, max = 7;
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }
        ArrayList<Integer> array2 = CreaArrayInRange.creaArrayInRange(array, min, max);

        for (int i = array.size() - 1; i >= 0; i--) {
            if (array.get(i) < min || array.get(i) > max) {
                array.remove(i);
            }
        }

        assertEquals(array, array2);

    }

}
