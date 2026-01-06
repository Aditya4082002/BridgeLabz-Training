package oopsPillars;

// interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// abstract class
abstract class Vehicle {

    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public abstract double calculateRentalCost(int days);

    public void setDetails(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }
}

// Car subclass
class Car extends Vehicle implements Insurable {

    private String insurancePolicyNumber;

    public void setInsurancePolicy(String policyNumber) {
        this.insurancePolicyNumber = policyNumber;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return getRentalRate() * 0.15;
    }

    public String getInsuranceDetails() {
        return "Car insurance applied";
    }
}

// Bike subclass
class Bike extends Vehicle implements Insurable {

    private String insurancePolicyNumber;

    public void setInsurancePolicy(String policyNumber) {
        this.insurancePolicyNumber = policyNumber;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.8;
    }

    public double calculateInsurance() {
        return getRentalRate() * 0.1;
    }

    public String getInsuranceDetails() {
        return "Bike insurance applied";
    }
}

// Truck subclass
class Truck extends Vehicle implements Insurable {

    private String insurancePolicyNumber;

    public void setInsurancePolicy(String policyNumber) {
        this.insurancePolicyNumber = policyNumber;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.5;
    }

    public double calculateInsurance() {
        return getRentalRate() * 0.2;
    }

    public String getInsuranceDetails() {
        return "Truck insurance applied";
    }
}

// main class
public class VehicleRentalSystem {

    public static void calculateCosts(Vehicle[] vehicles, int days) {

        for (Vehicle vehicle : vehicles) {

            double rentalCost = vehicle.calculateRentalCost(days);
            double insuranceCost = 0;

            if (vehicle instanceof Insurable) {
                insuranceCost = ((Insurable) vehicle).calculateInsurance();
            }

            System.out.println("Vehicle Type: " + vehicle.getType());
            System.out.println("Vehicle Number: " + vehicle.getVehicleNumber());
            System.out.println("Rental Cost: " + rentalCost);
            System.out.println("Insurance Cost: " + insuranceCost);
            System.out.println("Total Cost: " + (rentalCost + insuranceCost));
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Vehicle vehicle1 = new Car();
        Vehicle vehicle2 = new Bike();
        Vehicle vehicle3 = new Truck();

        vehicle1.setDetails("CAR101", "Car", 2000);
        vehicle2.setDetails("BIKE201", "Bike", 500);
        vehicle3.setDetails("TRUCK301", "Truck", 4000);

        Vehicle[] vehicles = { vehicle1, vehicle2, vehicle3 };

        calculateCosts(vehicles, 5);
    }
}
