import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestGetValutazione {

    @Test
    public void TestOutOfBoundMin() {
        assertThrows(IllegalArgumentException.class, () -> GetValutazione.getValutazione(-1));
    }
    @Test
    public void TestOutOfBoundMax() {
        assertThrows(IllegalArgumentException.class, () -> GetValutazione.getValutazione(101));
    }

    @Test
    public void TestE() {
        assertEquals('E', GetValutazione.getValutazione(22));
    }

    @Test
    public void TestD() {
        assertEquals('D', GetValutazione.getValutazione(51));
    }

    @Test
    public void TestC() {
        assertEquals('C', GetValutazione.getValutazione(67));
    }

    @Test
    public void TestB() {
        assertEquals('B', GetValutazione.getValutazione(77));
    }

    @Test
    public void TestA() {
        assertEquals('A', GetValutazione.getValutazione(90));
    }

}
