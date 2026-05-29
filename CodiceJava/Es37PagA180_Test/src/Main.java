void main() {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Inserisci una stringa, verifico se è palindroma (se letta all'incontrario è la stessa parola): ");
    String stringa = keyboard.nextLine();
    boolean risposta = VerificaPalindroma.verificaStringaPalindroma(stringa);
    if (risposta) {
        System.out.println("La stringa è palindroma");
    }else{
        System.out.println("La stringa NON è palindroma");
    }

}

