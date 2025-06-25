package com.smarthealth.controller;

import com.smarthealth.model.Patient;
import com.smarthealth.service.PatientService;

import java.util.Scanner;

public class PatientController {
    private PatientService patientService = new PatientService();
    private Scanner scanner = new Scanner(System.in);
    private Patient currentPatient = null;
    private AppointmentController appointmentController = new AppointmentController();

    public void start(){
        while(true){
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Profile");
            System.out.println("4. Appointments");
            System.out.println("5. Logout");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch(choice){
                case 1: registerPatient();
                case 2: login();
                case 3: viewProfile();
                case 4: appointmentController.start(currentPatient);
                case 5: {
                    System.out.println("Logged out");
                    return;
                }
                case 6: {
                    return;}
                default:
                    System.out.println("Invalid choice");;
            }

        }
    }



    private void registerPatient(){
        System.out.print("Enter name: ");
        String patientName = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter contact: ");
        String contact = scanner.nextLine();

        Patient patient = new Patient(patientName, email, password, contact);
        try {
            patientService.registerPatient(patient);
            System.out.println("Patient registered successfully");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void login(){
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try {
            Patient patient = patientService.login(email,password);
            if(patient != null){
                 currentPatient = patient;
                System.out.println("Patient logged successfully");
            }else{
                System.out.println("Patient not logged in");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void viewProfile(){
        if(currentPatient == null){
            System.out.println("Patient not logged in");
            return;
        }
        System.out.println("Name: " + currentPatient.getName());
        System.out.println("Email: " + currentPatient.getEmail());
        System.out.println("Contact: " + currentPatient.getContact());
    }
}
