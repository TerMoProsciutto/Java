void main() {
    Scanner keyboard = new Scanner(System.in);
    int maggiorenni = 0, minorenni = 0, numero, N = 3;
    for (int i = 1; i <= N; i++) {
        do {
            System.out.print("Inserisci la " + i + "^ entrata, dicendo se è minorenne(1) o maggiorenne(2): ");
            numero = keyboard.nextInt();

            if (numero < 1 || numero > 2) System.out.println("Errore Inserimento");

        } while (numero < 1 || numero > 2);

        if (numero == 1) {
            minorenni += 1;
        } else {
            maggiorenni += 1;
        }
    }
    System.out.print("Il numero di minorenni è: " + minorenni + "\nIl numero di maggiorenni è: " + maggiorenni);
}
