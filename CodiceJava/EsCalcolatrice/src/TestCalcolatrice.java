import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalcolatrice {

    @Test // Annotazione che indica che questo metodo è un test
    public void testAddizione() {
        Calcolatrice calculator = new Calcolatrice();
        calculator.setA(2);
        calculator.setB(3);
        double result = calculator.addizione();

        // Assert che verifica se il risultato atteso è uguale a quello ottenuto
        assertEquals(5, result);
    }

    @Test
    public void testSottrazione() {
        Calcolatrice calculator = new Calcolatrice();
        calculator.setA(10);
        calculator.setB(3);
        double result = calculator.sottrazione();

        // Assert che verifica se il risultato atteso è uguale a quello ottenuto
        assertEquals(7, result);
    }

    @Test
    public void testMoltiplicazione() {
        Calcolatrice calculator = new Calcolatrice();
        calculator.setA(20);
        calculator.setB(3);
        double result = calculator.moltiplicazione();

        // Assert che verifica se il risultato atteso è uguale a quello ottenuto
        assertEquals(60, result);
    }

    @Test
    public void testDivisione(){
        Calcolatrice calculator = new Calcolatrice();
        calculator.setA(6);
        calculator.setB(3);
        double result = calculator.divisione();

        // Assert che verifica se il risultato atteso è uguale a quello ottenuto
        assertEquals(2, result);
    }

    @Test
    public void TestDivisioneImpossibile() {
        Calcolatrice calculator = new Calcolatrice();
        calculator.setA(10);
        calculator.setB(0);

        //Uso assertThrows per catturare un eccezione generica, mentre assertThrowsExactly per un eccezione specifica
        assertThrows(Exception.class, calculator::divisione);
    }
}