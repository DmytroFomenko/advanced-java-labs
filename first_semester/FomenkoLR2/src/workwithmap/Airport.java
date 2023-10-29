package workwithmap;


import java.lang.Object;


public class Airport {
    private String name;
    private String sign;

    public Airport(String name, String sign) {
        this.name = name;
        this.sign = sign;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Airport airport))
            return false;

        return name.equals(airport.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getName() {
        return name;
    }

    public String getSign() {
        return sign;
    }

    public int setName(String name) {
        this.name = name;
        return 0;
    }

    public int setSign(String sign) {
        this.sign = sign;
        return 0;
    }

    @Override
    public String toString() {
        return "Airport name: " + name + ", sign: " + sign;
    }
}
