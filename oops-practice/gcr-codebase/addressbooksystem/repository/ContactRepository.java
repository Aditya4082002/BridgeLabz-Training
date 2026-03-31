package addressbooksystem.repository;
import java.util.*;
import addressbooksystem.model.*;

public class ContactRepository {
	private List<Contact> contacts = new ArrayList<>();
	
	public void addContact(Contact contact) {
		contacts.add(contact);
	}
	
	public List<Contact> getContact(){
		return contacts;
	}
	
	public void deleteContact(Contact contact) {
		contacts.remove(contact);
	}
}