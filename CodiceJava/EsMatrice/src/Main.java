final int dimensione = 11;
final int dimensioneCampiStudente = 4;
Scanner keyboard = new Scanner(System.in);

void main(String[] args) {
    String[][] studenti = GeneraStudenti.main();
    int conta = 0;


//    for (int i = 1; i < dimensione+1; i++) {
//        System.out.println("Studente n° " + i + "\nNome: " + studenti[i-1][0] + "   Cognome: " + studenti[i-1][1] + "   Email: " + studenti[i-1][2] + "   Media Voti: " + studenti[i-1][3] + "\n");
//    }

    for (int i = 0; i < dimensione; i++) {
        for (int j = 0; j < dimensioneCampiStudente; j++) {
            if (args[0].equalsIgnoreCase(studenti[i][j])) {
                switch (j) {
                    case 0:
                        System.out.println("Studente n° " + (i + 1) + "\nNome: " + studenti[i][j] + "   Cognome: " + studenti[i][j + 1] + "   Email: " + studenti[i][j + 2] + "   Media Voti: " + studenti[i][j + 3] + "\n");
                        break;
                    case 1:
                        System.out.println("Studente n° " + (i + 1) + "\nNome: " + studenti[i][j - 1] + "   Cognome: " + studenti[i][j] + "   Email: " + studenti[i][j + 1] + "   Media Voti: " + studenti[i][j + 2] + "\n");
                        break;
                    case 2:
                        System.out.println("Studente n° " + (i + 1) + "\nNome: " + studenti[i][j - 2] + "   Cognome: " + studenti[i][j - 1] + "   Email: " + studenti[i][j] + "   Media Voti: " + studenti[i][j + 1] + "\n");
                        break;
                    case 3:
                        System.out.println("Studente n° " + (i + 1) + "\nNome: " + studenti[i][j - 3] + "   Cognome: " + studenti[i][j - 2] + "   Email: " + studenti[i][j - 1] + "   Media Voti: " + studenti[i][j] + "\n");
                        break;
                }
                conta++;
            }
        }
    }
    if (conta != 0) {
        System.out.println("La parola: " + args[0].toLowerCase() + ", all'interno della classe compare: " + conta + " volta/e.");
    } else {
        System.out.println("La parola: " + args[0].toLowerCase() + ", all'interno della classe NON è presente.");
    }
}


