package com.smarthealth.model;

import java.time.LocalDate;

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;

    public Appointment(Patient patient, Doctor doctor, LocalDate date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public Patient getPatient() {return patient;}
    public Doctor getDoctor() {return doctor;}
    public LocalDate getDate() {return date;}

    public String toString(){
        return "Appointment with Dr. "+doctor.getName()+" ("+ doctor.getSpecialization()+") on"+ date;

    }

}
