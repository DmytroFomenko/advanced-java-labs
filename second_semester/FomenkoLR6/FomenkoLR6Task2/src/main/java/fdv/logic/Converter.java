package fdv.logic;


import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Converter {
    private int lang = 0;
    ResourceBundle bund = ResourceBundle.getBundle("Text", new Locale("en", "US"));
    private Date date = new Date();
    private String fromSum = "0";
    private String toSum = "0";
    private String fromCur;
    private String toCur;
    private String selFromUAH = "";
    private String selFromUSD = "selected";
    private String selFromEUR = "";

    private String selToUAH = "";
    private String selToUSD = "selected";
    private String selToEUR = "";


    public void setBund(ResourceBundle bund) {this.bund = bund;}

    public Date getDate() {return date;}

    public ResourceBundle getBund() {return bund;}

    public int getLang() {return lang;}

    public String getFromSum() {return fromSum;}

    public String getToSum() {return toSum;}

    public String getSelFromUAH() {return selFromUAH;}

    public String getSelFromUSD() {return selFromUSD;}

    public String getSelFromEUR() {return selFromEUR;}

    public String getSelToUAH() {return selToUAH;}

    public String getSelToUSD() {return selToUSD;}

    public String getSelToEUR() {return selToEUR;}


    public void convert(String fromCur, String fromSum, String toCur) {
        this.fromSum = fromSum;

        this.selFromUAH = "";
        this.selFromUSD = "";
        this.selFromEUR = "";
        this.selToUAH = "";
        this.selToUSD = "";
        this.selToEUR = "";


        this.toSum = String.valueOf(Double.parseDouble(bund.getString(fromCur))
                                            * Double.parseDouble(fromSum)
                                            / Double.parseDouble(bund.getString(toCur)));
        fromCurSelect(fromCur);
        toCurSelect(toCur);

//        if (fromCur.equals("UAH") && toCur.equals("EUR")) {
//            this.toSum = String.valueOf(Double.parseDouble(fromSum) * 0.0253);
//            this.selFromUAH = sel;
//            this.selToEUR = sel;
//        } else if (fromCur.equals("EUR") && toCur.equals("UAH")) {
//            this.toSum = String.valueOf(Double.parseDouble(fromSum) * 39.482);
//            this.selFromEUR = sel;
//            this.selToUAH = sel;
//        } else if (fromCur.equals("UAH") && toCur.equals("UAH")) {
//            this.toSum = fromSum;
//            this.selFromUAH = sel;
//            this.selToUAH = sel;
//        } else if (fromCur.equals("USD") && toCur.equals("USD")) {
//            this.toSum = fromSum;
//            this.selFromUSD = sel;
//            this.selToUSD = sel;
//        } else if (fromCur.equals("EUR") && toCur.equals("EUR")) {
//            this.toSum = fromSum;
//            this.selFromEUR = sel;
//            this.selToEUR = sel;
//        } else if (fromCur.equals("UAH") && toCur.equals("USD")) {
//            this.toSum = String.valueOf(Double.parseDouble(fromSum) * 0.0271);
//            this.selFromUAH = sel;
//            this.selToUSD = sel;
//        } else if (fromCur.equals("USD") && toCur.equals("UAH")) {
//            this.toSum = String.valueOf(Double.parseDouble(fromSum) * 36.921);
//            this.selFromUSD = sel;
//            this.selToUAH = sel;
//        } else if (fromCur.equals("USD") && toCur.equals("EUR")) {
//            this.toSum = String.valueOf(Double.parseDouble(fromSum) * 0.9358);
//            this.selFromUSD = sel;
//            this.selToEUR = sel;
//        } else if (fromCur.equals("EUR") && toCur.equals("USD")) {
//            this.toSum = String.valueOf(Double.parseDouble(fromSum) * 1.0686);
//            this.selFromEUR = sel;
//            this.selToUSD = sel;
//        } else {
//            this.toSum = fromSum;
//        }

    }

    public void fromCurSelect(String fromCur) {
        String sel = "selected";
        switch (fromCur) {
            case "UAH" -> this.selFromUAH = sel;
            case "EUR" -> this.selFromEUR = sel;
            case "USD" -> this.selFromUSD = sel;
        }
    }
    public void toCurSelect(String fromCur) {
        String sel = "selected";
        switch (fromCur) {
            case "UAH" -> this.selToUAH = sel;
            case "EUR" -> this.selToEUR = sel;
            case "USD" -> this.selToUSD = sel;
        }
    }

}
