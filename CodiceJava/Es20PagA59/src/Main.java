import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Inserisci il prezzo da pagare(ne verrà effettuato lo sconto: ");
        float prezzo = keyboard.nextFloat();
        if (prezzo > 0) {
            if (prezzo < 50) {
                prezzo = prezzo / 100 * 95;
            } else if (prezzo < 100) {
                prezzo = prezzo / 100 * 90;
            } else {
                prezzo = prezzo / 100 * 80;
            }
            System.out.println("Il prezzo da pagare scontato e' di: " + prezzo);
        } else {
            System.out.println("Errore");
        }
    }
}