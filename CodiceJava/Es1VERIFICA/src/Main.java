import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        double altezza_iniziale, distanza, altezza_finale=0;
        int mesi;
        do {
            System.out.print("Inserisci l'altezza iniziale della pianta: ");
            altezza_iniziale = keyboard.nextDouble();
        }while(altezza_iniziale <= 0);
        do {
            System.out.print("Inserisci i mesi trascorsi: ");
            mesi = keyboard.nextInt();
        }while(mesi < 1);
        altezza_finale += altezza_iniziale;
        for(int i = 0; i < mesi; i++){
            altezza_iniziale /= 2;
            altezza_finale += altezza_iniziale;
        }
        System.out.print("L'altezza finale dopo "+mesi+" mesi è di: "+altezza_finale);
    }
}