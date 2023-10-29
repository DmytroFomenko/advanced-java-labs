package fdv.entities;


import fdv.services.SmartphoneClassTypes;

import java.util.ArrayList;

public class SmartphoneClasses {

    private SmartphoneClassTypes type;
    private String priceRange;
    private ArrayList<Smartphone> composition;


    public SmartphoneClasses(SmartphoneClassTypes type, String priceRange, ArrayList<Smartphone> composition) {
        this.type = type;
        this.priceRange = priceRange;
        this.composition = composition;
    }

    public SmartphoneClassTypes getType() {return type;}
    public String getPriceRange() {return priceRange;}
    public ArrayList<Smartphone> getComposition() {return composition;}

}
