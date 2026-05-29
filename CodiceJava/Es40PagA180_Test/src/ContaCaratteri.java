public class ContaCaratteri {
    public static int contaCaratteri(String stringa1, String stringa2) {
        int contatore = 0;
        for (int i = 0; i < stringa1.length(); i++) {

            for (int j = 0; j < stringa2.length(); j++) {
                if (stringa1.charAt(i) == stringa2.charAt(j)) {
                    contatore++;
                    break;
                }
            }

        }
        return contatore;
    }
}
