package com.smarthealth.dao.interfaces;

import com.smarthealth.model.Doctor;
import java.util.List;

public interface DoctorDaoInterface {

    void save(Doctor doctor) throws Exception;
    List<Doctor> findAll() throws Exception;
}
