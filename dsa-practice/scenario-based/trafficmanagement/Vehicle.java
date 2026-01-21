package trafficmanagement;

public class Vehicle {

    String vehicleNumber;
    Vehicle next;

    Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.next = null;
    }
}
