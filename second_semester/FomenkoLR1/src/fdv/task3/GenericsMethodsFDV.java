package fdv.task3;


import java.util.Arrays;
import java.util.Random;

/**
 * Class for <b>laboratory work 1 task 3</b>
 * @author <u>Dmytro Fomenko</u>
 */
public class GenericsMethodsFDV {
    int num = 5;
    String[] names;
    Integer[] heights;
    Double[] weights;

    /**
     * Class constructor that generates arrays of names, heights and weights of default lengths
     */
    GenericsMethodsFDV() {
        this.names = new String[num];
        this.heights = new Integer[num];
        this.weights = new Double[num];

        int i = 0;
        for (String ignored : names) {
            names[i] = randomName();
            i++;
        }
        i = 0;
        for (Integer ignored : heights) {
            heights[i] = randomHeight();
            i++;
        }
        i = 0;
        for (Double ignored : weights) {
            weights[i] = randomWeight();
            i++;
        }
    }

    /**
     * Class constructor that generates arrays of names, heights and weights of specified lengths
     */
    GenericsMethodsFDV(int num) {
        this.num = num;
        this.names = new String[num];
        this.heights = new Integer[num];
        this.weights = new Double[num];

        int i = 0;
        for (String ignored : names) {
            names[i] = randomName();
            i++;
        }
        i = 0;
        for (Integer ignored : heights) {
            heights[i] = randomHeight();
            i++;
        }
        i = 0;
        for (Double ignored : weights) {
            weights[i] = randomWeight();
            i++;
        }
    }

    /**
     * Forms string of array elements of generic type
     * @param items Array of generic type
     * @return String of array elements
     * @param <T> Generic type
     */
    public <T> String printArr(T[] items) {
        StringBuilder s = new StringBuilder();
        for (T item : items) {
            //System.out.print(item + " ");
            s.append(item).append(" ");
        }
        //System.out.println();
        return s.toString();
    }


//    public <T> Double averageOfArr(T[] items) {
//        if ((items[0] instanceof Integer) || (items[0] instanceof Double)) {
//            double sum = 0;
//
//            if (items[0] instanceof Integer) {
//                for (Integer item : (Integer[]) items) {
//                    sum += item;
//                }
//            } else {
//                for (Double item : (Double[]) items) {
//                    sum += item;
//                }
//            }
//            return sum / items.length;
//        }
//        System.out.println("Cannot calculate not digital types: " + items.getClass());
//        return null;
//    }


    /**
     * Finds the average of generic array elements
     * @param arr Array of generic type
     * @return Average of generic array elements
     * @param <T> Generic type
     */
    private <T extends Number> Double averageOfArr(T[] arr) {
        double sum = 0;
        for (Number number:arr) {
            sum+=number.doubleValue();
        }
        return sum/arr.length;
    }


//    public <T extends Number> Double averageOfArr(T[] items) {
//        double sum = 0;
//        for (T item : (T[]) items) {
//            sum += item;
//        }
//        return sum / items.length;
//    }


    /**
     * Generates random name of 3 capital letters and 3 digits (like AAA777)
     * @return Generated random name of 3 capital letters and 3 digits
     */
    private String randomName() {
        int length = 3;
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "1234567890";
        StringBuilder randomName = new StringBuilder();
        Random random = new Random();
        randomName.setLength(0);
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(26);
            randomName.append(letters.charAt(number));
        }
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(10);
            randomName.append(numbers.charAt(number));
        }
        return randomName.toString();
    }

    /**
     * Generates random integer in range 145 and 215
     * @return Generated random integer in range 145 and 215
     */
    private Integer randomHeight() {
        int min = 145;
        int max = 215;
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }

    /**
     * Generates random double in range 40 and 120
     * @return Generated random double in range 40 and 120
     */
    private Double randomWeight() {
        double min = 40;
        double max = 120;
        double range = max - min + 1;
        double num = (Math.random() * range) + min;
        return (double) Math.round(num * 10) / 10;
    }

    @Override
    public String toString() {
        return "\nInstance of GenericMethods include " +
                "num = " + num +
                "\nNames: " + printArr(names) +
                "\nHeights: " + printArr(heights) +
                "\nAVG height: " + averageOfArr(heights) +
                "\nWeights: " + printArr(weights) +
                "\nAVG weight: " + averageOfArr(weights)
                ;
    }
}
