package fdv.task2;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;


public class DemoTask2FDV {
    public static void main(String[] args) throws IOException, InterruptedException {
        Thread[] threads = new Thread[10];
        ThreadsWriter f = new ThreadsWriter(new Object(), threads);
        String strPath = "C:\\Users\\Dmytro\\Desktop\\Dima\\Deep_Java\\Second\\Lab_5\\file_task2.txt";
        Scanner scan = new Scanner(System.in);

        f.mkFile(strPath);

        RandomAccessFile raf = new RandomAccessFile(strPath, "rw");

        // Fill the file by threads
        f.fillFile(raf);

        System.out.println("Content of file written by threads:");
        f.printList(f.readFromFile(strPath));

        System.out.print("\nEnter the line number to be replaced with characters (1-10): ");
        int numLine = scan.nextInt();
        System.out.print("Enter the symbol that will change the line: ");
        String symbol = scan.next();

        // Write symbols instead of chosen line
        f.writeSymbols(raf, numLine, symbol);

        System.out.println("\nContent of file after changing the line:");
        f.printList(f.readFromFile(strPath));

        raf.close();
    }
}
