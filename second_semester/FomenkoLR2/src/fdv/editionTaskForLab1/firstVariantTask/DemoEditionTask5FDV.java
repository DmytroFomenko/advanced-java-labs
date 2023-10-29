package fdv.editionTaskForLab1.firstVariantTask;


import java.util.ArrayList;

import static fdv.editionTaskForLab1.firstVariantTask.ArraySorterFDV.sortType1;
import static fdv.editionTaskForLab1.firstVariantTask.ArraySorterFDV.sortType2;

public class DemoEditionTask5FDV {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>() {{
            add("able");
            add("Add");
            add("База");
            add("вал");
            add("but");
            add("dask");
            add("Buss");
            add("бур");
            add("car");
            add("Амёба");
            add("Call");
            add("Воск");
            add("Door");
            add("авто");
        }};


        System.out.println("\nList:\n" + list);
        System.out.println();

        System.out.println("Sorted list by [АаБбВбГг..ЯяAaBbCc..Zz]:\n" + sortType1(list));
        System.out.println();

        System.out.println("Sorted list by [AaBbCc..ZzАаБбВбГг..Яя]:\n" + sortType2(list));
        System.out.println();
    }
}
