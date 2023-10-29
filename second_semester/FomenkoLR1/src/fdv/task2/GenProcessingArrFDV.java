package fdv.task2;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class for <b>laboratory work 1 task 2</b>
 * @param <T> Generic type T for generic class GenProcessingArrFDV
 * @author <u>Dmytro Fomenko</u>
 */
public class GenProcessingArrFDV<T extends Comparable> {

    private T[] array;

    /**
     * Class constructor that inputs an array of generic type
     * @param arr Array of generic type
     */
    GenProcessingArrFDV(T[] arr) {
        this.array = arr;
    }

    public T[] getArray() {return array;}

    /**
     * Prints an array into a string
     */
    public void printArr() {
        System.out.println(Arrays.toString(getArray()));
    }

    /**
     * Prints the data type of array
     */
    public void printType() {
        System.out.println("Type of array: " + getArray().getClass());
    }

    /**
     * Sorts an array
     * @return Returns sorted array
     */
    public T[] sortArr() {
        Arrays.sort(getArray());
        return getArray();
    }

    /**
     * Prints an array into a column
     */
    public void printArrInCol() {
        for (T i : getArray()) {
            System.out.println(i);
        }
    }

    /**
     * Finds minimal element of array
     * @return Minimal element of array
     */
    public T min() {
        T min = null;
        List<T> arrAsList = Arrays.asList(getArray());
        min = (T) Collections.min(arrAsList);
        return min;
    }

    /**
     * Finds maximal element of array
     * @return Maximal element of array
     */
    public T max() {
        T min = null;
        List<T> arrAsList = Arrays.asList(getArray());
        min = (T) Collections.max(arrAsList);
        return min;
    }

    /**
     * Finds the first element of array
     * @return The first element of array
     */
    public T firstElem() {
        T first = getArray()[0];
        return first;
    }

    /**
     * Finds the last element of array
     * @return The last element of array
     */
    public T lastElem() {
        T last = getArray()[getArray().length - 1];
        return last;
    }

}
