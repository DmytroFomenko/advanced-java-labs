package fdv.task4;


import java.util.List;

public class DemoTask4FDV {
    public static void main(String[] args) {
        TypeFinder t = new TypeFinder();
        String strPath = "c:\\Users\\Dmytro\\Desktop\\Dima\\Deep_Java\\Second\\Lab_4\\file_task4.txt";

        List<String> listElems = t.readArrElemsFromFile(strPath);

        t.typeFind(listElems);
    }
}
