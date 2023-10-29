package workwithset;



public class Lab2Task1Demo1Fomenko {
    public static void demo1() {
        System.out.println("\n        ===[ DEMONSTRATION 1 ]===\n");

        SalaryList employee = new SalaryList();

        System.out.println("Created empty collection:");
        System.out.println(employee);
        System.out.println("Collection is empty: " + employee.isEmpty());
        System.out.println("Size of collection = " + employee.size());

        System.out.println("\n\nCollection with 5 added elements of derived class 1:");
        employee.setFiveElemDeriv1();
        System.out.println(employee);
        System.out.println();
        System.out.println("Collection is empty: " + employee.isEmpty());
        System.out.println("Size of collection = " + employee.size());

        System.out.println("\n\nCollection with removed Dmytro Kovalenko and Kyrylo Shatov from derived class 1:");
        employee.remove(new Office("Dmytro", "Kovalenko", "Epam", "Junior", 25000));
        employee.remove(new Office("Kyrylo", "Shatov", "Sigma", "Senior", 25000));
        System.out.println(employee);
        System.out.println();
        System.out.println("Collection is empty: " + employee.isEmpty());
        System.out.println("Size of collection = " + employee.size());

        System.out.println("\n\nCollection with changed surnames Rudenko to Alamovskiy and Krotenko to Bratenko from derived class 1:");
        employee.firstItemBySname("Rudenko").setSname("Alamovskiy");
        employee.firstItemBySname("Krotenko").setSname("Bratenko");
        employee.resort();
        System.out.println(employee);
        System.out.println();
        System.out.println("Collection is empty: " + employee.isEmpty());
        System.out.println("Size of collection = " + employee.size());

        //=================================================================

        System.out.println("\n\nCollection with 5 added elements of derived class 2:");
        employee.setFiveElemDeriv2();
        System.out.println(employee);
        System.out.println();
        System.out.println("Collection is empty: " + employee.isEmpty());
        System.out.println("Size of collection = " + employee.size());

        System.out.println("\n\nCollection with removed Taras Didenko and Semen Gorbenko from derived class 2:");
        employee.remove(new Developer("Taras", "Didenko", "Epam", "Junior", 250, 5400));
        employee.remove(new Developer("Semen", "Gorbenko", "Sigma", "Middle", 150, 3200));
        System.out.println(employee);
        System.out.println();
        System.out.println("Collection is empty: " + employee.isEmpty());
        System.out.println("Size of collection = " + employee.size());

        System.out.println("\n\nCollection with changed surnames Bobrenko to Salomonenko and Ulianenko to Antonenko from derived class 2:");
        employee.firstItemBySname("Bobrenko").setSname("Salomonenko");
        employee.firstItemBySname("Ulianenko").setSname("Antonenko");
        employee.resort();
        System.out.println(employee);
        System.out.println();
        System.out.println("Collection is empty: " + employee.isEmpty());
        System.out.println("Size of collection = " + employee.size());

        System.out.println("\n\nClearing the collection...");
        employee.clear();
        System.out.println(employee);
        System.out.println("Collection is empty: " + employee.isEmpty());
        System.out.println("Size of collection = " + employee.size());
    }
}
