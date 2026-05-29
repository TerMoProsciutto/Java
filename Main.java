/*Una birreria a fine serata deve conteggiare l’incasso.
La cassiera accende il software gestionale il quale le chiede di inserire una alla volta le consumazioni servite.
Le consumazioni si dividono in bevande e ristorazione.
La cassiera per ogni consumazione deve inserire la tipologia di consumazione e il suo importo.

Quando la cassiera inserisce la stringa “esci” il software deve mostrare a video le seguenti informazioni:
1.    La media dell’incasso delle bevande
2.    La media dell’incasso della ristorazione
3.    Deve indicare se sono state vendute più bevande o più ristorazioni*/


public Scanner keyboard = new Scanner(System.in);
void main() {
    int contabevande = 0, contaristoriazioni = 0;
    String sceltaStringa;
    double mediabevande = 0, mediaristorazioni = 0, importo;
    do {
        try {
            System.out.println("\nInserisci la tipologia:\n1. Bevande\n2. Ristorazione\nDigita esci per uscire ");
            sceltaStringa = keyboard.nextLine();
            if (sceltaStringa.equals("esci")) {
                mediabevande /= contabevande;
                mediaristorazioni /= contaristoriazioni;
                System.out.println("\nMedia incasso delle bevande: " + mediabevande);
                System.out.println("Media incasso della ristorazione: " + mediaristorazioni);
                if (contabevande == contaristoriazioni) {
                    System.out.println("Sono state vendute tante bevande quante ristorazioni (" + contabevande + ")");
                } else if (contabevande > contaristoriazioni) {
                    System.out.println("Sono state vendute più bevande (" + contabevande + ") che ristorazioni (" + contaristoriazioni + ")");
                } else {
                    System.out.println("Sono state vendute più ristorazioni (" + contaristoriazioni + ") che ristorazioni (" + contabevande + ")");
                }
                return;
            }
            int scelta = Integer.parseInt(sceltaStringa);
            switch (scelta) {
                case 1:
                    contabevande++;
                    System.out.println("Inserisci l'importo: ");
                    importo = keyboard.nextDouble();
                    mediabevande += importo;
                    break;
                case 2:
                    contaristoriazioni++;
                    System.out.println("Inserisci l'importo: ");
                    importo = keyboard.nextDouble();
                    mediaristorazioni += importo;
                    break;
                default:
                    System.out.println("Errore, inserisci 1 o 2 oppure esci per uscire");
                    break;
            }

            keyboard.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("Erroreee!!!\n");
        }
    } while (true);

}
