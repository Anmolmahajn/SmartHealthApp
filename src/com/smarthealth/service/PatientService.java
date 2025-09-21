package com.smarthealth.service;

import com.smarthealth.model.Patient;
import com.smarthealth.service.interfaces.PatientServiceInterface;
import com.smarthealth.dao.PatientDao;

import java.util.List;


public class PatientService implements PatientServiceInterface {

    private PatientDao patientDao ;


    public PatientService() {
        this.patientDao = new PatientDao();
    }
    @Override
    public void registerPatient(Patient patient) throws Exception {
        if(!patient.getEmail().contains("@")){
            throw new Exception("Email address is invalid");
        }
        if(patient.getPassword().length()<6){
            throw new Exception("Password must be atleast 6 characters");
        }
        patientDao.save(patient);
    }

    @Override
    public Patient login(String email, String password) throws Exception {
        Patient patient = patientDao.getPatientbyEmail(email, password);
        if(patient == null){
            throw new Exception("Invalid email or password");
        }
        return patient;
    }

    @Override
    public Patient findPatientById(int id) {
        return null;
    }

    @Override
    public List<Patient> getAllPatients() {
        return List.of();
    }

    @Override
    public boolean updatePatient(Patient patient) {
        return false;
    }

    @Override
    public boolean deletePatient(int id) {
        return false;
    }
}
