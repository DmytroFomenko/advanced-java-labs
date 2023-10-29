package fomenkolr4.methods;


import java.io.FileNotFoundException;
import java.io.IOException;

public class DemoStringLR4FDV {
    public static void main(String[] args) throws IOException {


        System.out.println();
        System.out.println("\t\t\tTASK 1\n");
        System.out.println("Chars abcdEfgHабвГдеЖзщъ TO UPPER CASE:");
        System.out.println(TasksLR4FDV.upperCase(FileReader.readFile("src/fomenkolr4/files/task1_1.txt").toCharArray()));

        System.out.println();
        System.out.println("Chars ABCDeFGhАБВгДЕжЗЩЪ TO LOWER CASE:");
        System.out.println(TasksLR4FDV.lowCase(FileReader.readFile("src/fomenkolr4/files/task1_2.txt").toCharArray()));

        System.out.println();
        System.out.println("\t\t\tTASK 2\n");
        String sname = FileReader.readFile("src/fomenkolr4/files/task2_1.txt");
        System.out.println("Input:\n" + sname + "\nOutput:");
        System.out.println(TasksLR4FDV.sname(sname));
        System.out.println();
        String snameWrong = FileReader.readFile("src/fomenkolr4/files/task2_2.txt");
        System.out.println("Input:\n" + snameWrong + "\nOutput:");
        System.out.println(TasksLR4FDV.sname(snameWrong));

        System.out.println();
        String snameForeign = FileReader.readFile("src/fomenkolr4/files/task2_3.txt");
        System.out.println("Input:\n" + snameForeign + "\nOutput:");
        System.out.println(TasksLR4FDV.sname(snameForeign));


        System.out.println();
        System.out.println("\t\t\tTASK 3\n");
        System.out.println(TasksLR4FDV.checkPassword(FileReader.readFile("src/fomenkolr4/files/task3_1.txt")));
        System.out.println(TasksLR4FDV.checkPassword(FileReader.readFile("src/fomenkolr4/files/task3_2.txt")));

        System.out.println();
        System.out.println("\t\t\tTASK 4\n");
        System.out.println(TasksLR4FDV.checkLogin(FileReader.readFile("src/fomenkolr4/files/task4_1.txt")));
        System.out.println(TasksLR4FDV.checkLogin(FileReader.readFile("src/fomenkolr4/files/task4_2.txt")));

        System.out.println();
        System.out.println("\t\t\tTASK 5\n");
        System.out.println(TasksLR4FDV.checkSum(FileReader.readFile("src/fomenkolr4/files/task5_1.txt")));
        System.out.println(TasksLR4FDV.checkSum(FileReader.readFile("src/fomenkolr4/files/task5_2.txt")));


        System.out.println();
        System.out.println("\t\t\tTASK 6\n");
        System.out.println(TasksLR4FDV.checkDate(FileReader.readFile("src/fomenkolr4/files/task6_1.txt")));
        System.out.println(TasksLR4FDV.checkDate(FileReader.readFile("src/fomenkolr4/files/task6_2.txt")));

        System.out.println();
        System.out.println("\t\t\tTASK 7\n");
        System.out.println(TasksLR4FDV.checkPhoneNum (FileReader.readFile("src/fomenkolr4/files/task7_1.txt")));
        System.out.println(TasksLR4FDV.checkPhoneNum (FileReader.readFile("src/fomenkolr4/files/task7_2.txt")));

        System.out.println();
        System.out.println("\t\t\tTASK 8\n");
        System.out.println(TasksLR4FDV.checkPostNum(FileReader.readFile("src/fomenkolr4/files/task8_1.txt")));
        System.out.println(TasksLR4FDV.checkPostNum(FileReader.readFile("src/fomenkolr4/files/task8_2.txt")));
// If we want to test against all wrong datasets
//        System.out.println(TasksLR4FDV.checkPostNum("5a5!aA.5.bk"));
//        System.out.println(TasksLR4FDV.checkPostNum("a5!aA.5.ua"));
//        System.out.println(TasksLR4FDV.checkPostNum("a5_ЛЩж.5.rkp"));
//        System.out.println(TasksLR4FDV.checkPostNum("aaa_21_chars_name_aaa.str"));

        System.out.println();
        System.out.println("\t\t\tTASK 9\n");
        System.out.println(TasksLR4FDV.strCalc(FileReader.readFile("src/fomenkolr4/files/task9_1.txt")));



        String[] arr = HelpMet.readFileToArr("src/fomenkolr4/files/task10_1.txt");

        System.out.println();
        System.out.println("\t\t\tTASK 10\n");
        System.out.println(TasksLR4FDV.groupByDomainUsers(arr));

    }
}
