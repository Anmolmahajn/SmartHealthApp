package com.smarthealth.service.interfaces;

import com.smarthealth.model.Appointment;
import com.smarthealth.model.Doctor;
import com.smarthealth.model.Patient;

import java.util.List;
import java.time.LocalDate;

public interface AppointmentServiceInterface {
    void bookAppointment(Patient patient, Doctor doctor, LocalDate date);
    List<Appointment> getAppointmentsForPatient(Patient patient);
    List<Appointment> getAllAppointments();
}
