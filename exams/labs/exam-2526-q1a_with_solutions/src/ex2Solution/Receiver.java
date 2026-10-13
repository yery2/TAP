package ex2Solution;

import utils.Measurement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Receiver {

    private String filePath;

    private List<MeasurementObserver> observerList;

    public Receiver(String filePath) {
        this.filePath = filePath;
        this.observerList = new LinkedList<>();
    }

    public void readBus() throws IOException {
        try(FileReader fis = new FileReader(filePath)){
            BufferedReader dis = new BufferedReader(fis);
            String line;
            while ((line = dis.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(line, ",");
                while (tokens.hasMoreTokens()) {
                    Measurement m = new Measurement(tokens.nextToken(), tokens.nextToken(), Double.parseDouble(tokens.nextToken()));
                    receiveMeasurement(m);
                }
            }
        }
    }

    private void receiveMeasurement(Measurement m) {
        notifyObservers(m);
    }

    public void addObserver(MeasurementObserver obs){
        observerList.add(obs);
    }

    public void removeObserver(MeasurementObserver obs){
        observerList.remove(obs);
    }

    private void notifyObservers(Measurement measurement){
        for (MeasurementObserver obs : observerList)
            obs.notify(measurement);
    }
}
