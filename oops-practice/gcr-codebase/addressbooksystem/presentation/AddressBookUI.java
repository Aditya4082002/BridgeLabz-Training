package addressbooksystem.presentation;
import java.util.Scanner;
import addressbooksystem.service.ContactService;
import addressbooksystem.service.AddressBookService;

public class AddressBookUI{
	Scanner input = new Scanner(System.in);
	private final AddressBookService addressbookservice = new AddressBookService();
	public void startApp() {
		boolean running = true;
		int choice;
		System.out.println("-----------------------------");
		System.out.println("Welcome To AddressBook App.");
		System.out.println("-----------------------------");
		while(running) {
			System.out.println("-----------------------------");
			System.out.println("Options : ");
			System.out.println("1. Create Address Book.");
			System.out.println("2. Open Address Book.");
			System.out.println("3. Show All Address book.");
			System.out.println("4. Search Person by city/state.");
			System.out.println("5. Exit.");
			System.out.println("-----------------------------");
			
			System.out.println("Enter your chooice : ");
			choice  = input.nextInt();
			input.nextLine();//consume extra line
			
			 switch (choice) {
             case 1 :
            	 createAddressBook();
            	 break;
             case 2 :
            	 openAddressBook();
            	 break;
             case 3 :
            	 addressbookservice.showAllAddressBooks();
            	 break;
             //UC - 8
             case 4: 
            	 searchPersonByCityOrState();
            	 break;
             case 5 :
            	 System.out.println("Thanks for using Address Book App.");
            	 running = false;
            	 break;
             default :
            	 System.out.println("Invalid choice");
         }
			
		}
	}
	
	//search person by city or state
	private void searchPersonByCityOrState() {
		System.out.println("Enter city or state name : ");
		String value = input.nextLine();
		addressbookservice.searchPersonByCityorState(value);
	}
	
	//create address book
	private void createAddressBook() {
        System.out.print("Enter new Address Book name: ");
        String name = input.nextLine();

        if (addressbookservice.createAddressBook(name)) {
            System.out.println("Address Book created successfully!");
        } else {
            System.out.println("Address Book with this name already exists!");
        }
    }
	
	//open Address book
	private void openAddressBook() {
        System.out.print("Enter Address Book name to open: ");
        String name = input.nextLine();

        if (!addressbookservice.addressBookExists(name)) {
            System.out.println("Address Book not found!");
            return;
        }

        ContactService contactService = addressbookservice.getAddressBook(name);
        addressBookMenu(contactService);
    }
	
	//menu for address book
	private void addressBookMenu(ContactService service) {

        boolean active = true;

        while (active) {
        	System.out.println("-----------------------------");
			System.out.println("Options : ");
			System.out.println("1 - Add Contact.");
			System.out.println("2 - Edit Contact.");
			System.out.println("3 - Delete Contact.");
			System.out.println("4 - Display All Contacts.");
			System.out.println("5 - View Persons by city.");
			System.out.println("6 - View Persons by state.");
			System.out.println("7 - Count Persons by city.");
			System.out.println("8 - Count Persons by state");
			System.out.println("9 - Back");
			System.out.println("-----------------------------");

            System.out.println("Enter your chooice : ");
			int choice  = input.nextInt();
			input.nextLine();//consume extra line

			switch(choice) {
			case 1:
				addContactFromUser(service);
				break;
			case 2:
				editContact(service);
				break;
			case 3:
				deleteContactByName(service);
				break;
			case 4:
				displayContacts(service);
				break;
			//UC - 9
			case 5:
				viewPersonsByCity(service);
				break;
			case 6:
				viewPersonsByState(service);
				break;
			//UC - 10
			case 7:
				countByCity(service);
				break;
			case 8:
				countByState(service);
				break;
			case 9:
				return;
			default:
				System.out.println("Invalid input.");
		}
        }
    }
	
	//count persons by city
	public void countByCity(ContactService service) {
		System.out.println("Enter city: ");
		String city = input.nextLine();
		int count = service.countByCity(city);
		System.out.println("Number of persons in " + city + " : " + count);
	}
	
	//count persons by state
	public void countByState(ContactService service) {
		System.out.println("Enter state: ");
		String state = input.nextLine();
		int count  = service.countByState(state);
		System.out.println("Number of persons in " + state + " : " + count);
	}
	
	//view persons by city
	public void viewPersonsByCity(ContactService service){
		System.out.println("Enter City to view contacts : ");
		String city = input.nextLine();
		service.displayPersonsByCity(city);
	}
	
	//view persons by state
	public void viewPersonsByState(ContactService service) {
		System.out.println("Enter City to view contacts : ");
		String state = input.nextLine();
		service.displayPersonsByState(state);
	}
	
	//Add contacts 
	public void addContactFromUser(ContactService service) {
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
	public void editContact(ContactService service) {
		
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
		
		service.editExistingContact(name,firstName, lastName, address, city, state, email, zip, phone);
	}
	
	//delete contact
	public void deleteContactByName(ContactService service) {
		System.out.println("Enter name to delete.");
		String name = input.nextLine();
		service.deleteContact(name);
		
	}

	//Display contacts
	public void displayContacts(ContactService service) {
		service.displayAllContacts();
	}
}