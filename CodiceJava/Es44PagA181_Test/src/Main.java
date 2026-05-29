//codifica/decodifica di una stringa alla quale ogni char deve essere aumentato/diminuito di 13 posizioni (es. a--->n)
void main() {
    Scanner keyboard = new Scanner(System.in);
    int n = 1;
    String parola;
    boolean verifica;
    do {
        verifica = false;
        System.out.print("\nInserisci parola: ");
        parola = keyboard.nextLine();
        for (int i = 0; i < parola.length(); i++) {
            if (!((parola.charAt(i) >= 65 && parola.charAt(i) <= 90) || (parola.charAt(i) >= 97 && parola.charAt(i) <= 122))) {
                verifica = true;
            }
        }
    } while (verifica);

    // nel caso un giorno dovrò fare una decodifica di n numeri
//    do {
//        System.out.print("Desideri codificarla (1) o decodificarla (2)?: ");
//        n = keyboard.nextInt();
//    } while (n > 2 || n < 1);

    System.out.println("Parola codificata/decodificata: " + CodificaDecodificaDiUnaStringa.codificaStringa(parola, n,13));

}

