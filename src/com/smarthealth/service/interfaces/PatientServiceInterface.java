package com.smarthealth.service.interfaces;

import com.smarthealth.model.Patient;

import java.util.List;

public interface PatientServiceInterface {
    void registerPatient(Patient patient) throws Exception;
    Patient login(String email, String password) throws Exception;

    Patient findPatientById(int id);
    List<Patient> getAllPatients();
    boolean updatePatient(Patient patient);
    boolean deletePatient(int id);
}

