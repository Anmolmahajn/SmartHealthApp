package com.smarthealth.controller;

import com.smarthealth.model.Appointment;
import com.smarthealth.model.Doctor;
import com.smarthealth.model.Patient;
import com.smarthealth.service.AppointmentService;
import com.smarthealth.service.DoctorService;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class AppointmentController {
    private AppointmentService appointmentService = new AppointmentService();
    private DoctorService doctorService = new DoctorService();
    private Scanner scanner = new Scanner(System.in);

    public void start(Patient currentPatient) {
        if(currentPatient == null) {
            System.out.println("Please enter a valid patient");
            return;
        }

        while(true) {
            System.out.println("1. Book appointment");
            System.out.println("2. View appointment");
            System.out.println("3. Back");
            System.out.println("Enter your choice");
            int choice = Integer.parseInt(scanner.nextLine());
            switch(choice) {
                case 1:
            }
        }
    }

    private void bookAppointment(Patient patient) {
        List<Doctor> doctors = doctorService.getDoctors();
        if (doctors.isEmpty()) {
            System.out.println("No doctors found");
            return;
        }
        System.out.println("Available doctors: ");
        for(int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            System.out.println((i+1)+"  "+doctor.getName()+" "+doctor.getSpecialization());
        }
        System.out.println("Choose Doctor");
        int docchoice = Integer.parseInt(scanner.nextLine());
        if(docchoice<0 || docchoice > doctors.size()) {
            System.out.println("Please enter a valid doctor");
            return;
        }
        Doctor selectedDoctor = doctors.get(docchoice);
        System.out.println("Appointment Date");
        String dateStr = scanner.nextLine();

        try{
            LocalDate date = LocalDate.parse(dateStr);
            appointmentService.bookAppointment(patient, selectedDoctor, date);
            System.out.println("Appointment Booked");
        }catch (Exception e) {
            System.out.println("Invalid date");
        }
    }



    private void viewAppointment(Patient patient) {
        List<Appointment> appointments = appointmentService.getAppointmentsForPatient(patient);
        if(appointments.isEmpty()) {
            System.out.println("No appointments found");
        }else{
            System.out.println("Appointments");
            for(Appointment appt : appointments) {
                System.out.println(appt);
            }
        }
    }
}

