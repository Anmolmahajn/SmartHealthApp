package com.smarthealth.controller;

import com.smarthealth.service.DoctorService;
import com.smarthealth.model.Doctor;

import java.util.List;
import java.util.Scanner;


public class DoctorController {
    private DoctorService doctorService = new DoctorService();
    private Scanner scanner = new Scanner(System.in);



    public void start(){
        while(true){
            System.out.println("1. Register Doctor");
            System.out.println("2. View All Doctor");
            System.out.println("3. Back ");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch(choice){
                case 1:registerDoctor();
                case 2:viewAllDoctors();
                case 3:{
                    return;
                }
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void registerDoctor(){
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter contact: ");
        String contact = scanner.nextLine();

        Doctor doctor = new Doctor(name, specialization, contact);
        try {
            doctorService.registerDoctor(doctor);
            System.out.println("Doctor registered successfully");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void viewAllDoctors(){
        List<Doctor> doctors = doctorService.getDoctors();
        if(doctors.isEmpty()){
            System.out.println("No doctors found");
        }else{
            for(Doctor doctor : doctors){
                System.out.println("Name: " + doctor.getName());
                System.out.println(" Specialization: " + doctor.getSpecialization());
                System.out.println(" Contact: " + doctor.getContact());
            }
        }
    }
}
