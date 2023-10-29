package fdv.task1;


import java.io.IOException;
import java.util.Scanner;

public class DemoTask1FDV {
    public static void main(String[] args) throws IOException {
        PathsChecker p = new PathsChecker();
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.print("Input path to be checked ==> ");
        String path = scan.nextLine();
        System.out.println();

        //String path = "c:\\Users\\Dmytro\\Desktop\\Dima\\Deep_Java\\Second\\Lab_4";
        //String path = "c:\\Users\\Dmytro\\Desktop\\Dima\\Deep_Java\\Second\\Lab_4\\file_task1.txt";

        p.pathProcessing(path);

    }
}
