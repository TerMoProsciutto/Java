/* Scrivi il codice di un programma che chiede all'utente un numero
da 1 a 7 e ne visualizza il giorno corrispondente */
void main() {
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Numero tra 1 e 7: ");
    int giorno = keyboard.nextInt();
    switch (giorno){
        case 1:
            System.out.println("Lunedì");
            break;
        case 2:
            System.out.println("Martedì");
            break;
        case 3:
            System.out.println("Mercoledì");
            break;
        case 4:
            System.out.println("Giovedì");
            break;
        case 5:
            System.out.println("Venerdì");
            break;
        case 6:
            System.out.println("Sabato");
            break;
        case 7:
            System.out.println("Domenica");
            break;
        default:
            System.out.println("Input invalido");
            break;
    }
}
