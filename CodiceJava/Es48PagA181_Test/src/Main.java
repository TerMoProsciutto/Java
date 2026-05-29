void main() {
    Scanner keyboard = new Scanner(System.in);
    int[] array = new int[12];

    for (int i = 0; i < array.length; i++) {

        do {
            System.out.printf("Inserisci valore posizione " + i + ": ");
            array[i] = keyboard.nextInt();
        } while (array[i] < 0);

    }

    int risultato = CodiceBarre.calcolaTredicesimo(array);
    System.out.printf("Il 13° numero del codice a barre è: " + risultato);
}


