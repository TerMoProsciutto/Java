void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);
    int numero = args.length;
    int[] ar = new int[args.length];

//    System.out.print("Inserisci un numero: ");
//    numero = keyboard.nextInt();

    try {
        for (int i = 0; i < args.length; i++) {
            ar[i] = Integer.parseInt(args[i]);
//            System.out.println("arg[" + i + "] = " + ar[i]);
        }

        numero=ar[0];
        boolean risposta = Array(ar, numero);

        System.out.println(risposta);

    }
    catch (NumberFormatException e) {
        System.out.println("Rilevato tipo invalido inserito come argomento, per favore inserisci SOLO numeri INTERI!!!");
        return;
    }
}



public static boolean Array(int array[], int n) {
    boolean risposta = false;
    for (int i = 1; i < array.length; i++) {

        if (array[i] == n) {
            risposta = true;
        }
    }
    return risposta;
}