package fdv.task1;


import java.util.Objects;
import java.util.Scanner;
import java.util.function.BinaryOperator;

public class DemoTask1FDV {

    public static void main(String[] args) {
        Calculator c = new Calculator();
        Scanner scan = new Scanner(System.in);


        System.out.println(c.getBund().getString("menu"));
        System.out.println();
        String input = null;

        while (!Objects.equals(input, "9")) {
            BinaryOperator<Double> op;
            String opNum = "";
            System.out.print(c.getBund().getString("makeChoice"));
            input = scan.nextLine();

            switch (input) {
                case "1":
                    System.out.println(c.getBund().getString("langMenu"));
                    while (!opNum.equals("1") && !opNum.equals("2") && !opNum.equals("3")) {
                        //c.printChooseLangNum();
                        System.out.print(c.getBund().getString("chooseLanguageNum"));
                        opNum = scan.nextLine();
                    }
                    System.out.println();
                    c.setLocaleByChoice(opNum);
                    System.out.println(c.getBund().getString("menu"));
                    System.out.println();
                    break;
                case "2":
                    System.out.print(c.getBund().getString("inputFirstNum"));
                    String fNum = scan.nextLine();

                    while (!fNum.matches("[\\d]+\\.[\\d]+") && !fNum.matches("\\d+")) {
                        System.out.print(c.getBund().getString("inputFirstNum"));
                        fNum = scan.nextLine();
                    }
                    c.setFirstNum(Double.parseDouble(fNum));
                    System.out.println();
                    break;
                case "3":
                    System.out.print(c.getBund().getString("inputSecondNum"));
                    String sNum = scan.nextLine();

                    while (!sNum.matches("[\\d]+\\.[\\d]+") && !sNum.matches("\\d+")) {
                        System.out.print(c.getBund().getString("inputSecondNum"));
                        sNum = scan.nextLine();
                    }
                    c.setSecondNum(Double.parseDouble(sNum));
                    System.out.println();
                    break;
                case "4", "5", "6", "7", "8":
                    op = c.setOperator(input);
                    double res = c.makeCalc(op);
                    c.printCalc(input, res);
                    System.out.println();
                    break;
                case "9":
                    break;
                default:
                    System.out.println(c.getBund().getString("errorInChoiceNum"));
                    System.out.println();
                    break;
            }
        }
    }
}
