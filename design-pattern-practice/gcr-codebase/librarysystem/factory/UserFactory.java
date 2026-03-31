package librarysystem.factory;

public class UserFactory {

    public static User createUser(String type, String name) {

        if (type.equalsIgnoreCase("student")) {
            return new Student(name);
        } 
        else if (type.equalsIgnoreCase("faculty")) {
            return new Faculty(name);
        } 
        else if (type.equalsIgnoreCase("librarian")) {
            return new Librarian(name);
        } 
        else {
            throw new IllegalArgumentException("Invalid user type");
        }
    }
}
