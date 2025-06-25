package com.smarthealth.dao.interfaces;

import com.smarthealth.model.Appointment;
import com.smarthealth.model.Patient;

import java.util.List;

public interface AppointmentDaoInterface {
    void save(Appointment appointment);
    List<Appointment> findByPatient(Patient patient);
    List<Appointment> findAll();
}
