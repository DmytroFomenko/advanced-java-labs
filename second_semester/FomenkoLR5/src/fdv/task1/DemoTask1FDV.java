package fdv.task1;


import java.util.List;

public class DemoTask1FDV {
    public static void main(String[] args) {
        LatCyrFinder f = new LatCyrFinder();
        String strPath = "C:\\Users\\Dmytro\\Desktop\\Dima\\Deep_Java\\Second\\Lab_5\\file_task1.txt";

        List<String> listElems = f.readFile(strPath);
        f.cyrLatFind(listElems);
    }
}
