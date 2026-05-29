
void main() {
    Scanner keyboard = new Scanner(System.in);
    String priorita = "", durata = "";
    int zona;
    double prezzo = 0;
    do {
        System.out.println("Inserisci la durata(S,M,A)");
        durata = keyboard.nextLine();
    } while (!durata.equals("S") && !durata.equals("M") && !durata.equals("A"));

    do {
        System.out.println("Inserisci la zona (1,2,3)");
        zona = keyboard.nextInt();
    } while (zona <= 0 || zona > 3);
    do {
        System.out.println("Inserisci la priorità: alta oppure bassa");
        priorita = keyboard.nextLine();
    } while (!priorita.equals("bassa") && !priorita.equals("alta"));
    if (durata.equals("S")) {
        if (zona == 1) {
            prezzo = 10;
        }
        if (zona == 2) {
            prezzo = 5;
        }
        if (zona == 3) {
            prezzo = 15;
        }
    }
    if (durata.equals("M")) {
        if (zona == 1) {
            prezzo = 30;
        }
        if (zona == 2) {
            prezzo = 2;
        }
        if (zona == 3) {
            prezzo = 40;
        }
    }
    if (durata.equals("A")) {
        if (zona == 1) {
            prezzo = 250;
        }
        if (zona == 2) {
            prezzo = 150;
        }
        if (zona == 3) {
            prezzo = 300;
        }
    }
    if (priorita.equals("bassa")) {
        prezzo = prezzo * 0.8;
    }
    System.out.println("Il prezzo è di: " + prezzo);

}
