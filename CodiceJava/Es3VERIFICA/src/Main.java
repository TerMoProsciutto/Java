//SOLUZIONE ESERCIZIO 3 VERIFICA
void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    double prodotto = 1, numero, n;

    try {
        n = Double.parseDouble(args[0]);
    } catch (NumberFormatException eccezione) {
        System.out.println("Errore!!!!!!!!!!!!!!!!");
        keyboard.close();
        return;
    }

    if (n <= 1) {
        System.out.println("Errore! Inserisci un numero positivo maggiore di 1!"
        keyboard.close();
        return;
    }

    for (int i = 1; i <= n; i++) {
        System.out.print("inserisci il " + i + " numero: ");
        numero = keyboard.nextDouble();
        prodotto *= numero;
    }

    keyboard.close();
    numero = Math.pow(prodotto, 1 / n);
    System.out.print("La media geometrica tra " + n + " numeri è di: " + numero);
}

