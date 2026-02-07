package streamapi;

import java.util.*;
import java.util.stream.*;

public class IoTSensorReadings {

    static class SensorReading {
        private String sensorId;
        private double value;

        public SensorReading(String sensorId, double value) {
            this.sensorId = sensorId;
            this.value = value;
        }

        public String getSensorId() {
            return sensorId;
        }

        public double getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Sensor: " + sensorId + ", Reading: " + value;
        }
    }

    public static void main(String[] args) {

        List<SensorReading> readings = Arrays.asList(
                new SensorReading("S1", 22.5),
                new SensorReading("S2", 30.8),
                new SensorReading("S3", 18.4),
                new SensorReading("S4", 27.9),
                new SensorReading("S5", 35.2)
        );

        double threshold = 25.0;

        System.out.println("Sensor readings above threshold:\n");

        readings.stream()
                .filter(reading -> reading.getValue() > threshold)
                .forEach(reading ->
                        System.out.println(
                                "Sensor: " + reading.getSensorId() +
                                " | Value: " + reading.getValue()
                        )
                );
    }
}

