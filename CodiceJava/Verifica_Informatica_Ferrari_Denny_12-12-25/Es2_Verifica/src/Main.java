//Ferrari Denny 3F 12-12-25
//Esercizio 2
void main() {
    Scanner keyboard = new Scanner(System.in);
    //dichiarazione variabili
    boolean verifica = false;
    int numero = 0;
    String n;
    float temperatura = 0;
    //inserimento del numero di temperature con gestione delle eccezioni attraverso il try-catch e nel caso ripeta l'inserimento
    do {
        try {
            //imposto verifica a false nel caso si ripeta il ciclo do
            verifica = false;

            //prendo in input il numero di temperature da inserire
            System.out.print("Quante temperature vuoi inserire? ");
            n = keyboard.nextLine();

            //assegno a numero n, trasformando la stringa in intero attraverso il parse int
            numero = Integer.parseInt(n);

            //catturo, nel caso, l'errore
        } catch (NumberFormatException exception) {

            //stampo che l'utente non ha inserito un numero
            System.out.println("Errore, devi inserire un numero!!!\n");

            //imposto verifica a true in modo che si ripeta il ciclo do-while
            verifica = true;
        }
    } while (verifica);

    //dichiaro e inizializzo un array grande n (o numero)
    float[] array_temperature = new float[numero];

    //ciclo for per popolamento dell'array appena dichiarato
    for (int i = 0; i < numero; i++) {

        //inserimento delle temperature con gestione delle eccezioni attraverso il try-catch e nel caso ripeta l'inserimento
        do {
            try {

                //imposto verifica a false nel caso si ripeta il ciclo do
                verifica = false;

                //prendo in input la temperatura attraverso n
                System.out.print("Inserisci la temperatura in posizione " + i + ": ");
                n = keyboard.nextLine();

                //assegno temperatura a n, trasformando la stringa in float con parse float
                temperatura = Float.parseFloat(n);

                //prendo la temperatura e la inseriso all'interno dell'array in posizione i
                array_temperature[i] = temperatura;

                //catturo, nel caso, l'errore
            } catch (NumberFormatException exception) {

                //stampo che l'utente non ha inserito un numero
                System.out.println("Errore, devi inserire un numero!!!\n");

                //imposto verifica a true in modo che si ripeta il ciclo do-while
                verifica = true;
            }
        } while (verifica);
    }

    //uso il metodo analizzaTemperature
    analizzaTemperature(array_temperature);

}


public static void analizzaTemperature(float[] array_t) {
    //dichiarazione e inizializzazione delle variabili
    int sottozero = 0, soprazero = 0;
    float mediasottozero = 0, mediasoprazero = 0, max = array_t[0], min = max;

    //ciclo for per controllare ogni numero dell'array
    for (int i = 0; i < array_t.length; i++) {
        //controllo se il numero in posizione i dell'array sia maggiore di 0 e nel caso incremento soprazero (variabile che serve per sapere quanti numeri sono sopra lo 0) e aggiungo il numero in posizione i dell'array a mediasoprazero che adesso mi serve come somma dei numeri sopra lo zero ma che poi userò per calcolare la media di essi facendo somma/quantità
        if (array_t[i] >= 0) {
            soprazero++;
            mediasoprazero += array_t[i];
        }
        //se il numero non è >=0 sarà sicuramente sotto lo 0, quindi seguo gli stessi passaggi per una temperatura positiva ma con variabili diverse per quelle sotto zero
        else {
            sottozero++;
            mediasottozero += array_t[i];
        }
        //controllo del maggiore e del minore; il primo ciclo non andrà, perché avevo inizializzato a max e a min il numero in posizione 0 dell'array
        if (array_t[i] > max) {
            max = array_t[i];
        }
        if (array_t[i] < min) {
            min = array_t[i];
        }
    }
    //calcolo la media sopra e la media sotto
    mediasoprazero /= soprazero;
    mediasottozero /= sottozero;

    //dichiaro escursione e gli do come valore la differenza tra il valore massimo e quello minimo
    float escursione = max - min;

    //stampo a video tutte le informazioni richieste con un unico sout, andando a capo per ognuna per una migliore chiarezza visiva per l'utente
    System.out.println("Temperature sopra lo 0 (con 0 compreso): " + soprazero + "\nTemperature sotto lo 0: " + sottozero + "\nMedia delle temperature sopra lo 0 (con 0 compreso): " + mediasoprazero + "\nMedia delle temperature sotto lo 0: " + mediasottozero + "\nValore massimo analizzato: " + max + "\nValore minimo analizzato: " + min + "\nEscursione termica: " + escursione);
}