package fdv.task1;


import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.BinaryOperator;

public class Calculator {

    private double firstNum = 0;
    private double secondNum = 0;
    private ResourceBundle bund = ResourceBundle.getBundle("Text", new Locale("en"));



    public ResourceBundle getBund() {return bund;}
    public void setFirstNum(double firstNum) {this.firstNum = firstNum;}
    public void setSecondNum(double secondNum) {this.secondNum = secondNum;}



    public BinaryOperator<Double> setOperator(String op) {
        return switch (op) {
            case "4" -> Double::sum;
            case "5" -> (x, y) -> x - y;
            case "6" -> (x, y) -> x * y;
            case "7" -> (x, y) -> x / y;
            case "8" -> Math::pow;
            default -> null;
        };
    }
    public double makeCalc(BinaryOperator<Double> op) {
        return op.apply(this.firstNum, this.secondNum);
    }

    public String returnOpSymbol(String opNum) {
        return switch (opNum) {
            case "4" -> "+";
            case "5" -> "-";
            case "6" -> "*";
            case "7" -> "/";
            case "8" -> "^";
            default -> null;
        };
    }

    public void printCalc(String opNum, double res) {
        System.out.println(this.firstNum + " " + this.returnOpSymbol(opNum) + " " + this.secondNum + " = " + res);
    }

    public void setLocaleByChoice(String choice) {
        bund = ResourceBundle.getBundle("Text", new Locale(bund.getString(choice)));
    }

}

