package fdv.task4;


public class DemoTask4FDV {
    public static void main(String[] args) {
        System.out.println("Correct arguments (-w 25):");
        ImplementationTernary.main(new String[]{"-w", "25"});
        System.out.println("INcorrect arguments (-h 77):");
        ImplementationTernary.main(new String[]{"-h", "77"});
        System.out.println("No arguments:");
        ImplementationTernary.main(new String[]{});
    }
}
