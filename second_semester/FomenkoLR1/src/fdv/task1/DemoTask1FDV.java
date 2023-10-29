package fdv.task1;


/**
 * Demo class for <b>laboratory work 1 task 1</b>
 * @author <u>Dmytro Fomenko</u>
 */
public class DemoTask1FDV {
    public static void main(String[] args) {
        GenericClassFDV<String, Integer, Double> gen1 = new GenericClassFDV<>("Fomenko", 20, 1.80);
        System.out.println("GenClass:");
        gen1.printVars();
        System.out.println();

        GenericClassFDV<Integer, Double, Integer> gen2 = new GenericClassFDV<>(255, 3.33333, 61);
        System.out.println("GenClass:");
        gen2.printVars();
        System.out.println();

        GenericClassFDV<String, String, Double> gen3 = new GenericClassFDV<>("AAAAaaaa", "bbbbb", 5.99);
        System.out.println("GenClass:");
        gen3.printVars();
        System.out.println();
    }
}
