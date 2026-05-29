public class Sottostringa {
    public static int puntoDiPartenzaSottostringa(String s1, String s2) {
        if (s1.contains(s2)) {
            for (int i = 0; i <= s1.length() - s2.length(); i++) {
                if (s1.indexOf(s2, i, i + s2.length()) != -1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
