void main() {
    Scanner kb = new Scanner(System.in);
    int numero, pos;
    int[] array = {8, 2, 10, 5, 3, 1, 4, 9, 6, 7};
    boolean isCopiaSorted = false;
    int[] copiaArray = new int[0];

    int dimensioneArray = array.length;

    do {

        clear(20);
        menu();

        try {
            int scelta = kb.nextInt();
            kb.nextLine();
            clear(20);

            switch (scelta) {
                case 1:

                    if (dimensioneArray >= array.length) {
                        System.out.println("Array pieno");
                        break;
                    }

                    System.out.print("Inserisci il numero: ");
                    numero = kb.nextInt();
                    kb.nextLine();

                    int dimIniziale = dimensioneArray;

                    dimensioneArray = inserisciNumeroArray(array, dimensioneArray, numero);

                    if (dimIniziale != dimensioneArray) {
                        isCopiaSorted = false;
                    }

                    break;
                case 2:
                    System.out.print("Inserisci il numero da ricercare: ");
                    numero = kb.nextInt();
                    kb.nextLine();

                    pos = ricercaArray(array, numero, dimensioneArray);

                    if (pos == -1) {
                        System.out.println("Numero non trovato");
                        break;
                    }

                    System.out.println("Numero " + numero + " trovato in posizione " + pos);

                    break;
                case 3:
                    System.out.print("Inserisci il numero da modificare: ");
                    numero = kb.nextInt();
                    kb.nextLine();

                    pos = ricercaArray(array, numero, dimensioneArray);

                    if (pos == -1) {
                        System.out.println("Numero non trovato");
                        break;
                    }

                    System.out.print("Inserisci il numero con cui lo vuoi sostituire: ");
                    numero = kb.nextInt();
                    kb.nextLine();

                    if (contieneNumero(array, numero, dimensioneArray)) {
                        System.out.println("Elemento già presente all'interno dell'array");
                        break;
                    }

                    array[pos] = numero;
                    System.out.println("Numero in posizione " + pos + " modificato");
                    isCopiaSorted = false;

                    break;
                case 4:
                    System.out.print("Inserisci il numero da cancellare: ");
                    numero = kb.nextInt();
                    kb.nextLine();

                    pos = ricercaArray(array, numero, dimensioneArray);

                    if (pos == -1) {
                        System.out.println("Numero non trovato");
                        break;
                    }

                    dimensioneArray--;
                    isCopiaSorted = false;
                    compattaArray(array, pos, dimensioneArray);
                    System.out.println("Numero " + numero + " cancellato dall'array");

                    break;
                case 5:
                    System.out.println("Array: ");
                    visualizzaArray(array);
                    break;
                case 6:
                    copiaArray = selectionSort(array.clone(), dimensioneArray);
                    isCopiaSorted = true;
                    System.out.println("Array ordinato");
                    break;
                case 7:
                    int[] massimi = ricercaMassimiArray(array, dimensioneArray);
                    System.out.println("I due numeri più grandi all'interno dell'array sono: " + massimi[0] + ", " + massimi[1]);
                    break;
                case 8:
                    System.out.print("Inserisci di quanto vuoi espandere l'array: ");
                    int dim = kb.nextInt();
                    kb.nextLine();
                    array = espandiArray(array, dim);
                    System.out.println("Array aumentato di " + dim + " posizioni");
                    break;
                case 9:

                    if (!isCopiaSorted) {
                        System.out.println("Prima di eseguire la ricerca binaria devi avere l'array ordinato.\t(NB: se modifichi l'array dovrai rifare l'ordinamento)");
                        break;
                    }

                    System.out.print("Inserisci il numero da ricercare: ");
                    numero = kb.nextInt();
                    kb.nextLine();

                    pos = ricercaBinaria(copiaArray, numero, dimensioneArray);

                    if (pos == -1) {
                        System.out.println("Numero non trovato");
                        break;
                    }

                    System.out.println("Il numero " + numero + " si trova in posizione " + pos + " dell'array ordinato");

                    break;
                case 0:
                    System.out.println("Terminazione programma");
                    return;
                default:
                    System.out.println("Errore, il numero deve essere compreso tra 0 e 9");
            }
        } catch (InputMismatchException e) {
            clear(20);
            System.out.println("Errore, inserisci un numero intero");
            kb.nextLine();
        }

        clear(1);

        System.out.print("Premi invio per continuare: ");
        kb.nextLine();


    } while (true);

}

private static void clear(int n) {
    for (int i = 0; i < n; i++) {
        System.out.println();
    }
}

private int ricercaBinaria(int[] array, int numero, int dim) {
    int fine = dim - 1;
    int inizio = 0;

    while (inizio <= fine) {
        int meta = (fine + inizio) / 2;

        if (array[meta] == numero) {
            return meta;
        }

        if (array[meta] > numero) {
            fine = meta - 1;
        } else {
            inizio = meta + 1;
        }

    }

    return -1;
}

private int[] ricercaMassimiArray(int[] array, int dim) {
    int[] maxs = {array[0], array[0]};

    for (int i = 1; i < dim; i++) {
        if (array[i] > maxs[0]) {
            maxs[0] = array[i];
        }
    }

    for (int i = 1; i < dim; i++) {
        if (array[i] > maxs[1] && array[i] != maxs[0]) {
            maxs[1] = array[i];
        }
    }
    return maxs;
}

private int[] selectionSort(int[] copia, int dim) {
    int min;
    int temp;

    for (int i = 0; i < dim - 1; i++) {
        min = i;
        for (int j = i + 1; j < dim; j++) {
            if (copia[j] < copia[min]) {
                min = j;
            }
        }
        if (min != i) {
            temp = copia[i];
            copia[i] = copia[min];
            copia[min] = temp;
        }
    }
    return copia;
}

private void compattaArray(int[] array, int pos, int dim) {
    for (int i = pos; i < dim; i++) {
        array[i] = array[i + 1];
    }
    array[dim] = 0;
}

private int ricercaArray(int[] array, int numero, int dim) {
    for (int i = 0; i < dim; i++) {
        if (array[i] == numero) {
            return i;
        }
    }
    return -1;
}

private int inserisciNumeroArray(int[] array, int dimensioneArray, int numero) {

    if (contieneNumero(array, numero, dimensioneArray)) {
        System.out.println("Il numero è già presente all'interno dell'array");
        return dimensioneArray;
    }

    array[dimensioneArray] = numero;
    System.out.println("Il numero " + numero + " è stato inserito nell'array in posizione " + dimensioneArray);
    return dimensioneArray + 1;
}

private boolean contieneNumero(int[] array, int numero, int dim) {
    for (int i = 0; i < dim; i++) {
        if (array[i] == numero) {
            return true;
        }
    }
    return false;
}

private void visualizzaArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + " ");
    }
    System.out.println();
}

private int[] espandiArray(int[] array, int dim) {
    if (dim < 1) {
        System.out.println("Non puoi aumentare un array di " + dim + " posizioni");
        return array;
    }
    int[] espandi = new int[array.length + dim];

    for (int i = 0; i < array.length; i++)
        espandi[i] = array[i];

    return espandi;
}

private void menu() {
    System.out.println("☙━━━━━━━━━━━━━━━━━━━━━━━  ＭＥＮＵ  ━━━━━━━━━━━━━━━━━━━━━━━❧");
    System.out.println("1. Inserimento di un numero nell'array");
    System.out.println("2. Ricerca sequenziale di un numero all'interno dell'array");
    System.out.println("3. Modifica un numero presente nell'array");
    System.out.println("4. Cancellazione di un elemento presente nell'array");
    System.out.println("5. Visualizzazione array");
    System.out.println("6. Ordinamento dell'array");
    System.out.println("7. Ricerca dei due massimi presenti nell'array");
    System.out.println("8. Espansione dell'array");
    System.out.println("9. Ricerca Dicotomica (binaria)");
    System.out.println("0. Uscita dal programma");
    System.out.println("☙━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━❧");
    System.out.print("\nInserimento:  ");
}
