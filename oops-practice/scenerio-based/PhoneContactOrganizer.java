package scenrioBase;

import java.util.ArrayList;
import java.util.List;

public class PhoneContactOrganizer {

    // Contact class
    static class Contact {
        private String name;
        private String phoneNumber;

        Contact(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        String getName() {
            return name;
        }

        String getPhoneNumber() {
            return phoneNumber;
        }
    }

    // Custom Exception
    static class InvalidPhoneNumberException extends Exception {
        InvalidPhoneNumberException(String message) {
            super(message);
        }
    }

    // Contact Organizer logic
    static class ContactOrganizer {

        private List<Contact> contacts = new ArrayList<>();

        // Add contact
        void addContact(String name, String phoneNumber)
                throws InvalidPhoneNumberException {

            if (!isValidPhoneNumber(phoneNumber)) {
                throw new InvalidPhoneNumberException(
                        "Phone number must be exactly 10 digits"
                );
            }

            if (isDuplicate(phoneNumber)) {
                System.out.println("Duplicate contact not allowed");
                return;
            }

            contacts.add(new Contact(name, phoneNumber));
            System.out.println("Contact added successfully");
        }

        // Delete contact by phone number
        void deleteContact(String phoneNumber) {

            for (int i = 0; i < contacts.size(); i++) {
                if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                    contacts.remove(i);
                    System.out.println("Contact deleted");
                    return;
                }
            }

            System.out.println("Contact not found");
        }

        // Search contact by name
        void searchContact(String name) {

            for (Contact c : contacts) {
                if (c.getName().equalsIgnoreCase(name)) {
                    System.out.println(
                            "Name: " + c.getName() +
                            ", Phone: " + c.getPhoneNumber()
                    );
                    return;
                }
            }

            System.out.println("Contact not found");
        }

        // Validate phone number
        private boolean isValidPhoneNumber(String phoneNumber) {
            return phoneNumber.matches("\\d{10}");
        }

        // Check duplicate phone number
        private boolean isDuplicate(String phoneNumber) {
            for (Contact c : contacts) {
                if (c.getPhoneNumber().equals(phoneNumber)) {
                    return true;
                }
            }
            return false;
        }
    }

    // Main method
    public static void main(String[] args) {

        ContactOrganizer organizer = new ContactOrganizer();

        try {
            organizer.addContact("Aditya", "9876543210");
            organizer.addContact("Rahul", "9876543210");
            organizer.addContact("Amit", "12345");
        } catch (InvalidPhoneNumberException e) {
            System.out.println(e.getMessage());
        }

        organizer.searchContact("Aditya");
        organizer.deleteContact("9876543210");
        organizer.searchContact("Aditya");
    }
}
