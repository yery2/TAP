package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Utils {

    public static List<Measurement> loadMeasurements(String filePath) throws IOException {
        List<Measurement> measurements = new LinkedList<>();

        try(FileReader fis = new FileReader(filePath)){
            BufferedReader dis = new BufferedReader(fis);

            String line;
            while ((line = dis.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(line, ",");
                while (tokens.hasMoreTokens()) {
                    Measurement m = new Measurement(tokens.nextToken(), tokens.nextToken(), Double.parseDouble(tokens.nextToken()));
                    measurements.add(m);
                }
            }
        }

        return measurements;
    }


}
