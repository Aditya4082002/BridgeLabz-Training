package collections;

import java.util.*;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriageSystem {

    public static void main(String[] args) {

        // PriorityQueue: higher severity first
        PriorityQueue<Patient> pq = new PriorityQueue<>(
                (p1, p2) -> Integer.compare(p2.severity, p1.severity)
        );

        // Adding patients
        pq.add(new Patient("John", 3));
        pq.add(new Patient("Alice", 5));
        pq.add(new Patient("Bob", 2));

        System.out.println("Treatment Order:");

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
