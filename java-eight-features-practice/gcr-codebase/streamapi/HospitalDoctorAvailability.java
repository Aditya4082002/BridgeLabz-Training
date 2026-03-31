package streamapi;

import java.util.*;
import java.util.stream.*;

class Doctor {
    private String name;
    private String specialty;
    private boolean availableOnWeekend;

    public Doctor(String name, String specialty, boolean availableOnWeekend) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekend = availableOnWeekend;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public boolean isAvailableOnWeekend() {
        return availableOnWeekend;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Specialty: " + specialty;
    }
}

public class HospitalDoctorAvailability {

    public static void main(String[] args) {

        List<Doctor> doctors = Arrays.asList(
                new Doctor("Dr. Sharma", "Cardiology", true),
                new Doctor("Dr. Mehta", "Neurology", false),
                new Doctor("Dr. Verma", "Orthopedics", true),
                new Doctor("Dr. Rao", "Dermatology", true),
                new Doctor("Dr. Kapoor", "Pediatrics", false),
                new Doctor("Dr. Singh", "Anesthesiology", true)
        );

        // Stream pipeline
        List<Doctor> availableDoctors = doctors.stream()
                .filter(Doctor::isAvailableOnWeekend)
                .sorted(Comparator.comparing(Doctor::getSpecialty))
                .collect(Collectors.toList());

        System.out.println("Doctors available on weekends sorted by specialty:\n");

        availableDoctors.forEach(System.out::println);
    }
}

