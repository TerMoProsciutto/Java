import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int conta, nprec, n, cost, verifica = 0;

        do {
            System.out.println("Inserisci la quantità di numeri da inserire in ordine crescente: ");
            conta = keyboard.nextInt();
        } while (conta <= 1);

        System.out.println("Inserisci il primo numero: ");
        nprec = keyboard.nextInt();

        do {
            System.out.println("Inserisci un numero: ");
            n = keyboard.nextInt();
        } while (n <= nprec);       

        cost = n - nprec;

        nprec = n;

        for (int i = 2; i < conta; i++) {
            do {
                System.out.println("Inserisci un altro numero: ");
                n = keyboard.nextInt();
            } while (n <= nprec);

            if (n - nprec != cost) {
                verifica = 1;
                if (n - nprec > cost) {
                    cost = n - nprec;
                }
            }

            nprec = n;
        }

        if (verifica == 0) {
            System.out.println("I numeri differiscono ognuno dal precedente dal valore costante di: " + cost);
        } else {
            System.out.println("La differenza maggiore (perche' non sono tutte uguali) tra un numero e il suo precedente e' di: " + cost);
        }
    }
}