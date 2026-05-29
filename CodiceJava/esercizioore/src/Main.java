void main() {
    int n = 234555, h, m;
    boolean verifica = true;
    h = n / 10000;
    n -= h * 10000;
    m = n / 100;
    n -= m * 100;
    System.out.println("ore: " + h);
    System.out.println("minuti: " + m);
    System.out.println("secondi: " + n);
}