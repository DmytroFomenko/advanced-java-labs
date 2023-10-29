package fdv.task3;


import java.util.Arrays;

public class StResults {
    private String name;
    private int[] marks;
    private double ratingMark;

    public StResults(String name, int[] marks, double ratingMark) {
        this.name = name;
        this.marks = marks;
        this.ratingMark = ratingMark;
    }



    public static String intArrToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach(x -> sb.append(x).append(" "));
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n"
                + "Exams marks: " + intArrToString(marks) + "\n"
                + "Rating mark: " + ratingMark + "\n";
    }
}
