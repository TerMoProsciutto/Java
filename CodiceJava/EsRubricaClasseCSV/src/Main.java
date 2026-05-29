import static java.lang.Thread.sleep;

public static int DIM = 25;

void main(String[] args) throws IOException, InterruptedException {
    Persona[] rubrica = new Persona[DIM];
    int ultimo = popolaPersone(rubrica);
    Scanner keyboard = new Scanner(System.in);

    do {
        try {
            visualizzaMenu();
            int n = keyboard.nextInt();
            switch (n) {
                case 0:
                    salvataggio(rubrica, ultimo, args[0]);
                    return;
                case 1:
                    visualizzaRubrica(rubrica, ultimo);
                    break;
                case 2:
                    ultimo = nuovoContatto(rubrica, ultimo);

                    break;
                case 3:
                    modificaContatto(rubrica, ultimo);
                    break;
                case 4:
                    int elimina = eliminaContatto(rubrica, ultimo);
                    if (elimina != -1) {
                        ultimo--;
                    }
                    break;
                case 5:
                    cercaContatto(rubrica, ultimo);
                    break;
                case 6:
                    salvataggio(rubrica, ultimo, args[1]);
                    break;
                default:
                    System.out.println("\nErrore, inserisci un numero valido!!!");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("\nErrore, inserisci un numero!!!"); //nel caso inserisco qualche lettera catturo l'eccezione
            keyboard.nextLine();
        }
        sleep(1000); //aggiunge delay al menu
    } while (true);

}


public void cercaContatto(Persona[] rubrica, int ultimo) {
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Inserisci campo del contatto: ");
    String campo = keyboard.nextLine();

    int pos = ricercaCampo(rubrica, campo, ultimo);

    if (pos == -1) {
        System.out.println("Contatto non trovato!!");
        return;
    }
    System.out.println("\nContatto trovato!!");
    System.out.println("Nome: " + rubrica[pos].getNome());
    System.out.println("Cognome: " + rubrica[pos].getCognome());
    System.out.println("Numero: " + rubrica[pos].getNumero());

}

public int eliminaContatto(Persona[] rubrica, int ultimo) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Inserisci campo del contatto: ");
    String campo = keyboard.nextLine();
    int pos = ricercaCampo(rubrica, campo, ultimo);

    if (pos == -1) {
        System.out.println("Contatto non trovato!!");
        return -1;
    }
    System.out.println("\nContatto trovato!!");
    System.out.println("Nome: " + rubrica[pos].getNome());
    System.out.println("Cognome: " + rubrica[pos].getCognome());
    System.out.println("Numero: " + rubrica[pos].getNumero());
    System.out.println("Sei sicuro di volerlo cancellare? (0=no, 1=si): ");
    int scelta = keyboard.nextInt();
    if (scelta == 1) {
        rubrica[pos] = rubrica[ultimo - 1];
        rubrica[ultimo - 1] = null;
        return 1;
    }
    return -1;
}

public void modificaContatto(Persona[] rubrica, int ultimo) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Inserisci campo del contatto: ");
    String campo = keyboard.nextLine();
    int pos = ricercaCampo(rubrica, campo, ultimo);

    if (pos == -1) {
        System.out.println("Contatto non trovato!!");
        return;
    }
    System.out.println("\nContatto trovato!!");
    System.out.println("Nome: " + rubrica[pos].getNome());
    System.out.println("Cognome: " + rubrica[pos].getCognome());
    System.out.println("Numero: " + rubrica[pos].getNumero());
    boolean scelta = true;
    do {
        System.out.println("\nCosa vuoi modificare?\n1.Nome\n2.Cognome\n3.Numero");
        int n = keyboard.nextInt();
        keyboard.nextLine();
        switch (n) {
            case 1:
                System.out.println("Inserire nome: ");
                rubrica[pos].setNome(keyboard.nextLine());
                break;
            case 2:
                System.out.println("Inserire cognome: ");
                rubrica[pos].setCognome(keyboard.nextLine());
                break;
            case 3:
                System.out.println("Inserire numero: ");
                rubrica[pos].setNumero(keyboard.nextLine());
                break;
            default:
                System.out.println("Inserimento scorrettooo!!!");

        }
        System.out.println("Contatto Modificato!!");
        System.out.println("Desideri modificare qualcos'altro del precedente contatto? (0=no, 1=si): ");
        int no = keyboard.nextInt();

        if (no == 0) {
            scelta = false;
        }

    } while (scelta);

}

public int ricercaCampo(Persona[] rubrica, String campo, int ultimo) {
    for (int i = 0; i < ultimo; i++) {
        if (rubrica[i].getNome().equalsIgnoreCase(campo) || rubrica[i].getCognome().equalsIgnoreCase(campo) || rubrica[i].getNumero().equalsIgnoreCase(campo)) {
            return i;
        }
    }
    return -1;
}

public int nuovoContatto(Persona[] rubrica, int ultimo) {
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Nome: ");
    String nome = keyboard.nextLine();

    System.out.println("Cognome: ");
    String cognome = keyboard.nextLine();

    System.out.println("Numero: ");
    String numero = keyboard.nextLine();

    try {
        rubrica[ultimo] = new Persona(nome, cognome, numero);
    } catch (IllegalArgumentException e) {
        System.out.println("Hai inserito un numero non valido!");
        return ultimo;
    }

    System.out.println("Contatto Creato!!");
    return ultimo + 1;

}

public void visualizzaMenu() {
    System.out.print("""
            \s
            MENU:
            1. Visualizza rubrica
            2. Inserisci nuovo contatto
            3. Modifica contatto
            4. Elimina contatto
            5. Cerca contatto
            6. Crea backup della rubrica
            0. Esci
            \s
            Inserimento:\s""");
}

public void salvataggio(Persona[] rubrica, int ultimo, String nome) throws IOException {
    BufferedWriter out = new BufferedWriter(new FileWriter(nome));

    for (int i = 0; i < ultimo; i++) {
        out.write(rubrica[i].getNome() + ",");
        out.write(rubrica[i].getCognome() + ",");
        out.write(rubrica[i].getNumero());
        out.newLine();
    }

    out.close();
    System.out.println("Salvataggio in " + nome + " avvenuto con successo!!!");
}

public void visualizzaRubrica(Persona[] rubrica, int ultimo) {
    for (int i = 0; i < ultimo; i++) {
        System.out.println("\nContatto n° " + (i + 1));
        System.out.println("Nome: " + rubrica[i].getNome());
        System.out.println("Cognome: " + rubrica[i].getCognome());
        System.out.println("Numero: " + rubrica[i].getNumero());
    }
    if (ultimo == 0) {
        System.out.println("Nessun contatto presente");
    }
}

public int popolaPersone(Persona[] rubrica) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("rubrica.csv"));
    int i = 0;
    String[] split;

    do {
        String line = input.readLine();

        if (line == null || line.isEmpty()) {
            return i;
        }

        split = line.split(",");
        try {
            rubrica[i] = new Persona(split[0], split[1], split[2]);
        } catch (IllegalArgumentException e) {
            continue;
        }
        i++;
    } while (true);
}
