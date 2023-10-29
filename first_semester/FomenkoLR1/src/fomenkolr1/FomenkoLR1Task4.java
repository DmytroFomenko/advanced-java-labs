package fomenkolr1;

/**
 * Class for <b>laboratory work 1 task 4.</b>
 * <p>The class <i><b>implements the creation and output of an array of prime numbers</b></i></p>
 * @author <u>Dmytro Fomenko</u>
 */
public class FomenkoLR1Task4 {

    /**
     * The main function that <i><b>prints an array of prime numbers</b></i>
     * @param args The argument <i>(length of array of prime numbers)</i>
     */
    public static void main(String[] args) {
        System.out.printf("%45s","TASK 4\n");

        int[] arrayOfPrimes = new int[Integer.parseInt(args[0])];

        MethodsForFomenkoLR1Task4.arrOfPrimesFiller(arrayOfPrimes);

        System.out.print("Array of " + args[0] + " Primes: ");

        MethodsForFomenkoLR1Task4.arrPrinter(arrayOfPrimes);

        System.out.print("\n\n\n");
    }
}


