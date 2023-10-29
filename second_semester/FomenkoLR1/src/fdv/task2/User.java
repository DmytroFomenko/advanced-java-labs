package fdv.task2;


/**
 * Class for <b>laboratory work 1 task 2</b>
 * Implements interface Comparable
 * @author <u>Dmytro Fomenko</u>
 */
public class User implements Comparable<User> {

    private String name;
    private Integer age;

    /**
     * Constructor for User class
     * @param name Name of the user
     * @param age Age of the user
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {return name;}
    public int getAge() {return age;}

    /**
     * Compares objects to sort an array
     * @param o The object to be compared.
     * @return Returns a negative integer, zero, or a positive integer
     * as this object is less than, equal to, or greater than the specified object
     */
    @Override
    public int compareTo(User o) {
        int res;

        if ((res = -this.age.compareTo(o.getAge())) == 0) {
            res = this.name.compareTo(o.getName());
        }
        return res;
    }

    /**
     * Forms a string in such a form as needed
     * @return Returns a string in such a form as needed
     */
    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
