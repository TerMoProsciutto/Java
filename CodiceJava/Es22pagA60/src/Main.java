import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int costo;
        System.out.println("Inserisci per quanto si desidera l'abbonamento (settimanale = 0, mensile = 1, annuale = 3): ");
        int durata = keyboard.nextInt();
        System.out.println("Inserisci il tipo di zona in cui l'abbonamento sara' valido(zona centrale = 0, zona periferica = 1, entrambe le zone = 2): ");
        int zona = keyboard.nextInt();
        System.out.println("Desideri un'abbonamento che non funzioni durante le ore di punta? (nel caso verra' effettuato lo sconto del 20%, 0 = no, 1 = si); ");
        int sconto = keyboard.nextInt();
        if (zona == 0) {
            if (durata == 0) {
                costo = 10;
            } else if (durata == 1) {
                costo = 30;
            } else {
                costo = 250;
            }
        } else if (zona == 1) {
            if (durata == 0) {
                costo = 5;
            } else if (durata == 1) {
                costo = 20;
            } else {
                costo = 150;
            }
        } else {
            if (durata == 0) {
                costo = 15;
            } else if (durata == 1) {
                costo = 40;
            } else {
                costo = 300;
            }
        }
        if (sconto == 1) {
            costo = (costo / 100) * 80;
        }
        System.out.println("Il costo dell'abbonamento e' di: " + costo);
    }
}