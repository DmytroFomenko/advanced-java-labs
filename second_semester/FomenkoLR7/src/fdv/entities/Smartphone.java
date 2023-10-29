package fdv.entities;


import java.io.Serializable;
import java.util.Scanner;

/**
 * @author Fomenko D.V.
 */
public class Smartphone implements Serializable {

    // id, company,	model, performance, price
    private int id;
    private String company;
    private String model;
    private int performance;
    private double price;



    public Smartphone(String company, String model, int performance, double price) {
        this.company = company;
        this.model = model;
        this.performance = performance;
        this.price = price;
    }



    public String getModel() {
        return model;
    }

    public String getCompany() {return company;}

    public int getPerformance() {return performance;}

    public double getPrice() {return price;}
}


