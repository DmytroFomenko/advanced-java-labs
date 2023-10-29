package fdv.editionTaskForLab1.secondVariantTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class DemoSortUAAlphabet {
    private static void showStrings(ArrayList<String> list) {
        for (String s: list) {
            System.out.print(s+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String[] arrS = new String[]{"АСУ", "ЕОМ", "ЄСПД", "СКБД", "МВЗ", "МПЗ", "DBMS", "LMS", "UML"};
        ArrayList<String> listS = new ArrayList<>(Arrays.asList(arrS));
        System.out.println("Generated Array");
        showStrings(listS);
        Collections.sort(listS);
        System.out.println("Sorted Array (native order)");
        showStrings(listS);
        Collections.sort(listS,new StringsInOrderUAAlf());
        System.out.println("Sorted Array (UA order)");
        showStrings(listS);
    }

}

class StringsInOrderUAAlf implements Comparator<String> {
    private String sortOrder = "АБВГҐДЕЄЖЗІЇЙКЛМНОПРСТУФХЦЧШЩБЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public int compare(String s1, String s2) {
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            int s1Order = sortOrder.indexOf(s1.charAt(i));
            int s2Order = sortOrder.indexOf(s2.charAt(i));

            int order = s1Order - s2Order;
            if (order != 0) {
                return order;
            }
        }

        if (s1.length() > s2.length()) {
            return -1;
        } else if (s1.length() < s2.length()) {
            return 1;
        }
        return 0;
    }
}
