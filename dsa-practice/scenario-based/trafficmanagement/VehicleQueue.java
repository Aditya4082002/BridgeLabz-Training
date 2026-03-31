package trafficmanagement;

public class VehicleQueue {

    String[] queue;
    int front = -1;
    int rear = -1;
    int capacity;

    public VehicleQueue(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
    }

    public void enqueue(String vehicleNumber) {

        if (rear == capacity - 1) {
            System.out.println("Queue Overflow ");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        queue[++rear] = vehicleNumber;
        System.out.println(vehicleNumber + " Added into Queue");
    }

    public String dequeue() {

        if (front == -1) {
            System.out.println("Queue Underflow");
            return null;
        }

        String vehicle = queue[front];

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }

        return vehicle;
    }

    public boolean isEmpty() {
        return front == -1;
    }
}
