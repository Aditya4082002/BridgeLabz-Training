package com.oops.hospitalmanagement;

class SpecialistDoctor extends Doctor {

    SpecialistDoctor(int id, String name, String specialization) {
        super(id, name, specialization);
    }

    @Override
    public double calculateConsultationFee() {
        return 1000; // higher fee for specialists
    }
}