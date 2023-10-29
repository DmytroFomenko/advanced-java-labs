package fdv.task3;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DemoTask3FDV {
    public static void main(String[] args) throws IOException {
        String strPathToFile = "C:\\Users\\Dmytro\\Desktop\\Dima\\Deep_Java\\Second\\Lab_5\\file_task3.txt";
        String strPathToDir = "C:\\Users\\Dmytro\\Desktop\\Dima\\Deep_Java\\Second\\Lab_5\\";
        GroupResults o = new GroupResults(0, new ArrayList<>());


        GroupResults group1 = new GroupResults(1, new ArrayList<StResults>());

        group1.addStudent(new StResults("Taras", new int[]{67, 85, 94, 82, 91}, 85.49));
        group1.addStudent(new StResults("Stepan", new int[]{75, 78, 90, 83, 84}, 83.98));
        group1.addStudent(new StResults("Dmytro", new int[]{81, 86, 74, 65, 81}, 76.37));

        GroupResults group2 = new GroupResults(2, new ArrayList<>());

        group2.addStudent(new StResults("Mihailo", new int[]{84, 85, 95, 78, 82}, 88.71));
        group2.addStudent(new StResults("Andriy", new int[]{91, 62, 78, 68, 94}, 91.35));
        group2.addStudent(new StResults("Anatoliy", new int[]{64, 71, 91, 85, 76}, 82.56));
        group2.addStudent(new StResults("Semen", new int[]{85, 87, 81, 79, 87}, 86.14));
        group2.addStudent(new StResults("Nazar", new int[]{81, 97, 65, 84, 63}, 76.11));
        group2.addStudent(new StResults("Denys", new int[]{94, 87, 91, 97, 95}, 94.48));
        group2.addStudent(new StResults("Bogdan", new int[]{64, 62, 68, 64, 71}, 65.97));

        GroupResults group3 = new GroupResults(3, new ArrayList<>());

        group3.addStudent(new StResults("Kyrylo", new int[]{86, 78, 91, 85, 93}, 84.85));
        group3.addStudent(new StResults("Valeriy", new int[]{98, 85, 83, 84, 78}, 79.41));
        group3.addStudent(new StResults("Illya", new int[]{84, 98, 64, 68, 73}, 74.95));
        group3.addStudent(new StResults("Volodymyr", new int[]{78, 76, 61, 67, 82}, 73.65));
        group3.addStudent(new StResults("Oleksandr", new int[]{71, 85, 84, 76, 75}, 81.35));


        List<GroupResults> allGroupResults = new ArrayList<>();
        allGroupResults.add(group1);
        allGroupResults.add(group2);
        allGroupResults.add(group3);


        System.out.println("\nRaw data before archiving:\n");
        allGroupResults.forEach(System.out::println);

        o.mkFile(strPathToFile);
        o.writeListToFile(allGroupResults, strPathToFile);

        File f = new File(strPathToFile);
        String strPathToZip = strPathToDir + "zip_for_task3.zip";

        System.out.println();

        //If file archived successfully
        if (o.zipper(f, strPathToZip, strPathToFile)) {
            System.out.println("FILE ARCHIVED SUCCESSFULLY!!!\n");
            System.out.println("Zipped file data:\n");
            o.readFromZip(strPathToZip).forEach(System.out::println);
        } else {
            System.out.println("Error in archiving file...");
        }

    }
}
