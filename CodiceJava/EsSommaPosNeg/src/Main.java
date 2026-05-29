//Scrivi un algoritmo che calcola la somma tra 2 numeri per 5 volte. Un numero deve essere positivo e l’altro negativo. Visualizza la somma.
void main() {
    Scanner keyboard= new Scanner(System.in);
    int n1,n2,N;
    for(int i=0;i<N;i++){
        do{
            System.out.print("Inserisci 2 numeri, uno negativo e uno positivo\n Numero 1: ");
            n1=keyboard.nextInt();
            System.out.print("Numero 2: ");
            n2=keyboard.nextInt();
        }while((n1<0&&n2<0)||(n1>=0&&n2>=0));
    }
}
