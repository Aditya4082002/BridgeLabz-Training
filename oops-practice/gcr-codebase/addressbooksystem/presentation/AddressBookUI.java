package addressbooksystem.presentation;

import java.util.Scanner;

import addressbooksystem.service.ContactService;

public class AddressBookUI{
	Scanner input = new Scanner(System.in);
	ContactService service = new ContactService();
	public void startApp() {
		boolean running = true;
		int choice;
		System.out.println("-----------------------------");
		System.out.println("Welcome To AddressBook App.");
		System.out.println("-----------------------------");
		while(running) {
			System.out.println("-----------------------------");
			System.out.println("Options : ");
			System.out.println("1 - Add Contact.");
			System.out.println("2 - Edit Contact.");
			System.out.println("3 - Delete Contact.");
			System.out.println("4 - Display All Contacts.");
			System.out.println("5 - Exit");
			System.out.println("-----------------------------");
			
			System.out.println("Enter your chooice : ");
			choice  = input.nextInt();
			input.nextLine();//consume extra line
			
			switch(choice) {
				case 1:
					addContactFromUser();
					break;
				case 2:
					editContact();
					break;
				case 3:
					deleteContactByName();
					break;
				case 4:
					displayContacts();
					break;
				case 5:
					System.out.println("Thanks for using Address Book App.");
					return;
				default:
					System.out.println("Invalid input.");
			}
			
			if(!running) {
				break;
			}
		}
	}
	
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
		input.nextLine();//consume extra line
		
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
		input.nextLine();//consume extra line
		
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