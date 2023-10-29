package fdv.task3;


import java.util.Random;


public class RandomPoisson {

    public static int getPoissonRandom(double mean) {
        final int divider = 10;
        Random random = new Random();
        double mean_ = mean / divider;
        double L = Math.exp(-mean_);
        int k = 0;
        double p = 1.0;

        do {
            p = p * random.nextDouble();
            k++;
        } while (p > L);
        return ((k - 1) * divider);
    }
}
