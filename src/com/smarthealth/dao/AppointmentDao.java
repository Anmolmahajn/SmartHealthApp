package com.smarthealth.dao;

import com.smarthealth.dao.interfaces.AppointmentDaoInterface;
import com.smarthealth.model.Appointment;
import com.smarthealth.model.Patient;

import java.util.List;
import java.util.ArrayList;

public class AppointmentDao implements AppointmentDaoInterface {

    private List<Appointment> appointments = new ArrayList<>();

    @Override
    public void save(Appointment appointment) {
        appointments.add(appointment);
    }

    @Override
    public List<Appointment> findByPatient(Patient patient) {
        List<Appointment> result = new ArrayList<>();
        for(Appointment appt : appointments) {
            if(appt.getPatient().getEmail().equals(patient.getEmail())) {
                result.add(appt);
            }
        }
        return result;
    }

    @Override
    public List<Appointment> findAll() {
        return appointments;
    }
}
