import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPalindroma {

    @Test
    public void palindroma() {
        String frase = "PippiP";

        assertTrue(VerificaPalindroma.verificaStringaPalindroma(frase));

    }

    @Test
    public void nonPalindroma() {
        String frase = "Ciao Pippo";

        assertFalse(VerificaPalindroma.verificaStringaPalindroma(frase));
    }

}
