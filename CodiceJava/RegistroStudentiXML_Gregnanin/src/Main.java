
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public static Scanner keyboard = new Scanner(System.in);

void main() throws ParserConfigurationException, IOException, SAXException {

    Studente[] classe = inserimento();
    System.out.println(classe[0].getNome());

    do {
        try {
            visualizzaMenu();
            int n = keyboard.nextInt();
            keyboard.nextLine();
            switch (n) {
                case 0:
                    return;
                case 1:
                    caso1(classe);
                    break;
                case 2:
                    caso2(classe);
                    break;
                case 3:
                    caso3(classe);
                    break;
                case 4:
                    caso4(classe);
                    break;
                default:
                    System.out.println("ERRORE!!!");

            }
        } catch (InputMismatchException e) {
            System.out.println("ERRORE!!!");
        }
    } while (true);

}


public void visualizzaMenu() {
    System.out.println();
    System.out.println("----------------MENU----------------");
    System.out.println("1. Visualizza media di uno studente");
    System.out.println("2. Visualizza miglior studente");
    System.out.println("3. Visualizza peggior studente");
    System.out.println("4. Visualizza media classe");
    System.out.println("0. Esci dal programma\n");
    System.out.print("Inserimento: ");
}

public void caso1(Studente[] classe) {
    System.out.print("\nInserisci il codice matricola dello studente: ");
    String codiceMatricola = keyboard.nextLine();

    int pos = posizioneStudenteDaCodiceMatricola(classe, codiceMatricola);
    if (pos == -1) {
        System.out.println("Studente non trovato!");
        return;
    }

    System.out.println(classe[pos].getNome() + " " + classe[pos].getCognome() + " - media:    " + calcolaMediaStudente(classe[pos]));

}

public void caso2(Studente[] classe) {
    int pos = migliorStudente(classe);
    System.out.println("Il miglior studente di questa classe è " + classe[pos].getNome() + " " + classe[pos].getCognome() + " - media:    " + calcolaMediaStudente(classe[pos]));
}

public void caso3(Studente[] classe) {
    int pos = peggiorStudente(classe);
    System.out.println("Il peggior studente di questa classe è " + classe[pos].getNome() + " " + classe[pos].getCognome() + " - media:    " + calcolaMediaStudente(classe[pos]));
}

public void caso4(Studente[] classe) {
    System.out.println("Media della classe: " + calcolaMediaClasse(classe));
}

public int posizioneStudenteDaCodiceMatricola(Studente[] classe, String codiceMatricola) {
    for (int i = 0; i < classe.length; i++) {

        if (classe[i].getMatricola().equals(codiceMatricola)) {
            return i;
        }
    }
    return -1;
}

public double calcolaMediaClasse(Studente[] classe) {
    double media = 0;
    int contatore = 0;

    for (Studente studente : classe) {

        media += calcolaMediaStudente(studente);
        contatore++;


    }

    return media / contatore;
}

public int migliorStudente(Studente[] classe) {
    int pos = 0;
    double migliore = calcolaMediaStudente(classe[0]);
    for (int i = 1; i < classe.length; i++) {

        if (calcolaMediaStudente(classe[i]) > migliore) {
            migliore = calcolaMediaStudente(classe[i]);
            pos = i;
        }


    }
    return pos;
}

public int peggiorStudente(Studente[] classe) {
    int pos = 0;
    double peggiore = calcolaMediaStudente(classe[0]);
    for (int i = 1; i < classe.length; i++) {

            if (calcolaMediaStudente(classe[i]) < peggiore) {
                peggiore = calcolaMediaStudente(classe[i]);
                pos = i;
            }

    }
    return pos;
}

public double calcolaMediaStudente(Studente studente) {

    double media = 0;


    for (int i = 0; i < studente.getMaterie().length; i++) {
        media += studente.getMedie()[i];
    }

    return media / studente.getMaterie().length;
}

private static Studente[] inserimento() throws ParserConfigurationException, SAXException, IOException {
    String path = "voti.xml";
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
    Document DocXml = documentBuilder.parse(new File(path));

    NodeList studenti = DocXml.getElementsByTagName("studente");
    Studente[] ArrayStudenti = new Studente[studenti.getLength()];

    for (int i = 0; i < studenti.getLength(); i++) {
        Element studente = (Element) studenti.item(i);
        Studente oggettoStudente = new Studente();
        oggettoStudente.setNome((studente.getElementsByTagName("nome").item(0).getTextContent()));
        oggettoStudente.setCognome((studente.getElementsByTagName("cognome").item(0).getTextContent()));
        oggettoStudente.setMatricola(studente.getAttribute("matricola"));

        NodeList materie = studente.getElementsByTagName("materia");
        double[] medie = new double[materie.getLength()];
        String[] arrayMaterie = new String[materie.getLength()];

        for (int k = 0; k < materie.getLength(); k++) {
            double somma = 0;
            Element materia = (Element) materie.item(k);
            Element voti = (Element) materia.getElementsByTagName("voti").item(0);
            NodeList listaVoti = voti.getElementsByTagName("voto");
            int j;
            for (j = 0; j < listaVoti.getLength(); j++) {
                double voto = Double.parseDouble(listaVoti.item(j).getTextContent());
                somma = somma + voto;
            }
            medie[k] = somma / j;
            arrayMaterie[k] = materia.getAttribute("nome");
        }

        oggettoStudente.setMaterie(arrayMaterie);
        oggettoStudente.setMedie(medie);
        ArrayStudenti[i] = oggettoStudente;
    }
    return ArrayStudenti;
}
