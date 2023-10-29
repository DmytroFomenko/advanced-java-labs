package fdv.task3;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static java.nio.file.Files.exists;
import static java.nio.file.Files.isRegularFile;

public class ArrayToFileProc {

    public double[][] genArrDouble(Double min, Double max, int rows, int colsMin, int colsMax) {
        int colsNum;
        int rangeCols = colsMax - colsMin + 1;

        double range = max - min;
        double num;

        double[][] arr = new double[rows][];

        for (int i = 0; i < arr.length; i++) {
            colsNum = (int) ((Math.random() * rangeCols) + 1);
            arr[i] = new double[colsNum];

            for (int j = 0; j < arr[i].length; j++) {
                num = (double) Math.round(((Math.random() * range) + min) * 10) / 10;
                arr[i][j] = num;
            }
        }
        return arr;
    }

    public void printArr(double[][] arr) {
        for (double[] row : arr) {
            for (Double elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public boolean arrToFileWriter(double[][] arr, String strPath) throws IOException {
        Path path = Path.of(strPath);
        File file = new File(strPath);

        if (exists(path) && isRegularFile(path)) {
            FileWriter writer;
            writer = new FileWriter(file);

            for (int i = 0; i < arr.length; i++) {
                for (Double elem : arr[i]) {
                    writer.write(elem + " ");
                }
                if (i != arr.length - 1) { // For no newline at the end of file
                    writer.write("\n");
                }
            }
            writer.close();
            return true;
        } else {
            return false;
        }
    }


    public double[][] readArrFromFile(String strPath) {
        try {
            Path path = Paths.get(strPath);
            final int linesCount = (int) Files.lines(path).count();
            double[][] allNumbers = new double[linesCount][];
            int[] i = {0};

            Files.lines(path).forEach(line -> {
                double[] lineNumbers = Arrays.stream(line.split(" ")).mapToDouble(Double::valueOf).toArray();
                allNumbers[i[0]++] = lineNumbers;
            });
            return allNumbers;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public double[][] matrixMinElems(double[][] arr) {
        double[][] matrixMin = new double[arr.length][1];
        int[] i = {0};

        Arrays.stream(arr).forEach(row -> matrixMin[i[0]++] = Arrays.stream(row).min().stream().toArray());

        return matrixMin;
    }


    public double[][] matrixAvgElems(double[][] arr) {
        double[][] matrixAverage = new double[arr.length][1];
        int[] i = {0};

        Arrays.stream(arr).forEach(row -> matrixAverage[i[0]++] = Arrays.stream(row).average().stream().toArray());

        return matrixAverage;
    }
}


