import java.io.*;

public class Biblioteca {
    public static String[] titoli;
    public static String[] autori;
    public static String[] anniPubblicazione;
    public static int dim;
    public static String path;


    public static void caricaDaFile() throws IOException {

        //Qua non gestisco le eccezioni perché lo faccio già quando chiamo il metodo all'interno di BibliotecaApp.java

        BufferedReader br = new BufferedReader(new FileReader(path));
        br.readLine(); //salto l'intestazione
        int conta = 0;

        while (br.readLine() != null) {
            conta++;
        }

        dim = conta; //conta è diventato la dimensione degli array paralleli
        br = new BufferedReader(new FileReader(path));

        br.readLine();  //siccome ho ri-inizializzato br devo ri-saltare l'intestazione

        titoli = new String[conta];
        autori = new String[conta];
        anniPubblicazione = new String[conta];


        for (int i = 0; i < conta; i++) {
            String[] libro = br.readLine().split(",");
            titoli[i] = libro[0];
            autori[i] = libro[1];
            anniPubblicazione[i] = libro[2];
        }

    }

    public static void stampa() {
        for (int i = 0; i < dim; i++) {
            //Metto il mio "libro" (quindi titoli[i], autori[i] e anniPubblicazione[i]) all'interno di un oggetto Libro chiamato libro per poi stamparlo a video attraverso il metodo toString() che l'oggetto espone
            Libro libro = new Libro(titoli[i], autori[i], anniPubblicazione[i]);
            System.out.println("\nLibro " + (i + 1) + ":");
            System.out.println(libro.toString());
        }
    }

    public static int ricercaPerTitolo(String titolo) {
        for (int i = 0; i < dim; i++) {
            if (titoli[i].equalsIgnoreCase(titolo)) return i;
        }
        return -1;
    }

    public static void aggiungi(Libro libro) {

        if (ricercaPerTitolo(libro.getTitolo()) != -1) {
            System.out.println("\nIl titolo di questo libro è gia presente all'interno della biblioteca!");
            return;
        }

        //Creo degli array di supporto per modificare gli originali
        String[] nuoviTitoli = new String[dim + 1];
        String[] nuoviAutori = new String[dim + 1];
        String[] nuoviAnni = new String[dim + 1];

        for (int i = 0; i < dim; i++) {
            nuoviTitoli[i] = titoli[i];
            nuoviAutori[i] = autori[i];
            nuoviAnni[i] = anniPubblicazione[i];
        }

        titoli = nuoviTitoli;
        autori = nuoviAutori;
        anniPubblicazione = nuoviAnni;


        titoli[dim] = libro.getTitolo();
        autori[dim] = libro.getAutore();
        anniPubblicazione[dim] = libro.getAnnoPubblicazione();
        dim++;
        try {
            salvaSuFile(path);
        } catch (IOException e) {
            System.out.println("Errore nel salvataggio nel csv");
        }

        System.out.println("\nLibro aggiunto con successo!");

    }


    public static void modifica(Libro libro, int pos) {
        titoli[pos] = libro.getTitolo();
        autori[pos] = libro.getAutore();
        anniPubblicazione[pos] = libro.getAnnoPubblicazione();
        try {
            salvaSuFile(path);
        } catch (IOException e) {
            System.out.println("Errore nel salvataggio nel csv");
            return;
        }
        System.out.println("\nLibro modificato con successo!");
    }


    public static void elimina(String titolo) {
        int pos = ricercaPerTitolo(titolo);

        if (pos == -1) {
            System.out.println("\nErrore, libro non trovato!");
            return;
        }

        //Creo degli array di supporto per modificare gli originali
        String[] nuoviTitoli = new String[dim - 1];
        String[] nuoviAutori = new String[dim - 1];
        String[] nuoviAnni = new String[dim - 1];


        for (int i = 0, k = 0; i < dim; i++) {
            if (i == pos) continue;

            nuoviTitoli[k] = titoli[i];
            nuoviAutori[k] = autori[i];
            nuoviAnni[k] = anniPubblicazione[i];
            k++;

        }

        titoli = nuoviTitoli;
        autori = nuoviAutori;
        anniPubblicazione = nuoviAnni;
        dim--;

        try {
            salvaSuFile(path);
        } catch (IOException e) {
            System.out.println("Errore nel salvataggio nel csv");
        }

        System.out.println("\nLibro cancellato con successo!");

    }


    public static void salvaSuFile(String path) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));

        bw.write("titolo,autore,anno\n");//scrivo anche l'intestazione

        for (int i = 0; i < dim; i++) {
            String line = titoli[i] + "," + autori[i] + "," + anniPubblicazione[i];

            if (i != dim - 1)
                line += "\n"; //faccio così in modo che non mi lascia spazi alla fine del csv che romperebbero la lettura di esso all'avvio del programma

            bw.write(line);
        }

        bw.close();
    }
}
