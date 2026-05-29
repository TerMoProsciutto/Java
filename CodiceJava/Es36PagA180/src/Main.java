void main() {
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Inserisci una stringa:");
    String stringa = keyboard.nextLine();

    stringa = trim(stringa);

    System.out.println("\nStringa senza eventuali spaziature in testa e coda:\n" + stringa);
}

public static String trim(String stringa) {

    do {

        if (stringa.charAt(0) == ' ') {
            stringa = stringa.substring(1);
        }

        if (stringa.charAt(stringa.length() - 1) == ' ') {
            stringa = stringa.substring(0, stringa.length() - 1);
        }

    } while (stringa.charAt(0) == ' ' || stringa.charAt(stringa.length() - 1) == ' ');

    return stringa;
}