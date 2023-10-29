package fdv.task1;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PatientsTemperature {

    public List<Double> fillArr(int n, double min, double max) {
        return Stream.generate(() -> {
                    double range = max - min;
                    double num = (Math.random() * range) + min;
                    return (double) Math.round(num * 10) / 10;}).limit(n).toList();
    }


    public List<Double> filterArr(List<Double> list) {
        return list.stream().filter(t -> t >= 37.0).filter(t -> t <= 38.5).toList();
    }
}
