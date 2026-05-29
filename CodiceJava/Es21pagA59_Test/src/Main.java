import java.util.Scanner;


public static void main() {
    Scanner keyboard = new Scanner(System.in);
    int punteggio;

    do {
        System.out.println("Inserisci il punteggio dello studente: ");  //Le stringhe sono identificate dalle virgolette
        punteggio = keyboard.nextInt();
    } while (punteggio < 0);

    char valutazione = GetValutazione.getValutazione(punteggio);
    System.out.println("La valutazione è: " + valutazione);
}


