import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int a, b, c;
        do {
            System.out.println("Inserisci 3 numeri uno maggiore all'altro, ne verrà verificata la terna pitagorica: ");
            a = keyboard.nextInt();
            b = keyboard.nextInt();
            c = keyboard.nextInt();
        } while ((a <= 0) && (a < b && b < c));
        if (a * a + b * b == c * c) {
            System.out.println("E' una terna pitagorica");
        } else {
            System.out.println("Non e' una terna pitagorica");
        }
    }
}