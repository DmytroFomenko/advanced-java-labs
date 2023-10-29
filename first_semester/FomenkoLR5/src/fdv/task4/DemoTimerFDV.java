package fdv.task4;


import java.util.Scanner;

import static fdv.task4.TimerFDV.*;

public class DemoTimerFDV {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        TimerFDV timer = new TimerFDV();

        int choice;
        System.out.println("\n***** TIMER FUNCTIONS *****");
        System.out.println("1. START");
        System.out.println("2. PAUSE");
        System.out.println("3. STOP");
        System.out.println("4. RESET");
        System.out.println("0. EXIT");

        do {
            System.out.print("\nEnter the command => ");
            try {
                choice = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    if (seconds > 0 && isStopped) {
                        System.out.printf("After stopping you must reset the timer\n");
                    } else {
                        timer.start();
                        System.out.printf("Timer STARTED\n");
                    }
                    break;
                case 2:
                    timer.pause();
                    System.out.printf("Timer PAUSED\n");
                    System.out.printf("%s\n", periodsToTime(seconds));
                    break;
                case 3:
                    timer.stop();
                    System.out.printf("Timer STOPPED\n");
                    System.out.printf("%s\n", periodsToTime(seconds));
                    break;
                case 4:
                    if (!isStopped) {
                        System.out.printf("Can't reset timer before it stops\n");
                    } else {
                        timer.reset();
                        System.out.printf("Timer RESET\n");
                    }
                    break;
                case 0:
                    if (!isStopped) {
                        timer.stop();
                        System.out.printf("%s\n", periodsToTime(seconds));
                    }
                    System.out.printf("\nExiting...\n");
                    break;
                default:
                    System.out.printf("Wrong choice! Try again...\n");
            }
        } while (choice != 0);

    }
}
