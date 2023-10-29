package workwithmap;



public class Lab2Task2DemoFomenko {
    public static void main(String[] args) {

        String delimeter = new String("===========================================================\n");

        System.out.println("\n           DEMONSTRATION TASK 2\n\n");
        System.out.println("Creating not empty collection:");
        CountriesAirports countriesAirports = new CountriesAirports();
        countriesAirports.show();
        System.out.println(delimeter);

        System.out.println("Adding new element with new Key:");
        System.out.println(countriesAirports.addCountry("Ukraine", "Kyiv", 380));
        countriesAirports.show();
        System.out.println(delimeter);

        System.out.println("Adding new relate elements to new Key:");
        System.out.println(countriesAirports.addAirportToCountry(new Country("Ukraine", "Kyiv", 380),
                                                                 new Airport("Lviv Danylo Halytskyi", "UKLL")));
        System.out.println(countriesAirports.addAirportToCountry(new Country("Ukraine", "Kyiv", 380),
                                                                 new Airport("Odesa International Airport", "UKOO")));
        System.out.println(countriesAirports.addAirportToCountry(new Country("Ukraine", "Kyiv", 380),
                                                                 new Airport("Mykolaiv International Airport", "UKON")));
        countriesAirports.show();
        System.out.println(delimeter);

        System.out.println("Editing the Value of added Key:");
        System.out.println(countriesAirports.editAirport(new Country("Ukraine", "Kyiv", 380),
                                                         new Airport("Lviv Danylo Halytskyi", "UKLL"),
                                                         new Airport("Ternopil International Airport", "UKLT")));
        countriesAirports.show();
        System.out.println(delimeter);

        System.out.println("Deleting the Value of added Key:");
        System.out.println(countriesAirports.delete(new Country("Ukraine", "Kyiv", 380),
                                                    new Airport("Ternopil International Airport", "UKLT")));
        countriesAirports.show();
        System.out.println(delimeter);

        System.out.println("Attempting to edit data of a ValueObject so that it duplicates another existing ValueObject:");
        System.out.println(countriesAirports.editAirport(new Country("Ukraine", "Kyiv", 380),
                                                         new Airport("Odesa International Airport", "UKOO"),
                                                         new Airport("Mykolaiv International Airport", "UKON")));
        countriesAirports.show();
        System.out.println(delimeter);

        System.out.println("Attempting to delete data about a ValueObject that does not exist in the current Map:");
        System.out.println(countriesAirports.delete(new Country("Ukraine", "Kyiv", 380),
                                                    new Airport("Kramatorsk International Airport", "AAAA")));
        countriesAirports.show();
        System.out.println(delimeter);

        System.out.println("Attempting to edit the Key data so that it duplicated another existing object in the keyset:");
        System.out.println(countriesAirports.editCountry(new Country("Ukraine", "Kyiv", 380),
                                                         new Country("Spain", "Madrid", 34)));
        countriesAirports.show();
        System.out.println(delimeter);

        System.out.println("Attempting to delete data about a Key that does not exist in the Map:");
        System.out.println(countriesAirports.delete(new Country("Uganda", "Moscow", 404), true));
        countriesAirports.show();
        System.out.println(delimeter);

        System.out.println("Attempting to delete data of a Key with a non-empty Value:");
        System.out.println(countriesAirports.delete(new Country("Ukraine", "Kyiv", 380), false));
        countriesAirports.show();
        System.out.println(delimeter);

        System.out.println("Deleting data of the Key:");
        System.out.println(countriesAirports.deleteAirports(new Country("Ukraine", "Kyiv", 380)));
        System.out.println(countriesAirports.delete(new Country("Ukraine", "Kyiv", 380), false));
        countriesAirports.show();
        System.out.println(delimeter);

        System.out.println("Clearing the collection:");
        System.out.println(countriesAirports.clearCollection());
        countriesAirports.show();
        System.out.println(delimeter);

    }
}
