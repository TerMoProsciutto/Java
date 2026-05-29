/*
🔹 Tempo a disposizione
Circa 2 ore. Simulazione di compito in classe.

Realizzare un programma Java che gestisca un registro voti degli studenti, leggendo e scrivendo dati da / verso un file CSV, utilizzando array e metodi.

🔹 Il programma dovrà anche calcolare:
-media dei voti
-voto massimo
-voto minimo


🔹 File di lavoro
Il programma deve utilizzare un file chiamato (attenzione al percorso assoluto e relativo): voti.csv
Formato del file: matricola,nome,voto
Esempio:
        1001,Luca,7.5
        1002,Anna,8
        1003,Marco,6

🔹 Vincoli obbligatori
Usare array
Usare metodi

🔹 NON usare:
ArrayList
HashMap

🔹 Struttura dati:
Gestire i dati tramite classi

🔹 Metodi da realizzare:
Ogni metodo deve aver una singola responsabilità

🔹 Il programma deve essere suddiviso almeno nei seguenti metodi:
Lettura voti da file CSV
Visualizzazione elenco studenti
Inserimento nuovo voto
Modifica voto studente
Eliminazione studente
Calcolo media voti
Ricerca voto massimo
Ricerca voto minimo
Salvataggio su file CSV
Menu di scelta

🔹 Avvio del programma
All’avvio il programma deve leggere il file voti.csv e caricare i dati negli array.

🔹 Menu
Il programma deve mostrare ciclicamente il seguente menu:
1. Visualizza elenco studenti
2. Inserisci nuovo voto
3. Modifica voto
4. Elimina studente
5. Calcola media voti
6. Mostra voto massimo
7. Mostra voto minimo
8. Salva su file
9. Crea backup
0. Esci e salva i files su disco

🔹 Visualizzazione
Mostrare tutti gli studenti numerati a partire da 1 nel formato:
        1) 1001 - Luca - 7.5

🔹 Inserimento
Permettere l’inserimento di:
matricola
nome
voto

🔹 Modifica
Permettere la modifica del voto di uno studente selezionandolo tramite numero di matricola

🔹 Eliminazione
Permettere l’eliminazione di uno studente e riordinare correttamente gli array.

🔹 Calcoli richiesti
Il programma deve permettere di:
calcolare e visualizzare la media dei voti
individuare e visualizzare il voto massimo
individuare e visualizzare il voto minimo


🔹 Salvataggio
Salvare i dati nel file voti.csv, sovrascrivendo il contenuto precedente.

🔹 Backup
Creare una copia del file chiamata:
voti_backup.csv
*/

public static Scanner keyboard = new Scanner(System.in);
final int DIM = 30;

void main(String[] args) throws IOException, InterruptedException {

//in args[0] ci deve essere il nome del file csv contenente matricola,nome,voto
//in args[1] il nome del file in cui si vuole eseguire il backup

    Studente[] registroElettronico = new Studente[DIM];
    int dim = popolaRegistro(registroElettronico, args[0]);

    do {
        try {
            visualizzaMenu();
            int n = keyboard.nextInt();
            keyboard.nextLine();
            switch (n) {
                case 1:
                    visualizzaRegistro(registroElettronico, dim);
                    break;
                case 2:
                    modificaVoto(registroElettronico, dim);
                    break;
                case 3:
                    dim = eliminaStudente(registroElettronico, dim);
                    break;
                case 4:
                    float media = calcolaMedia(registroElettronico, dim);
                    System.out.println("\nLa media generale degli studenti è: " + media);
                    break;
                case 5:
                    float max = votoMassimo(registroElettronico, dim);
                    System.out.println("Il voto massimo è: " + max);
                    break;
                case 6:
                    float min = votoMinimo(registroElettronico, dim);
                    System.out.println("Il voto minimo è: " + min);
                    break;
                case 7:
                    salvataggio(registroElettronico, dim, args[0]);
                    System.out.println("Salvataggio avvenuto con successo!");
                    break;
                case 8:
                    salvataggio(registroElettronico, dim, args[1]);
                    System.out.println("backup avvenuto con successo!");
                    break;
                case 9:
                    System.out.print("Inserisci nome: ");
                    String nome = keyboard.nextLine();

                    float voto;

                    do {
                        System.out.print("Inserisci voto: ");
                        voto = keyboard.nextFloat();
                    } while (voto <= 0 || voto > 10);

                    keyboard.nextLine();

                    System.out.print("Inserisci numero matricola: ");
                    String matricola = keyboard.nextLine();

                    dim = creaMatricola(nome, voto, matricola, registroElettronico, dim);
                    System.out.println("Studente creato con successo!");
                    break;

                case 0:
                    salvataggio(registroElettronico, dim, args[0]);
                    System.out.println("Autosalvataggio avvenuto con successo!");
                    return;
                default:
                    System.out.println("\nErrore nell'inserimento!");
            }
        } catch (InputMismatchException ex) {
            System.out.println("\nErrore nell'inserimento!");
            keyboard.nextLine();
        }
        Thread.sleep(2000);
    } while (true);
}

public int creaMatricola(String nome, float voto, String matricola, Studente[] registroElettronico, int dim) {
    registroElettronico[dim] = new Studente(matricola, nome, voto);
    return dim + 1;
}

public void visualizzaMenu() {
    System.out.print("""
            
            -------------MENU-------------
            1. Visualizza elenco studenti
            2. Modifica voto
            3. Elimina studente
            4. Calcola media voti
            5. Mostra voto massimo
            6. Mostra voto minimo
            7. Salva su file
            8. Crea backup
            9. Inserimento nuovo studente
            0. Esci e salva i files su disco
            
            Inserimento:\s""");
}

public void salvataggio(Studente[] registroElettronico, int dim, String nome_file) throws IOException {
    BufferedWriter bw = new BufferedWriter(new FileWriter(nome_file));

    for (int i = 0; i < dim; i++) {
        bw.write(registroElettronico[i].getMatricola() + ',' + registroElettronico[i].getNome() + ',' + registroElettronico[i].getVoto());
        bw.newLine();
    }

    bw.close();
}

public float votoMassimo(Studente[] registroElettronico, int dim) {
    float max = registroElettronico[0].getVoto();
    for (int i = 1; i < dim; i++)
        if (registroElettronico[i].getVoto() > max)
            max = registroElettronico[i].getVoto();

    return max;
}

public float votoMinimo(Studente[] registroElettronico, int dim) {
    float min = registroElettronico[0].getVoto();

    for (int i = 1; i < dim; i++)
        if (registroElettronico[i].getVoto() < min)
            min = registroElettronico[i].getVoto();

    return min;
}

public float calcolaMedia(Studente[] registroElettronico, int dim) {
    int i;
    float media = 0;

    for (i = 0; i < dim; i++)
        media += registroElettronico[i].getVoto();
    return media / i;
}

public int eliminaStudente(Studente[] registroElettronico, int dim) {
    int pos = cercaDaMatricola(registroElettronico, dim);

    if (pos == -1) {
        System.out.println("Studente non trovato!");
        return dim;
    }

    System.out.print("Studente trovato: ");
    stampaMatricola(registroElettronico, pos);

    System.out.print("\nSei sicuro di volerlo cancellare?(1=si 0=no): ");
    int scelta = keyboard.nextInt();

    if (scelta == 1) {
        registroElettronico[pos] = registroElettronico[dim - 1];
        registroElettronico[dim - 1] = null;
        System.out.println("Studente cancellato!");
        return dim - 1;
    }

    System.out.println("Studente non cancellato!");
    return dim;
}

public void modificaVoto(Studente[] registroElettronico, int dim) {

    int pos = cercaDaMatricola(registroElettronico, dim);

    if (pos == -1) {
        System.out.println("Studente non trovato!");
        return;
    }
    System.out.print("Studente trovato: ");
    stampaMatricola(registroElettronico, pos);

    System.out.println();//   \n

    float voto;

    do {
        System.out.print("Inserisci il nuovo voto: ");
        voto = keyboard.nextFloat();
    } while (voto <= 0 || voto > 10);

    registroElettronico[pos].setVoto(voto);
    System.out.println("Studente salvato!");
}

public void stampaMatricola(Studente[] registroElettronico, int pos) {
    System.out.println(registroElettronico[pos].getMatricola() + " - " + registroElettronico[pos].getNome() + " - " + registroElettronico[pos].getVoto());
}

public int cercaDaMatricola(Studente[] registroElettronico, int dim) {

    System.out.print("\nInserisci il numero della marticola: ");
    String matricola = keyboard.nextLine();

    for (int i = 0; i < dim; i++) {
        if (registroElettronico[i].getMatricola().equalsIgnoreCase(matricola)) {
            return i;
        }
    }
    return -1;
}

public void visualizzaRegistro(Studente[] registroElettronico, int dim) {

    //VISUALIZZAZIONE --->  1) 1001 - Luca - 7.5

    System.out.println();//  \n

    for (int i = 0; i < dim; i++) {
        System.out.print((i + 1) + ") ");
        stampaMatricola(registroElettronico, i);
    }

}

public int popolaRegistro(Studente[] registroElettronico, String nome_file) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(nome_file));
    String line;
    int i = 0;

    while ((line = br.readLine()) != null) {

        if (line.isEmpty())
            continue;

        String[] splitted = line.split(",");

        if (splitted.length != 3) {
            System.out.println("\nErrore nella lunghezza della seguente linea: " + line);
            continue;
        }


        float voto;

        try {
            voto = Float.parseFloat(splitted[2]);
        } catch (NumberFormatException e) {
            System.out.println("\nErrore nel voto della seguente linea: " + line);
            continue;
        }
        if (voto <= 0 || voto > 10) {
            System.out.println("\nErrore nel voto della seguente linea: " + line);
            continue;
        }

        registroElettronico[i] = new Studente(splitted[0], splitted[1], voto);
        i++;
    }
    return i;
}
