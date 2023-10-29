package fdv.task2;


import java.util.function.BinaryOperator;

public class UnaryOperationsFDV {

    public static BinaryOperator<Double> setOperator(String opName) {
        return switch (opName) {
            case "plus" -> Double::sum;
            case "minus" -> (x, y) -> x - y;
            case "multy" -> (x, y) -> x * y;
            case "divide" -> (x, y) -> x / y;
            case "pow" -> Math::pow;
            default -> null;
        };
    }

    public static double makeCalc(double x, double y, BinaryOperator<Double> op) {
        return op.apply(x, y);
    }

}

