package com.smarthealth.dao.interfaces;

import com.smarthealth.model.Patient;

public interface PatientDaoInterface {
    void save(Patient patient) throws Exception;
    Patient getPatientbyEmail(String email, String password) ;
}
