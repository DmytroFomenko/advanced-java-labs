package fdv.task2;


import java.util.function.BinaryOperator;

import static fdv.task2.UnaryOperationsFDV.makeCalc;
import static fdv.task2.UnaryOperationsFDV.setOperator;


public class DemoTask2FDV {
    private static final String[] opArr =
            new String[]{"plus", "minus", "multy", "divide", "pow"};


    public static void main(String[] args) {
        double a = 3;
        double b = 7.0;


        BinaryOperator<Double> op;

        for (String opName : opArr) {
            op = setOperator(opName);
            if (op != null) {
                double res = makeCalc(a, b, op);
                System.out.printf("a=%.2f, b=%.2f, a %s b = %.4f\n", a, b, opName, res);
            } else {
                System.out.println("Unknown operation!");
            }
        }
    }
}
