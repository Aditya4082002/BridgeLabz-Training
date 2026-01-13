package com.oops.hospitalmanagement;

class Doctor extends Person {
    private String specialization;

    Doctor(int id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    public double calculateConsultationFee() {
        return 500; // default fee
    }

    public String getSpecialization() {
        return specialization;
    }
}
