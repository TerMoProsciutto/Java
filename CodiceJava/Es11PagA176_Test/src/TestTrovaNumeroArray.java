import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTrovaNumeroArray {

    public int[] array = {10, 20, 30, 40};

    @Test
    public void numeroPresente() {
        int n = 10;
        assertTrue(IsNumberArray.isNumberInArray(n, array));
    }

    @Test
    public void numeroNonPresente() {
        int n = 5;
        assertFalse(IsNumberArray.isNumberInArray(n, array));
    }
}
