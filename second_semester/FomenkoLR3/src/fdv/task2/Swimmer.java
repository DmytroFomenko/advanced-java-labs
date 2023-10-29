package fdv.task2;

import java.util.Scanner;


public class Swimmer {
    private String name;
    private int timeSec;
    private int topPlace = 0;


    public Swimmer(Scanner scan) {
        System.out.print("Input name of swimmer ==> ");
        this.name = scan.nextLine();

        boolean isOK;
        do {
            System.out.print("Input swim time (sec) ==> ");
            try {
                String timeSec = scan.nextLine();
                this.timeSec = Integer.parseInt(timeSec);
                if (this.timeSec >= 65 && this.timeSec <= 150) {
                    isOK = true;
                } else {
                    isOK = false;
                    System.out.println("Swim time must be between 65-150 sec");
                }
            } catch (NumberFormatException e) {
                System.out.println("Swim time must be an integer");
                isOK = false;
            }
        } while (!isOK);
    }


    public String getName() {return name;}
    public int getTimeSec() {return timeSec;}
    public int getTopPlace() {return topPlace;}

    public void setTopPlace(int topPlace) {this.topPlace = topPlace;}




    @Override
    public String toString() {
        return getTopPlace() + ". " + getName() + " - " + getTimeSec() + " sec";
    }
}
