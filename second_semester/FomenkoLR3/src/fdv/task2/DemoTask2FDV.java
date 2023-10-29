package fdv.task2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DemoTask2FDV {
    public static void main(String[] args) {
        int n = 6;
        Scanner scan = new Scanner(System.in);
        SwimmersTop top = new SwimmersTop();
        List<Swimmer> swimmersList = new ArrayList<>();

        top.fillSwimmers(swimmersList, n, scan);

        List<Swimmer> topSwimmersList = top.sortByTop(swimmersList);
        top.rewardSwimmers(topSwimmersList);

        System.out.print("Winner: ");
        top.printWinner(swimmersList);
        System.out.println();

        System.out.println("Top of swimmers:");
        top.printSw(topSwimmersList);

    }
}

