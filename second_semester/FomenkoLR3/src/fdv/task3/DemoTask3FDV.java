package fdv.task3;


import java.util.ArrayList;
import java.util.List;

class Owner {
    private String name;
    private String carMark;
    private String num;

    public Owner(String name, String carMark, String num) {
        this.name = name;
        this.carMark = carMark;
        this.num = num;
    }

    public String getName() {return name;}
    public String getCarMark() {return carMark;}
    public String getNum() {return num;}

    @Override
    public String toString() {return name + " - " + carMark + " (" + num + ")";}
}




public class DemoTask3FDV {
    public static void main(String[] args) {
        OwnersCars own = new OwnersCars();

        List<Owner> listOwners = new ArrayList<>() {{
            add(new Owner("Dmytro", "Honda", "A470"));
            add(new Owner("Anton", "Mazda", "M285"));
            add(new Owner("Oleh", "Honda", "C843"));
            add(new Owner("Semen", "Shkoda", "L075"));
            add(new Owner("Taras", "BMW", "P582"));
            add(new Owner("Sergiy", "Shkoda", "K962"));
            add(new Owner("Kyrylo", "BMW", "M681"));
            add(new Owner("Nazar", "Honda", "D174"));
            add(new Owner("Petro", "Shkoda", "L957"));
            add(new Owner("Oleksandr", "Shkoda", "V859"));
        }};

        System.out.println("\nALL OWNERS information:");
        own.printList(listOwners);
        System.out.println();

        System.out.println("\nAll car marks without duplicates:");
        own.printMarks(listOwners);
        System.out.println();

        System.out.println("Alphabet order marks:");
        own.numOfOwnersByMarks(listOwners);
        System.out.println();

        System.out.println("Reversed order nums of owners:");
        own.numOfOwnersByNumOwners(listOwners);

    }
}


