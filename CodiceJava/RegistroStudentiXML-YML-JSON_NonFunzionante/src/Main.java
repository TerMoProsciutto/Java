/*
Analisi Registro Studenti da File XML – Java

Obiettivo
Realizzare un programma Java che legga i dati degli studenti da un file XML e calcoli statistiche sulla classe.

Il programma dovrà:
leggere il file XML
calcolare la media dei voti di ogni studente
individuare lo studente più bravo
individuare lo studente meno bravo
calcolare la media generale della classe


È fornito il file:
classe.xml
Il file contiene l’elenco degli studenti; per ogni studente sono presenti più materie e, per ogni materia, più voti.

Vincoli obbligatori:
Usare il parser DOM
Usare metodi

NON usare:
ArrayList
HashMap
librerie esterne


Metodi da realizzare
Il programma deve essere organizzato almeno nei seguenti metodi:
Metodo di lettura del file XML
Metodo per calcolare la media di uno studente
Metodo per individuare lo studente più bravo
Metodo per individuare lo studente meno bravo
Metodo per calcolare la media della classe


Lettura XML
Il programma deve:
aprire il file classe.xml
scorrere tutti gli studenti
leggere tutte le materie
leggere tutti i voti di ogni materia


Calcolo media studente
Per ogni studente:
sommare tutti i voti di tutte le materie
calcolare la media aritmetica
visualizzare la media dello studente

Formato di esempio:
Rossi Luca - media: 7.42


Studente più bravo
Il programma deve determinare lo studente con media più alta e visualizzare:
Studente più bravo: Rossi Luca - media: X

Studente meno bravo
Il programma deve determinare lo studente con media più bassa e visualizzare:
Studente meno bravo: Verdi Marco - media: Y

Media della classe
Calcolare la media delle medie degli studenti e visualizzarla.

Formato:
Media della classe: Z

Requisiti tecnici
Usare il parser DOM
Usare cicli per scorrere i nodi XML
Effettuare tutti i calcoli tramite codice (no valori hardcoded)
Gestire correttamente i tipi numerici (double)

*/

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;


Scanner keyboard = new Scanner(System.in);

public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

    Studente[] classe = new Studente[20];
    if (args.length == 0) {
        System.out.println("Inserisci il nome del file in args di 0!!");
        return;
    }
    String estensione = trovaEstensione(args[0]);
    switch (estensione) {
        case "xml":
            inserimentoXML(classe,args[0]);
            break;
        case "yml":
            ObjectMapper jsonMapper = new ObjectMapper();
            ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
            inserimentoJSON(classe,args[0]);
            break;
        case "json":
            inserimentoYML(classe,args[0]);
            break;
        default:
            System.out.println("Il file non esiste!");
            return;
    }
    int dim = inserimentoXML(classe, args[0]);

    do {
        try {
            visualizzaMenu();
            int n = keyboard.nextInt();
            keyboard.nextLine();
            switch (n) {
                case 0:
                    return;
                case 1:
                    visualizzaMediaStudente(classe, dim);
                    break;
                case 2:
                    visualizzaMigliorStudente(classe, dim);
                    break;
                case 3:
                    visualizzaPeggiorStudente(classe, dim);
                    break;
                case 4:
                    visualizzaMediaClasse(classe, dim);
                    break;
                case 5:
                    visualizzaClasse(classe, dim);
                    break;
                default:
                    System.out.println("ERRORE!!!");

            }
        } catch (InputMismatchException e) {
            System.out.println("ERRORE!!!");
        }
    } while (true);

}

public void inserimentoYML(Studente[] classe, String nomeFile) {
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

    JsonNode root = mapper.readTree(new File(nomeFile));

    String host = root.path("server").path("host").asText("127.0.0.1");
    int port = root.path("server").path("port").asInt();

    System.out.println("Connessione a " + host + ":" + port);
}

public void inserimentoJSON(Studente[] classe, String arg) {
}

public String trovaEstensione(String nomeFile) {
    if (!nomeFile.contains(".")) {
        return "";
    }
    return nomeFile.substring(nomeFile.lastIndexOf(".") + 1).toLowerCase();
}

public void visualizzaClasse(Studente[] classe, int dim) {
    for (int i = 0; i < dim; i++) {

        System.out.println("\nStudente n° " + (i + 1) + "\n" + classe[i].getNome() + " " + classe[i].getCognome() + " - media:    " + calcolaMediaStudente(classe[i]));

    }
}

public void visualizzaMenu() {
    System.out.println();
    System.out.println("----------------MENU----------------");
    System.out.println("1. Visualizza media di uno studente");
    System.out.println("2. Visualizza miglior studente");
    System.out.println("3. Visualizza peggior studente");
    System.out.println("4. Visualizza media classe");
    System.out.println("5. Visualizza classe");
    System.out.println("0. Esci dal programma\n");
    System.out.print("Inserimento: ");
}

public void visualizzaMediaStudente(Studente[] classe, int dim) {
    System.out.print("\nInserisci il codice matricola dello studente: ");
    String codiceMatricola = keyboard.nextLine();

    int pos = posizioneStudenteDaCodiceMatricola(classe, codiceMatricola, dim);
    if (pos == -1) {
        System.out.println("Studente non trovato!");
        return;
    }

    System.out.println(classe[pos].getNome() + " " + classe[pos].getCognome() + " - media:    " + calcolaMediaStudente(classe[pos]));

}

public void visualizzaMigliorStudente(Studente[] classe, int dim) {
    int pos = migliorStudente(classe, dim);
    System.out.println("Il miglior studente di questa classe è " + classe[pos].getNome() + " " + classe[pos].getCognome() + " - media:    " + calcolaMediaStudente(classe[pos]));
}

public void visualizzaPeggiorStudente(Studente[] classe, int dim) {
    int pos = peggiorStudente(classe, dim);
    System.out.println("Il peggior studente di questa classe è " + classe[pos].getNome() + " " + classe[pos].getCognome() + " - media:    " + calcolaMediaStudente(classe[pos]));
}

public void visualizzaMediaClasse(Studente[] classe, int dim) {
    System.out.println("Media della classe: " + calcolaMediaClasse(classe, dim));
}

public int posizioneStudenteDaCodiceMatricola(Studente[] classe, String codiceMatricola, int dim) {
    for (int i = 0; i < dim; i++) {

        if (classe[i].getMatricola().equals(codiceMatricola)) {
            return i;
        }

    }
    return -1;
}

public double calcolaMediaClasse(Studente[] classe, int dim) {
    double media = 0;
    int contatore = 0;

    for (int i = 0; i < dim; i++) {

        media += calcolaMediaStudente(classe[i]);
        contatore++;

    }

    return media / contatore;
}

public int migliorStudente(Studente[] classe, int dim) {
    int pos = 0;
    double migliore = calcolaMediaStudente(classe[0]);
    for (int i = 1; i < dim; i++) {

        if (calcolaMediaStudente(classe[i]) > migliore) {
            migliore = calcolaMediaStudente(classe[i]);
            pos = i;
        }

    }
    return pos;
}

public int peggiorStudente(Studente[] classe, int dim) {
    int pos = 0;
    double peggiore = calcolaMediaStudente(classe[0]);
    for (int i = 1; i < dim; i++) {

        if (calcolaMediaStudente(classe[i]) < peggiore) {
            peggiore = calcolaMediaStudente(classe[i]);
            pos = i;
        }

    }
    return pos;
}

public double calcolaMediaStudente(Studente studente) {
    int contatore = 0;
    double media = 0;

    for (int i = 0; i < studente.getMaterie().length; i++) {
        for (int k = 0; k < studente.getMaterie()[i].getVoti().length; k++) {
            media += studente.getMaterie()[i].getVoti()[k];
            contatore++;
        }
    }

    return media / contatore;
}

public int inserimentoXML(Studente[] classe, String path) throws ParserConfigurationException, IOException, SAXException {
    File fileInput = new File(path);

    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(fileInput);
    doc.getDocumentElement().normalize();


    NodeList nList = doc.getElementsByTagName("studente");
    int i;
    for (i = 0; i < nList.getLength(); i++) {
        Node nNode = nList.item(i);
        Element studente = (Element) nNode;

        String matricola = studente.getAttribute("matricola");
        String nome = studente.getElementsByTagName("nome").item(0).getTextContent();
        String cognome = studente.getElementsByTagName("cognome").item(0).getTextContent();


        NodeList listaMaterie = studente.getElementsByTagName("materia");

        Materia[] materie = new Materia[listaMaterie.getLength()];
        for (int j = 0; j < listaMaterie.getLength(); j++) {
            Element materia = (Element) listaMaterie.item(j);
            String nomeMateria = materia.getAttribute("nome");

            NodeList listaVoti = materia.getElementsByTagName("voto");
            double[] votiMateria = new double[listaVoti.getLength()];

            for (int k = 0; k < listaVoti.getLength(); k++) {
                votiMateria[k] = Double.parseDouble(listaVoti.item(k).getTextContent());
            }
            materie[j] = new Materia(nomeMateria, votiMateria);
        }

        classe[i] = new Studente(matricola, nome, cognome, materie);
    }
    return i;
}
