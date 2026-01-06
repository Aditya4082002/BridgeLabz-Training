package oopsPillars;

// interface
interface GPS {

    String getCurrentLocation();

    void updateLocation(String location);
}

// abstract class
abstract class Vehicles {

    private int vehicleId;
    private String driverName;
    private double ratePerKm;

    public abstract double calculateFare(double distance);

    public void setDetails(int vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    protected double getRatePerKm() {
        return ratePerKm;
    }

    public String getVehicleDetails() {
        return "Vehicle Id: " + vehicleId +
               ", Driver Name: " + driverName +
               ", Rate Per Km: " + ratePerKm;
    }
}

// Car subclass
class Cars extends Vehicles implements GPS {

    private String location;

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String location) {
        this.location = location;
    }
}

// Bike subclass
class Bikes extends Vehicles implements GPS {

    private String location;

    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.8;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String location) {
        this.location = location;
    }
}

// Auto subclass
class Auto extends Vehicles implements GPS {

    private String location;

    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.9;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String location) {
        this.location = location;
    }
}

// main class
public class RideHailingApplication {

    public static void calculateFares(Vehicles[] vehicles, double distance) {

        for (Vehicles vehicle : vehicles) {

            double fare = vehicle.calculateFare(distance);

            System.out.println(vehicle.getVehicleDetails());
            System.out.println("Distance: " + distance);
            System.out.println("Fare: " + fare);

            if (vehicle instanceof GPS) {
                System.out.println("Current Location: " +
                    ((GPS) vehicle).getCurrentLocation());
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Vehicles vehicle1 = new Cars();
        Vehicles vehicle2 = new Bikes();
        Vehicles vehicle3 = new Auto();

        vehicle1.setDetails(101, "Ramesh", 15);
        vehicle2.setDetails(202, "Suresh", 10);
        vehicle3.setDetails(303, "Mahesh", 12);

        ((GPS) vehicle1).updateLocation("City Center");
        ((GPS) vehicle2).updateLocation("Railway Station");
        ((GPS) vehicle3).updateLocation("Bus Stand");

        Vehicles[] vehicles = { vehicle1, vehicle2, vehicle3 };

        calculateFares(vehicles, 10);
    }
}
