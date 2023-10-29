package fomenkolr1;

/**
 * Demo class for <b>laboratory work 1</b>
 * <p>The class <i><b>runs classes with calculations</b></i></p>
 * @author <u>Dmytro Fomenko</u>
 */
public class DemoLR1Fomenko {
    /**
     * The main function that <i><b>runs classes with calculations</b></i>
     * @param args <i>Arguments</i>
     * @author <u>Dmytro Fomenko</u>
     */
    public static void main(String[] args) {
        System.out.println("\n==[ Program start ]==\n\n");

        FomenkoLR1Task1.main(new String[]{"Hello, World"});

        FomenkoLR1Task2.main(new String[]{"36"});

        FomenkoLR1Task3.main(new String[]{
                "3",
                "25", "35",
                "20", "30",
                "-10", "20"}
        );

        FomenkoLR1Task4.main(new String[]{"17"});

        System.out.println("==[ End of program ]==");
    }
}












