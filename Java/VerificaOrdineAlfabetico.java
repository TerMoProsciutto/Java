public class VerificaOrdineAlfabetico {
    public static int verificaOrdineAlfabeticoStringhe(String a, String b) {

        boolean verifica_finale;

        if (a.equals(b)) return -1;

        int min;
        if (a.length() > b.length()) {
            min = b.length();
            verifica_finale = true;
        } else {
            min = a.length();
            verifica_finale = false;
        }

        for (int i = 0; i < min; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (a.charAt(i) < b.charAt(i)) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }


        if (verifica_finale)
            return 1;

        return -1;
    }
}
