public class Main {
    public static void main(String[] args) {

        //con la dichiarazione delle variabili il suo tipo diventa statico, ossia non può essere variato; mentre il suo valore può essere convertito di tipo attraverso il casting

        //casting implicito: conversione di tipo implicita eseguita automaticamente dal compilatore:  ad una variabile dichiarata di un certo tipo viene attribuito un valore di tipo diverso. Il tipo della variabile non cambia mai; è il valore che viene convertito adattandosi al tipo della variabile. Se il tipo di "arrivo" è più grande del tipo di partenza allora la conversione non da problemi di perdita di informazioni e per tanto avviene automaticamente.
        //casting esplicito: la conversione da un tipo più grande ad uno più piccolo non è mai automatica, perché sia in fase di compilazione e sia in fase di esecuzione può portare a perdita di informazioni.

        //byte=1B   int=4B   long=8B   float=4B   double=8B

        //Se operandi di tipo diverso vengono concatenati allora prevale il tipo String ne consegue che un numero concatenato ad una stringa, produce una stringa.
        //Se in una espressione intera compaiono più tipi di operandi interi (byte,char,short,int,long), allora vengono promossi implicitamente (auto) a int o long ossia il tipo più grande.

        //es.
        //float x = 12,45
        //double y = 11,43
        //x+y

        //Il valore prima viene promosso e poi assegnato.
        //la conversione esplicita può essere fatta in 2 modi:
        //casting esplicito
        //altri metodi di conversione

        //Il casting esplicito però non sempre è consentito: non si può convertire una variabile boolean in nessun altro tipo di dato primitivo.

        //dichiarazione delle variabili
        int eta = 10;
        int numero_figli = 2;
        String nome = "Paolo", x, eta1 = "20", s;
        float altezza = 100.5F, r;
        double z, y;
        int q, p;

        x = numero_figli + nome;
        System.out.println("cast implicito da numero a stringa: x= " + x);

        y = altezza;
        System.out.println("cast implicito da float a double: y= " + y);

        q = (int) altezza; //casting esplicito
        System.out.println("cast esplicito da float a intero: q= " + q);

        p = Integer.parseInt(eta1);
        System.out.println(p);

        z = Double.parseDouble(eta1);
        System.out.println(z);//string-double

        r = Float.parseFloat(eta1);
        System.out.println(r);//string-float

        z = z + p;
        System.out.println("Conversione implicita int-double: " + z);

        s = String.valueOf(q);
        System.out.println("Conversione int-string: " + s);

    }
}