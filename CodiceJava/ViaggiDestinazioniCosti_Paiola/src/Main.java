
public static int[][][] costi_viaggi;
public static String[] classi = new String[50];
public static String[] destinazioni;
public static int N;
public static int D;
public static Scanner key = new Scanner(System.in);


/*
input stream reader restituisce un carattere alla volta, leggendo un numero variabile di dati dall input stream
la quantita dipende dalla codifica che si usa, serve per leggere testo partendo da byte, tutto quello che arrivi
dall' esterno è byte (file/tastiera), il streamreader si occupa di fare da ponte;

streamreader fa:

- Riceve byte
- Decodifica
- Restituisce a java dei char



buffered reader deve appoggiarsi ad un reader sottostante, e l'unico reader che puo stare sopra un system.in è
input stream reader

*/
void main() throws FileNotFoundException {

    Scanner keyboard = new Scanner(new BufferedReader(new FileReader("nome.csv")));
    inserimento();

    int risp = 0;

    while (risp != 10) {
        System.out.println(
                "\n---MENU---\n" +
                        "1. mostrare il costo totale di una destinazione per una classe\n" +
                        "2. mostrare il costo totale di una classe su tutte le destinazioni\n" +
                        "3. trovare la destinazione più costosa per una classe\n" +
                        "4. trovare la classe che spende di più in totale\n" +
                        "5. mostrare la tabella dei costi (trasporto, vitto, alloggio) per una classe e una destinazione\n" +
                        "6. stampare tutti i dati inseriti\n" +
                        "10. Fine\n");
        if (!key.hasNextInt()) {
            System.out.println("Inserisci un numero valido.");
            key.nextLine();
            continue;
        }

        risp = key.nextInt();
        key.nextLine();

        switch (risp) {
            case 1:
                punto1();
                break;
            case 2:
                punto2();
                break;
            case 3:
                punto3();
                break;
            case 4:
                punto4();
                break;
            case 5:
                punto5();
                break;
            case 6:
                punto6();
                break;
            case 10:
                break;
            default:
                System.out.println("Errore di inserimento");
                break;

        }
    }


}

private void punto6() {

    System.out.println("Stampa completa dei dati: ");
    for (int c = 0; c < N; c++) {
        System.out.println("Classe " + classi[c]);
        for (int d = 0; d < D; d++) {
            System.out.println("Destinazione: " + destinazioni[d]);
            System.out.println("Trasporto: " + costi_viaggi[c][d][0]);
            System.out.println("Vitto: " + costi_viaggi[c][d][1]);
            System.out.println("Alloggio: " + costi_viaggi[c][d][2]);
            System.out.println("Totale costi: " + (costi_viaggi[c][d][0] + costi_viaggi[c][d][1] + costi_viaggi[c][d][2]));

        }
    }

}

private void punto5() {
    int c = scegliClasse();
    int d = scegliDestinazione();
    System.out.println("\nTabella costi per classe " + classi[c] + " con destinazione " + destinazioni[d]);
    System.out.println("Trasporto: " + costi_viaggi[c][d][0]);
    System.out.println("Vitto: " + costi_viaggi[c][d][1]);
    System.out.println("Alloggio: " + costi_viaggi[c][d][2]);
    System.out.println("Totale costi: " + (costi_viaggi[c][d][0] + costi_viaggi[c][d][1] + costi_viaggi[c][d][2]));
}

private void punto4() {

    int max = -1;
    int classeMax = 0;
    for (int c = 0; c < N; c++) {
        int tot = 0;
        for (int d = 0; d < D; d++) {
            tot += costi_viaggi[c][d][0] + costi_viaggi[c][d][1] + costi_viaggi[c][d][2];
        }
        if (tot > max) {
            max = tot;
            classeMax = c;
        }
    }
    System.out.println("La classe che spende di piu e " + classi[classeMax] + " con euro " + max);


}

private void punto3() {
    int c = scegliClasse();
    int max = -1;
    int destMax = 0;
    for (int d = 0; d < D; d++) {
        int tot = costi_viaggi[c][d][0] + costi_viaggi[c][d][1] + costi_viaggi[c][d][2];
        if (tot > max) {
            max = tot;
            destMax = d;
        }
    }
    System.out.println("La destinazione piu costosa per la classe " + classi[c] + " è: " + destinazioni[destMax] + " con euro " + max);
}

private void punto2() {
    int c = scegliClasse();
    int totale = 0;
    for (int d = 0; d < D; d++) {
        totale += costi_viaggi[c][d][0] + costi_viaggi[c][d][1] + costi_viaggi[c][d][2];
    }
    System.out.println("Il costo totale per la classe " + classi[c] + "su tutte le destinazioni è di: " + totale);
}


private void punto1() {
    int c = scegliClasse();
    int d = scegliDestinazione();
    int totale = costi_viaggi[c][d][0] + costi_viaggi[c][d][1] + costi_viaggi[c][d][2];
    System.out.println("Il costo totale per la classe " + classi[c] + " alla destinazione " + destinazioni[d] + " è di: " + totale);
}

public void inserimento() {
    do {
        System.out.println("Quante classi vuoi inserire?");
        if (!key.hasNextInt()) {
            System.out.println("Inserisci un numero valido");
            key.nextLine();
            continue;
        }
        N = key.nextInt();
        key.nextLine();
        if (N <= 0) {
            System.out.println("Inserisci un numero positivo");
        }
    } while (N <= 0);

    for (int i = 0; i < N; i++) {
        do {
            System.out.println("Nome classe " + i);
            classi[i] = key.nextLine();
            if (classi[i].isEmpty()) {
                System.out.println("Il nome della classe non puo essere vuoto");
            }
        } while (classi[i].isEmpty());
    }

    do {
        System.out.println("Quante destinazioni vuoi inserire?");
        if (!key.hasNextInt()) {
            System.out.println("Inserisci un numero valido");
            key.nextLine();
            continue;
        }
        D = key.nextInt();
        key.nextLine();
        if (D <= 0) {
            System.out.println("Inserisci un numero positivo");
        }
    } while (D <= 0);
    destinazioni = new String[D];
    costi_viaggi = new int[N][D][3];
    System.out.println("Inserisci i nomi delle destinazioni");
    for (int i = 0; i < D; i++) {
        do {
            System.out.println("Destinazione " + i);
            destinazioni[i] = key.nextLine();
            if (destinazioni[i].isEmpty()) {
                System.out.println("La destinazione non puo essere vuota");
            }
        } while (destinazioni[i].isEmpty());
        System.out.println("\nInserimento costi (trasporto, vitto, alloggio): ");
        for (int c = 0; c < N; c++) {
            for (int d = 0; d < D; d++) {
                System.out.println("\nClasse: " + classi[c] + "\n destinazione " + destinazioni[d]);
                costi_viaggi[c][d][0] = leggiCosto("Costo trasporto: ");
                costi_viaggi[c][d][1] = leggiCosto("Costo vitto: ");
                costi_viaggi[c][d][2] = leggiCosto("Costo alloggio: ");
            }
        }
    }
}

private static int leggiCosto(String s) {
    int costo = -1;
    do {
        System.out.println(s);
        if (!key.hasNextInt()) {
            System.out.println("Inserisci un numero valido");
            key.nextLine();
            continue;
        }
        costo = key.nextInt();
        if (costo <= 0) {
            System.out.println("Errore, il costo non puo essere negativo");
        }
    } while (costo <= 0);
    return costo;
}

public static int scegliClasse() {
    int pos = -1;
    String nome;
    do {
        System.out.println("Inserisci nome della classe");
        nome = key.nextLine();
        pos = cercaClasse(nome);
        if (pos == -1)
            System.out.println("Classe non trovata");
    } while (pos == -1);
    return pos;
}

public static int scegliDestinazione() {
    int pos = -1;
    String nome;
    do {
        System.out.println("Inserisci nome della destinazione");
        nome = key.nextLine();
        pos = cercaDestinazione(nome);
        if (pos == -1)
            System.out.println("Destinazione non trovata");
    } while (pos == -1);
    return pos;
}

private static int cercaClasse(String nome) {
    for (int i = 0; i < N; i++) {
        if (classi[i].equalsIgnoreCase(nome))
            return i;
    }
    return -1;
}

private static int cercaDestinazione(String nome) {
    for (int i = 0; i < D; i++) {
        if (destinazioni[i].equalsIgnoreCase(nome))
            return i;
    }
    return -1;
}