//Scrivi un programma java che visualizzi il carattere che si ripete più volte in una stringa
//inserita dall'utente e il numero di ripetizioni


void main() {
    Scanner keyboard = new Scanner(System.in);

    System.out.println("RICERCA DEL CARATTERE PIU RIPETITIVO");
    System.out.print("\nInserisci una stringa : ");
    String stringa = keyboard.nextLine();


    Risultato result = GetRipetizioniChar.getResult(stringa);

    System.out.println("\nil carattere (" + result.getCarattere() + ") è quello ripetuto più volte con: " + result.getRipetizioni() + " ripetizioni.");

}




