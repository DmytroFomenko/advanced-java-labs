package fdv.task1;


import java.util.List;

public class DemoTask1FDV {

    public static void main(String[] args) {
        int n = 25;
        double min = 35;
        double max = 40.5;

        PatientsTemperature tmpr = new PatientsTemperature();

        List<Double> listTemperatures = tmpr.fillArr(n, min, max);
        System.out.println("List of all temperatures (35.0 <= t <= 40.5):");
        System.out.println(listTemperatures);

        System.out.println();

        List<Double> filteredTemperatures = tmpr.filterArr(listTemperatures);
        System.out.println("List of filtered temperatures (37.0 <= t <= 38.5):");
        System.out.println(filteredTemperatures);

    }
}
