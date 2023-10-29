package fdv.task4;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class TypeFinder {

    public List<String> readArrElemsFromFile(String strPath) {
        try {
            Path path = Paths.get(strPath);
            return Files.lines(path, StandardCharsets.UTF_8).flatMap(e -> Stream.of(e.split("[ \\n]"))).toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void printList(List<String> list) {
        if (list.size() == 0) {
            System.out.println("No such elements!!!");
        } else {
            list.forEach(el -> System.out.print(el + " "));
        }
    }

    public void typeFind(List<String> listElems) {
        Scanner scan = new Scanner(System.in);

        String input = null;
        while (!Objects.equals(input, "stop")) {
            System.out.print("\nInput type to find elements: ");
            input = scan.nextLine();

            switch (input) {
                case "double":
                    printList(findDouble(listElems));
                    break;
                case "int":
                    printList(findInt(listElems));
                    break;
                case "String":
                    printList(findString(listElems));
                    break;
                case "char":
                    printList(findChars(listElems));
                    break;
                default:
                    if (!input.equals("stop"))
                        System.out.println("Incorrect input!!!");
            }
        }
    }

    public static List<String> findDouble(List<String> listElems) {
        List<String> elsDouble = new ArrayList<>();

        listElems.forEach(elem -> {
            if (elem.matches("[\\d]+\\.[\\d]+")) {
                elsDouble.add(elem);
            }
        });
        return elsDouble;
    }

    public static List<String> findInt(List<String> listElems) {
        List<String> elsInt = new ArrayList<>();

        listElems.forEach(elem -> {
            if (elem.matches("\\d+")) {
                elsInt.add(elem);
            }
        });
        return elsInt;
    }

    public static List<String> findString(List<String> listElems) {
        List<String> elsString = new ArrayList<>();

        listElems.forEach(elem -> {
            if (elem.matches("[A-Za-zА-Яа-яЄєЇїІі]{2,}")) {
                elsString.add(elem);
            }
        });
        return elsString;
    }

    public static List<String> findChars(List<String> listElems) {
        List<String> elsChar = new ArrayList<>();

        listElems.forEach(elem -> {
            if (elem.matches("[A-Za-zА-Яа-яЄєЇїІі]")) {
                elsChar.add(elem);
            }
        });
        return elsChar;
    }

}
