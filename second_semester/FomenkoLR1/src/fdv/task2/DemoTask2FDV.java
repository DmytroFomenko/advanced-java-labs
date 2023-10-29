package fdv.task2;

/**
 * Demo class for <b>laboratory work 1 task 2</b>
 * @author <u>Dmytro Fomenko</u>
 */
public class DemoTask2FDV {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("===== [Integer] =====");
        GenProcessingArrFDV<Integer> arrInt = new GenProcessingArrFDV(new Integer[]{9, 5, 15, 8, 49, 12});
        arrInt.printType();
        arrInt.printArr();
        System.out.println("Min: " + arrInt.min());
        System.out.println("Max: " + arrInt.max());
        System.out.println("First: " + arrInt.firstElem());
        System.out.println("Last: " + arrInt.lastElem());
        System.out.println("Sorted array in column: ");
        arrInt.sortArr();
        arrInt.printArrInCol();

        System.out.println();

        System.out.println("===== [String] =====");
        GenProcessingArrFDV<String> arrStr = new GenProcessingArrFDV(new String[]{"FFF", "AAA", "CCC", "DDD", "BBB"});
        arrStr.printType();
        arrStr.printArr();
        System.out.println("Min: " + arrStr.min());
        System.out.println("Max: " + arrStr.max());
        System.out.println("First: " + arrStr.firstElem());
        System.out.println("Last: " + arrStr.lastElem());
        System.out.println("Sorted array in column: ");
        arrStr.sortArr();
        arrStr.printArrInCol();

        System.out.println();

        System.out.println("===== [User] =====");
        GenProcessingArrFDV<User> arrUser = new GenProcessingArrFDV<>(new User[]{
                new User("AAA", 25)
                ,  new User("ZZZ", 27)
                ,  new User("SSS", 27)
                ,  new User("CCC", 25)
                ,  new User("FFF", 27)
        });
        arrUser.printType();
        arrUser.printArr();
        System.out.println("Min: " + arrUser.min());
        System.out.println("Max: " + arrUser.max());
        System.out.println("First: " + arrUser.firstElem());
        System.out.println("Last: " + arrUser.lastElem());
        arrUser.sortArr();
        System.out.println("Sorted array (age 9-1 | name a-z) in column: ");
        arrUser.printArrInCol();

    }
}
