package com.smarthealth.service.interfaces;

import com.smarthealth.model.Doctor;
import java.util.List;

public interface DoctorServiceInterface {
    void registerDoctor(Doctor doctor) throws Exception;
    List<Doctor> getDoctors();
    boolean removeDoctorById(int id) ;

    Doctor findDoctorById(int id);
    List<Doctor> findDoctorsBySpecialization(String specialization);
    List<Doctor> findDoctorsByLocation(String location);
}
