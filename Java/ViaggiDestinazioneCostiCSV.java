import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;

public class ViaggiDestinazioneCostiCSV {
    public static int[][][] costi_viaggi;
    public static String[] classi;
    public static String[] destinazioni;
    public static int N;
    public static int D;
    public static BufferedReader key = new BufferedReader(new InputStreamReader(System.in));


    public static void punto6() {

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

    public static void punto5() throws IOException {
        int c = scegliClasse();
        int d = scegliDestinazione();
        System.out.println("\nTabella costi per classe " + classi[c] + " con destinazione " + destinazioni[d]);
        System.out.println("Trasporto: " + costi_viaggi[c][d][0]);
        System.out.println("Vitto: " + costi_viaggi[c][d][1]);
        System.out.println("Alloggio: " + costi_viaggi[c][d][2]);
        System.out.println("Totale costi: " + (costi_viaggi[c][d][0] + costi_viaggi[c][d][1] + costi_viaggi[c][d][2]));
    }

    public static void punto4() {

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

    public static void punto3() throws IOException {
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

    public static void punto2() throws IOException {
        int c = scegliClasse();
        int totale = 0;
        for (int d = 0; d < D; d++) {
            totale += costi_viaggi[c][d][0] + costi_viaggi[c][d][1] + costi_viaggi[c][d][2];
        }
        System.out.println("Il costo totale per la classe " + classi[c] + "su tutte le destinazioni è di: " + totale);
    }

    public static void punto1() throws IOException {
        int c = scegliClasse();
        int d = scegliDestinazione();
        int totale = costi_viaggi[c][d][0] + costi_viaggi[c][d][1] + costi_viaggi[c][d][2];
        System.out.println("Il costo totale per la classe " + classi[c] + " alla destinazione " + destinazioni[d] + " è di: " + totale);
    }

    public static void inserimento() throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("viaggiIstruzione.csv"));
            String riga = br.readLine();
            String[] righe = new String[500];
            int count = 0;
            riga = br.readLine();
            while (riga != null) {
                righe[count] = riga;
                count++;
                riga = br.readLine();
            }
            br.close();
            String[] tempClassi = new String[50];
            int nClassi = 0;
            for (int i = 0; i < count; i++) {
                String[] campi = righe[i].split(",");
                String classeLetta = campi[0];
                boolean trovata = false;
                for (int j = 0; j < nClassi; j++) {
                    if (tempClassi[j].equalsIgnoreCase(classeLetta)) {
                        trovata = true;
                        break;
                    }
                }
                if (!trovata) {
                    tempClassi[nClassi] = classeLetta;
                    nClassi++;
                }
            }
            N = nClassi;
            classi = new String[N];
            for (int i = 0; i < N; i++) {
                classi[i] = tempClassi[i];
            }


            String[] tempDest = new String[50];
            int nDest = 0;
            for (int i = 0; i < count; i++) {
                String[] campi = righe[i].split(",");
                String destLetta = campi[1];
                boolean trovata = false;
                for (int j = 0; j < nDest; j++) {
                    if (tempDest[j].equalsIgnoreCase(destLetta)) {
                        trovata = true;
                        break;
                    }
                }
                if (!trovata) {
                    tempDest[nDest] = destLetta;
                    nDest++;
                }
            }
            D = nDest;
            destinazioni = new String[D];
            for (int i = 0; i < D; i++) {
                destinazioni[i] = tempDest[i];
            }


            for (int i = 0; i < count; i++) {
                String[] campi = righe[i].split(",");
                String classeLetta = campi[0];
                String destLetta = campi[0];
                int trasporto = Integer.parseInt(campi[2]);
                int vitto = Integer.parseInt(campi[3]);
                int alloggio = Integer.parseInt(campi[4]);

                int posClasse = cercaClasse(classeLetta);
                int posDest = cercaDestinazione(destLetta);



                costi_viaggi=new int[N][D][3];

                costi_viaggi[posClasse][posDest][0] = trasporto;
                costi_viaggi[posClasse][posDest][1] = vitto;
                costi_viaggi[posClasse][posDest][2] = alloggio;
            }
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file! ");
        }
    }

    public static int scegliClasse() throws IOException {
        int pos;
        String nome;
        do {
            System.out.println("Inserisci nome della classe: ");
            nome = key.readLine();
            pos = cercaClasse(nome);
            if (pos == -1)
                System.out.println("Classe non trovata");
        } while (pos == -1);
        return pos;
    }

    public static int scegliDestinazione() throws IOException {
        int pos;
        String nome;
        do {
            System.out.println("Inserisci nome della destinazione: ");
            nome = key.readLine();
            pos = cercaDestinazione(nome);
            if (pos == -1)
                System.out.println("Destinazione non trovata");
        } while (pos == -1);
        return pos;
    }

    public static int cercaClasse(String nome) {
        for (int i = 0; i < N; i++) {
            if (classi[i].equalsIgnoreCase(nome))
                return i;
        }
        return -1;
    }

    public static int cercaDestinazione(String nome) {
        for (int i = 0; i < D; i++) {
            if (destinazioni[i].equalsIgnoreCase(nome))
                return i;
        }
        return -1;
    }

}
