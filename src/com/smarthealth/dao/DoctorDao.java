package com.smarthealth.dao;

import com.smarthealth.dao.interfaces.DoctorDaoInterface;
import com.smarthealth.model.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorDao implements DoctorDaoInterface {
    public List<Doctor> doctorsList = new ArrayList<>();


    public void save(Doctor doctor) throws Exception {
        for (Doctor d : doctorsList) {
            if (d.getName().equals(doctor.getName()) && d.getSpecialization().equals(doctor.getSpecialization())) {
                throw new Exception("Doctor already exists");
            }
        }
        doctorsList.add(doctor);
    }

    public List<Doctor> findAll() {
        return doctorsList;}
}
