package fdv.task4;


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




public class DemoTask4FDV {
    public static void main(String[] args) {
        OwnersCarsNums own = new OwnersCarsNums();

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


        System.out.println();
        System.out.println("Search by name 'Dmytro':");
        own.printInfoByName(listOwners, "Dmytro");
        System.out.println();

        System.out.println("Search by name 'Ruslan':");
        own.printInfoByName(listOwners, "Ruslan");
        System.out.println();
        System.out.println();

        System.out.println("Search by number 'D174':");
        own.printInfoByNum(listOwners, "D174");
        System.out.println();

        System.out.println("Search by number 'L689':");
        own.printInfoByNum(listOwners, "L689");
        System.out.println();

    }
}


