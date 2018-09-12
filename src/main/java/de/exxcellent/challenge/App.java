package de.exxcellent.challenge;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static void main(String... args) throws IOException, URISyntaxException {

        CalculateSmallestSpread calculateSmallestSpread = new CalculateSmallestSpread();

        calculateSmallestSpread.calculateSmallestSpread(1);
        System.out.println("Day: " + calculateSmallestSpread.smallestSpreadKey + "  |  Smallest Temperature Spread: " + calculateSmallestSpread.smallestSpreadValue);

        calculateSmallestSpread.calculateSmallestSpread(2);
        System.out.println("Team: " + calculateSmallestSpread.smallestSpreadKey + " | Smallest distance: " + calculateSmallestSpread.smallestSpreadValue);

    }
}
