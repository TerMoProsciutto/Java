//Ferrari Denny 3F 12-12-25
//Esercizio 1
void main() {
    Scanner keyboard = new Scanner(System.in);
    //dichiaro e inizializzo a e b con una grandezza di 5
    int[] a = new int[5];
    int[] b = new int[5];
    //dichiaro somma_a per vedere se la somma dei numeri dell'array a sia effettivamente 20
    int somma_a = 0;
    //faccio un ciclo do per ripetere l'inserimento dei numeri nell'array a nel caso la somma dei numeri sia diversa da 20
    do {
        //inizializzo somma_a a 0 nel caso devo ripetere l'inserimento
        somma_a = 0;
        //ciclo for per assegnare alla posizione i dell'array a i numeri
        for (int i = 0; i < a.length; i++) {
            System.out.print("Inserisci il numero in posizione " + i + " dell'array A (la somma dei 5 numeri deve neccessariamente essere 20): ");
            a[i] = keyboard.nextInt();
            //aumento somma della quantità appena inserita
            somma_a += a[i];
        }
    } while (somma_a != 20);

    //ciclo for per popolamento di b
    for (int i = 0; i < b.length; i++) {
        //ciclo do per controllare che ogni numero inserito sia pari (il b[i]%2==1) e che sia compreso tra 0 e 10 (gli altri 2)
        do {
            System.out.print("Inserisci il numero in posizione " + i + " dell'array B (deve essere un numero pari compreso tra 0 e 10, estremi inclusi): ");
            b[i] = keyboard.nextInt();
        } while (b[i] % 2 == 1 || b[i] < 0 || b[i] > 10);
    }

    //stampo a video a attraverso il metodo visualizza
    System.out.print("Array A: ");
    visualizza(a);

    //stampo a video b attraverso il metodo visualizza
    System.out.print("\nArray B: ");
    visualizza(b);

    //dichiaro e inizializzo somma_incrociata al return del metodo sommaIncrociata
    int[] somma_incrociata = sommaIncrociata(a, b);

    //stampo a video somma_incrociata attraverso il metodo visualizza
    System.out.print("\nArray incrociato: ");
    visualizza(somma_incrociata);
}


public static void visualizza(int[] array) {
    //ciclo for per stampare a video un'array
    for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + " ");
    }
}


public static int[] sommaIncrociata(int[] a, int[] b) {
    //dichiaro e inizializzo risultato alla grandezza di a perche gli array sono della medesima grandezza
    int[] risultato = new int[a.length];

    //ciclo for per popolare il risultato con la somma incrociata dell'array a e b
    for (int i = 0; i < a.length; i++) {
        risultato[i] = a[i] + b[a.length - 1 - i];
    }
    //ritorno l'array incrociato
    return risultato;
}