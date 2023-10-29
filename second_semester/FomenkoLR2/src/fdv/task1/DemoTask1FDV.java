package fdv.task1;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;


public class DemoTask1FDV {

    private static final ArrayList<Developer> listDev = new ArrayList<>() {{
        add(new Developer("Dmytro", "Java", "09.12.2005", "01.06.2022"));
        add(new Developer("Stepan", "Python", "17.05.1999", "03.08.2021"));
        add(new Developer("Taras", "Java", "03.08.2003", "25.11.2022"));
        add(new Developer("Kyrylo", "C", "01.11.1950", "02.03.1970"));
        add(new Developer("Andriy", "Kotlin", "01.06.1993", "19.05.2017"));
        add(new Developer("Eduard", "Java", "12.10.1995", "21.02.2019"));
        add(new Developer("Volodymyr", "Kotlin", "03.04.1980", "15.12.2021"));
        add(new Developer("Vladislav", "Java", "16.05.1989", "11.09.2016"));
    }};


    public static void main(String[] args) {
        Predicate<Developer> isJava = (dev) -> dev.getLanguage().equals("Java");
        Predicate<Developer> ageRange27And37 = (dev) -> dev.getFullYear(dev.getBirthday()) >= 27 && dev.getFullYear(dev.getBirthday()) <= 37;
        Predicate<Developer> workOver3Years = (dev) -> dev.getYearsWork(dev.getStart()) >= 3;

        Developer dev = new Developer();

        System.out.println("All developers:");
        dev.printList(listDev);
        System.out.println();

        System.out.println("Java developers:");
        dev.printList(dev.getFilteredList(listDev, isJava));
        System.out.println();

        System.out.println("Developers with age in range 27 and 37 years:");
        dev.printList(dev.getFilteredList(listDev, ageRange27And37));
        System.out.println();

        System.out.println("Developers with 3 or more years of experience:");
        dev.printList(dev.getFilteredList(listDev, workOver3Years));
        System.out.println();

    }
}
