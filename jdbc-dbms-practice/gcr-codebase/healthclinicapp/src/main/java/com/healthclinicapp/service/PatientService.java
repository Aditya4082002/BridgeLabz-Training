package com.healthclinicapp.service;

import com.healthclinicapp.model.*;
import com.healthclinicapp.dao.*;
import com.healthclinicapp.exception.*;


public class PatientService {
	private PatientDao patientDao = new PatientDao();
	public int registerPatient(Patient patient)
            throws DuplicatePatientException{

        boolean exists = patientDao.isPatientExists(
                patient.getPhone(),
                patient.getEmail()
        );

        if (exists) {
            throw new DuplicatePatientException(
                    "Patient already exists with this phone or email"
            );
        }

        return patientDao.insertPatient(patient);
    }
}
