package addressbooksystem.service;

import addressbooksystem.repository.*;
import addressbooksystem.model.Contact;
import addressbooksystem.model.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ContactService {
	ContactRepository contactRepo = new ContactRepository();
	private Map<String, List<Contact>> cityMap = new HashMap<>();
	private Map<String, List<Contact>> stateMap = new HashMap<>();

	// method to add new contact
	public void addNewContact(String firstName, String lastName, String address, String city, String state,
			String email, int zip, long phone) {
		// Uc - 7
		// validate
		String name = firstName + " " + lastName;
		for (Contact contact : contactRepo.getContact()) {
			String current_name = contact.getFirstName() + " " + contact.getLastName();
			if (name.equalsIgnoreCase(current_name)) {
				System.out.println("already exist.");
				return;
			}

		}

		// create contact
		Contact contact = new Contact(firstName, lastName, address, city, state, email, zip, phone);
		contactRepo.addContact(contact);
		// add contacts to maps
		cityMap.computeIfAbsent(city.toLowerCase(), k -> new ArrayList<>()).add(contact);
		stateMap.computeIfAbsent(state.toLowerCase(), k -> new ArrayList<>()).add(contact);

		System.out.println("contact added successfully.");
	}

	// edit contact
	public void editExistingContact(String name, String firstName, String lastName, String address, String city,
			String state, String email, int zip, long phone) {
		List<Contact> contacts = contactRepo.getContact();
		for (Contact contact : contacts) {
			if (contact.getFirstName().equals(name)) {
				contact.setAddress(address);
				contact.setCity(city);
				contact.setEmail(email);
				contact.setFirstName(firstName);
				contact.setLastName(lastName);
				contact.setPhone(phone);
				contact.setState(state);
				contact.setZip(zip);
			} else {
				System.out.println("Contact not found.");
			}
		}
	}

	//
	public void deleteContact(String name) {

		// remove from repo
		Contact existingContact = findContactByName(name);

		// remove from city map
		String city = existingContact.getCity();
		List<Contact> cityContact = cityMap.get(city.toLowerCase());
		cityContact.remove(existingContact);

		// remove from satte map
		String state = existingContact.getState();
		List<Contact> stateContact = stateMap.get(state.toLowerCase());
		stateContact.remove(existingContact);

		contactRepo.deleteContact(existingContact);

	}

	// find contact
	public Contact findContactByName(String name) {
		List<Contact> contacts = contactRepo.getContact();
		for (Contact contact : contacts) {
			if (contact.getFirstName().equals(name)) {
				return contact;
			}
		}
		System.out.println("Contact not found.");
		return null;

	}

	// method to get all contacts
	public List<Contact> getAllContacts() {
		return contactRepo.getContact();
	}
	
	//display person by city
	public void displayPersonsByCity(String city) {
		List<Contact> contacts = cityMap.get(city);
		if (contacts == null || contacts.isEmpty()) {
			System.out.println("No contacts found");
			return;
		}
		for (Contact contact : contacts) {
			System.out.println(contact.toString());
		}
	}

	//display persons by state
	public void displayPersonsByState(String state) {
		List<Contact> contacts = cityMap.get(state);
		if (contacts == null || contacts.isEmpty()) {
			System.out.println("No contacts found");
			return;
		}
		for (Contact contact : contacts) {
			System.out.println(contact.toString());
		}
	}

	// Count contacts by city
	public int countByCity(String city) {
		String cityKey = city.toLowerCase();
		List<Contact> contacts = cityMap.get(cityKey);

		if (contacts == null) {
			return 0;
		}
		return contacts.size();
	}

	// Count contacts by State
	public int countByState(String state) {

		String stateKey = state.toLowerCase();
		List<Contact> contacts = stateMap.get(stateKey);

		if (contacts == null) {
			return 0;
		}

		return contacts.size();
	}
	
	//sort by name
	public void sortByName() {
		List<Contact> contacts =new ArrayList<>(contactRepo.getContact());
		contacts.sort(Comparator
				.comparing(Contact :: getFirstName, String.CASE_INSENSITIVE_ORDER)
				.thenComparing(Contact :: getLastName,String.CASE_INSENSITIVE_ORDER)
		);
		for (Contact contact : contacts) {
			System.out.println(contact.toString());
		}
	}
	
	//sort by city
	public void sortByCity() {
		List<Contact> contacts =new ArrayList<>(contactRepo.getContact());
		contacts.sort(Comparator.comparing(Contact :: getCity, String.CASE_INSENSITIVE_ORDER));
		for (Contact contact : contacts) {
			System.out.println(contact.toString());
		}
	}
	//sort by state
	public void sortByState() {
		List<Contact> contacts =new ArrayList<>(contactRepo.getContact());
		contacts.sort(Comparator.comparing(Contact :: getState, String.CASE_INSENSITIVE_ORDER));
		for (Contact contact : contacts) {
			System.out.println(contact.toString());
		}
	}
	//sort by zip
	public void sortByZip() {
		List<Contact> contacts =new ArrayList<>(contactRepo.getContact());
		contacts.sort(Comparator.comparing(Contact :: getZip));
		for (Contact contact : contacts) {
			System.out.println(contact.toString());
		}
	}

	// method to display all contacts
	public void displayAllContacts() {
		List<Contact> contacts = contactRepo.getContact();
		for (Contact contact : contacts) {
			System.out.println("-----------------------------");
			System.out.println(contact.toString());
			System.out.println("-----------------------------");
		}
	}
	
	//save to csv
	public void saveToCSV(String fileName) {

	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

	        for (Contact contact : contactRepo.getContact()) {

	            String line = contact.getFirstName() + "," +
	                          contact.getLastName() + "," +
	                          contact.getAddress() + "," +
	                          contact.getCity() + "," +
	                          contact.getState() + "," +
	                          contact.getEmail() + "," +
	                          contact.getZip() + "," +
	                          contact.getPhone();

	            writer.write(line);
	            writer.newLine();
	        }

	        System.out.println("Contacts saved successfully to csv file.");

	    } catch (IOException e) {
	        System.out.println("Error writing file: " + e.getMessage());
	    }
	}
	
	//save to file
	public void saveToFile(String fileName) {

	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

	        for (Contact contact : contactRepo.getContact()) {

	            String line = contact.getFirstName() + "|" +
	                          contact.getLastName() + "|" +
	                          contact.getAddress() + "|" +
	                          contact.getCity() + "|" +
	                          contact.getState() + "|" +
	                          contact.getEmail() + "|" + 
	                          contact.getZip() + "|" +
	                          contact.getPhone();

	            writer.write(line);
	            writer.newLine();
	        }

	        System.out.println("Contacts saved successfully to file.");

	    } catch (IOException e) {
	        System.out.println("Error writing file: " + e.getMessage());
	    }
	}
	
	//load from csv
	public void loadFromCSV(String fileName) {

	    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

	        String line;

	        while ((line = reader.readLine()) != null) {

	            String[] parts = line.split(",");

	            if (parts.length == 8) {
	            	Contact contact = new Contact( parts[0], parts[1], parts[2],parts[3], 
	            			parts[4], parts[5],
	            			Integer.parseInt(parts[6]), 
	            			Long.parseLong(parts[7]));
	                contactRepo.addContact(contact);
	            }
	        }

	        System.out.println("Contacts loaded successfully from csv file.");

	    } catch (IOException e) {
	        System.out.println("Error reading file: " + e.getMessage());
	    }
	}
	
	//load from file
	public void loadFromFile(String fileName) {

	    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

	        String line;

	        while ((line = reader.readLine()) != null) {

	            String[] parts = line.split("\\|");

	            if (parts.length == 8) {
	            	Contact contact = new Contact( parts[0], parts[1], parts[2],parts[3], 
	            			parts[4], parts[5],
	            			Integer.parseInt(parts[6]), 
	            			Long.parseLong(parts[7]));
	                contactRepo.addContact(contact);
	            }
	        }

	        System.out.println("Contacts loaded successfully from file.");

	    } catch (IOException e) {
	        System.out.println("Error reading file: " + e.getMessage());
	    }
	}

}