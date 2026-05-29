void main() {
    int prodotto=1,N=5,numero;
    Scanner keyboard = new Scanner(System.in);
    for(int i=0;i<N;i++){
        System.out.print("Inserisci il "+1+" numero: ");
        numero = keyboard.nextInt();
        prodotto*=numero;
    }
    System.out.println("Il prodotto tra "+N+" numeri è di: "+prodotto);
}
