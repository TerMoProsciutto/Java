static Scanner keyboard = new Scanner(System.in);

void main() {
    int n = 0;
    String[][] rubrica = {
            {"Pippo", "Pigrone", "1233210110"},
            {"Umberto", "Alfredo", "1937205283"},
            {"Md", "Buonaspesaitalia", "3890607534"},
            {"Tommaso", "Italico", "0172836452"},
            {"Gianpippo", "Calzelungo", "1042084116"},
            {"Benito", "Massari", "1923813149"}
    };

    do {
        try {
            System.out.println("inserire i seguenti numeri per fare le seguenti azioni:\n1.Cerca contatto all'interno della rubrica\n2.Visualizzare tutti i contatti della rubrica\n3.Uscire dal programma");
            n = keyboard.nextInt();

            System.out.print("\n");
            switch (n) {
                default:
                    System.out.println("Inserimento sbagliato!!!\n\n");
                    break;
                case 1:
                    String cerca = "";
                    boolean assente = true;
                    System.out.println("Per cosa vorresti cercare il contatto?\n1.Per Nome\n2.Per Cognome\n3.Per Numero Telefonico");
                    int scelta = keyboard.nextInt();
                    switch (scelta) {
                        case 1:
                            System.out.println("Inserisci il nome del contatto da cercare: ");
                            keyboard.next();
                            cerca = keyboard.nextLine();

                            for (int i = 0; i < rubrica.length; i++) {
                                if (rubrica[i][0].equalsIgnoreCase(cerca)) {
                                    System.out.println("Contatto n° " + (i + 1) + "\nNome: " + rubrica[i][0] + "   Cognome: " + rubrica[i][1] + "   Numero: " + rubrica[i][2] + "\n");
                                    assente = false;
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Inserisci il cognome del contatto da cercare: ");
                            keyboard.next();
                            cerca = keyboard.nextLine();

                            for (int i = 0; i < rubrica.length; i++) {
                                if (rubrica[i][1].equalsIgnoreCase(cerca)) {
                                    System.out.println("Contatto n° " + (i + 1) + "\nNome: " + rubrica[i][0] + "   Cognome: " + rubrica[i][1] + "   Numero: " + rubrica[i][2] + "\n");
                                    assente = false;
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Inserisci il numero del contatto da cercare: ");
                            keyboard.next();
                            cerca = keyboard.nextLine();

                            for (int i = 0; i < rubrica.length; i++) {
                                if (rubrica[i][2].equals(cerca)) {
                                    System.out.println("Contatto n° " + (i + 1) + "\nNome: " + rubrica[i][0] + "   Cognome: " + rubrica[i][1] + "   Numero: " + rubrica[i][2] + "\n");
                                    assente = false;
                                }
                            }
                            break;
                    }
                    if (assente) {
                        System.out.println("Il contatto " + cerca + " non è presente\n");
                    }
                    break;
                case 2:
                    for (int i = 0; i < rubrica.length; i++) {
                        System.out.println("Contatto n° " + (i + 1) + "\nNome: " + rubrica[i][0] + "   Cognome: " + rubrica[i][1] + "   Numero: " + rubrica[i][2] + "\n");
                    }
                    break;
                case 3:
                    return;
            }
        } catch (Exception e) {
            System.out.println("Erroreeee!!!!!\n\n");
            keyboard.next();
        }
    } while (true);
}