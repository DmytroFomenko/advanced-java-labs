package fdv.task2;


import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class DemoTask2FDV {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("c:\\Users\\Dmytro\\Desktop\\Dima\\Deep_Java\\Second\\Lab_4\\file_task2.txt");
        FileReaderFDV f = new FileReaderFDV();

        List<String> processedFileText = f.fileReader(path);

        processedFileText.forEach(System.out::println);
    }
}
