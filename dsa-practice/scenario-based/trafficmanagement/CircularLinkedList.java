package trafficmanagement;

public class CircularLinkedList {

    Vehicle head;
    Vehicle tail;
    int size = 0;
    int capacity = 2;

    public void add(String vehicleNumber) {

        if (size == capacity) {
            System.out.println("Round About is Full ");
            return;
        }

        Vehicle newVehicle = new Vehicle(vehicleNumber);

        if (head == null) {
            head = tail = newVehicle;
            newVehicle.next = newVehicle;
            size++;
            System.out.println("Vehicle " + vehicleNumber + " is added into roundabout");
            return;
        }

        tail.next = newVehicle;
        tail = newVehicle;
        tail.next = head;
        size++;
        System.out.println("Vehicle " + vehicleNumber + " is added into roundabout");
    }

    public void remove() {

        if (size == 0) {
            System.out.println("No Vehicle in RoundAbout");
            return;
        }

        if (head == tail) {
            System.out.println("Vehicle " + head.vehicleNumber + " is removed from roundabout");
            head = tail = null;
            size--;
            return;
        }

        System.out.println("Vehicle " + head.vehicleNumber + " is removed from roundabout");
        head = head.next;
        tail.next = head;
        size--;
    }

    public void display() {

        if (head == null) {
            System.out.println("Roundabout is empty");
            return;
        }

        System.out.println("Total vehicle: " + size);

        Vehicle current = head;

        do {
            System.out.println(current.vehicleNumber);
            current = current.next;
        } while (current != head);
    }

    public boolean hasSpace() {
        return size < capacity;
    }
}
