package workwithset;


// Класс наследник 2
public class Developer extends ITEmpl {
    private double salHour;
    private double bonusPr;

    public Developer(String fname, String sname, String dep, String position, double salHour, double bonusPr) {
        super(fname, sname, dep, position);
        this.salHour = salHour;
        this.bonusPr = bonusPr;
    }

    public double getSalHour() {return salHour;}

    public double getBonusPr() {return bonusPr;}

    public int setSalHour(double salHour) {
        this.salHour = salHour;
        return 0;
    }

    public int setBonusPr(double bonusPr) {
        this.bonusPr = bonusPr;
        return 0;
    }


    public String toString() { return super.toString() + ", salary p/h: " + salHour + ", bonus price: " + bonusPr; }



}
