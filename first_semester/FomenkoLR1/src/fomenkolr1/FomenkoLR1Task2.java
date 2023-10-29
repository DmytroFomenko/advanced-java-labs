package fomenkolr1;

/**
 * Class for <b>laboratory work 1 task 2.</b>
 * <p>The class <i><b>prints random strings of 10 numbers generated in a given range</b></i></p>
 * @author <u>Dmytro Fomenko</u>
 */
public class FomenkoLR1Task2 {
    /**
     * The main function that <i><b>prints random strings of 10 numbers generated in a given range</b></i>
     * @param args The argument <i>(count of generated numbers)</i>
     */
    public static void main(String[] args) {
        System.out.printf("%45s","TASK 2\n");

        System.out.print("Array of " + args[0] + " random values:\n");

        int[] arrayOfRandom = new int[Integer.parseInt(args[0])];

        MethodsForFomenkoLR1Task2.fillArrayByRandom(-50, 40, arrayOfRandom);

        MethodsForFomenkoLR1Task2.arrayOfRandomStrOf10Print(arrayOfRandom);

        System.out.print("\n\n\n");
    }
}

