void main() {
    Biblioteca.path = "biblioteca.csv";
    try {
        Biblioteca.caricaDaFile();
    } catch (IOException e) {
        System.out.println("Errore nella lettura del file!");
        return;
    }
    Scanner keyboard = new Scanner(System.in);
    int n;
    Libro libro = new Libro("", "", "");

    do {
        try {
            visualizzaMenu();
            n = keyboard.nextInt();
            keyboard.nextLine();
            switch (n) {
                case 1:
                    Biblioteca.stampa();
                    break;
                case 2:

                    System.out.print("\nInserisci il titolo del nuovo libro: ");
                    libro.setTitolo(keyboard.nextLine());

                    System.out.print("Inserisci l'autore del nuovo libro: ");
                    libro.setAutore(keyboard.nextLine());

                    System.out.print("Inserisci l'anno di pubblicazione del nuovo libro: ");
                    libro.setAnnoPubblicazione(keyboard.nextLine());

                    Biblioteca.aggiungi(libro);

                    break;
                case 3:
                    System.out.print("\nInserisci il titolo del libro che vuoi modificare: ");
                    String titolo = keyboard.nextLine();
                    int pos = Biblioteca.ricercaPerTitolo(titolo);

                    if (pos == -1) {
                        System.out.println("Libro non trovato! ");
                    }

                    System.out.print("\nInserisci il titolo del nuovo libro: ");
                    libro.setTitolo(keyboard.nextLine());

                    System.out.print("Inserisci l'autore del nuovo libro: ");
                    libro.setAutore(keyboard.nextLine());

                    System.out.print("Inserisci l'anno di pubblicazione del nuovo libro: ");
                    libro.setAnnoPubblicazione(keyboard.nextLine());

                    Biblioteca.modifica(libro, pos);


                    break;
                case 4:
                    System.out.print("\nInserisci il titolo del libro che vuoi eliminare: ");
                    String titolo1 = keyboard.nextLine();

                    Biblioteca.elimina(titolo1);

                    break;
                case 5:
                    try {
                        Biblioteca.salvaSuFile("biblioteca_backup.csv");
                    } catch (IOException e) {
                        System.out.println("Errore nel salvataggio nel csv");
                        break;
                    }
                    System.out.println("Salvataggio avvenuto con successo!");
                    break;
                case 6:
                    System.out.println("\nChiusura del programma");
                    break;
                default:
                    System.out.println("\nErrore inserimento!\nDevi inserire un numero tra 1 e 6!");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("\nErrore inserimento!\nDevi inserire un numero tra 1 e 6!");
            keyboard.nextLine();
            n = 0;
        }

    } while (n != 6);
}

public void visualizzaMenu() {
    System.out.println("\n\n--- MENU BIBLIOTECA ---");
    System.out.println("1 - Visualizza libri");
    System.out.println("2 - Inserisci libro");
    System.out.println("3 - Modifica libro");
    System.out.println("4 - Elimina libro");
    System.out.println("5 - Esegui backup");
    System.out.println("6 - Esci");
}
