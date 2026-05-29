void main(String[] args) {
    String str = args[0];
    int dimensione = str.length();
    boolean verifica = false;

    if (dimensione < 8) {
        System.out.println("Devi inserire almeno 8 caratteri!");
        verifica = true;
    }

    if (str.indexOf('@') == -1) {
        System.out.println("Errore devi inserire una @!");
        verifica = true;
    }

    if (verifica) {
        return;
    }

    System.out.print("La Password " + str + " è Corretta!");
}
