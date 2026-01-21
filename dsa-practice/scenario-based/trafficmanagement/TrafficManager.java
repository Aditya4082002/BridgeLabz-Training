package trafficmanagement;

import java.util.Scanner;

public class TrafficManager {

    public static void arrive(String vehicleNumber, CircularLinkedList round, VehicleQueue queue) {

        if (round.hasSpace()) {
            round.add(vehicleNumber);
        } else {
            queue.enqueue(vehicleNumber);
        }
    }

    public static void exit(CircularLinkedList round, VehicleQueue queue) {

        round.remove();

        if (round.hasSpace() && !queue.isEmpty()) {
            round.add(queue.dequeue());
        }
    }

    public static void main(String[] args) {

        CircularLinkedList roundAbout = new CircularLinkedList();
        VehicleQueue queue = new VehicleQueue(2);
        Scanner input = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {

            System.out.println("\nOptions:");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Exit Vehicle");
            System.out.println("3. Display Vehicles in Roundabout");
            System.out.println("4. Close");

            System.out.print("Enter your choice: ");
            String choice = input.nextLine();

            switch (choice) {

                case "1":
                    System.out.print("Enter vehicle Number: ");
                    String vehicle = input.nextLine();
                    arrive(vehicle, roundAbout, queue);
                    break;

                case "2":
                    exit(roundAbout, queue);
                    break;

                case "3":
                    roundAbout.display();
                    break;

                case "4":
                    System.out.println("Thanks...");
                    isRunning = false;
                    input.close();
                    break;

                default:
                    System.out.println("Invalid Choice ");
            }
        }
    }
}
