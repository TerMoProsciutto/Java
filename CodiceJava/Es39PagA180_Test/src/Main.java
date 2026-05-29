void main() {

    System.out.print("Inserisci la frase principale: ");
    String frase = IO.readln();

    System.out.println("Inserisci la sotto-stringa: ");
    String sottostringa = IO.readln();


    int risposta = Sottostringa.puntoDiPartenzaSottostringa(frase, sottostringa);

    if (risposta == -1) {
        System.out.println("La sotto-stringa non è presente nella frase.");
    } else {
        System.out.println("La sotto-stringa parte dalla posizione: " + risposta);
    }
}

