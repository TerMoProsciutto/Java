import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestContaNumeriInRange {

    static int[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

    @Test
    public void testConta(){
        assertEquals(3,ContaNumeriInRange.contaNumeriInRange(array,30,50));
    }

}
