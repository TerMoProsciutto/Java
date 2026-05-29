public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int somma = 0, contatore = 0, numero;
        System.out.println("Inserisci dei numeri, ne verrà calcolata la somma e la quantità di numeri dati in input(inserire 0 per stoppare)");
        do {
            numero = keybord.nextInt();
            somma = somma + numero;
            if (numero = !0) {
                contatore++; //contatore = contatore + 1
            }
        } while (n != 0);
        System.out.println("La quantità di numeri dati in input è di: " + contatore + "Mentre la somma di essi è di: " + somma);
    }
}