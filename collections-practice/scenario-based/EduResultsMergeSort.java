package scenario;
import java.util.*;

class Student {
    int rollNo;
    String name;
    int score;

    public Student(int rollNo, String name, int score) {
        this.rollNo = rollNo;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return rollNo + " - " + name + " : " + score;
    }
}


public class EduResultsMergeSort {

    // Merge Sort
    public static void mergeSort(List<Student> students) {
        if (students.size() <= 1) return;

        int mid = students.size() / 2;

        List<Student> left = new ArrayList<>(students.subList(0, mid));
        List<Student> right = new ArrayList<>(students.subList(mid, students.size()));

        mergeSort(left);
        mergeSort(right);

        merge(students, left, right);
    }

    // Merge two sorted lists (descending by score)
    private static void merge(List<Student> result,
                              List<Student> left,
                              List<Student> right) {

        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            // Stable: if scores equal, take from left first
            if (left.get(i).score >= right.get(j).score) {
                result.set(k++, left.get(i++));
            } else {
                result.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            result.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            result.set(k++, right.get(j++));
        }
    }

    public static void main(String[] args) {

        // District-wise sorted lists
        List<Student> district1 = Arrays.asList(
                new Student(101, "Alice", 90),
                new Student(102, "Bob", 85)
        );

        List<Student> district2 = Arrays.asList(
                new Student(201, "Carol", 95),
                new Student(202, "Dave", 85)
        );

        List<Student> district3 = Arrays.asList(
                new Student(301, "Eve", 92),
                new Student(302, "Frank", 80)
        );

        // Merge all district lists into one
        List<Student> allStudents = new ArrayList<>();
        allStudents.addAll(district1);
        allStudents.addAll(district2);
        allStudents.addAll(district3);

        // Apply Merge Sort
        mergeSort(allStudents);

        // Final Rank Sheet
        System.out.println("State-wise Rank List:");
        int rank = 1;
        for (Student s : allStudents) {
            System.out.println("Rank " + rank++ + " -> " + s);
        }
    }
}

