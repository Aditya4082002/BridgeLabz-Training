package addressbooksystem.controller;
import addressbooksystem.service.*;
import java.util.Scanner;

public class AddressBookController {
	ContactService service = new ContactService();
	Scanner input = new Scanner(System.in);
	
	//Add contacts 
	public void addContactFromUser() {
		//take user input
		System.out.println("Enter First Name : ");
		String firstName = input.nextLine();
		System.out.println("Enter Last Name : ");
		String lastName = input.nextLine();
		System.out.println("Enter Address : ");
		String address= input.nextLine();
		System.out.println("Enter city : ");
		String city= input.nextLine();
		System.out.println("Enter state : ");
		String state= input.nextLine();
		System.out.println("Enter email : ");
		String email= input.nextLine();
		System.out.println("Enter zip : ");
		int zip = input.nextInt();
		System.out.println("Enter phone : ");
		long phone = input.nextLong();
		//read extra space
		input.nextLine();
		
		service.addNewContact(firstName, lastName, address, city, state, email, zip, phone);
	}
	
	//Edit Contacts
	public void editContact() {
		
		System.out.println("Enter name to edit :");
		String name = input.nextLine();
		
		//take user input
		System.out.println("Enter First Name : ");
		String firstName = input.nextLine();
		System.out.println("Enter Last Name : ");
		String lastName = input.nextLine();
		System.out.println("Enter Address : ");
		String address= input.nextLine();
		System.out.println("Enter city : ");
		String city= input.nextLine();
		System.out.println("Enter state : ");
		String state= input.nextLine();
		System.out.println("Enter email : ");
		String email= input.nextLine();
		System.out.println("Enter zip : ");
		int zip = input.nextInt();
		System.out.println("Enter phone : ");
		long phone = input.nextLong();
		//read extra space
		input.nextLine();
		
		
		service.editExixtingContact(name,firstName, lastName, address, city, state, email, zip, phone);
	}
	
	//delete contact
	public void deleteContactByName() {
		System.out.println("Enter name to delete.");
		String name = input.nextLine();
		service.deleteContact(name);
		
	}

	
	
	//Display contacts
	public void displayContacts() {
		service.displayAllContacts();
	}
}
