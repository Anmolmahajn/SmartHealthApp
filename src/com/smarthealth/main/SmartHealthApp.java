package com.smarthealth.main;

import com.smarthealth.controller.PatientController;
import com.smarthealth.controller.DoctorController;

import java.util.Scanner;

public class SmartHealthApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        PatientController patientController = new PatientController();
        DoctorController doctorController = new DoctorController();


        while (true) {

            System.out.println("1. Patient Portal");
            System.out.println("2. Doctor Portal");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> patientController.start();
                case 2 -> doctorController.start();
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. ");
            }
        }
    }
}
