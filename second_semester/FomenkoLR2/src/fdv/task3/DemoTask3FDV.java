package fdv.task3;


import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;


public class DemoTask3FDV {

    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        Double[][] arr;


        DoubleArrProcFDV a = new DoubleArrProcFDV();
        arr = a.fillArr(n, m, 2.15, 4.52);

        System.out.println("\n==== The array has been filled successfully ====\n\n");



        Consumer<Double> leftAlign = (num) -> System.out.printf("%-10s ", num);
        Consumer<Double> rightAlign = (num) -> System.out.printf("%17s ", num);

        System.out.println("Array in LEFT align:");
        a.showArr(arr, leftAlign);
        System.out.print("\n\n");

        System.out.println("Array in RIGHT align:");
        a.showArr(arr, rightAlign);
        System.out.print("\n\n");



        Predicate<Double> numElemsInRange = (x) -> (x > 3.0) && (x < 4.0);

        System.out.println("Num of elements (3.0 < x < 4.0): " + a.countElem(arr, numElemsInRange));
        System.out.print("\n\n");



        UnaryOperator<Double> square = (num) -> Math.pow(num, 2);
        UnaryOperator<Double> roundUp = Math::ceil;
        UnaryOperator<Double> roundDown = Math::floor;

        a.procElem(arr, square);
        System.out.println("Array after SQUARE:");
        a.printArrWithSpecifier(arr, "%-5.2f  ");
        System.out.println();


        a.procElem(arr, roundUp);
        System.out.println("Array after rounding UP:");
        a.printArrWithSpecifier(arr, "%-3.0f  ");
        System.out.println();

        a.procElem(arr, roundDown);
        System.out.println("Array after rounding DOWN:");
        a.printArrWithSpecifier(arr, "%-3.0f  ");
        System.out.println();

    }
}

