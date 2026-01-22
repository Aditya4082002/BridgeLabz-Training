package addressbooksystem.service;
import addressbooksystem.repository.*;

import addressbooksystem.model.*;
import java.util.*;


public class ContactService {
	ContactRepository contactRepo = new ContactRepository();
	
	//method to add new contact
	public void addNewContact(String firstName, String lastName, String address, String city, String state, String email, int zip, long phone) {
		//Uc - 7
		//validate
		String name = firstName + " " + lastName;
		for(Contact contact : contactRepo.getContact()) {
			String current_name = contact.getFirstName() + " " + contact.getLastName();
			if(name.equalsIgnoreCase(current_name)) {
				System.out.println("already exist.");
				return;
			}
			
		}
		
		//create contact
		Contact contact = new Contact(firstName,lastName,address,city,state,email,zip,phone);
		contactRepo.addContact(contact);
		
		System.out.println("contact added successfully.");
	}	
	
	//edit contact
	public void editExixtingContact(String name,String firstName, String lastName, String address, String city, String state, String email, int zip, long phone) {
		List<Contact> contacts = contactRepo.getContact();
		for(Contact contact : contacts) {
			if(contact.getFirstName().equals(name)){
				contact.setAddress(address);
				contact.setCity(city);
				contact.setEmail(email);
				contact.setFirstName(firstName);
				contact.setLastName(lastName);
				contact.setPhone(phone);
				contact.setState(state);
				contact.setZip(zip);
			}else {
				System.out.println("Contact not found.");
			}
		}
	}
	
	//
	public void deleteContact(String name) {
		
		contactRepo.deleteContact(findContactByName(name));
	}
	//find contact
	public Contact findContactByName(String name) {
		List<Contact> contacts = contactRepo.getContact();
		for(Contact contact : contacts) {
			if(contact.getFirstName().equals(name)) {
				return contact;
			}
		}
		System.out.println("Contact not found.");
		return null;
		
	}

	
	//method to display all contacts
	public void displayAllContacts() {
		List<Contact> contacts = contactRepo.getContact(); 
		for(Contact contact : contacts) {
			System.out.println(contact.toString());
		}
	}
	
	
}