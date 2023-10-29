package fomenkolr1;


/**
 * <b>Methods for task 4</b>
 * @author <u>Dmytro Fomenko</u>
 */
public class MethodsForFomenkoLR1Task4 {
    /**
     * <i><b>Checks If a number is prime</b></i>
     * @param number <i>The number to be checked for primality</i>
     * @return <i>Return <b>true</b> if number is prime and <b>false</b> if number is not prime</i>
     */
    static boolean isPrime(int number) {
        // A pair number other than 2 cannot be prime
        if (number % 2 == 0 && number != 2)
            return false;
        // It makes sense to check only divisors whose ^2 is less than a number
        for (int divider = 3; divider * divider <= number; divider += 2) {   // It makes no sense for a divider to be paired
            if (number % divider == 0)
                return false;
        }
        return true;
    }

    /**
     * <i><b>Input the array, fill it with prime numbers and return it</b></i>
     * @param arrayOfPrimes <i>Empty array to be filled with prime numbers in ascending order</i>
     * @return <i>Return the array filled with prime numbers</i>
     */
    public static int[] arrOfPrimesFiller(int[] arrayOfPrimes) {
        int numInArrOfPrimes = 0;
        int number = 2;
        int counterOfPrimes = 0;

        while (counterOfPrimes < arrayOfPrimes.length) {

            if (isPrime(number)) {
                arrayOfPrimes[numInArrOfPrimes] = number;
                numInArrOfPrimes++;
                counterOfPrimes++;
            }
            number++;
        }
        return arrayOfPrimes;
    }


    /**
     * Prints int array with " " besides elements
     * @param arr Array which will be printed
     * @return Return array with one "0" element
     */
    static int[] arrPrinter(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        return new int[]{0};
    }
}
