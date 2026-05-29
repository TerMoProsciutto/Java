public class VerificaPalindroma {


    public static boolean verificaStringaPalindroma(String stringa) {
        String copia_inversa = "";

        for (int i = stringa.length() - 1; i >= 0; i--) {
            copia_inversa += stringa.charAt(i);
        }

        return stringa.equals(copia_inversa);
    }


}
