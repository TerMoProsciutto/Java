import java.util.ArrayList;

public class CreaArrayInRange {
    public static ArrayList<Integer> creaArrayInRange(ArrayList<Integer> array, int min, int max) {

        ArrayList<Integer> arrayCopia = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) >= min && array.get(i) <= max) {
                arrayCopia.add(array.get(i));
            }
        }
        return arrayCopia;
    }
}
