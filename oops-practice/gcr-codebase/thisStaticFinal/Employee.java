package thisStaticFinal;

public class Employee {
	
	//static variable 
	static String companyName = "Tech Solutions Inc."; 
	static int totalEmployee = 0;
		
	//instance variables
	private String name;
	private String designation;
	private final int id; //can not be changed
		
	//static methods
	public static void displayCompanyName() {
		System.out.println("Company Name : "  + companyName);
	}
	
	public static void displayTotalEmployee() {
		System.out.println("Total Employee : "  + totalEmployee);
	}
		
	//constructor
	public Employee(String name,String designation, int id){
		this.name = name;
		this.designation=designation;
		this.id=id;
		totalEmployee++;
	}
		
	//method to display details
	public void displayDetails() {
		if(this instanceof Employee) {
			displayCompanyName();
			System.out.println("Name : " + name);
			System.out.println("Designation : " + designation);
			System.out.println("id : " + id);
		}else {
			System.out.println("Invalid Object");
		}
	}
		
	//main method 
	public static void main(String[] args) {
		Employee employee1 = new Employee("Thamarai","Software Engineer",101);
		Employee employee2 = new Employee("Rohan","Project Manager",102);
		displayTotalEmployee();
		employee1.displayDetails();
		employee2.displayDetails();
	}

}
