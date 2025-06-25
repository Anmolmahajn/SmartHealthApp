package com.smarthealth.service.interfaces;

import com.smarthealth.model.Doctor;
import java.util.List;

public interface DoctorServiceInterface {
    void registerDoctor(Doctor doctor) throws Exception;
    List<Doctor> getDoctors();
}
