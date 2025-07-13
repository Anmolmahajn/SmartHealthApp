package com.smarthealth.dao;
import com.smarthealth.dao.interfaces.PatientDaoInterface;
import com.smarthealth.model.Patient;
import com.smarthealth.util.DBConnector;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class PatientDao implements PatientDaoInterface{

    private List<Patient> patientList = new ArrayList<>();

    @Override
    public void save(Patient patient) throws Exception {
        for (Patient p : patientList) {
            if (p.getEmail().equals(patient.getEmail())) {
                throw new Exception("Email already exists");
            }
        }
        patientList.add(patient);
    }

    @Override
    public Patient getPatientbyEmail(String email, String Password) {
        for (Patient patient : patientList) {
            if (patient.getEmail().equals(email) &&
                    patient.getPassword().equals(Password)) {
                return patient;
            }
        }
        return null;
    }

    @Override
    public List<Patient> getPatientList() {
        return patientList;
    }
}
