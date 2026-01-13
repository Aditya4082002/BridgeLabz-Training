package com.oops.hospitalmanagement;

interface HospitalService {
    void addPatient(Patient patient);
    void deletePatient(int patientId);
    Appointment bookAppointment(Patient patient, Doctor doctor, String date) throws AppointmentNotAvailableException;
    void cancelAppointment(Appointment appointment);
}