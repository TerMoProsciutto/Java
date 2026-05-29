public class GetRipetizioniChar {
    public static Risultato getResult(String stringa) {
        boolean exit = false;
        int contatore = 0;
        String controllo = "";
        Risultato result = new Risultato();


        for (int i = 0; i < stringa.length() - 1; i++) {
            for (int x = 0; x < controllo.length(); x++) {
                if (stringa.charAt(i) == controllo.charAt(x)) {
                    exit = true;
                    break;
                }
            }

            if (!exit) {
                for (int j = i + 1; j < stringa.length(); j++) {
                    if (stringa.charAt(i) == stringa.charAt(j)) {
                        contatore++;
                    }
                }
                if (contatore > 0) {
                    controllo += stringa.charAt(i);
                }
                if (contatore + 1 > result.getRipetizioni()) {
                    result.setCarattere(stringa.charAt(i));
                    result.setRipetizioni(contatore + 1);
                }
                contatore = 0;
            }
            exit = false;
        }

        return result;
    }
}
