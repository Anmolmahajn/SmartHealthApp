package com.smarthealth.service;

import com.smarthealth.dao.AppointmentDao;
import com.smarthealth.model.Appointment;
import com.smarthealth.model.Doctor;
import com.smarthealth.model.Patient;
import com.smarthealth.service.interfaces.AppointmentServiceInterface;

import java.util.List;
import java.time.LocalDate;

public class AppointmentService implements AppointmentServiceInterface {

    private AppointmentDao appointmentDao = new AppointmentDao();

    @Override
    public void bookAppointment(Patient patient, Doctor doctor, LocalDate date) {
        Appointment appointment =new Appointment(patient, doctor, date);
        appointmentDao.save(appointment);
    }

    @Override
    public List<Appointment> getAppointmentsForPatient(Patient patient) {
        return appointmentDao.findByPatient(patient);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentDao.findAll();
    }
}
