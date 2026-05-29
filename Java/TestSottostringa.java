import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSottostringa {

    @Test
    public void Presente() {
        String s1 = "ciao pippo come stai?";
        String s2 = "pippo";
        assertEquals(5,Sottostringa.puntoDiPartenzaSottostringa(s1, s2));
    }

    @Test
    public void NonPresente() {
        String s1 = "ciao pippo come stai?";
        String s2 = "astat";
        assertEquals(-1,Sottostringa.puntoDiPartenzaSottostringa(s1, s2));
    }
}
