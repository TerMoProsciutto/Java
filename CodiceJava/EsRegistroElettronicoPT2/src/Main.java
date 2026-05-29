
//Scanner keyboard = new Scanner(System.in);

void main(String[] args) {
    String[][] studenti = GeneraStudenti.main();
    System.out.println(visualizzaMediaStudentiPerEmail(studenti, args[0]));

    //String mediaStudente = visualizzaMediaStudentiPerEmail(studenti, args[0]);
    //System.out.println(mediaStudente);
}

public static String visualizzaMediaStudentiPerEmail(String[][] studenti, String emailConMaiuscole) {
    String email = emailConMaiuscole.toLowerCase();

    if (!(email.contains("@iisviolamarchesini.edu.it"))) {
        return "Inserimento scorretto dell'email, per favore riprova utilizzando il seguente dominio:   @iisviolamarchesini.edu.it";
    }

    for (int k = 0; k < studenti.length; k++) {
        if (studenti[k][2].equals(email)) {
            return "Media studente con indirizzo " + email + ": " + studenti[k][3];
        }
    }
    return "Nessun risultato trovato!!";
}


//public static void visualizza(String[][] studenti) {
//
//    for (int i = 1; i < studenti.length + 1; i++) {
//        System.out.println("Studente n° " + i + "\nNome: " + studenti[i - 1][0] + "   Cognome: " + studenti[i - 1][1] + "   Email: " + studenti[i - 1][2] + "   Media Voti: " + studenti[i - 1][3] + "\n");
//    }
//}
//
//public static void ricercaParolaInTuttoArrayConOutput(String[][] studenti, String parola) {
//    int conta = 0;
//
//    for (int i = 0; i < studenti.length; i++) {
//        for (int j = 0; j < studenti[i].length; j++) {
//            if (parola.equalsIgnoreCase(studenti[i][j])) {
//                switch (j) {
//                    case 0:
//                        System.out.println("Studente n° " + (i + 1) + "\nNome: " + studenti[i][j] + "   Cognome: " + studenti[i][j + 1] + "   Email: " + studenti[i][j + 2] + "   Media Voti: " + studenti[i][j + 3] + "\n");
//                        break;
//                    case 1:
//                        System.out.println("Studente n° " + (i + 1) + "\nNome: " + studenti[i][j - 1] + "   Cognome: " + studenti[i][j] + "   Email: " + studenti[i][j + 1] + "   Media Voti: " + studenti[i][j + 2] + "\n");
//                        break;
//                    case 2:
//                        System.out.println("Studente n° " + (i + 1) + "\nNome: " + studenti[i][j - 2] + "   Cognome: " + studenti[i][j - 1] + "   Email: " + studenti[i][j] + "   Media Voti: " + studenti[i][j + 1] + "\n");
//                        break;
//                    case 3:
//                        System.out.println("Studente n° " + (i + 1) + "\nNome: " + studenti[i][j - 3] + "   Cognome: " + studenti[i][j - 2] + "   Email: " + studenti[i][j - 1] + "   Media Voti: " + studenti[i][j] + "\n");
//                        break;
//                }
//                conta++;
//            }
//        }
//    }
//
//    if (conta != 0) {
//        System.out.println("La parola: " + parola.toLowerCase() + ", all'interno della classe compare: " + conta + " volta/e.");
//    } else {
//        System.out.println("La parola: " + parola.toLowerCase() + ", all'interno della classe NON è presente.");
//    }
//}