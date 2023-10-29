package workwithset;


import java.util.Comparator;

public class ComparatorHarder implements Comparator<ITEmpl> {

//    position – Z-A
//    sname – A->Z
//    fname – A->Z
    public int compare(ITEmpl o1, ITEmpl o2) {
        int rez;

        rez = o2.getPosition().compareTo(o1.getPosition());
        if (rez == 0) {
            rez = o1.getSname().compareTo(o2.getSname());
        }
        if (rez == 0) {
            rez = o1.getFname().compareTo(o2.getFname());
        }
        return rez;
    }
}
