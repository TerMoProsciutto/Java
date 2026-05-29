void main() {
    Scanner kb = new Scanner(System.in);
    Calcolatrice numeri = new Calcolatrice();

    try {
        System.out.print("Inserisci primo numero: ");
        numeri.setA(kb.nextDouble());

        System.out.print("Inserisci secondo numero: ");
        numeri.setB(kb.nextDouble());

        System.out.print("Inserisci simbolo operazione: ");
        kb.nextLine();

        double risultato;
        switch (kb.nextLine()) {
            case "+":
                risultato = numeri.addizione();
                break;
            case "-":
                risultato = numeri.sottrazione();
                break;
            case "*":
                risultato = numeri.moltiplicazione();
                break;
            case "/":
                risultato = numeri.divisione();
                break;
            default:
                System.out.println("Errore di inserimento\nSimboli corretti: + - * / ");
                return;
        }
        System.out.println("Il risultato è: " + risultato);

    } catch (InputMismatchException e) {
        System.out.println("Errore inserimento");
    }
}
