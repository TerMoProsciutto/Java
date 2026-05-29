public Scanner keyboard = new Scanner(System.in);

void main() throws IOException {

    int n;
    dim = inserimento();

    do {
        try {

            System.out.println("\n-----------MENU-----------");
            System.out.println("1. Visualizzazione dei nomi dei farmaci che curano da una certa malattia");
            System.out.println("2. Visualizzazione dell'elenco di tutti i farmaci prodotti da una certa azienda farmaceutica");
            System.out.println("3. Visualizzazione di tutto il record di un farmaco");
            System.out.println("0. Esci dal programma");
            System.out.print("\nInserimento: ");


            n = keyboard.nextInt();


            switch (n) {
                case 0:
                    System.out.println("Bye Bye!!");
                    return;
                case 1:
                    filtraPerMalattia();
                    break;
                case 2:
                    filtraPerAzienda();
                    break;
                case 3:
                    filtraPerNomeFarmaco();
                    break;
                default:
                    System.out.println("Numero non compreso");
            }

        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
        keyboard.nextLine();
    } while (true);
}


public static String path = "farmacia.csv";
public static int dim = 20;
public static Farmaco[] farmacia = new Farmaco[dim];


public static int inserimento() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(path));

    br.readLine();
    String line;
    int i = 0;

    while ((line = br.readLine()) != null) {

        String[] splitted = line.split(",");

        farmacia[i] = new Farmaco(splitted[0], splitted[1], splitted[2], Double.parseDouble(splitted[3]), splitted[4]);
        i++;
    }
    br.close();
    return i;
}

public static void filtraPerMalattia() throws IOException {

    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    double costoMedio = 0;
    double menoCostoso = Double.MAX_VALUE;
    int posMenoCostoso = -1;

    System.out.print("\nInserisci il nome della malattia: ");
    String malattia = keyboard.readLine();

    int contatore = 0;
    for (int i = 0; i < dim; i++) {
        if (malattia.equalsIgnoreCase(farmacia[i].getNomeMalattia())) {
            double costo;
            try {
                costo = farmacia[i].getCosto();
            } catch (NumberFormatException e) {

                System.out.println("Controlla il costo in posizione " + (i + 2) + " nel csv, c'è stato un errore nella lettura!!");
                continue;
            }

            System.out.println("Nome farmaco per curare " + malattia + ": " + farmacia[i].getNomeFarmaco());

            costoMedio += costo;

            if (menoCostoso > costo) {

                menoCostoso = costo;
                posMenoCostoso = i;
                contatore++;
            }

        }
    }

    if (posMenoCostoso == -1) {
        System.out.println("Malattia non trovata!");
        return;
    }
    costoMedio /= contatore;

    System.out.println("Costo medio dei farmaci: " + costoMedio + "$");
    System.out.println("Farmaco meno costoso: " + farmacia[posMenoCostoso].getNomeFarmaco() + " con " + menoCostoso + "$");
}


public static void filtraPerAzienda() throws IOException {

    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("\nInserisci il nome dell'azienda: ");
    String azienda = keyboard.readLine();
    int conta = 0;
    System.out.println("Nomi farmaci disponibili nell'azienda " + azienda + ": ");
    for (int i = 0; i < dim; i++) {
        if (azienda.equalsIgnoreCase(farmacia[i].getNomeAzienda())) {
            conta++;

            System.out.println(farmacia[i].getNomeFarmaco() + ", con costo: " + farmacia[i].getCosto() + "$");

        }
    }
    if (conta == 0) {
        System.out.println("Nessun prodotto trovato nell'azienda: " + azienda);
    }

}


public static void filtraPerNomeFarmaco() throws IOException {

    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("\nInserisci il nome del farmaco: ");
    String nomeFarmaco = keyboard.readLine();
    int conta = 0;

    for (int i = 0; i < dim; i++) {
        if (nomeFarmaco.equalsIgnoreCase(farmacia[i].getNomeFarmaco())) {

            conta++;
            System.out.println("\nAzienda produttrice: " + farmacia[i].getNomeAzienda());
            System.out.println("Malattia che può curare: " + farmacia[i].getNomeMalattia());
            System.out.println("Costo prodotto: " + farmacia[i].getCosto() + "$");
            System.out.println("Tipo prodotto: " + farmacia[i].getTipoDiFarmaco());

        }
    }
    if (conta == 0) {
        System.out.println("Nessun prodotto trovato!!");
    }


}
