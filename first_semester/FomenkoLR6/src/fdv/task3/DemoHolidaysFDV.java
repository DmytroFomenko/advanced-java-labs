package fdv.task3;


import java.util.Scanner;

public class DemoHolidaysFDV {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String path = "src/fdv/task3/holidays.txt";
        int numOfConsecHolidays = 3;


        System.out.print("\nEnter the day from which to start displaying holidays: ");
        String firstHoliday = scan.nextLine();

        System.out.println("\nHolidays of " + numOfConsecHolidays + " days from " + firstHoliday + ":\n");

        (new HolidaysShowerFDV()).printHolidaysByDate(path, firstHoliday, numOfConsecHolidays);
    }
}
