package javaConstructors;

public class Vehicle {

    // Instance variables
    String ownerName;
    String vehicleType;

    // Class variable (shared by all vehicles)
    static double registrationFee = 5000;

    // Constructor
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method
    void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: ₹" + registrationFee);
    }

    // Class method
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    // Main method
    public static void main(String[] args) {

        Vehicle vehicle1 = new Vehicle("Rohit", "Car");
        Vehicle vehicle2 = new Vehicle("Ananya", "Bike");

        vehicle1.displayVehicleDetails();
        System.out.println();

        vehicle2.displayVehicleDetails();
        System.out.println();

        // Update registration fee for all vehicles
        Vehicle.updateRegistrationFee(6500);

        System.out.println("After updating registration fee:\n");
        vehicle1.displayVehicleDetails();
    }
}

