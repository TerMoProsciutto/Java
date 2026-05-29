void main() {
    Scanner keyboard = new Scanner(System.in);
    double mi, mf, costdec, annitrasc;

    do {
        System.out.print("Inserire la massa iniziale (espressa in grammi) del materiale: ");
        mi = keyboard.nextDouble();
    } while (mi <= 0);

    do {
        System.out.print("Inserire la costante di decadimento del materiale: ");
        costdec = keyboard.nextDouble();
    } while (costdec <= 0 || costdec > 1);

    do {
        System.out.print("Inserire il numero di anni trascorsi: ");
        annitrasc = keyboard.nextDouble();
    } while (annitrasc <= 0);

    mf = mi * costdec * annitrasc;

    System.out.println("Massa finale del materiale: " + mf);

    while(mf > 1){
        annitrasc ++;
        mf = mi * costdec * annitrasc;
    }
    System.out.println("Gli anni che servono al materiale per avere una massa inferiore a 1g sono: " + annitrasc);
}
