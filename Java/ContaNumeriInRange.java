public class ContaNumeriInRange {
    public static int contaNumeriInRange(int[] array, int min, int max) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= min && array[i] <= max) {
                j++;
            }
        }

        return j;
    }
}
