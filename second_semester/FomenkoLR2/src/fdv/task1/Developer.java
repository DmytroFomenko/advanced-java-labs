package fdv.task1;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Developer {

    private String name;
    private String language;
    private LocalDate birthday;
    private LocalDate start;
    private static final String uaLocalDatePattern = "dd.MM.yyyy";

    public Developer(String name, String language, String birthday, String start) {
        this.name = name;
        this.language = language;
        this.birthday = LocalDate.parse(birthday, DateTimeFormatter.ofPattern(uaLocalDatePattern));
        this.start = LocalDate.parse(start, DateTimeFormatter.ofPattern(uaLocalDatePattern));;
    }

    public String getName() {return name;}
    public String getLanguage() {return language;}
    public LocalDate getBirthday() {return birthday;}
    public LocalDate getStart() {return start;}

    Developer() {}

    public long getFullYear(LocalDate birthday) {
        return ChronoUnit.YEARS.between(birthday, LocalDate.now());
    }

//    public int getFullYear(LocalDate birthday) {
//        return LocalDate.now().getYear() - birthday.getYear();
//    }


    public long getYearsWork(LocalDate start) {
        return ChronoUnit.YEARS.between(start, LocalDate.now());
    }
//    public int getYearsWork(LocalDate start) {
//        return LocalDate.now().getYear() - start.getYear();
//    }


    public ArrayList<Developer> getFilteredList(ArrayList<Developer> developers, Predicate<Developer> filterRule) {
        ArrayList<Developer> filteredList = new ArrayList<>() {};

        for (Developer dev : developers) {
            if (filterRule.test(dev)) {
                filteredList.add(dev);
            }
        }
        return filteredList;
    }


    public void printList(ArrayList<Developer> list) {
        for (Developer dev : list) {
            System.out.println(dev);
        }
    }

    @Override
    public String toString() {
        return getName() + " - " + getFullYear(getBirthday()) + " years old (" + getLanguage() + ", " + getYearsWork(getStart()) + " years)";
    }
}
