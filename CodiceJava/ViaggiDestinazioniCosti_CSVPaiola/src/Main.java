void main() throws IOException {

    ViaggiDestinazioneCostiCSV v = new ViaggiDestinazioneCostiCSV();
    v.inserimento();

    int risp = 0;
    BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

    while (risp != 10) {
        System.out.println(
                """
                        
                        ---MENU---
                        1. mostrare il costo totale di una destinazione per una classe
                        2. mostrare il costo totale di una classe su tutte le destinazioni
                        3. trovare la destinazione più costosa per una classe
                        4. trovare la classe che spende di più in totale
                        5. mostrare la tabella dei costi (trasporto, vitto, alloggio) per una classe e una destinazione
                        6. stampare tutti i dati inseriti
                        10. Fine
                        """);
        try {
            risp = Integer.parseInt(tastiera.readLine());
        } catch (Exception e) {
            System.out.println("Errore, inserimento scorretto");
            continue;
        }

        switch (risp) {
            case 1:
                v.punto1();
                break;
            case 2:
                v.punto2();
                break;
            case 3:
                v.punto3();
                break;
            case 4:
                v.punto4();
                break;
            case 5:
                v.punto5();
                break;
            case 6:
                v.punto6();
                break;
            case 10:
                System.out.println("Fine Esecuzione");
                break;
            default:
                System.out.println("Scelta non valida");
                break;

        }
    }
}


