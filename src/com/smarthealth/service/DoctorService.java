package com.smarthealth.service;

import com.smarthealth.dao.DoctorDao;
import com.smarthealth.model.Doctor;
import com.smarthealth.service.interfaces.DoctorServiceInterface;

import java.util.List;

public class DoctorService implements DoctorServiceInterface {

    private DoctorDao doctorDao = new DoctorDao();

    @Override
    public void registerDoctor(Doctor doctor) throws Exception {
        doctorDao.save(doctor);
    }

    @Override
    public List<Doctor> getDoctors() {
        return doctorDao.findAll();
    }


    public boolean removeDoctorById(int id) {
        try {
            return doctorDao.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}