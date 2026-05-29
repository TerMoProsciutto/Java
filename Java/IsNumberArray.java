public class IsNumberArray {
    public static boolean isNumberInArray(int n, int[] array) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                return true;
            }
        }

        return false;

    }
}
