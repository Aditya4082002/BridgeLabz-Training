package collections;

import java.util.*;

class CircularBuffer {
    private final int[] buffer;
    private final int capacity;
    private int head;
    private int tail;
    private int size;

    public CircularBuffer(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be > 0");
        }
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    // Insert element (overwrite oldest if full)
    public void insert(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity;

        if (size < capacity) {
            size++;
        } else {
            // full => overwrite oldest
            head = (head + 1) % capacity;
        }
    }

    public List<Integer> getElements() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int index = (head + i) % capacity;
            result.add(buffer[index]);
        }
        return result;
    }
}

public class CircularBufferDemo {
    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        System.out.println(cb.getElements());

        cb.insert(4);
        System.out.println(cb.getElements());
    }
}
