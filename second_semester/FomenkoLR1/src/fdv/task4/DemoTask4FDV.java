package fdv.task4;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Demo class for <b>laboratory work 1 task 4</b>
 * @author <u>Dmytro Fomenko</u>
 */
public class DemoTask4FDV {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>() {{
            add("able");
            add("256");
            add("but");
            add("dask");
            add("9675");
            add("car");
            add("store");
            add("349");
            add("553");
            add("key");
        }};


        Runnable sortType1 = () -> {
            list.sort(Collections.reverseOrder());
        };


        Comparator cmpType2 = (Object s1, Object s2) -> {
            String str1 = (String) s1;
            String str2 = (String) s2;

            if ((str1.charAt(0) > '9')) { // First letter
                if (str2.charAt(0) <= '9') { // First letter, second num
                    return 1;
                } else { // Both letters
                    return -str1.compareTo(str2);
                }
            } else if (str2.charAt(0) > '9') { // First num second letter
                return -1;
            } else { // Both nums
                return -str1.compareTo(str2);
            }
        };

        Runnable sortType2 = () -> {
            list.sort(cmpType2);
        };

        Thread t1 = new Thread(sortType1);
        Thread t2 = new Thread(sortType2);


        Proc starter = (Thread t) -> t.start();


        starter.startThread(t1);
        try {t1.join();} catch (InterruptedException e) {}

        System.out.println("First algorithm (z-a 9-0):");
        System.out.println(list + "\n");

        starter.startThread(t2);
        try {t2.join();} catch (InterruptedException e) {}

        System.out.println("Second algorithm (9-0 z-a):");
        System.out.println(list);
    }
}

/**
 * Interface for lambda starter
 */
interface Proc {
    void startThread(Thread t);
}
