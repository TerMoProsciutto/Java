void main() {
    Scanner keyboard = new Scanner(System.in);
    int dimensione, minore, maggiore;

    do {
        System.out.print("Inserisci la dimensione dell'array: ");
        dimensione = keyboard.nextInt();
    } while (dimensione <= 0);

    ArrayList<Integer> array = new ArrayList<>();


    System.out.println();
    for (int i = 0; i < dimensione; i++) {
        System.out.print("Inserisci il valore in posizione " + i + ": ");
        array.add(keyboard.nextInt());
    }

    System.out.print("\nInserisci un minimo e un massimo di numeri da ricercare all'interno dell'array: ");
    minore = keyboard.nextInt();

    do {
        System.out.print("\nInserisci un numero maggiore di " + minore + ": ");
        maggiore = keyboard.nextInt();
    } while (maggiore <= minore);

    ArrayList<Integer> secondoArray = CreaArrayInRange.creaArrayInRange(array, minore, maggiore);
    System.out.println("\nI numeri compresi tra " + minore + " e " + maggiore + " all'interno del primo array sono: " + secondoArray.size() + "\n");

    for (int i = 0; i < secondoArray.size(); i++) {

        System.out.println("Il secondo array in posizione " + i + " ha come valore: " + secondoArray.get(i));
    }

}


