package fdv.task4;


import java.util.function.Function;
import java.util.function.Predicate;

import static fdv.task4.TernaryFDV.ternaryOperator;

public class ImplementationTernary {
    public static void main(String[] args) {

        Predicate<Object> condition = (obj) -> obj.equals("-w");
        Function<Object, Integer> ifTrue = obj -> Integer.valueOf(args[1]);
        Function<Object, Integer> ifFalse = obj -> 80;
        Function<String, Integer> widthFun = ternaryOperator(condition, ifTrue, ifFalse);

        int width;

        // If there are no args, we can't to check them
        if (args.length >= 2) {
            width = widthFun.apply(args[0]);
        } else {
            width = widthFun.apply("");
        }

        System.out.println("Width = " + width);
    }
}
