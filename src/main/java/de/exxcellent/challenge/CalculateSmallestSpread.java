package de.exxcellent.challenge;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;


public class CalculateSmallestSpread {

    int globalIndexNumber;
    String smallestSpreadKey;
    int smallestSpreadValue;

    public int calculateSmallestSpread(int indexNumber) throws IOException, URISyntaxException {

        this.globalIndexNumber = indexNumber;
        InputStream weatherFile = getClass().getClassLoader().getResourceAsStream("de/exxcellent/challenge/weather.csv");
        InputStream footballFile = getClass().getClassLoader().getResourceAsStream("de/exxcellent/challenge/football.csv");
        BufferedReader bufferedReader = null;

        String line = "";
        String lineSplit = ",";
        int min = 0, max = 0;
        Map<String, Integer> spreadMap = new HashMap<>();
        int spreadNumber = 0;

        if (globalIndexNumber == 1) {
            bufferedReader = new BufferedReader(new InputStreamReader(weatherFile));
        } else if (globalIndexNumber == 2) {
            bufferedReader = new BufferedReader(new InputStreamReader(footballFile));
        }

        //I used while twice in order to skip the first column of both weather and football csv files
        while ((line = bufferedReader.readLine()) != null) {
            while ((line = bufferedReader.readLine()) != null) {

                String[] data = line.split(lineSplit);

                for (int i = 0; i < data.length; i++) {
                    if (indexNumber == 1) {
                        min = Integer.parseInt(data[1]);
                        max = Integer.parseInt(data[2]);
                    } else if (indexNumber == 2) {
                        min = Integer.parseInt(data[5]);
                        max = Integer.parseInt(data[6]);
                    }
                    spreadNumber = Math.abs(max - min);
                    spreadMap.put(data[0], spreadNumber);
                }
            }
        }

        //getting smallest spread
        Map.Entry<String, Integer> firstValue = spreadMap.entrySet().iterator().next();
        smallestSpreadKey = firstValue.getKey();
        smallestSpreadValue = firstValue.getValue();

        for (Map.Entry<String, Integer> map : spreadMap.entrySet()) {
            int value = map.getValue();
            if (value < smallestSpreadValue) {
                smallestSpreadValue = value;
                smallestSpreadKey = map.getKey();
            }
        }
        return indexNumber;
    }


}