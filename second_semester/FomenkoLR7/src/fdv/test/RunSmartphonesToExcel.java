package fdv.test;


import fdv.entities.Smartphone;
import fdv.entities.SmartphoneClasses;
import fdv.services.SmartphoneClassTypes;
import java.util.ArrayList;
import static fdv.services.CreateExcel.writeSmartListIntoExcel;



public class RunSmartphonesToExcel {

    public static void main(String[] args) {
        //System.out.println("list of smartphones to Excel....");

        // Smartphones List
        Smartphone XiaomiPocoF3 = new Smartphone("Xiaomi", "Poco F3", 76, 435);
        Smartphone Xiaomi11Ultra = new Smartphone("Xiaomi", "11 Ultra", 85, 950);
        Smartphone OnePlus10Pro = new Smartphone("OnePlus", "10 Pro", 91, 700);
        Smartphone OnePlus9Pro = new Smartphone("OnePlus", "9 Pro", 85, 680);
        Smartphone OnePlusAce = new Smartphone("OnePlus", "Ace", 83, 600);
        Smartphone XiaomiRedmiNote5 = new Smartphone("Xiaomi", "Redmi Note 5", 22, 135);
        Smartphone RealmeGTNeo3 = new Smartphone("Realme", "GT Neo 3", 83, 600);
        Smartphone RealmeC11 = new Smartphone("Realme", "C11", 15, 110);
        Smartphone GooglePixel6Pro = new Smartphone("Google Pixel", "6 Pro", 78, 950);
        Smartphone SamsungGalaxyA53 = new Smartphone("Samsung", "Galaxy A53", 47, 470);
        Smartphone SamsungGalaxyS22 = new Smartphone("Samsung", "Galaxy S22", 87, 900);
        Smartphone OnePlus9RT = new Smartphone("OnePlus", "9RT", 86, 550);
        Smartphone SamsungGalaxyA13 = new Smartphone("Samsung", "Galaxy A13", 18, 210);

        // Flagships
        ArrayList<Smartphone> flagshipsList = new ArrayList<>();
        flagshipsList.add(Xiaomi11Ultra);
        flagshipsList.add(GooglePixel6Pro);
        flagshipsList.add(SamsungGalaxyS22);
        flagshipsList.add(OnePlus10Pro);

        SmartphoneClasses flagships = new SmartphoneClasses(
                SmartphoneClassTypes.FLAGSHIP, "$700-1500", flagshipsList);

        // sub-flagships
        ArrayList<Smartphone> subFlagshipsList = new ArrayList<>();
        subFlagshipsList.add(XiaomiPocoF3);
        subFlagshipsList.add(OnePlus9Pro);
        subFlagshipsList.add(OnePlusAce);
        subFlagshipsList.add(RealmeGTNeo3);
        subFlagshipsList.add(SamsungGalaxyA53);
        subFlagshipsList.add(OnePlus9RT);

        SmartphoneClasses subFlagships = new SmartphoneClasses(
                SmartphoneClassTypes.SUB_FLAGSHIP, "$400-699", subFlagshipsList);

        // Budgets
        ArrayList<Smartphone> budgetsList = new ArrayList<>();
        budgetsList.add(RealmeC11);
        budgetsList.add(SamsungGalaxyA13);
        budgetsList.add(XiaomiRedmiNote5);

        SmartphoneClasses budgets = new SmartphoneClasses(
                SmartphoneClassTypes.BUDGET, "$100-399", budgetsList);


        ArrayList<SmartphoneClasses> allSmartphoneTypes = new ArrayList<>();
        allSmartphoneTypes.add(flagships);
        allSmartphoneTypes.add(subFlagships);
        allSmartphoneTypes.add(budgets);


        for (SmartphoneClasses sCl : allSmartphoneTypes) {
            System.out.println("=====[ " + sCl.getType() + " ]=====");
            System.out.println(sCl.getPriceRange());

            ArrayList<Smartphone> list = sCl.getComposition();
            StringBuilder sb = new StringBuilder();

            for (int i = 0, n = list.size(); i < n; i++) {
                Smartphone sf = list.get(i);
                sb.append(sf.getCompany())
                        .append(" ")
                        .append(sf.getModel())
                        .append(" (performance: ")
                        .append(sf.getPerformance())
                        .append(", price: $")
                        .append(sf.getPrice())
                        .append(")");
//                if (i != n - 1) {
//                    sb.append("\n");
//                }
                sb.append("\n");
            }

            System.out.println(sb);
        }

        writeSmartListIntoExcel(allSmartphoneTypes);
        //System.out.println("Writing smartphones to Excel ended");
    }
}
