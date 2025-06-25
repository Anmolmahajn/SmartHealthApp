package com.smarthealth.service;

import com.smarthealth.model.Patient;
import com.smarthealth.service.interfaces.PatientServiceInterface;
import com.smarthealth.dao.PatientDao;


public class PatientService implements PatientServiceInterface {

private PatientDao patientDao = new PatientDao();


    @Override
    public void registerPatient(Patient patient) throws Exception {
        patientDao.save(patient);
    }

    @Override
    public Patient login(String email, String password) throws Exception {
     return patientDao.getPatientbyEmail(email, password);
    }
}
