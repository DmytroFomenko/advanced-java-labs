package fdv.task2;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.*;

public class FileReaderFDV {

    public static String registerInverter(String word) {
        char[] letters = word.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > 'А' && letters[i] < 'я') {
                if (letters[i] > 'а' && letters[i] < 'я') {
                    letters[i] = (char) (letters[i] - ('a'-'A'));
                } else if (letters[i] > 'А' && letters[i] < 'Я') {
                    letters[i] = (char) (letters[i] + ('a'-'A'));
                }
            } else {
                if (isUpperCase(letters[i])) {
                    letters[i] = toLowerCase(letters[i]);
                } else if (isLowerCase(letters[i])) {
                    letters[i] = toUpperCase(letters[i]);
                }
            }
        }
        return new String(letters);
    }


    public static String processString(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        StringBuilder sb = new StringBuilder();

        String[] words = input.split("(?<=[^a-zA-Zа-яА-ЯєїйіЄЇЙІ])|(?=[^a-zA-Zа-яА-ЯєїйіЄЇЙІ])"); // split string to words and separators

        for (String word : words) {
            if (word.matches("[ ?!,.:\"]+")) { // current elem is separator
                sb.append(word);
            } else {
                if (word.length() > 3) {
                    word = registerInverter(word);
                }
                sb.append(word);
            }
        }
        return sb.toString();
    }


    public List<String> fileReader(Path path) throws IOException {

        List<String> lines = new ArrayList<>(Files.lines(path).toList());

        lines.replaceAll(FileReaderFDV::processString);

        return lines;
    }
}

