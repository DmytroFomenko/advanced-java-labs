package workwithmap;


import java.util.Objects;

public class Country {
    private String nazva;
    private String capital;
    private int cod;

    public Country(String nazva, String capital, int cod) {
        this.nazva = nazva;
        this.capital = capital;
        this.cod = cod;
    }

    public String getNazva() {
        return nazva;
    }

    public String getCapital() {
        return capital;
    }

    public int getCod() {
        return cod;
    }

    public int setNazva(String nazva) {
        this.nazva = nazva;
        return 0;
    }

    public int setCapital(String capital) {
        this.capital = capital;
        return 0;
    }

    public int setCod(int cod) {
        this.cod = cod;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Country country))
            return false;

        return nazva.equals(country.nazva);
    }

    @Override
    public int hashCode() {
        return nazva.hashCode();
    }

    public boolean equalsAll(Country a) {
        return this.equals(a) && this.capital == a.getCapital();
    }

    @Override
    public String toString() {
        return "Country nazva: " + nazva + ", capital: " + capital + ", cod: " + cod;
    }
}
