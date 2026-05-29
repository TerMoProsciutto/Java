import javax.print.DocFlavor;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Utilizzo del software: Main <distanza> <passi>");
            System.out.println("Esempio: $ java Main 120 30");
            return;
        }
        //TODO: veficare che args[0] e args[1] siano numeri

        char numero0 = (char) args[0];
        if(numero0 < 48 || numero0 > 57){
            System.out.println("La distanza deve essere espressa in numero e non in lettera");
            return;
        }

        int n = Integer.parseInt(args[1]);
        double distanza = Double.parseDouble(args[0]);


        if (distanza < 0 || n < 0) {
            System.out.println("Utilizzo del software: Main <distanza> <passi>");
            System.out.println("Esempio: $ java Main 120 30");
            return;
        }

        double coperta = 0.0;
        double rimanente = distanza;

        for (int i = 0; i < n; i++) {
            double passo = rimanente / 2.0; // metà della distanza rimanente
            coperta = coperta + passo;
            rimanente = rimanente - passo;
        }

        System.out.printf("Distanza effettivamente coperta: %.8f%n", coperta);
        System.out.printf("Distanza rimanente: %.8f%n", rimanente);

    }
}
