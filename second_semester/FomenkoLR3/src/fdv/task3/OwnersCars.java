package fdv.task3;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OwnersCars {

    public void printMarks(List<Owner> list) {
        list.stream().collect(Collectors.toConcurrentMap(Owner::getCarMark, Function.identity(), (p, q) -> p))
                .values().forEach(x -> System.out.println(x.getCarMark()));
    }

    public void numOfOwnersByMarks(List<Owner> list) {
        List<String> marks = new ArrayList<>();

        // Fill list of marks without duplicates
        list.stream().collect(Collectors.toConcurrentMap(Owner::getCarMark, Function.identity(), (p, q) -> p))
                .values().forEach(x -> marks.add(x.getCarMark()));

        // Sort list of marks, find nums of owners of every mark, print all marks and nums of owners
        marks.stream().sorted().forEach(mark -> System.out.println(mark + " - " + list.stream()
                .filter(x -> x.getCarMark().equals(mark)).count()));
    }


    public void numOfOwnersByNumOwners(List<Owner> list) {
        List<String> marks = new ArrayList<>();
        HashMap<String, Integer> marksNums = new HashMap<>();

        // Fill list of marks without duplicates
        list.stream().collect(Collectors.toConcurrentMap(Owner::getCarMark, Function.identity(), (p, q) -> p))
                .values().forEach(x -> marks.add(x.getCarMark()));

        // Fill HashMap of "Mark - Num of owners"
        marks.stream().sorted().forEach(mark -> marksNums.put(mark, Integer.parseInt(String.valueOf(list.stream().filter(x -> x.getCarMark().equals(mark)).count()))));

        // Sort HashMap by value (Num of owners) in reversed order and print its
        marksNums.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(mark -> System.out.println(mark.getKey() + " - " + mark.getValue()));
    }


    public void printList(List<Owner> list) {
        for (Owner o : list) {
            System.out.println(o);
        }
    }
}


