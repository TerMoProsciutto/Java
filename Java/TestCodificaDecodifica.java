import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCodificaDecodifica {
    @Test
    public void TestCodifica(){
        String parola = "ParolaCodificata";
        assertEquals("CnebynPbqvsvpngn", CodificaDecodificaDiUnaStringa.codificaStringa(parola,1,13));
    }
    @Test
    public void TestDecodifica(){
        String parola = "CnebynPbqvsvpngn";
        assertEquals("ParolaCodificata", CodificaDecodificaDiUnaStringa.codificaStringa(parola,1,13));
    }
}
