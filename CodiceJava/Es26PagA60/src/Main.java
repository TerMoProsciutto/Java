import java.lang.Math;

void main() {
    Scanner keyboard = new Scanner(System.in);
    int caselle;
    double nchicchi = 0;

    System.out.print("Inserire la quantità di caselle (per ognuna verrà dato un chicco di riso pari al numero della casella): ");
    caselle = keyboard.nextInt();

    for (double i = 0; i < caselle; i++) {
        nchicchi = nchicchi + Math.pow(2, i);
    }

    System.out.print("Il numero di chicchi è di: " + nchicchi);
}