void main() {
    final int DIM = 150000000;
    long inizio, fine;
    HashMap<String, HashMap<String, String>> output = new HashMap<>();

    int[] array = new int[DIM];
    Random rd = new Random();

    inizio = System.nanoTime();
    for (int i = 0; i < array.length; i++) {
        array[i] = rd.nextInt();
    }
    fine = System.nanoTime();
    output.put("PopolamentoArray", calcolaTempi(inizio, fine));

    inizio = System.nanoTime();
    array = Arrays.stream(array).sorted().toArray();
    fine = System.nanoTime();
    output.put("Sorting", calcolaTempi(inizio, fine));

    int pos = rd.nextInt(array.length - 1);

    int n = array[pos];

    inizio = System.nanoTime();
    int posL = ricercaLineare(array, n);
    fine = System.nanoTime();
    output.put("RicercaLineare", calcolaTempi(inizio, fine));

    inizio = System.nanoTime();
    int posB = ricercaBinaria(array, n);
    fine = System.nanoTime();
    output.put("RicercaBinaria", calcolaTempi(inizio, fine));

    inizio = System.nanoTime();
    int posR = ricercaBinariaRicorsiva(array, n, 0, array.length - 1);
    fine = System.nanoTime();
    output.put("RicercaRicorsiva", calcolaTempi(inizio, fine));


    System.out.println("\n\nTest dei tempi per ricercare il numero " + n + " presente in posizione " + pos + " all'interno di un array di numeri casuali di dimensione " + array.length + ":\n");
    System.out.println("Tempo popolamento array: " + stampaTempoEsecuzione(output.get("PopolamentoArray")) + "ms");
    System.out.println("Tempo ordinamento array: " + stampaTempoEsecuzione(output.get("Sorting")) + "ms");
    System.out.println("Il tempo per la ricerca lineare è di: " + stampaTempoEsecuzione(output.get("RicercaLineare")) + "ms\t\ttrovato in posizione: " + posL);
    System.out.println("Il tempo per la ricerca binaria (non ricorsiva) è di: " + stampaTempoEsecuzione(output.get("RicercaBinaria")) + "ms\t\ttrovato in posizione: " + posB);
    System.out.println("Il tempo per la ricerca binaria (ricorsiva) è di: " + stampaTempoEsecuzione(output.get("RicercaRicorsiva")) + "ms\t\ttrovato: " + posR);
}

private double stampaTempoEsecuzione(HashMap<String, String> popolamentoArray) {
    return Double.parseDouble(popolamentoArray.get("Esecuzione")) / 1000000;
}


private HashMap<String, String> calcolaTempi(long inizio, long fine) {
    HashMap<String, String> tempi = new HashMap<>();
    tempi.put("Inizio", String.valueOf(inizio));
    tempi.put("Fine", String.valueOf(fine));
    tempi.put("Esecuzione", String.valueOf(fine - inizio));
    return tempi;
}

private int ricercaLineare(int[] array, int numero) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == numero) {
            return i;
        }
    }
    return -1;
}

private int ricercaBinaria(int[] array, int numero) {
    int fine = array.length - 1;
    int inizio = 0;

    while (inizio <= fine) {
        int centro = (fine + inizio) / 2;

        if (array[centro] == numero) {
            return centro;
        }

        if (array[centro] > numero) {
            fine = centro - 1;
        } else {
            inizio = centro + 1;
        }

    }

    return -1;
}

private static int ricercaBinariaRicorsiva(int[] array, int numero, int inizio, int fine) {

    if (inizio > fine) {
        return -1;
    }

    int centro = (fine + inizio) / 2;

    if (array[centro] == numero) {
        return centro;
    }

    if (array[centro] > numero) {
        return ricercaBinariaRicorsiva(array, numero, inizio, centro - 1);

    } else {

        return ricercaBinariaRicorsiva(array, numero, centro + 1, fine);
    }
}