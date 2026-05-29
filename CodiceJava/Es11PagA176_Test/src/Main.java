void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    int dimensione;
    int n;
    System.out.println("Quanti numeri vuoi inserire? ");
    dimensione = keyboard.nextInt();

    int[] vettore = new int[dimensione];

    for (int i = 0; i < dimensione; i++) {
        System.out.println("Inserisci il numero in posizione " + i + ": ");
        n = keyboard.nextInt();
        vettore[i] = n;
    }

    System.out.println("Inserisci quale numero vuoi controllare all'interno dell'array: ");
    int numero = keyboard.nextInt();

    if (IsNumberArray.isNumberInArray(numero, vettore))
        System.out.println("Il numero è presente.");
    else
        System.out.println("Il numero non è presente.");

}