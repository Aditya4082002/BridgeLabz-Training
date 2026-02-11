package com.healthclinicapp.main;

import com.healthclinicapp.model.*;
import com.healthclinicapp.service.*;
import com.healthclinicapp.exception.*;
import java.util.Scanner;


public class HealthAppUI {
	Scanner input = new Scanner(System.in);

	public void start() {
		System.out.println("Welcome to Health Clinic App.");
		boolean running = true;
		System.out.println("Select from below :");
		while (running) {
			System.out.println("1. Patient Management.");
			System.out.println("2. Doctor Management.");
			System.out.println("3. Appointment Scheduling.");
			System.out.println("4. Visit Management & Medical Records");
			System.out.println("5. Exit");
			System.out.println("Enter your choice:");
			int choice = input.nextInt();
			input.nextLine();// consume extra line
			switch (choice) {
			// UC 1
			case 1:
				patientMenu();
				break;

			case 5:
				running = false;
				System.out.println("Thanks for using Health Clinic App.");
				break;
			default:
				System.out.println("invalid choice");
				continue;
			}

		}
	}

	//patient menu
	public void patientMenu() {
		
		boolean running = true;
		while (running) {
			System.out.println("-------------------------------------");
			System.out.println("Welcome to Patient Management.Select:");
			System.out.println("-------------------------------------");
			System.out.println("1. Register New Patient.");
			System.out.println("2. Update Patient Information.");
			System.out.println("3. Search Patient Records.");
			System.out.println("4. View Patient Visit History.");
			System.out.println("5. Exit.");
			System.out.println("-------------------------------------");
			System.out.println("Enter your choice : ");
			int choice = input.nextInt();
			input.nextLine();//consume extra line
			switch (choice) {
			// UC 1
			case 1:
				createNewPatient();
				break;

			case 5:
				running = false;
				break;
			default:
				System.out.println("invalid choice");
				continue;
			}
		}
	}
	public void createNewPatient() {
		System.out.println("Enter Name : ");
		String name = input.nextLine();
		
		System.out.println("Enter Phone : ");
		String phone = input.nextLine();
		
		System.out.println("Enter Bloodgroup : ");
		String bloodGroup = input.nextLine();
		
		System.out.println("Enter DOB :");
		String dob = input.nextLine();
		
		System.out.println("Enter Email : ");
		String email = input.nextLine();
		
		System.out.println("Enter address : ");
		String address = input.nextLine();
		
		Patient patient = new Patient(name,phone,bloodGroup,dob,email,address);
		
		PatientService service  = new PatientService();
		
		try{
			int patient_id = service.registerPatient(patient);
			System.out.println("Patients regestered successfully with id : " + patient_id);
		}catch(DuplicatePatientException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
