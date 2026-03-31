package functionalinterface;

interface Vehicle {

    void displaySpeed();

    default void displayBatteryPercentage() {
        System.out.println("Battery information not available for this vehicle");
    }
}


class Cars implements Vehicle {

    @Override
    public void displaySpeed() {
        System.out.println("Car speed: 80 km/h");
    }
}


class Bikes implements Vehicle {

    @Override
    public void displaySpeed() {
        System.out.println("Bike speed: 60 km/h");
    }
}


class ElectricCar implements Vehicle {

    @Override
    public void displaySpeed() {
        System.out.println("Electric Car speed: 100 km/h");
    }

    @Override
    public void displayBatteryPercentage() {
        System.out.println("Battery level: 75%");
    }
}


public class SmartDashboard {

    public static void main(String[] args) {

        Vehicle[] vehicles = {
            new Cars(),
            new Bikes(),
            new ElectricCar()
        };

        for (Vehicle v : vehicles) {
            v.displaySpeed();
            v.displayBatteryPercentage();
            System.out.println();
        }
    }
}

