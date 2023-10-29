package workwithset;

// Класс наследник 1
public class Office extends ITEmpl {
    private double salary;

    public Office(String fname, String sname, String dep, String position, double salary) {
        super(fname, sname, dep, position);
        this.salary = salary;
    }

    public double getSalary() {return salary;}

    public int setSalary(double salary) {
        this.salary = salary;
        return 0;
    }


    public String toString() {return super.toString() + ", salary: " + salary;}


}
