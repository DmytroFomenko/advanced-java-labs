package fdv.task5;


import java.io.IOException;
import java.util.TreeSet;

public class DemoTask5FDV {
    public static void main(String[] args) throws IOException {
        FlatProc f = new FlatProc();
        String strPathFlatsFile = "c:\\Users\\Dmytro\\Desktop\\Dima\\Deep_Java\\Second\\Lab_4\\file_task5.txt";
        String strPathToDir = "c:\\Users\\Dmytro\\Desktop\\Dima\\Deep_Java\\Second\\Lab_4\\Info_25.02.2023";
        String strPathToFile1And2Flats = "c:\\Users\\Dmytro\\Desktop\\Dima\\Deep_Java\\Second\\Lab_4\\Info_25.02.2023\\1and2flats.txt";
        String strPathToFile3Flats = "c:\\Users\\Dmytro\\Desktop\\Dima\\Deep_Java\\Second\\Lab_4\\Info_25.02.2023\\3flats.txt";

        TreeSet<Flat> flatSet = f.readFromFile(strPathFlatsFile);

        System.out.println("TreeSet of all flats read from file:");
        flatSet.forEach(System.out::println);
        System.out.println();

        f.mkDir(strPathToDir);
        System.out.println();

        f.mkFile(strPathToFile1And2Flats);
        System.out.println();

        if(f.writeToFile1And2Flats(flatSet, strPathToFile1And2Flats)) {
            System.out.println("Flats with 1 and 2 rooms written to file successfully!!!");
        }
        System.out.println();

        f.mkFile(strPathToFile3Flats);
        System.out.println();

        if(f.writeToFile3Flats(flatSet, strPathToFile3Flats)) {
            System.out.println("Flats with 3 rooms written to file successfully!!!");
        }
        System.out.println();

    }
}
