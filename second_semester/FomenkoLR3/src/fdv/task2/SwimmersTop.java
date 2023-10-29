package fdv.task2;


import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class SwimmersTop {

    public void fillSwimmers(List<Swimmer> list, int n, Scanner scan) {
        for (int i = 1; i <= n; i++) {
            System.out.println("Fill data of swimmer " + i + ":");
            list.add(new Swimmer(scan));
            System.out.println();
        }
    }


    public List<Swimmer> sortByTop(List<Swimmer> list) {
        return list.stream().sorted((Swimmer s1, Swimmer s2) -> {
            Integer swim1 = s1.getTimeSec();
            int swim2 = s2.getTimeSec();
            return swim1.compareTo(swim2);
        }).toList();
    }

    public void printWinner(List<Swimmer> list) {
        System.out.println(list.stream().sorted((Swimmer s1, Swimmer s2) -> {
            Integer swim1 = s1.getTimeSec();
            int swim2 = s2.getTimeSec();
            return swim1.compareTo(swim2);
        }).findFirst().get().getName());
    }


    public void rewardSwimmers(List<Swimmer> swimmers) {
        int[] top = {0};
        AtomicInteger lastSwimSec = new AtomicInteger(-1);       // Always < than top time

        swimmers.stream().forEach((sw) -> {
            if (lastSwimSec.get() != sw.getTimeSec())    // If swimmers have the same time, they have the same top place
                top[0]++;
            sw.setTopPlace(top[0]);
            lastSwimSec.set(sw.getTimeSec());
        });

//        for (Swimmer sw : swimmers) {
//            if (lastSwimSec < sw.getTimeSec())
//                top++;
//            sw.setTopPlace(top);
//            lastSwimSec = sw.getTimeSec();
//        }
    }


    public void printSw(List<Swimmer> swimmers) {
        swimmers.stream().forEach(System.out::println);
    }
}
