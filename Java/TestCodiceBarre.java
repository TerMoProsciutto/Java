import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCodiceBarre {
    @Test
    public void TestTredicesimoCodiceBarre() {
        int[] codiceBarre = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertEquals(4, CodiceBarre.calcolaTredicesimo(codiceBarre));
    }

    @Test
    public void TestTredicesimoCodiceBarreScorretto() {
        int[] codiceBarre = {1, 1};

        assertEquals(-1, CodiceBarre.calcolaTredicesimo(codiceBarre));
    }
}
