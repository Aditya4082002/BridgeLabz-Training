package com.oops.hospitalmanagement;

public class HospitalManagementSystem {

    public static void main(String[] args) {

        HospitalServiceImpl hospital = new HospitalServiceImpl();

        // Doctors
        Doctor d1 = new Doctor(1, "Dr. Sharma", "General");
        Doctor d2 = new SpecialistDoctor(2, "Dr. Mehta", "Cardiology");

        hospital.addDoctor(d1);
        hospital.addDoctor(d2);

        // Patients
        Patient p1 = new Patient(101, "Aditya", 22);
        p1.addMedicalRecord("Fever - Jan 2026");
        p1.addMedicalRecord("Cold - Feb 2026");

        hospital.addPatient(p1);

        try {
            Appointment a1 = hospital.bookAppointment(p1, d1, "10-02-2026");
            a1.displayAppointment();

            Appointment a2 = hospital.bookAppointment(p1, d2, "11-02-2026");
            a2.displayAppointment();

        } catch (AppointmentNotAvailableException e) {
            System.out.println("Booking Failed: " + e.getMessage());
        }

        p1.viewMedicalHistory();
        hospital.showAppointments();
    }
}