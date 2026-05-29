/*
Obiettivo
Realizzare un programma Java che permetta di gestire un magazzino prodotti e un elenco ordini, utilizzando due file CSV, array e metodi.
Il programma deve permettere di registrare un ordine solo se il prodotto è disponibile in magazzino, aggiornando correttamente le quantità.

File di lavoro
magazzino.csv
codice,nome,quantitaa

ordini.csv
codice,nome,quantita_ordinata,data

Vincoli obbligatori
Usare array, metodi, usare args per caricare i paths dei files: args[0] magazzino, args[1] ordini


Non usare: ArrayList, HashMap, strutture dati complesse



Struttura dati
Utilizzare array paralleli.

Magazzino:
Codice prodotto, nome prodotto, quantità disponibile


Ordini:
codice prodotto, nome prodotto, quantità ordinata,data


Metodi da realizzare
Il programma deve essere suddiviso almeno nei seguenti metodi:

Lettura magazzino da file CSV
Lettura ordini da file CSV
Visualizzazione magazzino
Visualizzazione ordini
Inserimento nuovo prodotto in magazzino
Inserimento nuovo ordine
Eliminazione prodotto (se esiste dal magazzino)
Salvataggio magazzino su file CSV
Salvataggio ordini su file CSV
Menu di scelta



Funzionalità richieste
Avvio del programma
All’avvio il programma deve:
leggere il file magazzino.csv
leggere il file ordini.csv


caricare i dati negli array



Menu
Il programma deve mostrare ciclicamente il seguente menu:
1. Visualizza magazzino
2. Visualizza ordini
3. Inserisci nuovo prodotto
4. Inserisci nuovo ordine, con data
5. Elimina prodotto dal magazzino
6. Salva magazzino su file
7. Salva ordini su file
8. Crea backup dei file
0. Esci


Inserimento ordine

Quando l’utente inserisce un nuovo ordine:
inserisce codice e quantità richiesta
il programma verifica che il prodotto esista in magazzino
controlla che la quantità disponibile sia sufficiente


se l’ordine è valido:
registra l’ordine
scala la quantità dal magazzino


se non è valido:
l’ordine non viene registrato



Backup
Creare una copia dei file:
magazzino_backup.csv
ordini_backup.csv
 */

public static final int DIM = 20;

void main(String[] args) throws IOException, InterruptedException {
    Scanner keyboard = new Scanner(System.in);
    String[][] magazzino = new String[DIM][3];
    String[][] ordini = new String[DIM][4];
    popolaMatrice(magazzino, args[0]);
    popolaMatrice(ordini, args[1]);

    do {
        try {
            visualizzaMenu();
            int n = keyboard.nextInt();
            switch (n) {
                case 0:
                    return;
                case 1:
                    visualizzaMatrice(magazzino);
                    break;
                case 2:
                    visualizzaMatrice(ordini);
                    break;
                case 3:
                    nuovoProdotto(magazzino);
                    break;
                case 4:
                    nuovoOrdineConData(ordini, magazzino);
                    break;
                case 5:
                    eliminaProdottoNelMagazzino(magazzino);
                    break;
                case 6:
                    salvataggio(magazzino, args[0]);
                    break;
                case 7:
                    salvataggio(ordini, args[1]);
                    break;
                case 8:
                    copiaBackup(magazzino, controllaUltimoProdotto(magazzino), "backupMagazzino.csv");
                    copiaBackup(ordini, controllaUltimoProdotto(ordini), "backupOrdini.csv");
                    break;
                default:
                    System.out.println("\nErrore, inserisci un numero valido!!!");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("\nErrore, inserisci un numero!!!");
            keyboard.nextLine();
        }
        Thread.sleep(1000); //aggiunge delay al menu
    } while (true);
}


public void salvataggio(String[][] matrice, String nomeFile) throws IOException {
    int ultimo = controllaUltimoProdotto(matrice);
    BufferedWriter out = new BufferedWriter(new FileWriter(nomeFile));

    for (int i = 0; i < ultimo; i++) {
        for (int j = 0; j < matrice[i].length; j++) {
            out.append(matrice[i][j]);
            if (j != matrice[i].length - 1) {
                out.append(',');
            }
        }
        if (i != ultimo - 1) {
            out.newLine();
        }

    }
    out.close();
    System.out.println("Salvataggio in " + nomeFile + ", effettuato con successo!!!");
}


public void copiaBackup(String[][] matrice, int ultimo, String nomeFile) throws IOException {
    BufferedWriter out = new BufferedWriter(new FileWriter(nomeFile));

    if (ultimo == -1) {
        ultimo = DIM;
    }

    for (int i = 0; i < ultimo; i++) {
        for (int j = 0; j < matrice[i].length; j++) {
            out.append(matrice[i][j]);
            if (j != matrice[i].length - 1) {
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

private void eliminaProdottoNelMagazzino(String[][] magazzino) {
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Inserisci codice prodotto: ");
    String codiceProdotto = keyboard.nextLine();

    for (int i = 0; i < magazzino.length; i++) {
        if (codiceProdotto.equalsIgnoreCase(magazzino[i][0])) {
            int ultimo = controllaUltimoProdotto(magazzino);
            if (ultimo == -1) {
                ultimo = DIM;
            }
            for (int x = i; x < ultimo; x++) {
                magazzino[x] = magazzino[x + 1];
            }
        }
    }

}


private void nuovoOrdineConData(String[][] ordini, String[][] magazzino) {
    Scanner keyboard = new Scanner(System.in);
    int ultimo = controllaUltimoProdotto(ordini);
    if (ultimo == -1) {
        System.out.println("Troppe richieste di ordini, riprova più tardi!");
        return;
    }


    System.out.println("Inserisci codice prodotto: ");
    ordini[ultimo][0] = keyboard.nextLine();


    int n;
    do {
        System.out.println("Inserisci quantità desiderata del prodotto: ");
        n = keyboard.nextInt();
    } while (n < 0);
    ordini[ultimo][2] = String.valueOf(n);

    if (!cercaOrdineNelMagazzino(ordini[ultimo], magazzino)) {
        System.out.println("Prodotto non ordinabile!!");
        return;
    }

    ordini[ultimo][3] = String.valueOf(LocalDate.now());

    System.out.println("Prodotto ordinato in data: " + ordini[ultimo][3]);
}

private boolean cercaOrdineNelMagazzino(String[] ordine, String[][] magazzino) {
    for (int i = 0; i < magazzino.length; i++) {
        if (magazzino[i][0].equalsIgnoreCase(ordine[0])) {
            ordine[0] = magazzino[i][0];
            ordine[1] = magazzino[i][1];
            if (Integer.parseInt(ordine[2]) <= Integer.parseInt(magazzino[i][2])) {
                magazzino[i][2] = String.valueOf(Integer.parseInt(magazzino[i][2]) - Integer.parseInt(ordine[2]));
                return true;
            }
            return false;
        }
    }
    return false;
}


private void visualizzaMatrice(String[][] matrice) {
    for (int i = 0; i < matrice.length; i++) {
        if (matrice[i][0] == null) {
            return;
        }
        System.out.println("Prodotto n° " + (i + 1));
        for (int x = 0; x < matrice[i].length; x++) {
            System.out.println(matrice[i][x]);
        }
        System.out.println();
    }
}

private static void nuovoProdotto(String[][] matrice) {
    Scanner keyboard = new Scanner(System.in);
    int ultimo = controllaUltimoProdotto(matrice);
    if (ultimo == -1) {
        System.out.println("Magazzino Pieno!!");
        return;
    }

    do {
        System.out.println("Inserisci codice prodotto: ");
        matrice[ultimo][0] = keyboard.nextLine();
    } while (matrice[ultimo][0].contains(","));

    do {
        System.out.println("Inserisci nome prodotto: ");
        matrice[ultimo][1] = keyboard.nextLine();
    } while (matrice[ultimo][1].contains(","));

    int n;

    do {
        System.out.println("Inserisci quantità disponibile del prodotto: ");
        n = keyboard.nextInt();
    } while (n < 0);
    matrice[ultimo][2] = String.valueOf(n);

    System.out.println("Prodotto Creato!!");
}

private static int controllaUltimoProdotto(String[][] matrice) {
    for (int i = 0; i < matrice.length; i++) {
        if (matrice[i][0] == null) {
            return i;
        }
    }
    return -1;
}

private void popolaMatrice(String[][] matrice, String nome_file) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader(nome_file));
    int i = 0;
    String line = input.readLine();
    while (line != null && !line.isEmpty()) {
        matrice[i] = line.split(",");

        if (matrice[i].length != 3) {
            matrice[i] = null;

        } else {
            i++;
        }

        line = input.readLine();
    }
}

private void visualizzaMenu() {
    System.out.println("""
            Menu:
            1. Visualizza magazzino
            2. Visualizza ordini
            3. Inserisci nuovo prodotto
            4. Inserisci nuovo ordine, con data
            5. Elimina prodotto dal magazzino
            6. Salva magazzino su file
            7. Salva ordini su file
            8. Crea backup dei file
            0. Esci""");
}
