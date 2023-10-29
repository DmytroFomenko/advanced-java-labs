package fdv.task4;


import java.util.List;

public class OwnersCarsNums {

    public void printInfoByName(List<Owner> list, String name) {
        if (list.stream().noneMatch(owner -> owner.getName().equals(name))) {
            System.out.println("Employee not found");
        } else {
            list.stream().filter(owner -> owner.getName().equals(name)).forEach(System.out::println);
        }
    }


    public void printInfoByNum(List<Owner> list, String num) {
        if (list.stream().noneMatch(owner -> owner.getNum().equals(num))) {
            System.out.println("Number not found");
            throw new IllegalArgumentException();
        } else {
            list.stream().filter(owner -> owner.getNum().equals(num)).forEach(System.out::println);
        }
    }
}
