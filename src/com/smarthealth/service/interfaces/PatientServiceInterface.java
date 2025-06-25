package com.smarthealth.service.interfaces;

import com.smarthealth.model.Patient;

public interface PatientServiceInterface {
    void registerPatient(Patient patient) throws Exception;
    Patient login(String email, String password) throws Exception;
}
