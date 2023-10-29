package fdv.task3;


import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class DoubleArrProcFDV {

    public Double[][] fillArr(int n, int m, double min, double max) {
        Double[][] arr = new Double[n][m];

        Rand randValue = (double minimal, double maximal) -> {
            double range = max - min;
            double num = (Math.random() * range) + min;
            return (double) Math.round(num * 100) / 100;
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = randValue.rand(min, max);
            }
        }
        return arr;
    }


    public void showArr(Double[][] arr, Consumer<Double> consumer) {
        int rows = arr.length;
        int cols = arr[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                consumer.accept(arr[i][j]);
            }
            System.out.println();
        }
    }


    public int countElem(Double[][] arr, Predicate<Double> condition) {
        int rows = arr.length;
        int cols = arr[0].length;
        int n = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (condition.test(arr[i][j])) {
                    n++;
                }
            }
        }
        return n;
    }

    public void procElem(Double[][] arr, UnaryOperator<Double> function) {
        int rows = arr.length;
        int cols = arr[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = function.apply(arr[i][j]);
            }
        }
    }


    public void printArrWithSpecifier(Double[][] arr, String specifier) {
        int cols = arr[0].length;

        for (Double[] doubles : arr) {
            for (int j = 0; j < cols; j++) {
                System.out.printf(specifier, doubles[j]);
            }
            System.out.println();
        }
    }

}


@FunctionalInterface
interface Rand {
    double rand(double minimal, double maximal);
}

