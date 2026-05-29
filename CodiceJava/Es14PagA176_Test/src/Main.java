void main() {
    Scanner keyboard = new Scanner(System.in);
    int dimensione, minore, maggiore;

    do {
        System.out.println("Inserisci la dimensione dell'array");
        dimensione = keyboard.nextInt();
    } while (dimensione <= 0);

    int[] array = new int[dimensione];

    for (int i = 0; i < dimensione; i++) {
        System.out.println("Inserisci il valore in posizione " + i + ":");
        array[i] = keyboard.nextInt();
    }

    System.out.println("Inserisci un minimo e un massimo di numeri da ricercare all'interno dell'array: ");
    minore = keyboard.nextInt();

    do {
        System.out.println("Inserisci un numero maggiore di " + minore + ":");
        maggiore = keyboard.nextInt();
    } while (maggiore <= minore);

    int quantita = ContaNumeriInRange.contaNumeriInRange(array, maggiore, minore);
    System.out.println("I numeri compresi tra " + minore + " e " + maggiore + " all'interno dell'array precedentemente inserito sono: " + quantita);

}


