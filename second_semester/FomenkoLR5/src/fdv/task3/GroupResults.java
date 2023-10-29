package fdv.task3;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import static java.nio.file.Files.exists;
import static java.nio.file.Files.isRegularFile;

public class GroupResults {
    private int groupCode;
    private List<StResults> studentsResults;


    public GroupResults(int groupCode, List<StResults> studentsResults) {
        this.groupCode = groupCode;
        this.studentsResults = studentsResults;
    }

    public void addStudent(StResults stud) {
        this.studentsResults.add(stud);
    }


    public void mkFile(String strPath) throws IOException {
        File f = new File(strPath);
        Files.deleteIfExists(Path.of(strPath));
        f.createNewFile();
    }


    public void writeListToFile(List<GroupResults> list, String strPath) throws IOException {
        Path path = Path.of(strPath);

        if (exists(path) && isRegularFile(path)) {
            FileWriter writer;
            writer = new FileWriter(strPath);

            writer.write(listGroupsToString(list));
            writer.close();
        }
    }


    public boolean zipper(File f, String strPathToArch, String strPathToFile) {
        try(ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(strPathToArch))) {
            zip.putNextEntry(new ZipEntry(f.getName()));

            File file = new File(strPathToFile);
            Files.copy(file.toPath(), zip);
            zip.close();
            Files.deleteIfExists(Path.of(strPathToFile));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public List<String> readFromZip(String strPathToArchive) {
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream(strPathToArchive))) {
            List<String> list = new ArrayList<>();

            zip.getNextEntry();
            Scanner in = new Scanner(zip, StandardCharsets.UTF_8);
            while (in.hasNextLine()) {
                list.add(in.nextLine());
            }
            zip.closeEntry();
            zip.close();
            return list;
        } catch (Exception ex) {}
        return null;
    }


    public static String listStudToString(List<StResults> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        return sb.toString();
    }

    public static String listGroupsToString(List<GroupResults> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach(el -> sb.append(el).append("\n"));
        return sb.toString();
    }

    @Override
    public String toString() {
        return "GROUP CODE: " + groupCode + "\n"
                + "Students:" + "\n"
                + listStudToString(studentsResults);
    }
}
