/*
Esercizio "ViaggiDestinazioneCosti"
La scuola deve organizzare i viaggi d’istruzione per alcune classi.
Ogni classe può andare in più destinazioni.
Per ogni destinazione ci sono tre tipi di costo:
- trasporto
- vitto
- alloggio
I dati devono essere memorizzati in:
- un array di stringhe con i nomi delle classi
- un array di stringhe con i nomi delle destinazioni
- un array tridimensionale con i costi delle classi nelle varie destinazioni
Il programma deve leggere da un file.csv:
- quante classi partecipano
- il nome di ogni classe
- quante destinazioni sono disponibili
- il nome di ogni destinazione
- per ogni classe e per ogni destinazione:
- costo del trasporto
- costo del vitto
- costo dell’alloggio
Il programma deve predisporre un menu di scelta che permetta all’utente di eseguire le seguenti operazioni:
- mostrare il costo totale di una destinazione per una classe
- mostrare il costo totale di una classe su tutte le destinazioni
- trovare la destinazione più costosa per una classe
- trovare la classe che spende di più in totale
- mostrare la tabella dei costi (trasporto, vitto, alloggio) per una classe e una destinazione
- stampare tutti i dati inseriti
- terminare il programma
Gestire correttamente gli errori di input.
Organizzare il programma in metodi.
*/

public Scanner kb = new Scanner(System.in);

void main(String[] args) throws IOException {

    String fileNomiClassi = args[0];
    String fileDestinazioni = args[1];
    String fileCosti = args[2];

    Classe[] viaggio = new Classe[trovaNClassi(fileNomiClassi)];
    popola(viaggio, fileNomiClassi, fileDestinazioni, fileCosti);

    do {
        visualizzaMenu();
        int n = kb.nextInt();

        kb.nextLine();//Pulisce il buffer

        switch (n) {
            case 1:
                caso1(viaggio);
                break;

            case 2:
                caso2(viaggio);
                break;

            case 3:
                caso3(viaggio);
                break;

            case 4:
                caso4(viaggio);
                break;

            case 5:
                caso5(viaggio);
                break;

            case 6:
                caso6(viaggio);
                break;

            case 7:
                return;

            default:
                System.out.println("Errore inserimento!");
        }


    } while (true);
}

public void caso6(Classe[] viaggio) {
    for (int i = 0; i < viaggio.length; i++) {
        System.out.print("\nClasse " + viaggio[i].getNomeClasse() + ": ");

        for (int k = 0; k < viaggio[i].getDestinazioni().length; k++) {
            System.out.print("\nDestinazione " + viaggio[i].getDestinazioni()[k] + ": ");
            for (int j = 0; j < viaggio[i].getCosti()[k].length; j++) {
                System.out.print(viaggio[i].getCosti()[k][j]);
                System.out.print("    ");
            }
        }
        System.out.println();
    }
}

public void caso5(Classe[] viaggio) {
    int numeroClasse;
    String nomeClasse;

    do {
        System.out.println("Inserisci il nome della classe: ");
        nomeClasse = kb.nextLine();
        numeroClasse = trovaClasse(nomeClasse, viaggio);
    } while (numeroClasse == -1);

    int numeroDestinazione;
    String destinazione;

    do {
        System.out.println("Inserisci la destinazione della classe: ");
        destinazione = kb.nextLine();
        numeroDestinazione = trovaDestinazione(numeroClasse, destinazione, viaggio);
    } while (numeroDestinazione == -1);

    System.out.print("I costi della classe " + nomeClasse + " per la destinazione " + destinazione + " sono:  ");
    for (int i = 0; i < viaggio[numeroClasse].getCosti()[numeroDestinazione].length; i++) {
        System.out.print(viaggio[numeroClasse].getCosti()[numeroDestinazione][i]);
        System.out.print("    ");
    }
    System.out.println();
}

public void caso4(Classe[] viaggio) {

    int[] sommaCostiClasse = new int[viaggio.length];

    for (int x = 0; x < viaggio.length; x++) {
        int sommaCosti = 0;


        for (int k = 0; k < viaggio[x].getCosti().length; k++) {
            for (int i = 0; i < viaggio[x].getCosti()[k].length; i++) {
                sommaCosti += Integer.parseInt(viaggio[x].getCosti()[k][i]);
            }
        }
        sommaCostiClasse[x] = sommaCosti;
    }

    int max = sommaCostiClasse[0];
    int classePiuCostosa = 0;

    for (int i = 1; i < sommaCostiClasse.length; i++) {
        if (sommaCostiClasse[i] > max) {
            max = sommaCostiClasse[i];
            classePiuCostosa = i;
        }
    }

    System.out.println("La classe che ha i costi piu alti è: " + viaggio[classePiuCostosa].getNomeClasse());
}

public void caso3(Classe[] viaggio) {


    int numeroClasse;
    String nomeClasse;

    do {
        System.out.println("Inserisci il nome della classe: ");
        nomeClasse = kb.nextLine();
        numeroClasse = trovaClasse(nomeClasse, viaggio);
    } while (numeroClasse == -1);

    int[] sommaCostiDestinazione = new int[viaggio[numeroClasse].getCosti().length];


    for (int k = 0; k < viaggio[numeroClasse].getCosti().length; k++) {
        int sommaCosti = 0;
        for (int i = 0; i < viaggio[numeroClasse].getCosti()[k].length; i++) {
            sommaCosti += Integer.parseInt(viaggio[numeroClasse].getCosti()[k][i]);
        }
        sommaCostiDestinazione[k] = sommaCosti;
    }

    int max = sommaCostiDestinazione[0];
    int destinazionePiuCostosa = 0;

    for (int i = 1; i < sommaCostiDestinazione.length; i++) {
        if (sommaCostiDestinazione[i] > max) {
            max = sommaCostiDestinazione[i];
            destinazionePiuCostosa = i;
        }
    }

    System.out.println("La destinazione piu costosa per la classe " + nomeClasse + " è: " + viaggio[numeroClasse].getDestinazioni()[destinazionePiuCostosa]);


}

public void caso2(Classe[] viaggio) {


    int numeroClasse;
    String nomeClasse;

    do {
        System.out.println("Inserisci il nome della classe: ");
        nomeClasse = kb.nextLine();
        numeroClasse = trovaClasse(nomeClasse, viaggio);
    } while (numeroClasse == -1);

    int sommaCosti = 0;

    for (int k = 0; k < viaggio[numeroClasse].getCosti().length; k++) {
        for (int i = 0; i < viaggio[numeroClasse].getCosti()[k].length; i++) {
            sommaCosti += Integer.parseInt(viaggio[numeroClasse].getCosti()[k][i]);
        }
    }
    System.out.println("La somma di tutti i costi della classe " + nomeClasse + " equivale a: " + sommaCosti);
}

public void caso1(Classe[] viaggio) {


    int numeroClasse;
    String nomeClasse;

    do {
        System.out.println("Inserisci il nome della classe: ");
        nomeClasse = kb.nextLine();
        numeroClasse = trovaClasse(nomeClasse, viaggio);
    } while (numeroClasse == -1);

    int numeroDestinazione;
    String destinazione;

    do {
        System.out.println("Inserisci la destinazione della classe: ");
        destinazione = kb.nextLine();
        numeroDestinazione = trovaDestinazione(numeroClasse, destinazione, viaggio);
    } while (numeroDestinazione == -1);

    int sommaCosti = 0;
    for (int i = 0; i < viaggio[numeroClasse].getCosti()[numeroDestinazione].length; i++) {
        sommaCosti += Integer.parseInt(viaggio[numeroClasse].getCosti()[numeroDestinazione][i]);
    }

    System.out.println("Il costo totale per la classe " + nomeClasse + " con destinazione " + destinazione + " è: " + sommaCosti);
}

public int trovaDestinazione(int numeroClasse, String destinazione, Classe[] viaggio) {
    for (int i = 0; i < viaggio[numeroClasse].getDestinazioni().length; i++) {
        if (destinazione.equalsIgnoreCase(viaggio[numeroClasse].getDestinazioni()[i])) {
            return i;
        }
    }
    return -1;
}

public int trovaClasse(String nomeClasse, Classe[] viaggio) {
    for (int i = 0; i < viaggio.length; i++) {
        if (nomeClasse.equalsIgnoreCase(viaggio[i].getNomeClasse())) {
            return i;
        }
    }
    return -1;
}

public int trovaNClassi(String nome_file) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(nome_file));

    int conta = 0;

    while (br.readLine() != null) {
        conta++;
    }

    return conta;
}

public void visualizzaMenu() {
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
}

public void popola(Classe[] viaggio, String fileNomiClassi, String fileNomiDestinazioni, String fileCosti) throws IOException {
    BufferedReader nomiClassi = new BufferedReader(new FileReader(fileNomiClassi));
    BufferedReader destinazioni = new BufferedReader(new FileReader(fileNomiDestinazioni));
    BufferedReader costi = new BufferedReader(new FileReader(fileCosti));


    String nomeClasse = nomiClassi.readLine();
    String lineDestinazioni = destinazioni.readLine();
    String lineCosti = costi.readLine();

    for (int i = 0; i < viaggio.length; i++) {
        String[] splitDestinazioni = lineDestinazioni.split(",");
        String[] splitCosti = lineCosti.split(",");
        String[][] matriceCosti = new String[splitDestinazioni.length][splitCosti.length / splitDestinazioni.length];

        int k = 0;
        for (int x = 0; x < matriceCosti.length; x++) {
            for (int y = 0; y < matriceCosti[x].length; y++) {
                matriceCosti[x][y] = splitCosti[k];
                k++;
            }
        }

        viaggio[i] = new Classe(matriceCosti, splitDestinazioni, nomeClasse);

        nomeClasse = nomiClassi.readLine();
        lineDestinazioni = destinazioni.readLine();
        lineCosti = costi.readLine();
    }
}