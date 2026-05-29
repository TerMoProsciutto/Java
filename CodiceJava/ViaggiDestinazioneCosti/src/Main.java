//Esercizio "ViaggiDestinazioneCosti"
//La scuola deve organizzare i viaggi d’istruzione per alcune classi.
//Ogni classe può andare in più destinazioni.
//Per ogni destinazione ci sono tre tipi di costo:
//- trasporto
//- vitto
//- alloggio

//I dati devono essere memorizzati in:
//- un array di stringhe con i nomi delle classi
//- un array di stringhe con i nomi delle destinazioni
//- file csv

//Il programma deve leggere da un file.csv:
//- quante classi partecipano
//- il nome di ogni classe
//- quante destinazioni sono disponibili
//- il nome di ogni destinazione

//- per ogni classe e per ogni destinazione:
//- costo del trasporto
//- costo del vitto
//- costo dell’alloggio

//Il programma deve predisporre un menu di scelta che permetta all’utente di eseguire le seguenti operazioni:
//- mostrare il costo totale di una destinazione per una classe
//- mostrare il costo totale di una classe su tutte le destinazioni
//- trovare la destinazione più costosa per una classe
//- trovare la classe che spende di più in totale
//- mostrare la tabella dei costi (trasporto, vitto, alloggio) per una classe e una destinazione
//- stampare tutti i dati inseriti
//- terminare il programma

//Gestire correttamente gli errori di input.
//Organizzare il programma in metodi.


public static Scanner keyboard = new Scanner(System.in);

void main() throws IOException, InterruptedException {
    String destinazione;
    String classe;
    do {
        System.out.println("""
                
                Menu a scelta multipla (inserire il corrispettivo numero per eseguire l'azione):
                1. mostrare il costo totale di una destinazione per una classe
                2. mostrare il costo totale di una classe su tutte le destinazioni
                3. trovare la destinazione più costosa per una classe
                4. trovare la classe che spende di più in totale
                5. mostrare la tabella dei costi (trasporto, vitto, alloggio) per una classe e una destinazione
                6. stampare tutti i dati inseriti
                7. terminare il programma
                """);
        int n = keyboard.nextInt();
        keyboard.nextLine();
        switch (n) {
            case 1:
                System.out.println("Inserisci il nome della classe: ");
                classe = keyboard.nextLine();

                System.out.println("Inserisci il nome della destinazione: ");
                destinazione = keyboard.nextLine();

                System.out.println("Il costo totale per la destinazione della classe è: " + costoDestinazione(classe, destinazione) + "€");
                break;
            case 2:

                System.out.println("Inserisci il nome della classe: ");
                classe = keyboard.nextLine();

                System.out.println("La somma di tutte le spese della classe equivale a: " + sommaCosti(classe));
                break;
            case 3:

                System.out.println("Inserisci il nome della classe: ");
                classe = keyboard.nextLine();
                System.out.println("La destinazione piu costosa della classe è: " + trovaDestinazionePiuCostosa(classe));
                break;
            case 4:
                System.out.println("La classe che spende di piu in totale è: " + classeMoreMoney());
                break;
            case 5:
                System.out.println("Inserisci il nome della classe: ");
                classe = keyboard.nextLine();

                System.out.println("Inserisci il nome della destinazione: ");
                destinazione = keyboard.nextLine();

                System.out.println("I costi (trasporto, vitto, alloggio) per la destinazione della classe sono: " + visualizzaCostiDestinazione(classe, destinazione));
                break;
            case 6:
                System.out.println("Tutti i dati presenti nel programma: ");
                visualizzaTuttiCosti();
                break;
            case 7:
                return;
            default:
                System.out.println("Inserimento scorretto!!!");
        }
        Thread.sleep(5000);
    } while (true);
}


public void visualizzaTuttiCosti() throws IOException {
    BufferedReader costi = new BufferedReader(new FileReader("costi.csv"));
    BufferedReader destinazioni = new BufferedReader(new FileReader("nomi_destinazioni.csv"));
    BufferedReader classi = new BufferedReader(new FileReader("nomi_classi.csv"));

    String parola = costi.readLine();
    do {
        System.out.println(parola);
        parola = costi.readLine();
    } while (parola != null);

    parola = destinazioni.readLine();
    do {
        System.out.println(parola);
        parola = destinazioni.readLine();
    } while (parola != null);

    parola = classi.readLine();
    do {
        System.out.println(parola);
        parola = classi.readLine();
    } while (parola != null);
}


public String classeMoreMoney() throws IOException {
    int[] somme = new int[numeroDiClassi()];
    BufferedReader in = new BufferedReader(new FileReader("nomi_classi.csv"));
    String[] nomiClassi = in.readLine().split(",");

    for (int i = 0; i < nomiClassi.length; i++) {
        somme[i] = sommaCosti(nomiClassi[i]);
    }

    int precedente = somme[0], posizione = 0;


    for (int i = 1; i < somme.length; i++) {
        if (somme[i] > precedente) {
            precedente = somme[i];
            posizione = i;
        }
    }

    return nomiClassi[posizione];
}

public int numeroDiClassi() throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("nomi_classi.csv"));
    String[] array = input.readLine().split(",");
    return array.length;
}


public static int leggiNomeClasse(String parola) throws IOException {

    BufferedReader input = new BufferedReader(new FileReader("nomi_classi.csv"));
    String[] array = input.readLine().split(",");

    for (int i = 0; i < array.length; i++) {

        if (parola.equalsIgnoreCase(array[i])) {
            return i;
        }

    }
    return -1;
}


public static int leggiNomeDestinazione(String parola) throws IOException {

    BufferedReader input = new BufferedReader(new FileReader("nomi_destinazioni.csv"));
    String[] array = input.readLine().split(",");

    do {
        for (int i = 0; i < array.length; i++) {

            if (parola.equalsIgnoreCase(array[i])) {
                return i;
            }

        }


        System.out.println("Destinazione non trovata!!!\nInserisci il nome della destinazione: ");
        parola = keyboard.nextLine();
    } while (true);
}

public static int costoDestinazione(String classe, String parola) throws IOException {
    int[] costi_classe = leggiCostiClasse(classe);
    int somma = 0;
    int pos = 3 * leggiNomeDestinazione(parola);

    for (int i = pos; i < pos + 3; i++) {
        somma = somma + costi_classe[i];
    }

    return somma;
}

public static String visualizzaCostiDestinazione(String classe, String parola) throws IOException {
    int[] costi_classe = leggiCostiClasse(classe);
    int posizione = 3 * leggiNomeDestinazione(parola);
    String risultato = "";

    for (int i = posizione; i < posizione + 3; i++) {
        risultato += costi_classe[i] + " ";
    }

    return risultato;
}

public static String trovaDestinazionePiuCostosa(String parola) throws IOException {
    int[] array = leggiCostiClasse(parola);
    int[] somme = new int[array.length / 3];


    for (int i = 0, x = 0; i < array.length; i = i + 3, x++) {
        somme[x] += array[i];
        somme[x] += array[i + 1];
        somme[x] += array[i + 2];
    }

    int max = somme[0];
    int posizione = 0;

    for (int i = 1; i < somme.length; i++) {
        if (somme[i] > max) {
            max = somme[i];
            posizione = i;
        }
    }

    return fromIntToStringDestinazione(posizione);

}

public static String fromIntToStringDestinazione(int pos) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("nomi_destinazioni.csv"));
    String[] array = input.readLine().split(",");
    return array[pos];
}


public static int sommaCosti(String parola) throws IOException {
    int[] array = leggiCostiClasse(parola);
    int somma = 0;
    for (int i = 0; i < array.length; i++) {
        somma += array[i];
    }
    return somma;
}


public static int[] leggiCostiClasse(String classe) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("costi.csv"));
    int numero_classe;
    do {
        numero_classe = leggiNomeClasse(classe);
        if (numero_classe != -1) {
            break;
        }
        System.out.println("Classe non trovata!!!\nInserisci il nome della classe: ");
        classe = keyboard.nextLine();
    } while (true);

    for (int i = 0; i < numero_classe; i++) {
        input.readLine();
    }

    String[] arrayDiStringhe = input.readLine().split(",");

    int[] array = new int[arrayDiStringhe.length];

    for (int i = 0; i < arrayDiStringhe.length; i++) {
        array[i] = Integer.parseInt(arrayDiStringhe[i]);
    }

    return array;
}