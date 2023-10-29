package fdv.task1;


/**
 * Class for <b>laboratory work 1 task 1</b>
 * @author <u>Dmytro Fomenko</u>
 * @param <T> First generic type for generic class GenericClassFDV
 * @param <V> Second generic type for generic class GenericClassFDV
 * @param <K> Third generic type for generic class GenericClassFDV
 */
public class GenericClassFDV<T, V, K> {
    private T t;
    private V v;
    private K k;

    /**
     * Class constructor
     * @param t Variable t of generic type
     * @param v Variable v of generic type
     * @param k Variable k of generic type
     */
    GenericClassFDV(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {return t;}
    public V getV() {return v;}
    public K getK() {return k;}

    /**
     * Prints the values of variables and their data types in a column
     */
    public void printVars() {
        System.out.println(getT() + ": instance of " + getT().getClass());
        System.out.println(getV() + ": instance of " + getV().getClass());
        System.out.println(getK() + ": instance of " + getK().getClass());
    }
}
