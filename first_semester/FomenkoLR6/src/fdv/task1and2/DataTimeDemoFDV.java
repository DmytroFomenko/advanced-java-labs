package fdv.task1and2;


import static fdv.task1and2.DataTimeProcessing.*;


public class DataTimeDemoFDV {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("===[ Work with DATE ]===\n");

        String dateT1 = "14.11.2022";
        System.out.println("Vacation date: " + dateT1);
        String ticketDate = goalDate(dateT1, -45);
        System.out.println("Start of last ticket sale: " + ticketDate);
        System.out.print("\n\n");

        System.out.println("The date of conclusion of the agreement: " + dateT1);
        String cargoDate = goalDate(dateT1, 14);
        System.out.println("The final date of shipment of the cargo: " + cargoDate);
        System.out.print("\n\n");

        System.out.println("===[ Work with TIME ]===\n");

        String timeT1 = "14:25:40";
        System.out.println("Order time: " + timeT1);
        String deliveryTime = goalTime(timeT1, 60, 0);
        System.out.println("Time of delivery: " + deliveryTime);
        System.out.println();

        System.out.println("First message time: " + timeT1);
        String messageTime = goalTime(timeT1, 3, 30);
        System.out.println("Repeated message time: " + messageTime);
        System.out.print("\n\n");

        System.out.println("===[ Work with DATE DIFFERENCE ]===\n");

        String date2T1 = "08.05.2014";
        String differenceDate = yearsMonthDays(date2T1);
        System.out.println("The employee has worked from " + date2T1 + " to today for " + differenceDate);
        System.out.print("\n\n");

        System.out.println("===[ Task 2 - Find the DATE of SECOND WEDNESDAY of given QUARTER ]===\n");
        System.out.println("Dates of summary of current year:");
        System.out.println(showMeetingData(1));
        System.out.println(showMeetingData(2));
        System.out.println(showMeetingData(3));
        System.out.println(showMeetingData(4));
    }
}
