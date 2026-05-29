import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public static void menu() throws IOException {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        //richiamo il metodo farmaci all'interno della classe Farmaci per prendere in memoria tutti i dati della farmacia (inclusa la sua dimensione)
        Farmaci.farmaci();
        int n;//questo intero mi servirà per fare la scelta nel menu
        do {
            do {
                //Stampo il Menu di scelta
                System.out.println("\n-----------MENU-----------");
                System.out.println("1. Visualizzazione dei nomi dei farmaci che curano da una certa malattia");
                System.out.println("2. Visualizzazione dell'elenco di tutti i farmaci prodotti da una certa azienda farmaceutica");
                System.out.println("3. Visualizzazione di tutto il record di un farmaco");
                System.out.println("0. Esci dal programma");
                System.out.print("\nInserimento: ");

                //gestisto attraverso un try-catch NumberFormatException (ovvero se l'utente non inserisce un intero)
                try {
                    n = Integer.parseInt(keyboard.readLine());
                } catch (NumberFormatException e) {
                    //stampo l'errore e assegno n a -1 in modo da ripetere il menu finche non inserisco un numero
                    System.out.println("Errore di inserimento!!\nDevi inserire un numero!!");
                    n = -1;
                }

            } while (n == -1);


            switch (n) {
                case 0:
                    //caso di uscita dal programma
                    return;
                case 1:
                    Farmaci.filtraPerMalattia();//richiamo il metodo filtraPerMalattia contenuto nella classe Farmaci
                    break;
                case 2:
                    Farmaci.filtraPerAzienda();//richiamo il metodo filtraPerAzienda contenuto nella classe Farmaci
                    break;
                case 3:
                    Farmaci.filtraPerNomeFarmaco();//richiamo il metodo filtraPerNomeFarmaco contenuto nella classe Farmaci
                    break;
                default:
                    //nel caso in cui n è un numero intero ma diverso dalle mie scelte stampo un messaggio di errore
                    System.out.println("Errore!!\nDevi inserire un numero valido!!");
            }
        } while (true);
    }
}
