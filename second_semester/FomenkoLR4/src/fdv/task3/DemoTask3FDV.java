package fdv.task3;


import java.io.IOException;

public class DemoTask3FDV {

    public static void main(String[] args) throws IOException {
        ArrayToFileProc a = new ArrayToFileProc();
        String strPath = "c:\\Users\\Dmytro\\Desktop\\Dima\\Deep_Java\\Second\\Lab_4\\file_task3.txt";

        double[][] generatedArr = a.genArrDouble(2.5, 3.5, 5, 1, 5);
        System.out.println("\nGenerated arr:");
        a.printArr(generatedArr);


        System.out.println();
        boolean successWritingToFile = a.arrToFileWriter(generatedArr, strPath);

        if (successWritingToFile)
            System.out.println("Write array to file completed successfully!!!");
        else
            System.out.println("There is no such file at the given path!!!");

        System.out.println();

        double[][] readArrFromFile = a.readArrFromFile(strPath);
        System.out.println("Read from file array:");
        a.printArr(readArrFromFile);

        System.out.println();

        System.out.println("Matrix of minimal elements of each row:");
        double[][] minNums = a.matrixMinElems(readArrFromFile);
        a.printArr(minNums);

        System.out.println();

        System.out.println("Matrix of average elements values of each row:");
        double[][] averageNums = a.matrixAvgElems(readArrFromFile);
        a.printArr(averageNums);

    }
}
