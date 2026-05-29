void main(String[] args) {

//    if(args.length==0){
//        System.out.println("Inserisci qualche valore in args!!!");
//        return;
//    }

    char c = args[args.length - 1].charAt(0);
    int conta = 0;
    for (int i = 0; i < args.length - 1; i++) {
        for (int k = 0; k < args[i].length(); k++) {
            if (args[i].charAt(k) != c) {
                conta++;
            }
        }
    }
    System.out.println("In tutto args, ad esclusione di: " + c + " ci sono: " + conta + " caratteri");
}
