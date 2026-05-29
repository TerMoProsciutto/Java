void main() {
    Scanner keyboard = new Scanner(System.in);
    double distanza = 0, somma=0;
    int spostamenti = 0;
    do {
        System.out.print("Inserisci la distanza da percorrere: ");
        distanza = keyboard.nextFloat();
    }while(distanza<=0);
    do {
        System.out.print("Inserisci il numero degli spostamenti: ");
        spostamenti = keyboard.nextInt();
    }while(spostamenti<=0);
    for(int i=0; i<spostamenti; i++){
        distanza=distanza/2;
        somma=somma+distanza;
    }
    System.out.println(somma);
}
