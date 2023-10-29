package workwithmap;


import workwithset.ITEmpl;

import java.util.HashSet;
import java.util.Iterator;

public class AirportsSet extends HashSet<Airport> {

    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.forEach(airport -> sb.append(airport).append(System.lineSeparator()));
        if (sb.isEmpty()) {
            sb.append("No airports").append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String editAirport(Airport airport, Airport newAirport) {
        StringBuilder sb = new StringBuilder();

        // If old and new airport data the same
        if (airport.equals(newAirport)) {
            sb.append("Airport was NOT changed (there are the same data): ")
                    .append(airport);
        } else { // If old and new airport data NOT the same
            if (this.remove(airport)) { // If old airport was successfully removed (it was present)
                if (this.add(newAirport)) { // If new airport was successfully added (changed, it was not present)
                    sb.append(airport)
                            .append(" was changed to: ")
                            .append(newAirport);
                } else { // If new airport was NOT successfully added (changed)
                    this.add(airport); // Return old airport
                    sb.append(airport)
                            .append(" was NOT changed (the new airport data already exists): ")
                            .append(newAirport);
                }
            } else { // If old airport was NOT successfully removed
                sb.append("Airport was NOT changed (airport NOT exists): ")
                        .append(airport);
            }
        }
        return sb.toString();
    }

    public String deleteAirport(Airport airport) {
        StringBuilder sb = new StringBuilder();
        if (this.remove(airport)) { // If old airport was successfully removed (it was present)
            sb.append(airport)
                    .append(" was removed");
        } else { // If new airport was NOT successfully removed (it was NOT present)
            sb.append(airport)
                    .append(" was NOT removed (the airport NOT exists)");
        }
        return sb.toString();
    }

    public String deleteAirports() {
        this.clear();
        return "All airports was removed";
    }
}
