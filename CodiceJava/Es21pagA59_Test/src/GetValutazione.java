public class GetValutazione {
    public static char getValutazione(int punteggio) {

        if (punteggio < 0 || punteggio > 100) {
            throw new IllegalArgumentException();
        }

        if (punteggio <= 40) {
            return 'E';
        }
        if (punteggio <= 60) {
            return 'D';
        }
        if (punteggio <= 70) {
            return 'C';
        }
        if (punteggio <= 85) {
            return 'B';
        }
        return 'A';


    }
}
