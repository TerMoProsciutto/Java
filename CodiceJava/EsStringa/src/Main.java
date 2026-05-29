public class Main {
    void main(String[] args) {
        String str = args[0];
        int dimensione = str.length();

        System.out.println("Dimensione: " + dimensione);
        System.out.println("Primo carattere: " + str.substring(0, 1));
        System.out.println("Ultimo carattere: " + str.substring(dimensione - 1));
        System.out.println("La stringa tutta in maiuscolo è: " + str.toUpperCase());

        if (dimensione - 1 < 3) {
            System.out.println("Parola troppo corta per estrarre una sottostringa di 3 caratteri.");
        } else {
            System.out.println("Primi 3 caratteri: " + str.substring(0, 3));
        }
    }
}