public class CodiceBarre {
    public static int calcolaTredicesimo(int[] array) {

        if (array.length != 12) {
            return -1;
        }

        int somma = 0;

        for (int i = 0; i < 12; i++) {

            if (i % 2 == 0) {
                somma += array[i] * 3;
            } else {
                somma += array[i];
            }

        }

        return (somma % 10);
    }
}
