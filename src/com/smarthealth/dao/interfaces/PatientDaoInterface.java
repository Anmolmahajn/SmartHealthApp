package com.smarthealth.dao.interfaces;

import com.smarthealth.model.Patient;
import java.util.List;

public interface PatientDaoInterface {
    void save(Patient patient) throws Exception;
    Patient getPatientbyEmail(String email, String password) ;
    List<Patient> getPatientList() ;
}
