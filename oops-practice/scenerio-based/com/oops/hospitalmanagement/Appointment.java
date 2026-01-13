package com.oops.hospitalmanagement;

class Appointment {
	private Patient patient;
	private Doctor doctor;
	private String date;

	Appointment(Patient patient, Doctor doctor, String date) {
		this.patient = patient;
		this.doctor = doctor;
		this.date = date;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void displayAppointment() {
		System.out.println("Patient: " + patient.name + " | Doctor: " + doctor.name + " | Date: " + date + " | Fee: " + doctor.calculateConsultationFee());
	}
}
