package workwithset;


public class Lab2Task1Demo2Fomenko {
    public static void demo2() {
        System.out.println("\n\n        ===[ DEMONSTRATION 2 ]===\n");

        System.out.println("Created collection with test data sorted by sname A-Z:");
        SalaryList employees = new SalaryList(true/*, c1*/);
        System.out.println(employees);


        System.out.println();
        System.out.println("Collection is empty: " + employees.isEmpty());
        System.out.println("Size of collection = " + employees.size());
        System.out.println();
        System.out.println();


        System.out.println("Collection sorted by position Z-A, sname A-Z, fname A-Z:");
        employees = new SalaryList(true, new ComparatorHarder());
        System.out.println(employees);
        System.out.println();
        System.out.println("Collection is empty: " + employees.isEmpty());
        System.out.println("Size of collection = " + employees.size());
    }
}
