
package fomenkolr1;

/***
 * Class for <b>laboratory work 1 task 3.</b>
 * <p>The class <i><b>prints a randomly generated temperature for each day of the 3 months of the selected quarter</b></i></p>
 * @author <u>Dmytro Fomenko</u>
 */
public class YearData {

    /***
     * <i><b>The record that describes days, months and quarters</i></b>
     * @param numInQuarter <i>The number of month in a quarter</i>
     * @param quarter <i>The number of quarter</i>
     * @param name <i>The name fo the month</i>
     * @param daysInMonth <i>Count of days in month</i>
     */
    record Month(
            int numInQuarter,
            int quarter,
            String name,
            int daysInMonth
    ) {}
    private static final Month[] year = {
            new Month(1, 1, "January", 31),
            new Month(2, 1, "February", 28),
            new Month(3, 1, "March", 31),
            new Month(1, 2, "April", 30),
            new Month(2, 2, "May", 31),
            new Month(3, 2, "June", 30),
            new Month(1, 3, "July", 31),
            new Month(2, 3, "August", 31),
            new Month(3, 3, "September", 30),
            new Month(1, 4, "October", 31),
            new Month(2, 4, "November", 30),
            new Month(3, 4, "December", 31)};


//    class TempInDay {
//    }

    /**
     * Parse string array to int
     * @param quartNum String array that will be parsed to int
     * @return Int array
     */
    public static int quartNumToInt(String quartNum) {
        return Integer.parseInt(quartNum);
    }

    /**
     * Prints name of month
     * @param name Name of month that will be printed
     * @return <i>Returns 0</i>
     */
    public static int printMonthName(String name) {
        int center = 41 + (name.length() /2);
        System.out.printf("\n%" + (center) + "s", name);      // Printing the name of the month
        return 0;
    }

    /**
     * Prints the string with 5 spaces
     * @param value <i>Value that will be printed</i>
     * @return 0 <i>Returns 0</i>
     */
    public static int printWithSpace5(int value) {
        System.out.printf("%5s", value);
        return 0;
    }


    /**
     * Calculate and print temperatures of all days in months in selected quarter
     * @param allArgsArr <i>Array of all indexes</i>
     * @param daysInFirstStr <i>Number of days that will be printed in first line</i>
     * @return <i>Returns 0</i>
     */
    public static int Calc (String[] allArgsArr, int daysInFirstStr) {

        int[] temperature = new int[allArgsArr.length - 1];

        for (int i = 0; i < temperature.length; i++) {
            temperature[i] = Integer.parseInt(allArgsArr[i + 1]);
        }

        for (Month m : year) {
            if (m.quarter == quartNumToInt(allArgsArr[0])) {

                printMonthName(m.name);
                System.out.print("\nday");

                int t = 1;
                for (int day = 1; day <= m.daysInMonth; day++) {
                    printWithSpace5(day);

                    if (day == daysInFirstStr || day == m.daysInMonth) {
                        System.out.print("\n t ");

                        for (; t <= day; t++) {
                            int tMin = temperature[(m.numInQuarter - 1) * 2];
                            int tMax = temperature[(m.numInQuarter - 1) * 2 + 1];

                            int randomValue = MethodsForFomenkoLR1Task2.randomizer(tMin, tMax);

                            printWithSpace5(randomValue);
                        }
                        if (day == daysInFirstStr) {
                            System.out.print("\nday");
                        }
                    }
                }
            }
        }
        return 0;
    }
}




