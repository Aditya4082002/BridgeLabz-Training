package DSA;

class MyHashMap {

    // Node for Linked List
    static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int SIZE = 10;          // bucket size
    private Node[] buckets;         // array of linked lists

    // Constructor
    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    // Hash function
    private int hash(int key) {
        return key % SIZE;
    }

    // Insert or Update
    public void put(int key, int value) {
        int index = hash(key);
        Node head = buckets[index];

        // Check if key already exists
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                current.value = value; // update
                return;
            }
            current = current.next;
        }

        // Insert new node at head
        Node newNode = new Node(key, value);
        newNode.next = head;
        buckets[index] = newNode;
    }

    // Retrieve value
    public int get(int key) {
        int index = hash(key);
        Node current = buckets[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }

        return -1; // not found
    }

    // Delete key
    public void remove(int key) {
        int index = hash(key);
        Node current = buckets[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    // Display HashMap
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Bucket " + i + ": ");
            Node current = buckets[i];
            while (current != null) {
                System.out.print("[" + current.key + "=" + current.value + "] ");
                current = current.next;
            }
            System.out.println();
        }
    }

    // Main Method
    public static void main(String[] args) {

        MyHashMap map = new MyHashMap();

        map.put(1, 10);
        map.put(11, 20); // collision with key 1
        map.put(2, 30);

        System.out.println("Value for key 1: " + map.get(1));
        System.out.println("Value for key 11: " + map.get(11));

        map.remove(1);
        System.out.println("After removing key 1:");

        map.display();
    }
}

