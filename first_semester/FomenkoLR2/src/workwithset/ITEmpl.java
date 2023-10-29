package workwithset;


// Базовый класс
public abstract class ITEmpl implements Comparable<ITEmpl> {

    private String fname;
    private String sname;
    private String dep;
    private String position;

    public ITEmpl(String fname, String sname, String dep, String position) {
        this.fname = fname;
        this.sname = sname;
        this.dep = dep;
        this.position = position;
    }


    public String getFname() {return fname;}

    public String getSname() {return sname;}

    public String getDep() {return dep;}

    public String getPosition() {return position;}


    public int setFname(String fname) {
        this.fname = fname;
        return 0;
    }

    public int setSname(String sname) {
        this.sname = sname;
        return 0;
    }

    public int setDep(String dep) {
        this.dep = dep;
        return 0;
    }

    public int setPosition(String position) {
        this.position = position;
        return 0;
    }

    @Override
    public String toString() {
        return fname + " " + sname + ", department: " + dep + ", position: " + position;
    }


    public int compareTo(ITEmpl o) {
        //To compare are: this vs o
        return this.sname.compareTo(o.sname);
    }
}

