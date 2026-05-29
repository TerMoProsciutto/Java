boolean gioco = true;
Scanner keyboard = new Scanner(System.in);

void main() {
    int i = 0, n;
    String[][] Tabella = {
            {"┌", "─", "┬", "─", "┬", "─", "┐"},
            {"│", "1", "│", "2", "│", "3", "│"},
            {"├", "─", "┼", "─", "┼", "─", "┤"},
            {"│", "4", "│", "5", "│", "6", "│"},
            {"├", "─", "┼", "─", "┼", "─", "┤"},
            {"│", "7", "│", "8", "│", "9", "│"},
            {"└", "─", "┴", "─", "┴", "─", "┘"}
    };
    visualizza(Tabella);
    do {
        if (i % 2 == 0) {
            System.out.println("Inserire il valore di dove si vuole posizionare 〤 (inserire 0 per terminare)");
            n = keyboard.nextInt();
            if (n == 0) {
                return;
            }
            if (modificaTabella(Tabella, n, "X")) {
                i--;
            }
        } else {
            System.out.println("Inserire il valore di dove si vuole posizionare 〇 (inserire 0 per terminare)");
            n = keyboard.nextInt();
            if (n == 0) {
                return;
            }
            if (modificaTabella(Tabella, n, "O")) {
                i--;
            }
        }
        i++;
        visualizza(Tabella);
    } while (gioco);
}

public static void visualizza(String[][] array) {
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
            System.out.print(array[i][j] + "  ");
        }
        System.out.print("\n");
    }
}

public static boolean modificaTabella(String[][] array, int n, String simbolo) {
    switch (n) {
        default:
            System.out.println("Inserimento scorretto");
            return true;
        case 1:
            if (array[1][1].contains("1")) {
                array[1][1] = simbolo;
            } else {
                System.out.println("errore, casella gia occupata!!!");
                return true;
            }
            break;
        case 2:
            if (array[1][3].contains("2")) {
                array[1][3] = simbolo;
            } else {
                System.out.println("errore, casella gia occupata!!!");
                return true;
            }
            break;
        case 3:
            if (array[1][5].contains("3")) {
                array[1][5] = simbolo;
            } else {
                System.out.println("errore, casella gia occupata!!!");
                return true;
            }
            break;
        case 4:
            if (array[3][1].contains("4")) {
                array[3][1] = simbolo;
            } else {
                System.out.println("errore, casella gia occupata!!!");
                return true;
            }
            break;
        case 5:
            if (array[3][3].contains("5")) {
                array[3][3] = simbolo;
            } else {
                System.out.println("errore, casella gia occupata!!!");
                return true;
            }
            break;
        case 6:
            if (array[3][5].contains("6")) {
                array[3][5] = simbolo;
            } else {
                System.out.println("errore, casella gia occupata!!!");
                return true;
            }
            break;
        case 7:
            if (array[5][1].contains("7")) {
                array[5][1] = simbolo;
            } else {
                System.out.println("errore, casella gia occupata!!!");
                return true;
            }
            break;
        case 8:
            if (array[5][3].contains("8")) {
                array[5][3] = simbolo;
            } else {
                System.out.println("errore, casella gia occupata!!!");
                return true;
            }
            break;
        case 9:
            if (array[5][5].contains("9")) {
                array[5][5] = simbolo;
            } else {
                System.out.println("errore, casella gia occupata!!!");
                return true;
            }
            break;
    }
    return false;
}
