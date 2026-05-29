import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVerificaOrdine {
    @Test
    public void TestOrdineAlfabetico1() {
        String s1 = "bonomo";
        String s2 = "ferrari";
        assertEquals(0, VerificaOrdineAlfabetico.verificaOrdineAlfabeticoStringhe(s1, s2));
    }
    @Test
    public void TestOrdineAlfabetico2() {
        String s1 = "ferrari";
        String s2 = "bonomo";
        assertEquals(1, VerificaOrdineAlfabetico.verificaOrdineAlfabeticoStringhe(s1, s2));
    }
    @Test
    public void TestOrdineAlfabetico3() {
        String s1 = "ferrari";
        String s2 = "ferrari";
        assertEquals(-1, VerificaOrdineAlfabetico.verificaOrdineAlfabeticoStringhe(s1, s2));
    }
}
