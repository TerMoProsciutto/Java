import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Farmaci {

    //dichiaro tutto public static in modo che tutti i metodi di questa classe (e non) possano accedere a queste informazioni

    public static String path = "farmacia.csv";//path del csv
    public static String[][] farmacia = new String[20][5];//dichiaro fissa la dimensione della farmacia
    public static int dim;


    public static void farmaci() throws IOException {
        dim = inserimento();//ottengo la dimensione della farmacia attraverso un return di un contatore dentro inserimento
    }


    public static int inserimento() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));

        br.readLine();//Salta l'intestazione
        String line;
        int i = 0;

        while ((line = br.readLine()) != null) {//assegnazione con controllo

            String[] splitted = line.split(",");

            farmacia[i] = splitted;
            i++;
        }
        br.close();
        return i;//ritorno la dimensione della farmacia
    }

    public static void filtraPerMalattia() throws IOException {

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        double costoMedio = 0;
        double menoCostoso = Double.MAX_VALUE;
        int posMenoCostoso = -1;

        System.out.print("\nInserisci il nome della malattia: ");
        String malattia = keyboard.readLine();

        int contatore = 0;
        for (int i = 0; i < dim; i++) {
            if (malattia.equalsIgnoreCase(farmacia[i][2])) {
                double costo;
                try {
                    costo = Double.parseDouble(farmacia[i][3]);
                } catch (NumberFormatException e) {
                    //stampo dove si trova l'errore nel caso in cui nel csv il costo è diverso da un numero, in modo da avere una rapida correzione dell'errore
                    System.out.println("Controlla il costo in posizione " + (i + 2) + " nel csv, c'è stato un errore nella lettura!!");
                    continue;
                }

                System.out.println("Nome farmaco per curare " + malattia + ": " + farmacia[i][0]);

                costoMedio += costo;

                if (menoCostoso > costo) {
                    //se il costo che ho appena trovato risulta minore di uno precedente allora mi salvo sia la sua posizione che il valore, incremento il contatore
                    menoCostoso = costo;
                    posMenoCostoso = i;
                    contatore++;
                }

            }
        }

        if (posMenoCostoso == -1) {//se non trova niente lo segnalo all'utente
            System.out.println("Malattia non trovata!");
            return;
        }
        costoMedio /= contatore;//calcolo la media

        System.out.println("Costo medio dei farmaci: " + costoMedio + "$");
        System.out.println("Farmaco meno costoso: " + farmacia[posMenoCostoso][0] + " con " + menoCostoso + "$");
    }


    public static void filtraPerAzienda() throws IOException {

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\nInserisci il nome dell'azienda: ");
        String azienda = keyboard.readLine();
        int conta = 0;

        for (int i = 0; i < dim; i++) {
            if (azienda.equalsIgnoreCase(farmacia[i][1])) {
                conta++;
                //nel caso in cui trovo l'azienda stampo il farmaco con il suo costo
                System.out.println("Nome farmaco disponibile nell'azienda " + azienda + ": " + farmacia[i][0] + ", con costo: " + farmacia[i][3] + "$");

            }
        }
        if (conta == 0) {//se non trova niente lo segnalo all'utente
            System.out.println("Nessun prodotto trovato nell'azienda: " + azienda);
        }

    }


    public static void filtraPerNomeFarmaco() throws IOException {

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\nInserisci il nome del farmaco: ");
        String nomeFarmaco = keyboard.readLine();
        int conta = 0;

        for (int i = 0; i < dim; i++) {
            if (nomeFarmaco.equalsIgnoreCase(farmacia[i][0])) {
                //nel caso in cui trovo un prodotto, visualizzo tutto il record
                conta++;
                System.out.println("\nAzienda produttrice: " + farmacia[i][1]);
                System.out.println("Malattia che può curare: " + farmacia[i][2]);
                System.out.println("Costo prodotto: " + farmacia[i][3] + "$");
                System.out.println("Tipo prodotto: " + farmacia[i][4]);

            }
        }
        if (conta == 0) {//se non trova niente lo segnalo all'utente
            System.out.println("Nessun prodotto trovato!!");
        }


    }
}

