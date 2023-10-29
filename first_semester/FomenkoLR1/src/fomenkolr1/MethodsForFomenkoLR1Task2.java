package fomenkolr1;

/**
 * <b>Methods for task 2</b>
 * @author <u>Dmytro Fomenko</u>
 */
public class MethodsForFomenkoLR1Task2 {
    /**
     * <i><b>Returns the random integer value</b></i>
     * @param min <i>Minimal generated value</i>
     * @param max <i>Maximal generated value</i>
     * @return <i>The random integer value</i>
     */
    public static int randomizer(int min, int max) {
        int range = max - min + 1;
        int rand = (int)(Math.random() * range) + min;
        return rand;
    }

    /**
     * Create and fill the array by random numbers
     * @param min <i>Minimal generated value</i>
     * @param max <i>Maximal generated value</i>
     * @param arrayOfRandom <i>Array which will be filled by random nums</i>
     * @return <i>Returns the array filled by random nums</i>
     */
    public static int[] fillArrayByRandom(int min, int max, int[] arrayOfRandom) {
        // Filling an array with random numbers
        for (int i = 0; i < arrayOfRandom.length; i++) {
            arrayOfRandom[i] = MethodsForFomenkoLR1Task2.randomizer(min, max);
        }
        return arrayOfRandom;
    }

    /**
     * <i><b>Prints the array of random strings of 10 numbers</b></i>
     * @param arrOfRand <i>Array which will be printed</i>
     * @return <i>Returns 0 if there are no errors</i>
     */
    public static int arrayOfRandomStrOf10Print(int[] arrOfRand) {
        // Printing an array of random numbers
        for (int i = 0, k = 1; i < arrOfRand.length; i++, k++) {
            System.out.printf("%-7s", arrOfRand[i]);
            if (k == 10) {
                System.out.print("\n");
                k = 0;
            }
        }
        return 0;
    }
}
