package fdv.task5;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.TreeSet;

import static java.nio.file.Files.exists;
import static java.nio.file.Files.isRegularFile;

public class FlatProc {

    public TreeSet<Flat> readFromFile(String strPath) throws IOException {
        Path path = Paths.get(strPath);
        TreeSet<Flat> flatSet = new TreeSet<>();
        int[] square = {0};
        int[] roomCount = {0};
        int[] floor = {0};

        Files.lines(path).forEach(line -> {
            int[] flat = Arrays.stream(line.split(" ")).mapToInt(Integer::valueOf).toArray();
            square[0] = flat[0];
            roomCount[0] = flat[1];
            floor[0] = flat[2];
            flatSet.add(new Flat(square[0], roomCount[0], floor[0]));
        });
        return flatSet;
    }


    public void mkDir(String strPath) throws IOException {
        Path path = Path.of(strPath);

        if (!exists(path)) {
            Files.createDirectory(path);
            System.out.println("Directory " + path.getFileName() + " created!!!");
        } else {
            System.out.println("Directory already exists!!!");
        }
    }

    public void mkFile(String strPath) throws IOException {
        File f = new File(strPath);

        if (f.createNewFile())
            System.out.println("File " + f.getName() + " created!!!");
        else
            System.out.println("File already exists!!!");
    }


    public boolean writeToFile1And2Flats(TreeSet<Flat> flatSet, String strPath) throws IOException {
        Path path = Path.of(strPath);
        File file = new File(strPath);

        if (exists(path) && isRegularFile(path)) {
            FileWriter writer;
            writer = new FileWriter(file);

            for (Flat flat : flatSet) {
                if (flat.getRoomCount() == 1 || flat.getRoomCount() == 2)
                    writer.write(flat + "\n");
            }
            writer.close();
            return true;
        } else {
            return false;
        }
    }

    public boolean writeToFile3Flats(TreeSet<Flat> flatSet, String strPath) throws IOException {
        Path path = Path.of(strPath);
        File file = new File(strPath);

        if (exists(path) && isRegularFile(path)) {
            FileWriter writer;
            writer = new FileWriter(file);

            for (Flat flat : flatSet) {
                if (flat.getRoomCount() == 3)
                    writer.write(flat + "\n");
            }
            writer.close();
            return true;
        } else {
            return false;
        }
    }


}
