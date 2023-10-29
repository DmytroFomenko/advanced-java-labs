package fdv.editionTaskForLab1.firstVariantTask;


import java.util.ArrayList;
import java.util.Comparator;

public class ArraySorterFDV {

    /**
     * Sorts ArrayList of strings by [АаБбВбГг..ЯяAaBbCc..Zz]
     *
     * @param list ArrayList for sorting
     * @return Sorted ArrayList
     */
    public static ArrayList<String> sortType1(ArrayList<String> list) {
        ArrayList<String> resList = (ArrayList<String>) list.clone();

        BinaryFunction<String, Integer> resComparing = (s1, s2) -> {
            int res = 0;

            int len1 = s1.length();
            int len2 = s2.length();
            int minLen = Integer.min(len1, len2);
            int i = 0;

            while ((res == 0) && (i < minLen)) {

                char char1At = s1.charAt(i);
                char char2At = s2.charAt(i);
                char char1AtUpper = Character.toUpperCase(char1At);
                char char2AtUpper = Character.toUpperCase(char2At);

                if (s1.charAt(0) >= 'А' && s2.charAt(0) <= 'z') {
                    res = -1;
                    break;
                }
                if (char1AtUpper != char2AtUpper) // Different letter
                    res = char1AtUpper - char2AtUpper;
                else
                    res = char1At - char2At;

                i++;
            }
            if (i >= minLen) {
                res = len1 - len2;
            }
            return res;
        };


        Comparator cmpType1 = (Object s1, Object s2) -> resComparing.cmp((String)s1, (String)s2);

        resList.sort(cmpType1);
        return resList;
    }

    /**
     * Sorts ArrayList of strings by [AaBbCc..ZzАаБбВбГг..Яя]
     *
     * @param list ArrayList for sorting
     * @return Sorted ArrayList
     */
    public static ArrayList<String> sortType2(ArrayList<String> list) {
        ArrayList<String> resList = (ArrayList<String>) list.clone();

        BinaryFunction<String, Integer> resComparing = (s1, s2) -> {
            int res = 0;

            int len1 = s1.length();
            int len2 = s2.length();
            int minLen = Integer.min(len1, len2);
            int i = 0;

            while ((res == 0) && (i < minLen)) {

                char char1At = s1.charAt(i);
                char char2At = s2.charAt(i);
                char char1AtUpper = Character.toUpperCase(char1At);
                char char2AtUpper = Character.toUpperCase(char2At);

                if (char1AtUpper != char2AtUpper) // Different letter
                    res = char1AtUpper - char2AtUpper;
                else
                    res = char1At - char2At;

                i++;
            }
            if (i >= minLen) {
                res = len1 - len2;
            }

            return res;
        };


        Comparator cmpType2 = (Object s1, Object s2) -> resComparing.cmp((String)s1, (String)s2);

        resList.sort(cmpType2);
        return resList;
    }
}

@FunctionalInterface
interface BinaryFunction<String, Integer> {
    Integer cmp(String s1, String s2);
}


