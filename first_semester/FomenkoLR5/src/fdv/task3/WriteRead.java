package fdv.task3;


import java.util.Scanner;


public class WriteRead {

    public static int inputNumber(Scanner scan, String prompt, boolean allowZero) {
        int lowLimit;
        int value = -1;
        boolean dataOk;

        if (allowZero) {
            lowLimit = 0;
        } else {
            lowLimit = 1;
        }

        do {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scan.nextLine());
                dataOk = (value >= lowLimit);
            } catch (NumberFormatException e) {
                dataOk = false;
            }
        } while (!dataOk);

        return value;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Writer writer = new Writer("W1");

        int cntReaders = inputNumber(scan, "Enter the number of readers (positive integer): ", true);

        int choice;

        do {
            System.out.print("Enter the number of messages to be written and read: ");
            try {
                choice = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            if (choice > 0) {
                writer.addReaders(cntReaders);
                writer.startWriting(choice);
                System.out.printf("\n");
                return;
            } else if (choice == 0) {
                writer.stopWriting();
                writer.deleteAllReaders();
                System.out.printf("Exiting...\n");
                return;
            } else {
                System.out.printf("Wrong choice! Try again ...\n");
            }
        } while (choice != 0);
    }
}
