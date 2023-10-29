package fomenkolr4.methods;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class HelpMet {
    public static char upperCaseOneSymb(char setLetter) {

        if (setLetter > 96 && setLetter < 123) {
            setLetter -= 32;
        }
        if ((setLetter > 1071 && setLetter < 1102)) {
            setLetter -= 32;
        }
        return setLetter;
    }

    public static String toStringHashMap(HashMap<String, ArrayList<String>> hm) {
        StringBuilder sb = new StringBuilder();
        hm.forEach((key, value) -> {
                       sb.append(key).append(" ==> ");
                       value.forEach((s -> sb.append(s).append(", ")));
                       sb.setLength(sb.length() - 2);
                       sb.append("\n");
                   }
        );
        return sb.toString();
    }

//    public static String[] readFileToArr (String path) throws FileNotFoundException {
//        Scanner sc = new Scanner(new File(path));
//        List<String> lines = new ArrayList<>();
//        while (sc.hasNextLine()) {
//            lines.add(sc.nextLine());
//        }
//        String[] arr = lines.toArray(new String[0]);
//
//        return arr;
//    }

    public static String[] readFileToArr(String strPath) throws IOException {
        return Files.readAllLines(Paths.get(strPath), StandardCharsets.UTF_8).toArray(new String[0]);
    }
}
