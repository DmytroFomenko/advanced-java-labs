package workwithmap;


import javax.lang.model.type.NoType;
import java.util.HashMap;
import java.util.Set;

public class CountriesAirports extends HashMap<Country, Set<Airport>> {

    public CountriesAirports() {

        AirportsSet airportsUSA = new AirportsSet();
        airportsUSA.add(new Airport("Bob Baker Memorial Airport", "PAIK"));
        airportsUSA.add(new Airport("Jmj Landing Airport", "02KS"));
        airportsUSA.add(new Airport("Young Private Airport", "06WI"));
        airportsUSA.add(new Airport("Fulton Seaplane Base", "0FD6"));
        airportsUSA.add(new Airport("Rocky Reef Farm Airport", "0NK8"));
        this.put(new Country("USA", "Washington", 1), airportsUSA);

        AirportsSet airportsUK = new AirportsSet();
        airportsUK.add(new Airport("Glasgow International Airport", "EGPF"));
        airportsUK.add(new Airport("Newcastle Airport", "EGNT"));
        airportsUK.add(new Airport("Liverpool John Lennon Airport", "EGGP"));
        airportsUK.add(new Airport("Southampton Airport", "EGHI"));
        airportsUK.add(new Airport("Exeter International Airport", "EGTE"));
        this.put(new Country("UK", "London", 44), airportsUK);

        AirportsSet airportsGermany = new AirportsSet();
        airportsGermany.add(new Airport("Stuttgart Airport", "EDDS"));
        airportsGermany.add(new Airport("Nuremberg Airport", "EDDN"));
        airportsGermany.add(new Airport("Frankfurt-Hahn Airport", "EDFH"));
        airportsGermany.add(new Airport("Bremen Airport", "EDDW"));
        airportsGermany.add(new Airport("Dortmund Airport", "EDLW"));
        this.put(new Country("Germany", "Berlin", 49), airportsGermany);

        AirportsSet airportsAustralia = new AirportsSet();
        airportsAustralia.add(new Airport("St George Airport", "YSGE"));
        airportsAustralia.add(new Airport("Bellevue Airport", "YBLU"));
        airportsAustralia.add(new Airport("Jericho Airport", "YJCO"));
        airportsAustralia.add(new Airport("Paynes Find Airport", "YPYF"));
        airportsAustralia.add(new Airport("Jiggalong Mission Airport", "YJIG"));
        this.put(new Country("Australia", "Canberra", 61), airportsAustralia);

        AirportsSet airportsSwitzerland = new AirportsSet();
        airportsSwitzerland.add(new Airport("Geneva Cointrin International Airport", "LSGG"));
        airportsSwitzerland.add(new Airport("St Gallen Altenrhein Airport", "LSZR"));
        airportsSwitzerland.add(new Airport("Sion Airport", "LSGS"));
        airportsSwitzerland.add(new Airport("Helipad Klinik Gut", "CH-0005"));
        airportsSwitzerland.add(new Airport("Helipad Station Corvatsch", "CH-0006"));
        this.put(new Country("Switzerland", "Bern", 41), airportsSwitzerland);

        AirportsSet airportsSpain = new AirportsSet();
        airportsSpain.add(new Airport("Barcelona International Airport", "LEBL"));
        airportsSpain.add(new Airport("Palma De Mallorca Airport", "LEPA"));
        airportsSpain.add(new Airport("Alicante International Airport", "LEAL"));
        airportsSpain.add(new Airport("Gran Canaria Airport", "GCLP"));
        airportsSpain.add(new Airport("Ibiza Airport", "LEIB"));
        this.put(new Country("Spain", "Madrid", 34), airportsSpain);

        AirportsSet airportsDenmark = new AirportsSet();
        this.put(new Country("Denmark", "Copenhagen", 45), airportsDenmark);
    }

    public String showCountries() {
        StringBuilder sb = new StringBuilder();
        this.forEach((country, airports) -> sb.append(System.lineSeparator()).append(country.getNazva()));
        System.out.println(sb);
        return sb.toString();
    }

    public String toStringAirports(Country country) {
        String st = "";
        AirportsSet airportsSet = (AirportsSet) this.get(country);
        if (airportsSet != null) {
            st = airportsSet.toString();
        } else {
            st = "No airports added";
        }
        return st;
    }

    public String showAirports(Country country) {
        String str = new String(this.toStringAirports(country));
        System.out.println(str);
        return str;
    }

    public String show() {
        StringBuilder sb = new StringBuilder();
        this.forEach((country, airports) -> sb.append(System.lineSeparator()).append(country).append(System.lineSeparator()).append(toStringAirports(country)));
        if (sb.isEmpty()) {
            sb.append(System.lineSeparator())
                    .append("Collection is empty")
                    .append(System.lineSeparator());
        }
        System.out.println(sb);
        return sb.toString();
    }

    public String addCountry(String nazva, String capital, int cod) {
        StringBuilder sb = new StringBuilder();
        Country country = new Country(nazva, capital, cod);
        // If country already exists or it`s old AirportSet == null -> return null
        if (this.putIfAbsent(country, new AirportsSet()) == null) {
            sb.append("Where added: ");
        } else {
            sb.append("Where NOT added (because country already exists): ");
        }
        sb.append(country);
        return sb.toString();
    }

    public String addAirportToCountry(Country country, Airport airport) {
        StringBuilder sb = new StringBuilder();
        if (this.putIfAbsent(country, new AirportsSet()) == null) {
            sb.append("Where added: ").append(country).append(" and to it");
        } else {
            sb.append("To: ").append(country);
        }
        if (this.get(country).add(airport)) {
            sb.append(" was added: ").append(airport);
        } else {
            sb.append(" was NOT added (because the airport already exists): ").append(airport);
        }
        return sb.toString();
    }

    public String editCountry(Country country, Country newCountry) {
        StringBuilder sb = new StringBuilder();

        Country countryFromKey = null;
        AirportsSet airportsSetFromValue = null;

        // Finding and saving country key in "this" (with "capital")
        for (Entry<Country, Set<Airport>> item : this.entrySet()) {
            Country c = item.getKey();

            // Saving airportsSet from value
            if (country.equals(c)) {
                airportsSetFromValue = (AirportsSet) item.getValue();
                countryFromKey = c;
                break;
            }
        }

        // If country was found and saved from key
        if (countryFromKey != null) {
            this.remove(country);
            if (this.containsKey(newCountry)) {
                this.put(countryFromKey, airportsSetFromValue);
                sb.append("Can NOT edit country (new country data already exists): ")
                        .append(newCountry);
            } else {
                this.put(newCountry, airportsSetFromValue);
                sb.append("Was edited: ")
                        .append(countryFromKey)
                        .append(" to ")
                        .append(newCountry);
            }
        } else {
            sb.append("Can NOT edit country (no such country exists): ")
                    .append(country);
        }

        return sb.toString();
    }

    public String editAirport(Country country, Airport airport, Airport newAirport) {
        StringBuilder sb = new StringBuilder();

        AirportsSet as = (AirportsSet) this.get(country);
        if (as != null) {
            sb.append("Airport edition: ")
                    .append(country)
                    .append(" ")
                    .append(as.editAirport(airport, newAirport));
        } else {
            sb.append("Can NOT edit country's airport (no such country exists): ")
                    .append(country);
        }


        return sb.toString();
    }

    public String delete(Country country, Airport airport) {
        StringBuilder sb = new StringBuilder();

        AirportsSet as = (AirportsSet) this.get(country);
        if (as != null) {
            sb.append("Airport deletion: ")
                    .append(country)
                    .append(" ")
                    .append(as.deleteAirport(airport));
        } else {
            sb.append("Can NOT delete country's airport (no such country exists): ")
                    .append(country);
        }

        return sb.toString();
    }

    public String delete(Country country, boolean deleteWithNotEmptyAirports) {
        StringBuilder sb = new StringBuilder();

        Country countryFromKey = null;

        for (Entry<Country, Set<Airport>> item : this.entrySet()) {
            Country c = item.getKey();

            if (country.equals(c)) {
                countryFromKey = c;
                break;
            }
        }

        if (countryFromKey != null) {
            if (deleteWithNotEmptyAirports || this.get(country).isEmpty()) {
                this.remove(countryFromKey);
                sb.append("Was deleted (with airports): ")
                        .append(countryFromKey);
            } else {
                sb.append("Was NOT deleted (airports exists in country): ")
                        .append(countryFromKey);
            }
        } else {
            sb.append("Can NOT delete country (no such country exists): ")
                    .append(country);
        }
        return sb.toString();
    }

    public String deleteAirports(Country country) {
        StringBuilder sb = new StringBuilder();

        AirportsSet as = (AirportsSet) this.get(country);
        if (as != null) {

            sb.append("All airports deletion: ")
                    .append(country)
                    .append(" ")
                    .append(as.deleteAirports());
        } else {
            sb.append("Can NOT delete country's airports (no such country exists): ")
                    .append(country);
        }

        return sb.toString();
    }

    public String clearCollection() {
        clear();
        return "Collection was cleared";
    }
}






