void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);
    int n, dimensione;

    System.out.println("Quanti numeri sarannno presenti nell'array? ");
    dimensione = keyboard.nextInt();
    int[] ar = new int[dimensione];

    for (int i = 0; i < dimensione; i++) {
        System.out.print("Inserisci il numero in posizione " + i + ": ");
        n = keyboard.nextInt();
        ar[i] = n;
    }
    n=1;
    while(n!=0){
        System.out.print("Inserisci un numero (controllo che sia nell'array, inserisci 0 per terminare): ");
        n = keyboard.nextInt();

        boolean risposta = Array(ar, n);

        System.out.println(risposta);
    }


}


public static boolean Array(int array[], int n) {
    boolean risposta = false;
    for (int i = 0; i < array.length; i++) {

        if (array[i] == n) {
            risposta = true;
        }
    }
    return risposta;
}