/*
Obiettivo
Realizzare un programma Java che permetta di gestire una rubrica telefonica, leggendo e
scrivendo i dati da/verso un file CSV, utilizzando array e metodi.

File di lavoro
Il programma deve utilizzare un file chiamato: rubrica.csv. Ogni riga del file contiene un
contatto nel seguente formato: nome,cognome,telefono

Vincoli obbligatori
● Usare array
● Usare metodi
● NON usare: ArrayList, HashMap

Struttura dati
La rubrica deve essere gestita tramite array paralleli: nome, cognome, telefono

Metodi da realizzare
Il programma DEVE essere suddiviso nei seguenti metodi:
1. Lettura iniziale della rubrica da file CSV
2. Visualizzazione della rubrica
3. Inserimento di un nuovo contatto
4. Modifica di un contatto esistente
5. Eliminazione di un contatto
6. Backup della rubrica su un nuovo file CSV
7. Menu di scelta

Funzionalità richieste
All’avvio il programma deve leggere il file rubrica.csv e caricare i contatti negli array.

Il programma deve mostrare ciclicamente il seguente menu:
1. Visualizza rubrica
2. Inserisci nuovo contatto
3. Modifica contatto
4. Elimina contatto
5. Cerca contatto
5. Crea backup della rubrica
0. Esci
*/

public static final int DIM = 30;   //Gestisce la dimensione massima della rubrica (numero di contatti massimi)

/*
PROBLEMI DEL CODICE:

-Quando ricerco un contatto per qualsiasi cosa (solo ricerca, eliminazione, modifica) prende il primo che trova all'interno dell'array


 */

void main() throws IOException, InterruptedException {
    Scanner keyboard = new Scanner(System.in);
    String[][] rubrica = new String[DIM][3];
    int ultimo = popolaRubrica(rubrica);

    do {
        try {
            visualizzaMenu();
            int n = keyboard.nextInt();
            switch (n) {
                case 0:
                    salvataggioAutomatico(rubrica, ultimo);
                    return;
                case 1:
                    visualizzaRubrica(rubrica, ultimo);
                    break;
                case 2:
                    nuovoContatto(rubrica, ultimo);
                    ultimo++;
                    break;
                case 3:
                    modificaContatto(rubrica, ultimo);
                    break;
                case 4:
                    int elimina = eliminaContatto(rubrica, ultimo);
                    if (elimina == 0) {
                        ultimo--;
                    }
                    break;
                case 5:
                    cercaContatto(rubrica, ultimo);
                    break;
                case 6:
                    copiaBackup(rubrica, ultimo);
                    break;
                default:
                    System.out.println("\nErrore, inserisci un numero valido!!!");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("\nErrore, inserisci un numero!!!"); //nel caso inserisco qualche lettera catturo l'eccezione
            keyboard.nextLine();
        }
        Thread.sleep(1000); //aggiunge delay al menu
    } while (true);

}

private static void visualizzaMenu() {
    System.out.println("""
            
            MENU:
            1. Visualizza rubrica
            2. Inserisci nuovo contatto
            3. Modifica contatto
            4. Elimina contatto
            5. Cerca contatto
            6. Crea backup della rubrica
            0. Esci""");
}

public void salvataggioAutomatico(String[][] rubrica, int ultimo) throws IOException {
    BufferedWriter out = new BufferedWriter(new FileWriter("rubrica.csv"));

    for (int i = 0; i < ultimo; i++) {
        for (int j = 0; j < rubrica[i].length; j++) {
            out.append(rubrica[i][j]);
            if (j != rubrica[i].length - 1) {
                out.append(',');
            }
        }
        if (i != ultimo - 1) {
            out.newLine();
        }

    }
    out.close();
    System.out.println("Salvataggio automatico effettuato con successo!!!");
}

public void copiaBackup(String[][] rubrica, int ultimo) throws IOException {
    BufferedWriter out = new BufferedWriter(new FileWriter("backup.csv"));

    for (int i = 0; i < ultimo; i++) {
        for (int j = 0; j < rubrica[i].length; j++) {
            out.append(rubrica[i][j]);
            if (j != rubrica[i].length - 1) {
                out.append(',');
            }
        }
        if (i != ultimo - 1) {
            out.newLine();
        }

    }
    out.close();
    System.out.println("Backup effettuato con successo!!!");
}

public static void cercaContatto(String[][] rubrica, int ultimo) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Inserisci un campo del contatto: ");
    String campo = keyboard.nextLine();
    int numeroContatto = ricercaCampo(rubrica, campo, ultimo);
    if (numeroContatto != -1) {
        System.out.println("\nContatto trovato!\nNome:" + rubrica[numeroContatto][0] + "\nCognome: " + rubrica[numeroContatto][1] + "\nNumero Telefonico: " + rubrica[numeroContatto][2]);
    } else {
        System.out.println("Contatto non trovato!!");
    }
}

public int eliminaContatto(String[][] rubrica, int ultimo) {
    Scanner keyboard = new Scanner(System.in);
    int numeroContatto;


    System.out.println("Inserisci un campo del contatto: ");
    String ricerca = keyboard.nextLine();
    numeroContatto = ricercaCampo(rubrica, ricerca, ultimo);

    if (numeroContatto == -1) {
        System.out.println("Contatto non trovato!!");
        return -1;
    }

    System.out.println("Contatto trovato!\nNome:" + rubrica[numeroContatto][0] + "\nCognome: " + rubrica[numeroContatto][1] + "\nNumero Telefonico: " + rubrica[numeroContatto][2]);
    System.out.println("Sei sicuro di volerlo cancellare dalla rubrica? (0=no, 1=si): ");
    int x = keyboard.nextInt();
    if (x == 1) {
        for (int i = numeroContatto; i < ultimo; i++) {
            rubrica[i] = rubrica[i + 1];
        }
        return 0;
    }
    return -1;
}

public void modificaContatto(String[][] rubrica, int ultimo) {
    Scanner keyboard = new Scanner(System.in);
    boolean scelta;
    int numeroContatto;


    System.out.println("Inserisci un campo del contatto: ");
    String ricerca = keyboard.nextLine();
    numeroContatto = ricercaCampo(rubrica, ricerca, ultimo);

    if (numeroContatto == -1) {
        System.out.println("Contatto non trovato!!");
        return;
    }

    System.out.println("Contatto trovato!\nNome:" + rubrica[numeroContatto][0] + "\nCognome: " + rubrica[numeroContatto][1] + "\nNumero Telefonico: " + rubrica[numeroContatto][2]);
    do {
        System.out.println("\nCosa vuoi modificare?\n1.Nome\n2.Cognome\n3.Numero");
        int n = keyboard.nextInt();
        keyboard.nextLine();
        switch (n) {
            case 1:
                do {
                    System.out.println("Inserire nome: ");
                    rubrica[numeroContatto][0] = keyboard.nextLine();
                } while (rubrica[numeroContatto][0].contains(","));
                break;
            case 2:
                do {
                    System.out.println("Inserire cognome: ");
                    rubrica[numeroContatto][1] = keyboard.nextLine();
                } while (rubrica[numeroContatto][1].contains(","));
                break;
            case 3:
                controlloNumeroTelefonico(rubrica, numeroContatto, keyboard);
                break;
            default:
                System.out.println("Inserimento scorrettooo!!!");

        }
        System.out.println("Contatto Modificato!!");
        System.out.println("Desideri modificare qualcos'altro del precedente contatto? (0=no, 1=si): ");
        int x = keyboard.nextInt();
        if (x == 1) {
            scelta = true;
        } else {
            scelta = false;
        }
    } while (scelta);


}

//DA SISTEMARE
public static int ricercaCampo(String[][] rubrica, String ricerca, int ultimo) {
    for (int i = 0; i < ultimo; i++) {
        for (int k = 0; k < rubrica[i].length; k++) {
            if (rubrica[i][k].equalsIgnoreCase(ricerca)) {
                return i;
            }
        }
    }
    return -1;
}


public static void nuovoContatto(String[][] rubrica, int ultimo) {
    Scanner keyboard = new Scanner(System.in);

    do {
        System.out.println("Inserisci nome: ");
        rubrica[ultimo][0] = keyboard.nextLine();
    } while (rubrica[ultimo][0].contains(","));

    do {
        System.out.println("Inserisci cognome: ");
        rubrica[ultimo][1] = keyboard.nextLine();
    } while (rubrica[ultimo][1].contains(","));

    controlloNumeroTelefonico(rubrica, ultimo, keyboard);
    System.out.println("Contatto Creato!!");
}

public static void controlloNumeroTelefonico(String[][] rubrica, int pos, Scanner keyboard) {
    do {
        boolean contieneparola = false;
        System.out.println("Inserisci numero telefonico (deve essere composto da 10 numeri): ");
        rubrica[pos][2] = keyboard.nextLine();
        if (rubrica[pos][2].length() == 10) {
            for (int i = 0; i < 10; i++) {
                if (rubrica[pos][2].charAt(i) > 57 || rubrica[pos][2].charAt(i) < 48) {
                    contieneparola = true;
                    break;
                }
            }
            if (contieneparola) {
                System.out.println("Devi inserire un numero!!!");
                rubrica[pos][2] = "";
            }
        }
    } while (rubrica[pos][2].length() != 10);
}

public static int popolaRubrica(String[][] rubrica) throws IOException {
    String line;
    BufferedReader input = new BufferedReader(new FileReader("rubrica.csv"));
    int i = 0;


    line = input.readLine();
    while (line != null && !line.equals("")) {  //Controllo se line sia diverso da "" perche nel caso in cui nel csv ci siano degli spazi non mi rovinino il programma (ultimo)
        rubrica[i] = line.split(",");

        boolean numeroNonCorretto = false;  //controllo che il numero sia della grandezza giusta e contiene solo numeri altrimenti non salvo il contatto nella matrice
        if (rubrica[i][2].length() != 10) {
            numeroNonCorretto = true;
        } else {
            for (int j = 0; j < 10; j++) {
                if (rubrica[i][2].charAt(j) > 57 || rubrica[i][2].charAt(j) < 48) { //Controllo char per char che il numero non contanga lettere
                    numeroNonCorretto = true;
                    break;
                }
            }
        }
        if (numeroNonCorretto) {
            rubrica[i] = null;
        } else {
            i++;
        }
        line = input.readLine();
    }

    return i;
}

public static void visualizzaRubrica(String rubrica[][], int ultimo) {
    for (int i = 0; i < ultimo; i++) {
        System.out.println("\nContatto n° " + (i + 1));
        System.out.println("Nome: " + rubrica[i][0]);
        System.out.println("Cognome: " + rubrica[i][1]);
        System.out.println("Numero Telefonico: " + rubrica[i][2]);
    }
}