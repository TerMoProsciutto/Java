import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double area, perimetro, lato_corto, lato_lungo,base_minore;
        
        do {
            System.out.print("Inserisci il valore del lato più corto del rettangolo: ");
            lato_corto = keyboard.nextDouble();
        } while (lato_corto <= 0);
        
        do {
            System.out.print("Inserisci il valore del lato più lungo del rettangolo: ");
            lato_lungo = keyboard.nextDouble();
        } while (lato_lungo <= 0 || lato_lungo <= lato_corto);
        
        area = lato_corto * lato_lungo;
        perimetro = lato_lungo * 2 + lato_corto * 2;
        System.out.println("l'area del rettangolo è: " + area + "\nil perimetro del rettangolo è: " + perimetro);
    }
}
