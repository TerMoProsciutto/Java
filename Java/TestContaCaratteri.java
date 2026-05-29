import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestContaCaratteri {
    @Test
    public void TestCaratteri(){
        String s1="ciao Pippo come stai?";
        String s2="ci";
        assertEquals(5,ContaCaratteri.contaCaratteri(s1,s2));
    }
}
