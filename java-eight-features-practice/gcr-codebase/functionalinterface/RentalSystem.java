package functionalinterface;

interface Rentable {

    void rent();

    void returnVehicle();
}

class Car implements Rentable {

    @Override
    public void rent() {
        System.out.println("Car has been rented");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Car has been returned");
    }
}

class Bike implements Rentable {

    @Override
    public void rent() {
        System.out.println("Bike has been rented");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Bike has been returned");
    }
}

class Bus implements Rentable {

    @Override
    public void rent() {
        System.out.println("Bus has been rented");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Bus has been returned");
    }
}


public class RentalSystem {

    public static void main(String[] args) {

        Rentable[] vehicles = {
            new Car(),
            new Bike(),
            new Bus()
        };

        for (Rentable vehicle : vehicles) {
            vehicle.rent();
            vehicle.returnVehicle();
            System.out.println();
        }
    }
}

