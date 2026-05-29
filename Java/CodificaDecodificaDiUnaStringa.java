public class CodificaDecodificaDiUnaStringa {
    public static String codificaStringa(String stringa, int scelta, int posizioni) {
        String risultato = "";
        char carattere = 0;

        //scelta = 1 --> codifica         scelta = 0 --> decodifica

        if (scelta == 1) {
            for (int i = 0; i < stringa.length(); i++) {
                carattere = stringa.charAt(i);
                for (int j = 0; j < posizioni; j++) {
                    carattere += 1;
                    if (stringa.charAt(i) > 96) {
                        if (carattere > 122) {
                            carattere = 'a';
                        }
                    } else {
                        if (carattere > 90) {
                            carattere = 'A';
                        }
                    }
                }
                risultato += carattere;
            }
        }
    else {
        for (int i = 0; i < stringa.length(); i++) {
            carattere = stringa.charAt(i);
            for (int j = 0; j < posizioni; j++) {
                carattere -= 1;
                if (stringa.charAt(i) > 96) {
                    if (carattere < 97) {
                        carattere = 'z';
                    }
                } else {
                    if (carattere < 65) {
                        carattere = 'Z';
                    }
                }
            }
            risultato += carattere;
        }
    }

        return risultato;
    }
}
