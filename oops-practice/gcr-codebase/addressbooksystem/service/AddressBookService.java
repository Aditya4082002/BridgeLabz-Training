package addressbooksystem.service;
import java.util.HashMap;
import java.util.Map;

//UC - 6
public class AddressBookService {

    private final Map<String, ContactService> addressBooks = new HashMap<>();

    public boolean createAddressBook(String name) {
        if (addressBooks.containsKey(name)) {
            return false;
        }
        addressBooks.put(name, new ContactService());
        return true;
    }

    public ContactService getAddressBook(String name) {
        return addressBooks.get(name);
    }

    public boolean addressBookExists(String name) {
        return addressBooks.containsKey(name);
    }

    public void showAllAddressBooks() {
        if (addressBooks.isEmpty()) {
            System.out.println("No Address Books available.");
        } else {
            System.out.println("Available Address Books:");
            for (String name : addressBooks.keySet()) {
                System.out.println("- " + name);
            }
        }
    }
}