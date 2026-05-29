void main(String[] args) throws IOException {
    if (args.length == 0) {
        System.out.println("Non e stato inserito alcun argomento in input!!!");
        return;
    }
    try {
    Scanner in = new Scanner(new BufferedReader(new FileReader(args[0])));

        int numeroStudenti = 11;
        final int numeroCampiStudenti = 7;
        final int numeroVoti = 4;
        int contaFalso = 0;

        in.nextLine(); //salta l'intestazione
        System.out.println("\nERRORI:"); // sout per organizzazione grafica

        String[][] Studenti = new String[numeroStudenti][numeroCampiStudenti];

        for (int i = 0; i < numeroStudenti; i++) {
            boolean isVotiValidi = true;
            String[] studente = in.nextLine().split(",");
            if (studente.length == numeroCampiStudenti) {
                for (int j = 3; j < numeroCampiStudenti; j++) {
                    if (Float.parseFloat(studente[j]) < 0 || Float.parseFloat(studente[j]) > 10) {
                        isVotiValidi = false;
                        contaFalso++;
                        System.out.println("Lo studente " + (i + 1) + " ha almeno un voto non valido!!!");
                        break;
                    }
                }

                if (!studente[0].contains("@iisviolamarchesini.edu.it")) {
                    System.out.println("Email errata dello studente n° " + (i + 1) + "!! Deve contenere: @iisviolamarchesini.edu.it");
                    isVotiValidi = false;
                    contaFalso++;
                }

                if (isVotiValidi) {
                    Studenti[i - contaFalso] = studente;
                }
            } else {
                System.out.println("Dimensione sbagliata studente " + (i + 1) + ", deve essere costruito nella seguente modalita: Mail,Nome,Cognome,Italiano,Storia,Matematica,Inglese!!!");
                contaFalso++;
            }
        }
        in.close();
        numeroStudenti -= contaFalso;

        System.out.println("\nSTUDENTI:"); // sout per organizzazione grafica

        for (int i = 0; i < numeroStudenti; i++) {

            double[] voti = new double[numeroVoti];
            for (int j = 3; j < numeroCampiStudenti; j++) {
                voti[j - 3] = Double.parseDouble(Studenti[i][j]);
            }
            System.out.print("Email: " + Studenti[i][0] + "   Nome: " + Studenti[i][1] + "   Cognome: " + Studenti[i][2] + "   Media Voti: " + "%.2f%n".formatted(calcolaMedia(voti)));

        }
    } catch (FileNotFoundException e) {
        System.out.println("File non Trovato!!!");
    }

}

public static double calcolaMedia(double[] array) {
    double media = 0;
    int i;
    for (i = 0; i < array.length; i++) {
        media += array[i];
    }
    return media / i;
}