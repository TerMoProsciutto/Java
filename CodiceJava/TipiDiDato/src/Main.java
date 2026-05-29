import java.sql.SQLOutput;

void main() {
    //Tipi di dati
    //Interi
    //byte = 8 bit con segno(da -128 a +127)-> 256 combinazioni
    byte b1 = 12;
    System.out.println("b1 = " + b1);
    byte b2 = 127;
    System.out.println("b2 = " + b2);
    /*i linguaggi fortemente tipizzati(pascal,c,c++,c#,java) ammettono le conversioni (casting) automatiche da parte del compilatore o scelte dal programmatore, da un tipo ad un altro
    MA SOLO quando non c'è rischio di perdita di dati.
    javascript e php non sono tipizzati: non è obbligatorio dichiarare il tipo di variabile prima di usarla.*/

    //short = 2 byte (16 bit) con segno (da -32,768 a 32,767)

    short s1 = 10000;
    System.out.println("s1 = " + s1);

    //int = 4 byte (32 bit) con segno (da -2,147,483,648 a 2,147,483,647)

    System.out.println("long massimo: " + Long.MAX_VALUE);
    System.out.println("long minimo: " + Long.MIN_VALUE);

    /*MIN_VALUE e MAX_VALUE sono costanti statiche e pubbliche definite all'interno della classe integer
    Statica significa che appartiene alla classe integer non ad un oggetto specifico infatti vi si accede direttamente usando il nome della classe
    pubblica significa accessibile da qualsiasi parte del soggetto (globale). */

    //long = 8 byte (64 bit) con segno (da -9.223.372.036.854.775.808 a 9.223.372.036.854.775.807)

    //char = singolo carattere compresa la punteggiatura grandi 2 byte
    //ascii a 7 bit -> 128 combinazioni
    //ascii a 8 bit -> 256 combinazioni
    //unicode non si usa un numero fisso di bit, ma usa diversi formati di codifica
    //UTF-8 -> utilizza 8 bit per carattere
    //UTF-16 -> utilizza 16 bit per carattere
    //UTF-32 -> utilizza 32 bit per carattere
    //java è stato progettato per supportare unicode e per questo un carattere occupa 2 byte
    //C e C++ un char occupa 1 byte perché C è nato per memorizzare un carattere del codice ascii
    //esiste una dualità tra i caratteri e gli interi
    char c1 = 'a';
    System.out.println("c1 = " + c1);
    char c2 = 65;
    System.out.println("c2 = " + c2);
    int i = 100 + 'a';
    System.out.println("i = " + i);

    //boolean -> George Boole matematico inglese del 1800 -> proprietà degli insiemi formati da due soli elementi
    //Shannon ha ripreso le idee di Boole per progettare circuiti hardware elettrici per fare calcoli logici
    //una variabile booleana può essere simalata con un valore intero 0-1
    //si usa per fare dei controlli: se vero(1) se falso(0)
    boolean bol1 = false;
    System.out.println("bol1 = " + bol1);
    boolean bol2 = true;
    System.out.println("bol2 = " + bol2);
    boolean vf = 5 < 3;
    System.out.println("vf = " + vf);

    //String NON è un tipo primitivo
    //S maiuscola -> classe che consente di richiamare dei metodi sull'oggetto della classe

    boolean controllo = true;
    String cognome = "cognome serio";
    System.out.println(cognome.endsWith("cognome serio"));

    String cognome1 = "Gentili";
    String cognome2 = "Brouni";
    boolean minore = cognome1.length() > cognome2.length();

    cognome1 = "Paiola";
    cognome2 = "Paio";

    System.out.println(cognome1.compareTo(cognome2));
}