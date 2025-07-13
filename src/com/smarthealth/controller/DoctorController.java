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
            System.out.println("3. Remove Doctor");
            System.out.println("4. Back ");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch(choice){
                case 1:registerDoctor();
                        break;
                case 2:viewAllDoctors();
                        break;
                case 3:removeDoctorById();
                break;
                case 4:{
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
        System.out.print("Enter location: ");
        String location = scanner.nextLine();
        String contact ;
        while (true) {
            System.out.print("Enter Contact: ");
            contact = scanner.nextLine().trim();

            if (contact.matches("\\d{10}")) {
                break;
            } else {
                System.out.println("Invalid contact number.");
            }
        }


        Doctor doctor = new Doctor(name, specialization,location, contact);
        try {
            doctorService.registerDoctor(doctor);
            System.out.println("Doctor registered successfully");
        }catch (Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }
    public void viewAllDoctors(){
        List<Doctor> doctors = doctorService.getDoctors();
        if(doctors.isEmpty()){
            System.out.println("No doctors found");
        }else{
            System.out.printf("%-10s %-20s %-25s %-25s %-15s\n", "ID", "Name", "Specialization","Location", "Contact");
            System.out.println("--------------------------------------------------------------------------------------------");

            for (Doctor doctor : doctors) {
                System.out.printf("%-10s %-20s %-25s %-25s %-15s\n",
                        doctor.getId(),
                        doctor.getName(),
                        doctor.getSpecialization(),
                        doctor.getLocation(),
                        doctor.getContact());

            }
        }
    }


    public void removeDoctorById(){
        System.out.print("Enter Doctor ID to remove: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean removed = doctorService.removeDoctorById(id);
        if(removed){
            System.out.println("Doctor id "+ id +" removed successfully");

        }else{
            System.out.println("Doctor id "+ id +" not found");
        }
    }
}
