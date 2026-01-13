package com.oops.hospitalmanagement;
import java.util.*;

class HospitalServiceImpl implements HospitalService {

    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor added: " + doctor.name);
    }

    @Override
    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient added: " + patient.name);
    }

    @Override
    public void deletePatient(int patientId) {
        Iterator<Patient> it = patients.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == patientId) {
                it.remove();
                System.out.println("Patient deleted");
                return;
            }
        }
        System.out.println("Patient not found");
    }

    @Override
    public Appointment bookAppointment(Patient patient, Doctor doctor, String date)
            throws AppointmentNotAvailableException {

        for (Appointment a : appointments) {
            if (a.getDoctor() == doctor) {
                throw new AppointmentNotAvailableException(
                        "Doctor already has an appointment on this date");
            }
        }

        Appointment appointment = new Appointment(patient, doctor, date);
        appointments.add(appointment);
        return appointment;
    }

    @Override
    public void cancelAppointment(Appointment appointment) {
        appointments.remove(appointment);
        System.out.println("Appointment cancelled");
    }

    public void showAppointments() {
        System.out.println("\nAppointments:");
        for (Appointment a : appointments) {
            a.displayAppointment();
        }
    }
}