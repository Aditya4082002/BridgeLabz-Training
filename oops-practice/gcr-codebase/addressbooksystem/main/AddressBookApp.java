package addressbooksystem.main;
import addressbooksystem.controller.*;
public class AddressBookApp {

	public static void main(String[] args) {
		AddressBookController addressBook = new AddressBookController();
		
		
		addressBook.addContactFromUser();//UC - 2
		addressBook.addContactFromUser();
		
		addressBook.displayContacts();
		
		addressBook.editContact();//UC - 3
		
		addressBook.displayContacts();
		
		addressBook.deleteContactByName();//UC - 4
		
		addressBook.displayContacts();
	}

}
