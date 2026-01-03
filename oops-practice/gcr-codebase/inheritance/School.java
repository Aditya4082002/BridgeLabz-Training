package inheritance;

//Superclass
class Persons {
    //attributes
    protected String name;
    protected int age;

    //constructor
    Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //common method
    public void displayRole() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
    }
}

//Teacher subclass
class Teacher extends Persons {
    //attribute
    protected String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void displayRole() {
        super.displayRole();
        System.out.println("Role : Teacher");
        System.out.println("Subject : " + subject);
    }
}

//Student subclass
class Student extends Persons {
    // specific attribute
    protected String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    public void displayRole() {
        super.displayRole();
        System.out.println("Role : Student");
        System.out.println("Grade : " + grade);
    }
}

//Staff subclass
class Staff extends Persons {
    //specific attribute
    protected String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    public void displayRole() {
        super.displayRole();
        System.out.println("Role : Staff");
        System.out.println("Department : " + department);
    }
}

//Main class
public class School{
    public static void main(String[] args) {

        Persons[] people = {
            new Teacher("Mr. Sharma", 40, "Mathematics"),
            new Student("Aditya", 20, "Second Year"),
            new Staff("Ramesh", 35, "Administration")
        };

        for (Persons person : people) {
            person.displayRole();
        }
    }
}
