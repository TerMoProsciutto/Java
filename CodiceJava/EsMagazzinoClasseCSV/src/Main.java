public static final int DIM = 20;

void main(String[] args) throws IOException, InterruptedException {
    Scanner keyboard = new Scanner(System.in);
    Magazzino[] magazzino = new Magazzino[DIM];
    Ordine[] ordini = new Ordine[DIM];

    int ultimoMagazzino = popolaMagazzino(magazzino, args[0]);
    int ultimoOrdini = popolaOrdini(ordini, args[1]);

    do {
        try {
            visualizzaMenu();
            int n = keyboard.nextInt();
            switch (n) {
                case 0:
                    return;
                case 1:
                    visualizzaMagazzino(magazzino, ultimoMagazzino);
                    break;
                case 2:
                    visualizzaOrdini(ordini, ultimoOrdini);
                    break;
                case 3:
                    nuovoProdotto(magazzino, ultimoMagazzino);
                    ultimoMagazzino++;
                    break;
                case 4:
                    ultimoOrdini = nuovoOrdineConData(ordini, magazzino, ultimoMagazzino, ultimoOrdini);
                    break;
                case 5:
                    ultimoMagazzino = eliminaProdottoNelMagazzino(magazzino, ultimoMagazzino);
                    break;
                case 6:
                    salvataggioMagazzino(magazzino, args[0], ultimoMagazzino);
                    break;
                case 7:
                    salvataggioOrdini(ordini, args[1], ultimoOrdini);
                    break;
                case 8:
                    salvataggioMagazzino(magazzino, args[2], ultimoMagazzino);
                    salvataggioOrdini(ordini, args[3], ultimoOrdini);
                    break;
                default:
                    System.out.println("\nErrore, inserisci un numero valido!!!");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("\nErrore, inserisci un numero!!!");
            keyboard.nextLine();
        }
        Thread.sleep(1000); //aggiunge delay al menu
    } while (true);
}

private void salvataggioOrdini(Ordine[] ordini, String nome, int ultimo) throws IOException {
    BufferedWriter out = new BufferedWriter(new FileWriter(nome));
    for (int i = 0; i < ultimo; i++) {
        out.write(ordini[i].getCodice() + ',' + ordini[i].getNome() + ',' + ordini[i].getQuantita() + ',' + ordini[i].getData());
        out.newLine();
    }
    out.close();
    System.out.println("Ordini salvato in: " + nome);
}

private void salvataggioMagazzino(Magazzino[] magazzino, String nome, int ultimo) throws IOException {
    BufferedWriter out = new BufferedWriter(new FileWriter(nome));

    for (int i = 0; i < ultimo; i++) {
        out.write(magazzino[i].getCodice() + ',' + magazzino[i].getNome() + ',' + magazzino[i].getQuantita());
        out.newLine();
    }
    out.close();
    System.out.println("Magazzino salvato in: " + nome);
}

public int eliminaProdottoNelMagazzino(Magazzino[] magazzino, int ultimo) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Inserisci il codice prodotto: ");
    String codiceProdotto = keyboard.nextLine();
    int pos = cercaNelMagazzino(magazzino, ultimo, codiceProdotto);
    if (pos == -1) {
        System.out.println("Prodotto non trovatoo!!!");
        return ultimo;
    }
    System.out.println("Prodotto trovatoo!!!");
    System.out.println("Codice: " + magazzino[pos].getCodice());
    System.out.println("Nome: " + magazzino[pos].getNome());
    System.out.println("Disponibilità: " + magazzino[pos].getQuantita());

    System.out.println("Sei sicuro di volerlo cancellare?(0=no,1=si)");
    int scelta = keyboard.nextInt();

    if (scelta == 1) {
        magazzino[pos] = magazzino[ultimo - 1];
        magazzino[ultimo - 1] = null;
        System.out.println("Prodotto cancellato!!!");
        return ultimo - 1;
    }
    return ultimo;
}

private int nuovoOrdineConData(Ordine[] ordini, Magazzino[] magazzino, int ultimoMagazzino, int ultimoOrdini) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Inserisci il codice prodotto: ");
    String codiceProdotto = keyboard.nextLine();
    int pos = cercaNelMagazzino(magazzino, ultimoMagazzino, codiceProdotto);
    if (pos == -1) {
        System.out.println("Prodotto non trovatoo!!!");
        return ultimoOrdini;
    }
    System.out.println("Prodotto trovatoo!!!");
    System.out.println("Codice: " + magazzino[pos].getCodice());
    System.out.println("Nome: " + magazzino[pos].getNome());
    System.out.println("Disponibilità: " + magazzino[pos].getQuantita());


    System.out.print("\nInserisci quantità da ordinare: ");
    int quantita = keyboard.nextInt();

    if (quantita > magazzino[pos].getQuantita()) {
        System.out.println("Non ci sono abbastanza " + magazzino[pos].getNome() + " presenti nel magazzinoo!!");
        return ultimoOrdini;
    }
    magazzino[pos].setQuantita(magazzino[pos].getQuantita() - quantita);
    ordini[ultimoOrdini] = new Ordine(magazzino[pos].getCodice(), magazzino[pos].getNome(), quantita, LocalDate.now());

    System.out.println("Prodotto ordinatooo!!!");

    return ultimoOrdini + 1;

}

private static int cercaNelMagazzino(Magazzino[] magazzino, int ultimoMagazzino, String codiceProdotto) {
    for (int i = 0; i < ultimoMagazzino; i++) {
        if (codiceProdotto.equalsIgnoreCase(magazzino[i].getCodice())) {
            return i;
        }
    }
    return -1;
}

public void nuovoProdotto(Magazzino[] magazzino, int ultimo) {
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Codice: ");
    String codice = keyboard.nextLine();

    System.out.println("Nome: ");
    String nome = keyboard.nextLine();

    System.out.println("Quantità: ");
    int quantita = keyboard.nextInt();

    magazzino[ultimo] = new Magazzino(codice, nome, quantita);
    System.out.println("Prodotto creatoo!!!");
}

private void visualizzaOrdini(Ordine[] ordini, int ultimo) {
    for (int i = 0; i < ultimo; i++) {
        System.out.println("\nProdotto n° " + (i + 1));
        System.out.println("Codice: " + ordini[i].getCodice());
        System.out.println("Nome: " + ordini[i].getNome());
        System.out.println("Quantità ordinata: " + ordini[i].getQuantita());
        System.out.println("Data dell'ordine: " + ordini[i].getData());
    }
}

private void visualizzaMagazzino(Magazzino[] magazzino, int ultimo) {
    for (int i = 0; i < ultimo; i++) {
        System.out.println("\nProdotto n° " + (i + 1));
        System.out.println("Codice: " + magazzino[i].getCodice());
        System.out.println("Nome: " + magazzino[i].getNome());
        System.out.println("Disponibilità: " + magazzino[i].getQuantita());
    }
}

public void visualizzaMenu() {
    System.out.println("""
            
            Menu:
            1. Visualizza magazzino
            2. Visualizza ordini
            3. Inserisci nuovo prodotto
            4. Inserisci nuovo ordine, con data
            5. Elimina prodotto dal magazzino
            6. Salva magazzino su file
            7. Salva ordini su file
            8. Crea backup dei file
            0. Esci""");
}

public static int popolaMagazzino(Magazzino[] magazzino, String nome) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader(nome));
    int i = 0;
    String[] split;

    do {
        String line = input.readLine();

        if (line == null || line.isEmpty()) {
            return i;
        }

        split = line.split(",");
        magazzino[i] = new Magazzino(split[0], split[1], Integer.parseInt(split[2]));
        i++;
    } while (true);
}

public static int popolaOrdini(Ordine[] ordini, String nome) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader(nome));
    int i = 0;
    String[] split;

    do {
        String line = input.readLine();

        if (line == null || line.isEmpty()) {
            return i;
        }

        split = line.split(",");
        ordini[i] = new Ordine(split[0], split[1], Integer.parseInt(split[2]), LocalDate.parse(split[3]));
        i++;
    } while (true);
}