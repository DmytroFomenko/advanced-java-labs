package workwithset;


import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class SalaryList extends TreeSet<ITEmpl> {


    public void FillTestData() {
        this.add(new Office("Bogdan", "Shevchenko", "Epam", "Junior", 20000));
        this.add(new Office("Pavlo", "Uhanenko", "NIX", "Senior", 90000));
        this.add(new Office("Andriy", "Tkachenko", "Sigma", "Middle", 60000));
        this.add(new Office("Mykhaylo", "Shpak", "NIX", "Senior", 30000));
        this.add(new Office("Bogdan", "Melnyk", "Epam", "Senior", 90000));
        this.add(new Developer("Vladislav", "Kanonenko", "NIX", "Middle", 100, 1000));
        this.add(new Developer("Andriy", "Sherbak", "Epam", "Senior", 150, 2000d));
        this.add(new Developer("Vasyl", "Honcharenko", "Sigma", "Junior", 250, 500));
        this.add(new Developer("Pavlo", "Antonenko", "Epam", "Senior", 150, 2000));
        this.add(new Developer("Anton", "Shevchuk", "NIX", "Middle", 170, 1000));
    }

    public SalaryList() {
        super();
    }

    public SalaryList(boolean fill) {
        super();
        if (fill) {
            FillTestData();
        }
    }
    public SalaryList(boolean fill, Comparator<ITEmpl> c) {
        super(c);
        if (fill) {
            FillTestData();
        }
    }


    public void setFiveElemDeriv1() {
        this.add(new Office("Igor", "Stratienko", "NIX", "Junior", 15000));
        this.add(new Office("Dmytro", "Kovalenko", "Epam", "Junior", 25000));
        this.add(new Office("Mykyta", "Rudenko", "Sigma", "Middle", 15000));
        this.add(new Office("Kyrylo", "Shatov", "Sigma", "Senior", 25000));
        this.add(new Office("Dmytro", "Krotenko", "Epam", "Senior", 30000));
    }

    public void setFiveElemDeriv2() {
        this.add(new Developer("Pavlo", "Ulianenko", "NIX", "Junior", 150, 1200));
        this.add(new Developer("Taras", "Didenko", "Epam", "Junior", 250, 5400));
        this.add(new Developer("Semen", "Gorbenko", "Sigma", "Middle", 150, 3200));
        this.add(new Developer("Oleg", "Minchenko", "Sigma", "Senior", 290, 1200));
        this.add(new Developer("Taras", "Bobrenko", "Epam", "Senior", 30, 4300));
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ITEmpl h : this) {
            sb.append(System.lineSeparator()).append(h);
        }
        return sb.toString();
    }


    public ITEmpl firstItemBySname(String sname) {
        Iterator<ITEmpl> i = this.iterator();

        while (i.hasNext()) {
            ITEmpl item = i.next();
            if (item.getSname().equals(sname)) {
                return item;
            }
        }
        throw new NoSuchElementException("No element with sname = " + sname);
    }


    public boolean resort() {
        TreeSet<ITEmpl> buf = (TreeSet<ITEmpl>) this.clone();
        this.clear();
        for (ITEmpl i : buf) {
            this.add(i);
        }
        return true;
    }

}
