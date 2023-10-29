package fomenkolr1;

/**
 * Class for <b>laboratory work 1 task 3.</b>
 * <p>The class <i><b>prints a randomly generated temperature for each day of the 3 months of the selected quarter</b></i></p>
 * @author <u>Dmytro Fomenko</u>
 */
public class FomenkoLR1Task3 {
    /***
     * The main function that <i><b>prints the temperature of each day of the months of the selected quarter</b></i>
     * @param args Arguments <i>("<b>number of quarter</b>", "<b>min t? of 1 month</b>",
     *             "<b>max t? of 1 month</b>", "<b>min t? of 2 month</b>", "<b>max t? of 2 month</b>",
     *             "<b>min t? of 3 month</b>", "<b>max t? of 3 month</b>")</i>
     */
    public static void main(String[] args) {
        System.out.printf("%45s","TASK 3\n");

        System.out.printf("%30sQuarter №%s temperature", " ", YearData.quartNumToInt(args[0]));

        YearData.Calc(args, 15);

        System.out.print("\n\n\n");
    }
}



