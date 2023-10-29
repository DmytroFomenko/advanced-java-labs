package fdv.task1;


import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.nio.file.attribute.*;
import java.time.format.DateTimeFormatter;
import static java.nio.file.Files.*;
import static java.util.TimeZone.getDefault;

public class PathsChecker {

    public void pathProcessing(String strPath) throws IOException {
        Path path = Path.of(strPath);
        File file = new File(strPath);

        if (!exists(path)) {
            System.out.println("The object at the specified path does not exist!");
        } else if (isDirectory(path)) {
            System.out.println("[" + path.getFileName() + "] IS THE DIRECTORY !!!");
            System.out.println("The contents of the directory " + path.getFileName() + ":");
            try (DirectoryStream<Path> stream = newDirectoryStream(path)) {
                stream.forEach(System.out::println);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (isRegularFile(path)) {
            System.out.println("[" + file.getName() + "] IS THE FILE !!!");

            DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            BasicFileAttributes attr = readAttributes(path, BasicFileAttributes.class);

            System.out.println("Absolute path: " + file.getAbsolutePath());

            System.out.println("File name: " + file.getName());

            System.out.println("Creation time: " + attr.creationTime().toInstant().atZone(getDefault().toZoneId()).format(timeFormat));
            System.out.println("Last modified time: " + attr.lastModifiedTime().toInstant().atZone(getDefault().toZoneId()).format(timeFormat));
            System.out.println("Last access time: " + attr.lastAccessTime().toInstant().atZone(getDefault().toZoneId()).format(timeFormat));

            System.out.println("File size: " + attr.size() + " bytes");

            System.out.println("Is symbolic link: " + attr.isSymbolicLink());
            System.out.println("File key: " + attr.fileKey());
            System.out.println("Is other: " + attr.isOther());
        }
    }
}
