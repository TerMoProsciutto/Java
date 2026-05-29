import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGetRipetizioniChar {

    @Test
    public void TestCharRipetente() {

        String frase = "Ciao pippo come stai?";

        Risultato oggetto = GetRipetizioniChar.getResult(frase);

        assertEquals('i', oggetto.getCarattere());
        assertEquals(3, oggetto.getRipetizioni());

    }

}
