package fdv.task1;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LatCyrFinder {

    public List<String> readFile(String strPath) {
        try {
            Path path = Paths.get(strPath);
            return Files.lines(path, StandardCharsets.UTF_8).flatMap(e -> Stream.of(e.split("[ \\n.,]+"))).toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void printList(List<String> list) {
        if (list.size() == 0) {
            System.out.println("No such elements!!!");
        } else {
            list.forEach(el -> System.out.print(el + " "));
        }
    }


    public void cyrLatFind(List<String> listElems) {
        Scanner scan = new Scanner(System.in);

        String input = null;
        while (!Objects.equals(input, "stop") && !Objects.equals(input, "Stop")) {
            System.out.print("\nInput Cyrl or Latn to find words: ");
            input = scan.nextLine();

            if (Objects.equals(input, "Cyrl") || Objects.equals(input, "cyrl")) {
                System.out.print(input + ": ");
                printList(findTypeWords(listElems, input));
            } else if ((Objects.equals(input, "Latn") || Objects.equals(input, "latn"))) {
                System.out.print(input + ": ");
                printList(findTypeWords(listElems, input));
            } else {
                if (!Objects.equals(input, "stop") && !Objects.equals(input, "Stop"))
                    System.out.print(input + ": Incorrect input!!!");
            }
        }
    }

    public static List<String> findTypeWords(List<String> listElems, String type) {
        List<String> elsDouble = new ArrayList<>();
        String regex = "";

        if (Objects.equals(type, "Cyrl") || Objects.equals(type, "cyrl")) {
            regex = "[А-Яа-яІЇЄіїє]+";
        } else if ((Objects.equals(type, "Latn") || Objects.equals(type, "latn"))) {
            regex = "[\\w]+";
        }

        String finalRegex = regex;
        Predicate<String> isCyrl = s -> s.matches(finalRegex);

        listElems.forEach(elem -> {
            if (isCyrl.test(elem))
                elsDouble.add(elem);
        });
        return elsDouble;
    }

}
